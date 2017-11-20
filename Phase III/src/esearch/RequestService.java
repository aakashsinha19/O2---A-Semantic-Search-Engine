package esearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestService {

	public static String get(String reqUrl, boolean debug) {
		String output = "", result = "";

		try {
				URL url = new URL(reqUrl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
	
				if (conn.getResponseCode() == 404) {
					return "";
				}
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}
	
				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
	
				
				while ((output = br.readLine()) != null) {
					result += output;
//						System.out.println(output);
				}
				if (debug) {
					System.out.println("Output from Server .... \n");
					System.out.println(result);
				}
			
				conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		
		return result;
	}
	
	public static String post(String reqUrl, String body, boolean debug) {

		String output = "", result = "";
		try {

				URL url = new URL(reqUrl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
	
				
				OutputStream os = conn.getOutputStream();
				os.write(body.getBytes());
				os.flush();
	
				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
				}
	
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));
					
				while ((output = br.readLine()) != null) {
					result += output;
//						System.out.println(output);
				}
				if (debug) {
					System.out.println("Output from Server .... \n");
					System.out.println(result);
				}
					conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }
		
		return result;
	}
	
	public static String put(String reqUrl, String body, boolean debug) {

		String output = "", result = "";
		try {

				URL url = new URL(reqUrl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Content-Type", "application/json");
	
				
				OutputStream os = conn.getOutputStream();
				os.write(body.getBytes());
				os.flush();
	
				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED &&
						conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
				}
	
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));
						
				while ((output = br.readLine()) != null) {
					result += output;
//						System.out.println(output);
				}
				if (debug) {
					System.out.println("Output from Server .... \n");
					System.out.println(result);
				}
			
				conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }
		
		return result;
	}
}
