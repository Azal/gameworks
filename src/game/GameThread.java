package game;

/**
	GameThread executes the update method of GameWindows on every tick
	It has methods to know what keys are pressed.
	@version  1.1  
	@created_by @group6/timarti
	@update_log
	            27/09/2013 - @group6/timarti - Created the class.  
	            22/10/2013 - @group6/muZk - refactor       
**/

public class GameThread extends Thread {
	
	private GameWindows game;
	private static int tick = 10;
	
	public GameThread(GameWindows game)
	{
		this.game = game;
	}
	
	public void run() {
		while(!game.isClosed()) // Not sure if this is necessary
		{
			try {
				Thread.sleep(tick); 
			} catch (Exception e) {
				
			}
			
			if(!game.isPaused()){
				game.Update();			
			}
		
		}
	}

}
