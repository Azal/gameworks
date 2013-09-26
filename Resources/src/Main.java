
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SoundFactory sf = new SoundFactory();
		
		ISound sound = sf.createSound("path");
		sound.Play();
	}

}
