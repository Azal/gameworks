package iic2113.gameworks.Preview;


import iic2113.gameworks.Preview.Interfaces.IGameworksWindow;
import iic2113.gameworks.scenery.SceneryFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GameTest.Game;


/**
* Class MainFrame
*  Class which contains the logic associated with the window displayed to the main interface.
*  From this window the user must be able to select any action to perform.
*	@version  0.2
* @created_by @group1/meacuna      
*/

public class MainFrame extends JFrame implements IGameworksWindow {

	private static final long serialVersionUID = 1L;
	private static MainFrame mainFrame = null;
	private JPanel spritePanel;
	public JButton editCharacterBtn;
	private JButton editMapBtn;
	private JButton playTestBtn;
	
	private MainFrame() {
		initGraphicalInterface();
		setHandlers();
	}
	
	public static MainFrame getInstance() {
		if(mainFrame == null) {
			mainFrame = new MainFrame();
		}
		mainFrame.setVisible(true);
		return mainFrame;
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
	public void setHandlers() {
		editCharacterBtn.addMouseListener(new OpenCharacterEditionFrame());
		editMapBtn.addMouseListener(new OpenMapEditionFrame());
		playTestBtn.addMouseListener(new OpenPlayTest());
	}
		
	private class OpenCharacterEditionFrame extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			CharacterEditionFrame characterEditionFrame = CharacterEditionFrame.getInstance(SceneryFactory.createMapCharacter());
		}
	}
	
	private class OpenPlayTest extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				Game game = Game.Create("Test", 800, 400);
				game.Init();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			/*
			   Game game = Game.Create();
			   game.Init();
			 */
		}
	}
	
	private class OpenMapEditionFrame extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			MapEditionFrame mapEditionFrame = MapEditionFrame.getInstance();
		}
	}

	@Override
	public void clean() {
		
	}
}
