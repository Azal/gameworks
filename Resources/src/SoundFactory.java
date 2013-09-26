package Resources.src;


public class SoundFactory {
	
	public SoundFactory() {
		
	}
	
	public ISound createSound(String path) {
		if(GetExtension(path).equals("mp3")) {
			return new SoundMP3(path);
		}
		
		else {
			return null;
		}
	}
	
	private String GetExtension(String s) {
		return "mp3";
	}

}
