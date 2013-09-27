package Resources.src;

/**
 * @Version 0.1
 * @created_by @group2/Nicol‡s Castro
 *
 */


public abstract class Factory {
	
	protected String getExtension(String path) {
		String extension = "";
		
		int i = path.lastIndexOf('.');
		if (i > 0) {
		    extension = path.substring(i+1);
		}
		return extension;
	}
}
