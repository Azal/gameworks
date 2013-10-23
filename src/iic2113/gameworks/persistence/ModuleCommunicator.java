package src.iic2113.gameworks.persistence;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;

/**
-Send and ask information from other modules. They must be subscribed.
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */


public class ModuleCommunicator implements ICommunicate {
	enum Modules { story, resources, characterBehaviour, preview, scenery, persistence, network }
	
	public ModuleCommunicator(){
	
	}
	public boolean subscribe() {
		
		return false;
		
	}
	public boolean save(String module, String className, int id, String data) {
		
		/*String parsedData = "";
		while(data.indexOf("\"") != -1)
		{
			parsedData += data.substring(0, data.indexOf("\"")) + "\\" + "\"";
			data = data.substring(data.indexOf("\"") + 1);
		}
		parsedData += "}";
		*/
		
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(data);
			JSONObject json = new JSONObject((Map)obj);
			Encrypter.write(module, className, id, json);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Map<Integer,JSONObject>> load(int module) {
		
		JSONObject json = Encrypter.read("assets/data/" + module + "/");
		Map<String,Map<Integer,JSONObject>> classMap = new HashMap<String,Map<Integer,JSONObject>>();
		Map<Integer,JSONObject> idsMap = new HashMap<Integer, JSONObject>();
		System.out.println("ESTO ESTO");
		
		
		Set<String> o = json.keySet();
		
		for (String strClass : o)
		{
			JSONObject j = (JSONObject) json.get(strClass);
			
			Set<String> i = j.keySet();
			
			for (String strId : i)
			{
				idsMap.put(Integer.parseInt(strId),(JSONObject) j.get(strId));
			}
			
			classMap.put(strClass, idsMap);
			idsMap = new HashMap<Integer, JSONObject>();
	
		}
		
		System.out.println(classMap);
		return classMap;
	}

	
	/**class bottom**/	
}
