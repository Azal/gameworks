package iic2113.gameworks.persistence;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

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
		Encrypter.read("assets/data/preview/");

		/*
		//Hay que cambiar este metodo a private.. esta asi por ahora para probar
		try {
			DESKeySpec keySpec = new DESKeySpec("SecreKey".getBytes("UTF8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(keySpec);

			// Encrypt
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			
			String encrypted = Encrypter.encrypt("hola como estas, muy bien y tu? {}", cipher);
			System.out.println(encrypted);

			cipher.init(Cipher.DECRYPT_MODE, key,cipher.getParameters());
			String decrypted = Encrypter.decrypt(encrypted, cipher);
			System.out.println(decrypted);
			
			
		} catch (InvalidKeyException | UnsupportedEncodingException
				| NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		*/
		try {
		    // Generate a temporary key. In practice, you would save this key.
		    // See also Encrypting with DES Using a Pass Phrase.
		    SecretKey key = KeyGenerator.getInstance("DES").generateKey();

			// Encrypt
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			

		    // Encrypt
		    String encrypted = Encrypter.encrypt("Hola como estas, esto es una prueba {},:", cipher);
		    System.out.println(encrypted);
		    cipher.init(Cipher.DECRYPT_MODE, key, cipher.getParameters());
		    
		    // Decrypt
		    String decrypted = Encrypter.decrypt(encrypted, cipher);
		    System.out.println(decrypted);
		} catch (Exception e) {
		}
		//ModuleCommunicator mc = new ModuleCommunicator();
		//mc.load(1);
		
		
		
	}

}
