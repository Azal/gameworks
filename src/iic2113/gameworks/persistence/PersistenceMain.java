package iic2113.gameworks.persistence;

import java.util.Scanner;

import org.json.simple.JSONObject;
import iic2113.gameworks.persistence.*;

/**
-Main for internal use of Persistence Module.
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */


public class PersistenceMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONObject json2 = new JSONObject();
		json.put("hola1", "hola1");
		json1.put("hola2", "hola2");
		json2.put("hola3", "hola3");
		Encrypter.write("preview", "otrotardis", 0, json);
		Encrypter.write("preview", "tardis", 0, json);
		Encrypter.write("preview", "tardis", 1, json1);
		Encrypter.read("assets/data/1/");
		
		ModuleCommunicator mc = new ModuleCommunicator();
		mc.load(1);
		
		
		
	}

}
