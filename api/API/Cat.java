package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Main.Static;

public class Cat {
	
	private Long code;
	private String cat;
	private String raw;
	
	public Cat() {
		try {
		 String url = "https://"+Static.server + "/api/v1/suprise_me";
	     URL obj = new URL(url);
	     HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
	     con.setRequestMethod("GET");
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     @SuppressWarnings("unused")
		int responseCode = con.getResponseCode();
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getErrorStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     raw = response.toString();
	     JSONParser parser = new JSONParser();
	     Object obj2 = parser.parse(raw);
	     JSONObject jsonObject = (JSONObject) obj2;
	     code = (Long) jsonObject.get("code");
	     cat = (String) jsonObject.get("cats");
	    }catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public Long getCode() {
		return code;
	}
	
	public String getCat() {
		return cat;
	}
	
	public String getRawJSON() {
		return raw;
	}
	
	public void Refresh() {
		try {
			 String url = "https://enjuu.click/api/v1/suprise_me";
		     URL obj = new URL(url);
		     HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		     con.setRequestMethod("GET");
		     con.setRequestProperty("User-Agent", "Mozilla/5.0");
		     @SuppressWarnings("unused")
			int responseCode = con.getResponseCode();
		     BufferedReader in = new BufferedReader(
		             new InputStreamReader(con.getErrorStream()));
		     String inputLine;
		     StringBuffer response = new StringBuffer();
		     while ((inputLine = in.readLine()) != null) {
		     	response.append(inputLine);
		     }
		     in.close();
		     raw = response.toString();
		     JSONParser parser = new JSONParser();
		     Object obj2 = parser.parse(raw);
		     JSONObject jsonObject = (JSONObject) obj2;
		     code = (Long) jsonObject.get("code");
		     cat = (String) jsonObject.get("cats");
		    }catch(Exception e) {
				e.printStackTrace();
			}
	}

}
