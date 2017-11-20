package semantic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.python.util.PythonInterpreter; 
import org.python.core.*; 

public class QueryClient {

	private final static String pyFilePath = "C:\\Users\\nvsab\\workspace\\o2\\WebContent\\WEB-INF\\lib\\";
	private static final String logFile = "C:\\Users\\nvsab\\workspace\\o2\\WebContent\\WEB-INF\\lib\\log.txt";
	private static final String qFile = "C:\\Users\\nvsab\\workspace\\o2\\WebContent\\WEB-INF\\lib\\expandedQuery.txt";
	
	public static String getExpandedQuery (String query) {
		runExpandCode (query);
		
		String expandedQuery = getOutput (qFile);
		System.out.println("e q:\n" + expandedQuery + "--end");
		return expandedQuery;
	}
	
	public static void trainModel () {
		runTrainingCode ();
		
		System.out.println("train :" + getOutput (logFile));
	}
	
	private static String getOutput (String fileName) {
		
		BufferedReader br = null;
		FileReader fr = null;
		String output = "";
		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
//				System.out.println(sCurrentLine);
				output += sCurrentLine ;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return output;
	}
	
	private static void runTrainingCode () {
		try {
			System.out.println("Training: ");
            System.out.println("Executing code....");

            Process process = Runtime.getRuntime().exec("python " + pyFilePath + "updateCorpus.py");
            process.waitFor ();            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public static void runExpandCode (String query) {
        try {
            System.out.println("Executing code....");
            
            Process process = Runtime.getRuntime().exec("python " + pyFilePath + "expandQuery.py " + query);
            process.waitFor ();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
}
