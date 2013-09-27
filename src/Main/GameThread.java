package Main;
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
			
			update();
			events();
		}
	}
	
	
	/**
	 * Update in map elements (player and NPC positions, objects, bullets, animations, etc)
	 * @author nggomez, timartin
	 */
	private void update(){
		// Example implementation
		long delta = System.currentTimeMillis() - lastLoopTime;
		lastLoopTime = System.currentTimeMillis();
		
		Graphics2D g = (Graphics2D) game.GetStrategy().getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,800,600);
		
		g.setColor(Color.white);
		
		g.drawString("FPS: "+1000/delta, 50, 50);
		g.drawString("Time: "+game.getGameTime()/1000, 50, 80);
		
		
		g.dispose();
		game.GetStrategy().show();
	}
	
	/**
	 * Fire other type of events
	 * @author nggomez
	 */
	private void events(){
		
	}
	
}
