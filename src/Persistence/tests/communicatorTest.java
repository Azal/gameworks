

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



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
	public void askTest() {
		assertNotNull(com.ask(0, 1));
	}
	
	
	@Test
	public void subscribeTest() {
		assertTrue(true);
	}

}