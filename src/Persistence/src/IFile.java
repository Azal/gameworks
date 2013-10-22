import java.io.File;


public interface IFile {
	

	
	public boolean isFile(String name);
	
	/**
	 * Finds a file, if it exists, given a root directory
	 */
	public String findFile(File root, String name);
	/**
	 * Creates a new file in a given directory, if the directory exists
	 */
	public boolean newFile(File path, Object o);

	/**class bottom**/	
}
