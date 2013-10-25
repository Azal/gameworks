package iic2113.gameworks.Preview;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import java.awt.Button;
import java.awt.TextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;

import iic2113.gameworks.Preview.Interfaces.IGameworksWindow;
import iic2113.gameworks.Preview.Placeholders.MapObject;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
* Class MapEditonFrame
*  Class which contains the logic associated with the window displayed to make map editions: 
*  manage attributes, and add objects to the map.
*	@version  1
* @created_by @group1/jarizti1       
*/

public class MapEditionFrame extends JFrame implements IGameworksWindow {

	private static final long serialVersionUID = 1699801098792119697L;
	private static MapEditionFrame mapEditionFrame = null;
	private MapPanel panel = new MapPanel();				//this panel shows the current state of the map
	private JPanel contentPane;								//this panel contains all the objects in the MapEditionFrame
	private TextField characterName = new TextField();		//input for the name of the player
	private TextField filePath = new TextField();			//path to the sprite for the player
	private JSpinner yCell = new JSpinner();				//number of the cell that represents the y position for the player
	private JSpinner xCell = new JSpinner();				//number of the cell that represents the x position for the player
	private Button addObject = new Button("Add Object");	//button to add an object given the required inputs
	private Button addPlayer = new Button("Add Player");	//button to add a player
	private Button save = new Button("Save");				//save the state of the scenary module
	private TextField backgroundFilePath = new TextField();	//path to the sprite for the backround
	private Button changeBackground = new Button("Change Background"); //change the background using the given path 
	
	private MapEditionFrame() 
	{
		panel.map = Scenery.Map.getCurrentMap();
		initGraphicalInterface();
		setHandlers();
		setVisible(true);
	}
	
	public static MapEditionFrame getInstance() {
		if(mapEditionFrame == null) {
			mapEditionFrame = new MapEditionFrame();
		}
		mapEditionFrame.setVisible(true);
		return mapEditionFrame;
	}
	
	@Override
	public void initGraphicalInterface() {
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(10, 10, 32*16, 32*9);
		contentPane.add(panel);
		addPlayer.setBounds(443, 304, 79, 24);
		contentPane.add(addPlayer);
		
		characterName.setText("Name");
		characterName.setBounds(20, 319, 122, 24);
		contentPane.add(characterName);
		
		filePath.setText("/images/exp32.png");
		filePath.setBounds(147, 319, 122, 24);
		contentPane.add(filePath);
		
		backgroundFilePath.setText("/images/Green tile.png");
		backgroundFilePath.setBounds(20, 380, 155, 24);		
		contentPane.add(backgroundFilePath);
		
		xCell.setBounds(308, 319, 38, 24);
		contentPane.add(xCell);
		
		yCell.setBounds(376, 319, 38, 24);
		contentPane.add(yCell);
		
		JLabel lblX = new JLabel("x");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblX.setBounds(293, 320, 18, 23);
		contentPane.add(lblX);
		
		JLabel lblY = new JLabel("y");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblY.setBounds(364, 319, 18, 24);
		contentPane.add(lblY);
		
		save.setBounds(533, 399, 79, 24);
		contentPane.add(save);
		
		changeBackground.setBounds(181, 380, 130, 24);
		contentPane.add(changeBackground);
		
		addObject.setBounds(443, 333, 79, 24);
		contentPane.add(addObject);
	}
	

	@Override
	public void setHandlers(){
		addPlayer.addMouseListener(new AddPlayerHandler());
		addObject.addMouseListener(new AddObjectHandler());
		changeBackground.addMouseListener(new ChangeBackgroundHandler());
	}
	
	private class AddPlayerHandler extends MouseAdapter {
		@Override
		//adds an object to the map (panel)
		public void mouseClicked(MouseEvent e) {
			Scenery.PlayableCharacter ply = new Scenery.PlayableCharacter(characterName.getText());
			ply.setXPosition((int) xCell.getValue());
			ply.setYPosition((int) yCell.getValue());
			ply.setSpritePath(filePath.getText());
			panel.map.addCharacter(ply);
			panel.repaint();
		}
	}
	
	private class AddObjectHandler extends MouseAdapter {
		@Override
		//adds an object to the map (panel)
		public void mouseClicked(MouseEvent e) {
			Scenery.MapObject obj = new Scenery.MapObject();
			obj.setXPosition((int) xCell.getValue());
			obj.setYPosition((int) yCell.getValue());
			obj.setSpritePath(filePath.getText());
			panel.map.addMapObject(obj);
			panel.repaint();
		}
	}
	
	private class ChangeBackgroundHandler extends MouseAdapter {
		@Override
		//changes the background path for the map
		public void mouseClicked(MouseEvent e) {
			panel.map.setSpritePath(backgroundFilePath.getText());
			panel.repaint();
		}
	}
}
