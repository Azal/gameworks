import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Map;

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
	
	public ModuleCommunicator(){
	
	}
	public boolean subscribe() {
		
		return false;
		
	}
	public boolean save(int module, String className, int id, String data) {
		
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

	public Dictionary<String, String> load(int module) {
		
		JSONObject json = Encrypter.read("assets/data/" + module + "/");
		
		return null;
	}

	
	/**class bottom**/	
}
