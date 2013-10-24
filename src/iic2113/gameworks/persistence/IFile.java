package iic2113.gameworks.persistence;

import java.io.File;

public interface IFile {

	/**
	 * Returns a boolean whether the file exists or not
	 * 
	 * @param casterModule
	 *            Contains the Module that is casting the static method
	 * @param name
	 *            Is the title of the file to find
	 */
	boolean isFile(String casterModule, String name);

	/**
	 * Finds a file, if it exists, given a root directory, and it returns the
	 * content of it
	 * 
	 * @param casterModule
	 *            Contains the Module that is casting the static method
	 * @param name
	 *            Is the title of the file to find
	 * @param results
	 *            Stores the folders where a file with the title name
	 */
	String findFile(String casterModule, String name);

	/**
	 * Creates a new file in a given directory, if the directory exists
	 * 
	 * @param path
	 *            Is the path where the new file is going to be created
	 * @param o
	 *            Is the object to save in the directory given by path
	 */
	boolean newFile(String path, Object o);

	/**
	 * Reads a file given a filePath
	 */
	String readFile(String filePath);

	/** class bottom **/
}
