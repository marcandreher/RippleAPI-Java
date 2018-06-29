package API;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Main.Static;

public class User {
	
	private Long code;
	private String country;
	private Long id;
	private String latest_activity;
	private Long privileges;
	private String registered_on;
	private String username;
	private String username_aka;
	
	private String ide;
	private UserType ty;
	
	
	public User(UserType type, String identificator) {
		File f = new File("tmp/user.json");
		f.mkdir();
		ide = identificator;
		ty = type;
		if(type == UserType.ID) {
			String getter = null;
	        URL u = null;
			try {
				u = new URL(Static.server + "/api/v1/users?id="+identificator);
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
	            JSONParser parser = new JSONParser();
	            try {
	            	File f2 = new File("tmp/user.json");

	            	f2.getParentFile().mkdirs(); 
	            	f2.createNewFile();
	            	PrintWriter writer = new PrintWriter("tmp/user.json", "UTF-8");
	            	writer.println(getter);
	            	writer.close();
	            	Object obj = parser.parse(new FileReader("tmp/user.json"));
	                JSONObject jsonObject = (JSONObject) obj;
	                code = (Long) jsonObject.get("code");
			        country = (String) jsonObject.get("country");
			        id = (Long) jsonObject.get("id");
			        latest_activity = (String) jsonObject.get("latest_activity");
			        privileges = (Long) jsonObject.get("privileges");
			        registered_on = (String) jsonObject.get("registered_on");
	                username = (String) jsonObject.get("username");
			        username_aka = (String) jsonObject.get("username_aka");
	            } catch (Exception e3) {
	                e3.printStackTrace();
	            }
		}else {
			String getter = null;
	        URL u = null;
			try {
				u = new URL(Static.server + "/api/v1/users?name="+identificator);
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
	            JSONParser parser = new JSONParser();
	            try {
	            	File f2 = new File("tmp/user.json");

	            	f2.getParentFile().mkdirs(); 
	            	f2.createNewFile();
	            	PrintWriter writer = new PrintWriter("tmp/user.json", "UTF-8");
	            	writer.println(getter);
	            	writer.close();
	            	Object obj = parser.parse(new FileReader("tmp/user.json"));
	                JSONObject jsonObject = (JSONObject) obj;
	                code = (Long) jsonObject.get("code");
			        country = (String) jsonObject.get("country");
			        id = (Long) jsonObject.get("id");
			        latest_activity = (String) jsonObject.get("latest_activity");
			        privileges = (Long) jsonObject.get("privileges");
			        registered_on = (String) jsonObject.get("registered_on");
	                username = (String) jsonObject.get("username");
			        username_aka = (String) jsonObject.get("username_aka");
	            } catch (Exception e3) {
	                e3.printStackTrace();
	            }
		}
	}
	
	public Long getCurrentAPICode() {
		return code;
	}
	
	public String getCountry() {
		return country;
	}
	
	public Long getID() {
		return id;
	}
	
	public String getLatest_Activity() {
		return latest_activity;
	}
	
	public Long getPrivileges() {
		return privileges;
	}
	
	public String getRegistered_On() {
		return registered_on;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getUserName_aka() {
		return username_aka;
	}
	
	public Score getBestScore() {
		if(ty == UserType.ID){
				String getter = null;
		        URL u = null;
				try {
					u = new URL(Static.server + "/api/v1/users/scores/best?id="+ide);
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
		            JSONParser parser = new JSONParser();
		            try {
		            	File f2 = new File("tmp/user.json");

		            	f2.getParentFile().mkdirs(); 
		            	f2.createNewFile();
		            	PrintWriter writer = new PrintWriter("tmp/user.json", "UTF-8");
		            	writer.println(getter);
		            	writer.close();
		            	Object obj = parser.parse(new FileReader("tmp/user.json"));
		                JSONObject jsonObject = (JSONObject) obj;
		                return new Score((Long) jsonObject.get("id"));
		            } catch (Exception e3) {
		                e3.printStackTrace();
		            }
		}else {
			String getter = null;
	        URL u = null;
			try {
				u = new URL(Static.server + "/api/v1/users/scores/best?name="+ide);
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
	            JSONParser parser = new JSONParser();
	            try {
	            	File f2 = new File("tmp/user.json");

	            	f2.getParentFile().mkdirs(); 
	            	f2.createNewFile();
	            	PrintWriter writer = new PrintWriter("tmp/user.json", "UTF-8");
	            	writer.println(getter);
	            	writer.close();
	            	Object obj = parser.parse(new FileReader("tmp/user.json"));
	                JSONObject jsonObject = (JSONObject) obj;
	                JSONArray slideContent = (JSONArray) jsonObject.get("scores");
	            } catch (Exception e3) {
	                e3.printStackTrace();
	            }
		}
		return null;
		
		
			
	}
	
	public Boolean isOnline() {
		if(ty == UserType.ID) {
			String getter = null;
	        URL u = null;
			try {
				u = new URL(Static.server + "/api/v1/isOnline?id="+ide);
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
	            JSONParser parser = new JSONParser();
	            try {
	            	File file = new File("tmp/user.json");
	            	file.delete();
	            	PrintWriter writer = new PrintWriter("tmp/user.json", "UTF-8");
	            	writer.println(getter);
	            	writer.close();
	            	Object obj = parser.parse(new FileReader("tmp/user.json"));
	                JSONObject jsonObject = (JSONObject) obj;
	                return (Boolean) jsonObject.get("result");
	            } catch (Exception e3) {
	                e3.printStackTrace();
	            }
		}else {
			String getter = null;
	        URL u = null;
			try {
				u = new URL(Static.server + "/api/v1/isOnline?u="+ide);
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
	            JSONParser parser = new JSONParser();
	            try {
	            	File file = new File("tmp/user.json");
	            	file.delete();
	            	PrintWriter writer = new PrintWriter("tmp/user.json", "UTF-8");
	            	writer.println(getter);
	            	writer.close();
	            	Object obj = parser.parse(new FileReader("tmp/user.json"));
	                JSONObject jsonObject = (JSONObject) obj;
	                return (Boolean) jsonObject.get("result");
	            } catch (Exception e3) {
	                e3.printStackTrace();
	            }
		}
		return null;
	}
	
	
	public void refresh_Items() {
		if(ty == UserType.ID) {
			String getter = null;
	        URL u = null;
			try {
				u = new URL(Static.server + "/api/v1/users?id="+ide);
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
	            JSONParser parser = new JSONParser();
	            try {
	            	File file = new File("tmp/user.json");
	            	file.delete();
	            	PrintWriter writer = new PrintWriter("tmp/user.json", "UTF-8");
	            	writer.println(getter);
	            	writer.close();
	            	Object obj = parser.parse(new FileReader("tmp/user.json"));
	                JSONObject jsonObject = (JSONObject) obj;
	                code = (Long) jsonObject.get("code");
			        country = (String) jsonObject.get("country");
			        id = (Long) jsonObject.get("id");
			        latest_activity = (String) jsonObject.get("latest_activity");
			        privileges = (Long) jsonObject.get("privileges");
			        registered_on = (String) jsonObject.get("registered_on");
	                username = (String) jsonObject.get("username");
			        username_aka = (String) jsonObject.get("username_aka");
	            } catch (Exception e3) {
	                e3.printStackTrace();
	            }
		}else {
			String getter = null;
	        URL u = null;
			try {
				u = new URL(Static.server + "/api/v1/users?name="+ide);
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
	            JSONParser parser = new JSONParser();
	            try {
	            	File file = new File("tmp/user.json");
	            	file.delete();
	            	PrintWriter writer = new PrintWriter("tmp/user.json", "UTF-8");
	            	writer.println(getter);
	            	writer.close();
	            	Object obj = parser.parse(new FileReader("tmp/user.json"));
	                JSONObject jsonObject = (JSONObject) obj;
	                code = (Long) jsonObject.get("code");
			        country = (String) jsonObject.get("country");
			        id = (Long) jsonObject.get("id");
			        latest_activity = (String) jsonObject.get("latest_activity");
			        privileges = (Long) jsonObject.get("privileges");
			        registered_on = (String) jsonObject.get("registered_on");
	                username = (String) jsonObject.get("username");
			        username_aka = (String) jsonObject.get("username_aka");
	            } catch (Exception e3) {
	                e3.printStackTrace();
	            }
		}
	}

}
