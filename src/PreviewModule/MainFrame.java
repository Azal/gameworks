package PreviewModule;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;




/**
* Class MainFrame
*  Class which contains the logic associated with the window displayed to the main interface.
*  From this window the user must be able to select any action to perform.
*	@version  0.1
* @created_by @group1/meacuna      
*/

public class MainFrame extends JFrame implements IGameworksWindow {

	private JPanel spritePanel;
	private JButton editCharacterBtn;
	private JButton editMapBtn;
	private JButton playTestBtn;
	
	public MainFrame() 
	{
		initGraphicalInterface();
		setHandlers();
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
	}
	
	private class OpenCharacterEditionFrame extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			CharacterEditionFrame characterEditionFrame = new CharacterEditionFrame();
		}
	}
	
	private class OpenMapEditionFrame extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			MapEditonFrame mapEditionFrame = new MapEditonFrame();
		}
	}
	

}
