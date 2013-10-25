package Scenery;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterTest {

	@Test
	public void testDie() {
		fail("Not yet implemented");
	}

	@Test
	public void testMove() {
		Character tester = new PlayableCharacter("");

		tester.xPosition = 1;

		tester.yPosition = 1;

		tester.move(3, 1);

		assertEquals("Move 1 down yPosition should be 2", 2, tester.yPosition);


		tester.xPosition = 1;

		tester.yPosition = 1;

		tester.move(4, 1);

		assertEquals("Move 1 left xPosition should be 0", 0, tester.xPosition);
		
		
		tester.xPosition = 1;

		tester.yPosition = 1;

		tester.move(2, 1);

		assertEquals("Move 1 right xPosition should be 2", 2, tester.xPosition);
		
		
		tester.xPosition = 1;

		tester.yPosition = 1;

		tester.move(1, 1);

		assertEquals("Move 1 up xPosition should be 0", 0, tester.yPosition);
	}

	@Test
	public void testInteract() {
		fail("Not yet implemented");
	}

}
