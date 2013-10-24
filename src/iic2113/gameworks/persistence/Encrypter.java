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
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Iterator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
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

	private static SecretKey key;
	private static Cipher ecipher;

	public Encrypter() {
		// save();
		// read();

		try {
			DESKeySpec keySpec = new DESKeySpec("IIC21137".getBytes("UTF8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			key = keyFactory.generateSecret(keySpec);
			ecipher = Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidKeyException | UnsupportedEncodingException
				| InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	public boolean write(String module, String className, int id,
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
			//writer.write(encrypt(json.toJSONString()));
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
	public JSONObject read(String route) {

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

	public String encrypt(String str) {

		try {

			ecipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] utf8 = str.getBytes("UTF8");
			byte[] enc = ecipher.doFinal(utf8);

			return new sun.misc.BASE64Encoder().encode(enc);

		} catch (InvalidKeyException | UnsupportedEncodingException
				| IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String decrypt(String str) {

		try {

			ecipher.init(Cipher.DECRYPT_MODE, key, ecipher.getParameters());
			byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
			byte[] utf8 = ecipher.doFinal(dec);

			return new String(utf8, "UTF8");

		} catch (InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException | IOException
				| InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void encoding() {

	}

	public void decoding() {

	}

}
