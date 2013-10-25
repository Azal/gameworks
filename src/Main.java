
import iic2113.gameworks.Preview.MainFrame;
import GameTest.Game;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


@SuppressWarnings("serial")
class PauseGameAction extends AbstractAction {
	String toPrint;
    public PauseGameAction(String toPrint) {
    	this.toPrint = toPrint;
    }
    public void actionPerformed(ActionEvent e) {
    	System.out.println(toPrint);
    	try {
			Game game = Game.GetGame();
			if(game.isPaused())
				game.Resume();
			else
				game.Pause();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}

@SuppressWarnings("serial")
class CloseGameAction extends AbstractAction {
	String toPrint;
    public CloseGameAction(String toPrint) {
    	this.toPrint = toPrint;
    }
    public void actionPerformed(ActionEvent e) {
    	System.out.println(toPrint);
    	try {
			Game game = Game.GetGame();
			game.Close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}

public class Main {

	/**
		-Class description goes here.-
			-Reference to external code-
	 *
	 *	@version  0.2
	    @created_by @group8/maxfindel,jpeeblesg
	    @update_log
	    	23/09/2013 - @group8/maxfindel
	    	22/10/2013 - @group1/fjsandov
	    	dd/mm/yyyy - @groupX/author[,author2,...]          
	 */

	/**  
    main documentation comment 
	 * @throws Exception */
	public static void main(String[] args) throws Exception {
		System.out.println("Hello gaming world!");
		MainFrame mainFrame = new MainFrame();
	}

}