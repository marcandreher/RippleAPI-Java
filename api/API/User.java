package API;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import Main.Static;

@SuppressWarnings("unused")
public class User {
	
	private int code;
	private String country;
	private int id;
	private String latest_activity;
	private int privileges;
	private String registered_on;
	private String username;
	private String username_aka;
	
	private String ide;
	private UserType ty;
	private String raw;
	
	
	public User(UserType type, String identificator) {
		File f = new File("tmp/user.json");
		f.mkdir();
		ide = identificator;
		ty = type;
		if(type == UserType.ID) {
			String getter = null;
	        URL u = null;
			try {
				u = new URL("https://"+Static.server + "/api/v1/users?id="+identificator);
			} catch (MalformedURLException e1) {
				
			}
	        try{
	            URLConnection urlConnection = u.openConnection();
	            urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
	            try (InputStream stream = urlConnection.getInputStream();
	              InputStreamReader inputStreamReader = new InputStreamReader(stream);
	              BufferedReader reader = new BufferedReader(inputStreamReader)) {
	              StringBuilder result = new StringBuilder();
	              String tmp;
	              while ((tmp = reader.readLine()) != null) {
	                result.append(tmp).append("\n");
	              }
	              getter = result.toString();
	            }
	        }catch (Exception e){
	        	
	        }
	            try {
	                JSONObject jsonObject = new JSONObject(getter);
	                code = (int) jsonObject.get("code");
			        country = (String) jsonObject.get("country");
			        id = (int) jsonObject.get("id");
			        latest_activity = (String) jsonObject.get("latest_activity");
			        privileges = (int) jsonObject.get("privileges");
			        registered_on = (String) jsonObject.get("registered_on");
	                username = (String) jsonObject.get("username");
			        username_aka = (String) jsonObject.get("username_aka");
			        raw = getter;
	            } catch (Exception e3) {
	                
	            }
		}else {
			String getter = null;
	        URL u = null;
			try {
				u = new URL("https://"+Static.server + "/api/v1/users?name="+identificator);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
	        try{
	            URLConnection urlConnection = u.openConnection();
	            urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
	            try (InputStream stream = urlConnection.getInputStream();
	              InputStreamReader inputStreamReader = new InputStreamReader(stream);
	              BufferedReader reader = new BufferedReader(inputStreamReader)) {
	              StringBuilder result = new StringBuilder();
	              String tmp;
	              while ((tmp = reader.readLine()) != null) {
	                result.append(tmp).append("\n");
	              }
	              getter = result.toString();
	            }
	        }catch (Exception e){
	        	
	        }
	            
	            try {
	                JSONObject jsonObject =  new JSONObject(getter);
	                code = (int) jsonObject.get("code");
			        country = (String) jsonObject.get("country");
			        id = (int) jsonObject.get("id");
			        latest_activity = (String) jsonObject.get("latest_activity");
			        privileges = (int) jsonObject.get("privileges");
			        registered_on = (String) jsonObject.get("registered_on");
	                username = (String) jsonObject.get("username");
			        username_aka = (String) jsonObject.get("username_aka");
			        raw = getter;
	            } catch (Exception e3) {
	                
	            }
		}
	}
	
	public int getCurrentAPICode() {
		return code;
	}
	
	public String getCountry() {
		return country;
	}
	
	public int getID() {
		return id;
	}
	
	public String getLatest_Activity() {
		return latest_activity;
	}
	
	public int getPrivileges() {
		return privileges;
	}
	
	public String getRegistered_On() {
		return registered_on;
	}
	
	public String getName() {
		return username;
	}
	
	public String getUserName_aka() {
		return username_aka;
	}
	
	public String getRawJSON() {
		return raw;
	}
	
	public URL getUser_Page() {
		try {
			return new URL("https://enjuu.click/u/"+this.getID());
		} catch (MalformedURLException e) {
			
		}
		return null;
	}
	
	public Score getBestScore() {
		try {
			 String url = "https://"+Static.server + "/api/v1/users/scores/best?id="+ id;
		     URL obj = new URL(url);
		     HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		     con.setRequestMethod("GET");
		     con.setRequestProperty("User-Agent", "Mozilla/5.0");
		     int responseCode = con.getResponseCode();
		     BufferedReader in = new BufferedReader(
		             new InputStreamReader(con.getInputStream()));
		     String inputLine;
		     StringBuffer response = new StringBuffer();
		     while ((inputLine = in.readLine()) != null) {
		     	response.append(inputLine);
		     }
		     in.close();
		     JSONObject jsonObject = new JSONObject(response.toString());
		     JSONArray arr = (JSONArray) jsonObject.get("scores");
		     
		     return new Score(arr.getJSONObject(0).getLong("id"), arr.getJSONObject(0).getString("beatmap_md5"), 
		    		 arr.getJSONObject(0).getLong("score"), arr.getJSONObject(0).getLong("max_combo"), 
		    		 arr.getJSONObject(0).getBoolean("full_combo"), arr.getJSONObject(0).getLong("mods"), 
		    		 arr.getJSONObject(0).getLong("count_300"), arr.getJSONObject(0).getLong("count_100"), 
		    		 arr.getJSONObject(0).getLong("count_50"), arr.getJSONObject(0).getLong("count_geki"), 
		    		 arr.getJSONObject(0).getLong("count_katu"), arr.getJSONObject(0).getLong("count_miss"), 
		    		 arr.getJSONObject(0).getString("time"), arr.getJSONObject(0).getLong("play_mode"), 
		    		 arr.getJSONObject(0).getLong("accuracy"), arr.getJSONObject(0).getLong("pp"), 
		    		 arr.getJSONObject(0).getString("rank"), arr.getJSONObject(0).getLong("completed"), 
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("beatmap_id"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("beatmapset_id"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getString("song_name"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("ar"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("od"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("difficulty"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("max_combo"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("hit_length"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("ranked"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("ranked_status_frozen"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getString("latest_update"));
		    }catch(Exception e) {
				
			}
		return null;
	}
	
	public Score getLastScore() {
		try {
			 String url = "https://"+Static.server + "/api/v1/users/scores/recent?id="+ this.getID();
		     URL obj = new URL(url);
		     HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		     con.setRequestMethod("GET");
		     con.setRequestProperty("User-Agent", "Mozilla/5.0");
		     int responseCode = con.getResponseCode();
		     BufferedReader in = new BufferedReader(
		             new InputStreamReader(con.getInputStream()));
		     String inputLine;
		     StringBuffer response = new StringBuffer();
		     while ((inputLine = in.readLine()) != null) {
		     	response.append(inputLine);
		     }
		     in.close();
		     JSONObject jsonObject = new JSONObject(response.toString());
		     JSONArray arr = (JSONArray) jsonObject.get("scores");
		     
		     return new Score(arr.getJSONObject(0).getLong("id"), arr.getJSONObject(0).getString("beatmap_md5"), 
		    		 arr.getJSONObject(0).getLong("score"), arr.getJSONObject(0).getLong("max_combo"), 
		    		 arr.getJSONObject(0).getBoolean("full_combo"), arr.getJSONObject(0).getLong("mods"), 
		    		 arr.getJSONObject(0).getLong("count_300"), arr.getJSONObject(0).getLong("count_100"), 
		    		 arr.getJSONObject(0).getLong("count_50"), arr.getJSONObject(0).getLong("count_geki"), 
		    		 arr.getJSONObject(0).getLong("count_katu"), arr.getJSONObject(0).getLong("count_miss"), 
		    		 arr.getJSONObject(0).getString("time"), arr.getJSONObject(0).getLong("play_mode"), 
		    		 arr.getJSONObject(0).getLong("accuracy"), arr.getJSONObject(0).getLong("pp"), 
		    		 arr.getJSONObject(0).getString("rank"), arr.getJSONObject(0).getLong("completed"), 
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("beatmap_id"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("beatmapset_id"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getString("song_name"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("ar"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("od"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("difficulty"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("max_combo"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("hit_length"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("ranked"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getLong("ranked_status_frozen"),
		    		 arr.getJSONObject(0).getJSONObject("beatmap").getString("latest_update"));
		    }catch(Exception e) {
				
			}
		return null;
	}
	

}
