package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Main.Static;

public class Userpage {
	
	public static String getUserpage(User u) {
		try {
			 String url = "https://"+Static.server + "/api/v1/users/userpage?id="+u.getID();
		     URL obj = new URL(url);
		     HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		     con.setRequestMethod("GET");
		     con.setRequestProperty("User-Agent", "Mozilla/5.0");
		     @SuppressWarnings("unused")
			int responseCode = con.getResponseCode();
		     BufferedReader in = new BufferedReader(
		             new InputStreamReader(con.getInputStream()));
		     String inputLine;
		     StringBuffer response = new StringBuffer();
		     while ((inputLine = in.readLine()) != null) {
		     	response.append(inputLine);
		     }
		     in.close();
		     JSONParser parser = new JSONParser();
		     Object obj2 = parser.parse(response.toString());
		     JSONObject jsonObject = (JSONObject) obj2;
		     return (String) jsonObject.get("userpage");
		    }catch(Exception e) {
				System.out.println("[RippleAPI]: This User don't have a Userpage "+e.getSuppressed());
			}
		return null;
	}

}
