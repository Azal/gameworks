package src.iic2113.gameworks.resources;

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
		
		else if (getExtension(path).equals("mid")){
			return new SoundMidi(path);
		}

		else {
			return null;
		}
	}

}
