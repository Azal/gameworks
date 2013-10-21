import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



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
	
	public boolean send(char module) {
		
		return false;
	}
	public boolean subscribe() {
		
		return false;
		
	}

	public boolean ask(int module, int asktype) {
		return false;
	}

	public boolean save(String tag, String data) {
		
		return false;
	}

	public Dictionary<String, String> load() {
		return null;
	}

	
	/**class bottom**/	
}
