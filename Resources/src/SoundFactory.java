package Resources.src;


public class SoundFactory {
	
	public SoundFactory() {

	}

	public ISound createSound(String path) {
		if(GetExtension(path).equals("wav")) {
			return new SoundWAV(path);
		}

		else {
			return null;
		}
	}

	private String GetExtension(String path) {
		String extension = "";
		
		int i = path.lastIndexOf('.');
		if (i > 0) {
		    extension = path.substring(i+1);
		}

		return extension;
	}

}
