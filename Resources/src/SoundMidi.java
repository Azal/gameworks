package Resources.src;


public class SoundMidi implements ISound {
	
	
	private boolean useExternalSynth = false;
	
	public boolean PlaySynchronous() {
		
		return true;
	}


	public boolean PlayAsynchronous() {
		
		return true;
	}
	
}
