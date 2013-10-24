package icc2113.gameworks.persistence;
import java.lang.Thread;

/**
-Save current state of the game.
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */


public class SaveGameController extends Thread{
	
	private boolean autosave = false;

	public SaveGameController()
	{
		
	}

	public void run()
	{
		while(autosave)
		{
			int min = 15*60*1000; //every 15 minutes the game will be saved
			try {
				save();
				Thread.sleep(min);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	
	/**
	 * Show alert message window and save current state to the log
	 */
	public void updateLog()
	{
		//comunicación con eventos para que avise
	}
	
	/**
	 * Save the game
	 */
	public void save()
	{
		updateLog();
	}
	
	public void activateAutoSave(){
		autosave = true;
		this.run();
	}
	
	public void desactivateAutoSave(){
		autosave = false;
	}
	
}
