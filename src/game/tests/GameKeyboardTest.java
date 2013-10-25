package game.tests;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import game.*;

import org.junit.Test;

public class GameKeyboardTest {
	@Test
	public void KeyPressed(){
		GameKeyboard gk = GameKeyboard.Create();
		assertFalse(gk.isPressed(KeyEvent.VK_0));
	}
}