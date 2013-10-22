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
	private MapPanel panel = new MapPanel();
	private JPanel contentPane;
	private TextField filepath = new TextField();
	private JSpinner yCell = new JSpinner();
	private JSpinner xCell = new JSpinner();
	private Button addObject = new Button("Add Object");
	private Button save = new Button("Save");
	
	public MapEditionFrame() 
	{
		initGraphicalInterface();
		setHandlers();
		setVisible(true);
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
		addObject.setBounds(316, 304, 79, 24);
		contentPane.add(addObject);
		
		filepath.setText("/image/exp32.png");
		filepath.setBounds(20, 304, 122, 24);
		contentPane.add(filepath);
		
		xCell.setBounds(181, 304, 38, 24);
		contentPane.add(xCell);
		
		yCell.setBounds(249, 304, 38, 24);
		contentPane.add(yCell);
		
		JLabel lblX = new JLabel("x");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblX.setBounds(166, 305, 18, 23);
		contentPane.add(lblX);
		
		JLabel lblY = new JLabel("y");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblY.setBounds(237, 304, 18, 24);
		contentPane.add(lblY);
		
		save.setBounds(533, 399, 79, 24);
		contentPane.add(save);
		
		try {
			panel.backTile = ImageIO.read(this.getClass().getResource("/image/Green tile.png"));
			panel.cellPix = 32;
			panel.width = 16;
			panel.height = 9;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void setHandlers(){
		addObject.addMouseListener(new AddObjectHandler());
	}
	
	private class AddObjectHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				MapObject obj = new MapObject();
				obj.sprite = ImageIO.read(this.getClass().getResource(filepath.getText()));
				obj.x = (int) xCell.getValue();
				obj.y = (int) yCell.getValue();
				panel.objects.add(obj);
				panel.repaint();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
