package iic2113.gameworks.persistence;

import org.json.simple.JSONObject;
import iic2113.gameworks.persistence.*;

/**
 * -Main for internal use of Persistence Module.
 * 
 * @version 0.1
 * @author @group7/slakat
 * @since 26/09/2013 - @group7/slakat
 * @update_log
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

		Encrypter encrypter = new Encrypter();
		encrypter.write("preview", "otrotardis", 0, json);
		encrypter.write("preview", "tardis", 0, json);
		encrypter.write("preview", "tardis", 1, json1);
		//JSONObject j = encrypter.read("assets/data/preview/");
		//System.out.println("hola: " + j);
		/*JSONObject jo = new JSONObject(encrypter.read("assets/data/preview/"));
		
		// Encrypt
		String encrypted = encrypter.encrypt(jo.toJSONString());
		System.out.println(encrypted);

		// Decrypt
		String decrypted = encrypter.decrypt(encrypted);
		System.out.println(decrypted);
		 */
		// ModuleCommunicator mc = new ModuleCommunicator();
		// mc.load(1);

	}

}
