package iic2113.gameworks.persistence;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.plaf.FileChooserUI;

/**
 * -find and updates files path or create them if don't exists
 * 
 * @version 0.1
 * @author @group7/slakat
 * @since 26/09/2013 - @group7/slakat
 * @update_log
 */

public class FileManager {


	/**
	 * Returns a boolean whether the file exists or not
	 * @param casterModule Contains the Module that is casting the static method
	 * @param name Is the title of the file to find
	 */
	static boolean isFile(String casterModule, String name) {
		
		if (findFile(casterModule, name) != "") {
			return true;
		} else
			return false;
	}

	/**
	 * Finds a file, if it exists, given a root directory, and it returns the
	 * content of it
	 * @param casterModule Contains the Module that is casting the static method
	 * @param name Is the title of the file to find
	 * @param results Stores the folders where a file with the title name
	 */
	static String findFile(String casterModule, String name) {

		List<File> results = new ArrayList<File>();
		String result = "";

		File root = new File(casterModule);

		if (!root.isDirectory()) {
			System.out.print("File " + root.getPath()
					+ " is not a directory");
		}
		try {
			File[] files = root.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				// if is directory, it starts to search in this directory
				if (file.isDirectory()) {
					result = findFile(file.getPath(), name);
				}
				// It compares to the file's name
				if (file.getName().matches(name)) {
					addResult(file, results);
					if(!results.isEmpty())
						result = results.get(0).getPath();
					}
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * Creates a new file in a given directory, if the directory exists
	 * @param path Is the path where the new file is going to be created
	 * @param o Is the object to save in the directory given by path
	 */
	static boolean newFile(String path, Object o) {

		File newpath = new File(path);

		if (!newpath.isDirectory()) {

			// Creates new directory if it doesn't exists
			newpath.mkdirs();
		}

		File f = null;
		boolean bool;

		try {
			// create new file
			File f1 = (File) o;
			f = new File(newpath.getAbsolutePath(), f1.getName());

			// tries to create new file in the system
			bool = f.createNewFile();

			// prints
			System.out.println("File created: " + bool);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Print the path to the found files
	 */
	private static void showResults(List<File> results) {
		for (File archivo : results) {
			System.out.println(archivo.getPath());
		}
	}

	/**
	 * Add a file to the search results
	 */
	private static void addResult(File file, List<File> results) {
		results.add(file);
	}

	/**
	 * Reads a file given a filePath
	 */
	public static String readFile(String filePath) {
		
		String content = null;
		File file = new File(filePath);
		try {
			FileReader reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;

	}

	/** class bottom **/
}