package iic2113.gameworks.persistence;

import org.json.simple.JSONObject;

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
		Encrypter.write("preview", "otrotardis", 0, json);
		Encrypter.write("preview", "tardis", 0, json);
		Encrypter.write("preview", "tardis", 1, json1);
		Encrypter.read("assets/data/preview/");
		
		JSONObject jo = new JSONObject(Encrypter.read("assets/data/preview/"));
		
		Encrypter enc = new Encrypter();
		// Encrypt
		String encrypted = enc.encrypt(jo.toJSONString());
		System.out.println(encrypted);

		// Decrypt
		String decrypted = enc.decrypt(encrypted);
		System.out.println(decrypted);

		// ModuleCommunicator mc = new ModuleCommunicator();
		// mc.load(1);

	}

}
