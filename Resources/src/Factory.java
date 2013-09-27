package Resources.src;

public abstract class Factory {
	
	protected String GetExtension(String path) {
		String extension = "";
		
		int i = path.lastIndexOf('.');
		if (i > 0) {
		    extension = path.substring(i+1);
		}

		return extension;
	}
}
