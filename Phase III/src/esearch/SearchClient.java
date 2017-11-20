package esearch;
import org.json.simple.JSONObject;
import java.lang.NullPointerException;
import java.util.Date;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import semantic.QueryClient;

public class SearchClient {

	private final static String baseUrl = "http://localhost:9200";
	private static final String corpusFileName = "C://Users//nvsab//workspace//o2//WebContent//WEB-INF//lib//corpus.txt";
	
	private static void updateCorpus(String content) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			File file = new File(corpusFileName);

			// if file doesnt exists, then create it
			if (! file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			content += ' ';
			bw.write(content);
			System.out.println("Corpus Updated");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
//				System.out.println("In finally");
//				QueryClient.trainModel();
			
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static boolean indexDoc(String docName, String content, String authorName, boolean debug) {
		
		JSONObject jo = new JSONObject();
		Date date = new Date();
		
		jo.put("content", content);
		jo.put("time", date.getTime());
		jo.put("authorName", authorName);
		
		String reqUrl = baseUrl + "/o2/text/" + docName;
		String body = jo.toJSONString();
		
		String output = RequestService.put(reqUrl, body, true);
		
		if (debug)
			System.out.println("IndexDoc output:\n" + output);
		
		if (output.length() == 0)
			return false;	
		updateCorpus (content);
		return true;
	
	}
	
	public static String searchDoc(String query) {
		String output= "";
		try {
//			System.out.println("query:\n" + query);
//			String expandedQuery = QueryClient.getExpandedQuery(query);
			String expandedQuery;
//			System.out.println("Expanded q:\n" + expandedQuery);
//			String expandedQuery = "";
			expandedQuery = query.replaceAll(" ", "%20");
			
			String reqUrl = baseUrl + "/o2/text/_search?q=" + expandedQuery;
//			System.out.println(reqUrl + "--end");
			
			output = RequestService.get(reqUrl, false);
		}
		catch(NullPointerException npe) {
			System.out.println("Query is null");
		}
		return output;
	}

}
