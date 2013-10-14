import java.io.File;


public interface IFile {
	
	
	public boolean isFile(String name);
	
	public String findFile(File root, String name);
	
	public boolean newFile(File path, Object o);

	/**class bottom**/	
}
