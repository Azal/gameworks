package Resources.src;


public class SoundFactory extends Factory {
	
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

}
