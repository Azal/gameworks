package src.iic2113.gameworks.persistence;


/**
-Save current state of the project.
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */


public class SaveProjectController extends Thread {
	
	private boolean keepSaving = false;
	
	public SaveProjectController() {
		
	}
	
	public void run()
	{
		while(keepSaving)
		{
			int min =5*60*1000;
			try {
				Thread.sleep(min);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * Check current state of the project
	 */
	public void checkState()
	{
		
	}
	
	/**
	 * Save project
	 */
	public void save()
	{
		
	}
	
	/**
	 * Autosave the project
	 */
	public void autoSave()
	{
		keepSaving =true;
		this.start();
	}
	
	public void noAutoSave()
	{
		keepSaving = false;
	}

	/** class bottom **/
}
