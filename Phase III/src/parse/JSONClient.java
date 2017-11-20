package parse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONClient {
	
	public static JSONObject strToJSON (String jsonStr) {
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(jsonStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not parse");
			e.printStackTrace();
		}
		
		return json;
	}

}
