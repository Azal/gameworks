package iic2113.gameworks.persistence;

import java.awt.List;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Iterator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.runners.Parameterized.Parameters;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * -save&read project progress info in json files.-
 * 
 * @version 0.1
 * @author @group7/slakat
 * @since 26/09/2013 - @group7/slakat
 * @update_log
 */

public class Encrypter {

	public Encrypter() {
		// save();
		// read();


	}

	/**
	 * <p>
	 * 
	 * <p>
	 * 
	 * @param message
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean write(String module, String className, int id,
			JSONObject json) {

		boolean success = false;

		try {
			String filePath = "assets/data/" + module + "/" + className + "_"
					+ id + ".json";
			final File file = new File(filePath);
			final File parent_directory = file.getParentFile();

			if (null != parent_directory) {
				parent_directory.mkdirs();
			}

			FileWriter writer = new FileWriter(file);
			writer.write(json.toJSONString());
			writer.flush();
			writer.close();
			success = true;

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(json);
		return success;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject read(String route) {

		JSONParser parser = new JSONParser();
		JSONObject finalJson = new JSONObject();
		JSONObject subfinalJson = new JSONObject();

		File folder = new File(route);
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles);
		String actual_class = "";
		int hiddenFiles = 0;
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];

			if (file.getName().startsWith(".")) {
				hiddenFiles++;
				continue;
			}

			String actual_id = "";
			if (i > hiddenFiles) {
				if (!actual_class.equals(file.getName().split("_")[0])) {
					finalJson.put(actual_class, subfinalJson);
					System.out.println(finalJson);
					subfinalJson = new JSONObject();
				}
			}
			actual_class = file.getName().split("_")[0];
			String temp = file.getName().split("_")[1];
			int index = temp.lastIndexOf(".json");

			if (index != -1)
				actual_id = temp.substring(0, index);
			else
				continue;

			if (file.isFile() && file.getName().endsWith(".json")) {

				try {
					Object obj = parser.parse(new FileReader(file.getPath()));
					JSONObject jsonObject = (JSONObject) obj;
					subfinalJson.put(actual_id, jsonObject);
					System.out.println("subfinal " + i + " " + subfinalJson);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		finalJson.put(actual_class, subfinalJson);
		System.out.println(finalJson);
		return finalJson;

	}

	/*
	public static String encrypt(String str, Cipher cipher) {

		try {

			byte[] clearText = str.getBytes("UTF-8");

			// Encode bytes to base64 to get a string
			return new sun.misc.BASE64Encoder().encode(cipher
					.doFinal(clearText));

		} catch (UnsupportedEncodingException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String str, Cipher dcipher) {
		
		try {

			byte[] byteDataToDecrypt = str.getBytes();
			byte[] byteCipherText = dcipher.doFinal(byteDataToDecrypt); 
			byte[] decrypted = dcipher.doFinal(byteCipherText);

			return new String(decrypted, "UTF8");
			
		} catch (UnsupportedEncodingException
				| IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	 public static String encrypt(String str, Cipher ecipher) {
	        try {
	            // Encode the string into bytes using utf-8
	            byte[] utf8 = str.getBytes("UTF8");

	            // Encrypt
	            byte[] enc = ecipher.doFinal(utf8);

	            // Encode bytes to base64 to get a string
	            return new sun.misc.BASE64Encoder().encode(enc);
	        } catch (javax.crypto.BadPaddingException e) {
	        } catch (IllegalBlockSizeException e) {
	        } catch (UnsupportedEncodingException e) {
	        } catch (java.io.IOException e) {
	        }
	        return null;
	    }

	    public static String decrypt(String str, Cipher dcipher) {
	        try {
	            // Decode base64 to get bytes
	            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

	            // Decrypt
	            byte[] utf8 = dcipher.doFinal(dec);

	            // Decode using utf-8
	            return new String(utf8, "UTF8");
	        } catch (javax.crypto.BadPaddingException e) {
	        } catch (IllegalBlockSizeException e) {
	        } catch (UnsupportedEncodingException e) {
	        } catch (java.io.IOException e) {
	        }
	        return null;
	    }

	public void encoding() {

	}

	public void decoding() {

	}

}
