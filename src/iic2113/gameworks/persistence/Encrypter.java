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
import java.util.Arrays;
import java.util.Iterator;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.runners.Parameterized.Parameters;

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

	public void encoding() {

	}

	public void decoding() {

	}

}
