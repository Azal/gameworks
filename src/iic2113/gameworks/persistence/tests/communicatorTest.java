package iic2113.gameworks.persistence.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.iic2113.gameworks.persistence.ModuleCommunicator;



public class communicatorTest {
	ModuleCommunicator com;

	@Before
	public void setUp() throws Exception {
		com = new ModuleCommunicator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sendTest() {
		assertTrue(true);
	}
	
	
	@Test
	public void subscribeTest() {
		assertTrue(true);
	}

}
