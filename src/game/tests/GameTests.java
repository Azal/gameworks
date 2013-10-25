package game.tests;

import static org.junit.Assert.*;
import game.*;
import org.junit.Test;

class Game extends GameWindows{
	private static Game instance = null;
	
	public Game() {
		super("Test",99,99);
	}
	public static Game Create(){
		if(instance == null)
			instance = new Game();
		return instance;
	}
}

public class GameTests {
	
	@Test
	public void singleton() {
		Game g1 = Game.Create();
		Game g2 = Game.Create();
		assertTrue(g1 == g2);
	}
	
}