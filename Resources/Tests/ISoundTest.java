package Resources.Tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Resources.src.ISound;
import Resources.src.SoundFactory;

public class ISoundTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void loadAndPlayAsynchronousSound() {
		SoundFactory sf = new SoundFactory();
		ISound sound = sf.createSound("assets/sounds/sound_ambience_nature.wav");
		assertTrue(sound.PlayAsynchronous());
	}
	@Test
	public void loadAndPlaySynchronousSound() {
		SoundFactory sf = new SoundFactory();
		ISound sound = sf.createSound("assets/sounds/sound_ambience_nature.wav");
		assertTrue(sound.PlaySynchronous());
	}

}
