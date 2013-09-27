import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;

public class GameThread extends Thread {
	
	private Game game;
	
	public GameThread(Game game)
	{
		this.game = game;
	}
	
	public void run() {
		long lastLoopTime = System.currentTimeMillis();
		while(true)
		{
			try { Thread.sleep(10); } catch (Exception e) {}
			
			long delta = System.currentTimeMillis() - lastLoopTime;
			lastLoopTime = System.currentTimeMillis();
			
			Graphics2D g = (Graphics2D) game.GetStrategy().getDrawGraphics();
			g.setColor(Color.black);
			g.fillRect(0,0,800,600);
			
			
			g.setColor(Color.white);
			g.drawString("FPS: " + 1000/delta, 50, 50);
			g.drawString("Mouse position: (" + game.getMousePositionX() + ", " + game.getMousePositionY() + ")", 50, 100);
			
			g.dispose();
			game.GetStrategy().show();
		}
	}

}
