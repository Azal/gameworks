package iic2113.gameworks.persistence;
import java.io.File;
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

	static boolean isFile(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Finds a file, if it exists, given a root directory
	 */
	static String findFile(File root, String name) {

		// Cleans the results list at the beginning
		List<File> results = new ArrayList<File>();

		if (!root.isDirectory()) {
			throw new IllegalArgumentException("File root is not a directory");
		}
		File[] files = root.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			// if is directory, it starts to search in this directory
			if (file.isDirectory()) {
				findFile(file, name);
			}
			// It compares to the file's name
			if (file.getName().matches(name)) {
				addResult(file, results);
				return results.get(0).getAbsolutePath();
			}
		}

		if (!results.isEmpty()) {
			return results.get(0).getAbsolutePath();
		}
		return "End of search";
	}

	/**
	 * Creates a new file in a given directory, if the directory exists
	 */
	static boolean newFile(String path, Object o) {

		File newpath = new File(path);

		if (!newpath.isDirectory()) {
			// throw new
			// IllegalArgumentException("File root is not a directory");
			newpath.mkdir();
			System.out.print("Entro al if");
		}

		else {

			File f = null;
			boolean bool;

			try {
				// create new file
				System.out.print("El path es " + newpath.getPath() + "\n");
				File f1 = (File) o;
				// System.out.print("El path del object es " + f1.getPath() +
				// "\n");
				f = new File(newpath.getPath(), "text.txt");

				// tries to create new file in the system
				bool = f.createNewFile();

				// prints
				System.out.println("File created: " + bool);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	/**
	 * Print the path to the found files
	 */
	private static void showResults(List<File> results) {
		for (File archivo : results) {
			System.out.println(archivo.getAbsolutePath());
		}
	}

	/**
	 * Add a file to the search results
	 */
	private static void addResult(File file, List<File> results) {
		results.add(file);
		showResults(results);
	}

	/** bottom class **/
}
