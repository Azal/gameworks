package src.iic2113.gameworks.resources.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import src.iic2113.gameworks.resources.ISound;
import src.iic2113.gameworks.resources.SoundFactory;


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
		assertTrue(sound.playAsynchronous());
	}
	@Test
	public void loadAndPlaySynchronousSound() {
		SoundFactory sf = new SoundFactory();
		ISound sound = sf.createSound("assets/sounds/sound_ambience_nature.wav");
		assertTrue(sound.playSynchronous());
	}

}
