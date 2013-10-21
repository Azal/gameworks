import java.util.Scanner;

import org.json.simple.JSONObject;

/**
-Main for internal use of Persistence Module.
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */


public class mainPersistence {

	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONObject json2 = new JSONObject();
		json.put("hola1", "hola1");
		json1.put("hola2", "hola2");
		json2.put("hola3", "hola3");
		Encrypter s = new Encrypter();
		s.write(1, "tardis", 0, json);
		s.write(1, "tardis", 1, json1);
		s.read("assets/data/1/");
		
		
	}

}
