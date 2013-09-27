package Resources.src;

/**
 * @Version 0.1
 * @created_by @group2/Ignacio Carmach
 *
 */


public class SoundFactory extends Factory {
	
	public SoundFactory() {

	}

	public ISound createSound(String path) {
		if(getExtension(path).equals("wav")) {
			return new SoundWAV(path);
		}

		else {
			return null;
		}
	}

}
