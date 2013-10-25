package iic2113.gameworks.resources.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



import iic2113.gameworks.resources.ResourceMaker;
import iic2113.gameworks.resources.ISound;
import iic2113.gameworks.resources.SoundFactory;



public class ISoundTest {

	private ResourceMaker rm = new ResourceMaker();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void loadAndPlayAsynchronousSound() {
		ISound sound = rm.createSound("assets/sounds/sound_ambience_nature.wav");
		assertTrue(sound.playAsynchronous());
	}
	@Test
	public void loadAndPlaySynchronousSound() {
		ISound sound = rm.createSound("assets/sounds/sound_ambience_nature.wav");
		assertTrue(sound.playSynchronous());
	}

}
