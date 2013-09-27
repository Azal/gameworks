package src;

import java.awt.Color;
import java.awt.Graphics2D;


public class GameThread extends Thread {
	
	private Game game;
	private long lastLoopTime;
	
	public GameThread(Game game)
	{
		this.game = game;
	}
	
	public void run() {
		lastLoopTime = System.currentTimeMillis();
		while(true)
		{
			try { Thread.sleep(10); } catch (Exception e) {}
			if(!game.isPaused()){
				update();
				lastLoopTime = System.currentTimeMillis();
			}
		}
	}
	
	// Example
	private void update(){
		long delta = System.currentTimeMillis() - lastLoopTime;
		
		Graphics2D g = (Graphics2D) game.GetStrategy().getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,800,600);
		
		g.setColor(Color.white);
		g.drawString("FPS: " + 1000/delta, 50, 50);
		g.drawString("Mouse position: (" + game.getMousePositionX() + ", " + game.getMousePositionY() + ")", 50, 100);
		g.drawString("Time: "+game.getGameTime()/1000, 50, 120);
		
		g.dispose();
		game.GetStrategy().show();
	}

}
