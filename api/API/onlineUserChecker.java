package API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Main.Static;

public class onlineUserChecker {
	
	private Long status;
	private Long result;
	private String message;
	
	public onlineUserChecker() throws Exception {
		getItems();
	}

	public Long getResult() {
		return result;
	}
	
	public Long getAPIStatus() {
		return status;
	}
	
	public String getAPIMessage() {
		return message;
	}
	
	public void Refresh() throws Exception {
		getItems();
	}
	
	private void getItems() throws Exception
	{
		 String server = "https://c."+Static.server + "/api/v1/onlineUsers";
	     URL objurl = new URL(server);
	     HttpsURLConnection connect = (HttpsURLConnection) objurl.openConnection();
	     connect.setRequestMethod("GET");
	     connect.setRequestProperty("User-Agent", "Mozilla/5.0");
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(connect.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     JSONParser parser = new JSONParser();
	     Object obj2 = parser.parse(response.toString());
	     JSONObject jsonObject = (JSONObject) obj2;
	     status = (Long) jsonObject.get("status");
	     result = (Long) jsonObject.get("result");
	     message = (String) jsonObject.get("message");
	}
}
