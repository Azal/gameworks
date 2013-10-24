package iic2113.gameworks.Preview;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GameTest.Game;
import iic2113.gameworks.Preview.Interfaces.IGameworksWindow;


/**
* Class MainFrame
*  Class which contains the logic associated with the window displayed to the main interface.
*  From this window the user must be able to select any action to perform.
*	@version  0.1
* @created_by @group1/meacuna      
*/

public class MainFrame extends JFrame implements IGameworksWindow {

	private JPanel spritePanel;
	public JButton editCharacterBtn;
	private JButton editMapBtn;
	private JButton playTestBtn;
	
	public MainFrame() 
	{
		initGraphicalInterface();
		setHandlers();
		setVisible(true);
	}
	
	@Override
	public void initGraphicalInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		JLabel lblGameWorksInterface = new JLabel("GameWorks Interface");
		lblGameWorksInterface.setBounds(10, 17, 604, 47);
		lblGameWorksInterface.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameWorksInterface.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblGameWorksInterface);
		
		spritePanel = new JPanel();
		spritePanel.setBounds(30, 130, 140, 123);
		spritePanel.setBackground(Color.ORANGE);
		getContentPane().setLayout(null);
		getContentPane().add(spritePanel);
		
		spritePanel = new JPanel();
		spritePanel.setBounds(220, 130, 140, 123);
		spritePanel.setBackground(Color.GREEN);
		getContentPane().setLayout(null);
		getContentPane().add(spritePanel);
		
		spritePanel = new JPanel();
		spritePanel.setBounds(410, 130, 140, 123);
		spritePanel.setBackground(Color.BLUE);
		getContentPane().setLayout(null);
		getContentPane().add(spritePanel);
		
		editCharacterBtn = new JButton("Edit Character");
		editCharacterBtn.setBounds(30, 300, 140, 49);
		editCharacterBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(editCharacterBtn);
		
		editMapBtn = new JButton("Edit Map");
		editMapBtn.setBounds(220, 300, 140, 49);
		editMapBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(editMapBtn);
		
		playTestBtn = new JButton("Run Test");
		playTestBtn.setBounds(410, 300, 140, 49);
		playTestBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(playTestBtn);
	}
	

	@Override
	public void setHandlers(){
		editCharacterBtn.addMouseListener(new OpenCharacterEditionFrame());
		editMapBtn.addMouseListener(new OpenMapEditionFrame());
		playTestBtn.addMouseListener(new OpenPlayTest());
	}
	
	
	private class OpenCharacterEditionFrame extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			CharacterEditionFrame characterEditionFrame = new CharacterEditionFrame();
		}
	}
	
	private class OpenPlayTest extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				Game game = Game.Create("Test", 800, 400);
				game.onKeyPress("ENTER", new PauseGameAction("Pausing Game [ENTER]"));
				game.onKeyPress("ESCAPE", new CloseGameAction("Closing game [ESC]"));
				game.Init();
			} catch (Exception e1) {
				e1.printStackTrace();
			}		
		}
		
		@SuppressWarnings("serial")
		private class PauseGameAction extends AbstractAction {
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
		private class CloseGameAction extends AbstractAction {
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
	}
	
	private class OpenMapEditionFrame extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			MapEditionFrame mapEditionFrame = new MapEditionFrame();
		}
	}
	

}
