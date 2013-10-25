package iic2113.gameworks.Preview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import iic2113.gameworks.Preview.Interfaces.IGameworksWindow;

/**
* Class CharacterEditionFrame
*  Class which contains the logic associated with the window displayed to make character editions: 
*  manage attributes, behaviors and sprites linked to the character.
*	@version  0.5
* @created_by @group1/fjsandov       
*/

public class CharacterEditionFrame extends JFrame implements IGameworksWindow
{
	private static final long serialVersionUID = -7491192988502147491L;
	CharacterEditionFrame characterEditionFrame;
	
	private JList<Object> attributesList;
	private JTextField stringName;
	private JTextField stringValue;
	private JButton saveAttrString;	
	private JTextField numericName;
	private JSpinner numericValue;
	private JButton saveAttrNumeric;	
	private JTextField booleanName;
	private JCheckBox booleanValue;
	private JButton saveAttrBoolean;
	private JButton removeAttributeBtn;
	
	private JList<Object> behaviorList;
	
	private JButton loadSpriteBtn;
	private JPanel spritePanel;

	private JButton saveBtn;
	
	public CharacterEditionFrame() 
	{
		characterEditionFrame = this;
		initGraphicalInterface();
		setHandlers();
		setVisible(true);
	}
	
	@Override
	public void initGraphicalInterface() {
		setBounds(100, 100, 640, 480);
		
		JLabel lblEditingCharacter = new JLabel("Editing Character");
		lblEditingCharacter.setBounds(10, 17, 604, 47);
		lblEditingCharacter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditingCharacter.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblEditingCharacter);
		
		JLabel lblAttributes = new JLabel("Attributes");
		lblAttributes.setBounds(25, 70, 69, 20);
		lblAttributes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblAttributes);
		
		JLabel lblString = new JLabel("String:");
		lblString.setBounds(25, 136, 69, 20);
		lblString.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblString);
				
		JLabel lblNumeric = new JLabel("Numeric:");
		lblNumeric.setBounds(25, 101, 69, 20);
		lblNumeric.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNumeric);
		
		JLabel lblBoolean = new JLabel("Boolean:");
		lblBoolean.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBoolean.setBounds(25, 172, 69, 20);
		getContentPane().add(lblBoolean);
		
		JLabel lblBehaviors = new JLabel("Behaviors");
		lblBehaviors.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBehaviors.setBounds(25, 221, 97, 20);
		getContentPane().add(lblBehaviors);
		
		numericName = new JTextField();
		numericName.setBounds(98, 103, 124, 20);
		numericName.setColumns(10);
		getContentPane().add(numericName);
				
		numericValue = new JSpinner();
		numericValue.setBounds(232, 103, 118, 20);
		getContentPane().add(numericValue);
		
		stringName = new JTextField();
		stringName.setBounds(98, 138, 124, 20);
		stringName.setColumns(10);
		getContentPane().add(stringName);
		
		stringValue = new JTextField();
		stringValue.setBounds(228, 138, 122, 20);
		stringValue.setColumns(10);
		getContentPane().add(stringValue);
		
		spritePanel = new JPanel();
		spritePanel.setBounds(476, 223, 125, 123);
		spritePanel.setBackground(Color.CYAN);
		getContentPane().setLayout(null);
		getContentPane().add(spritePanel);
		
		loadSpriteBtn = new JButton("Load Sprite");		
		loadSpriteBtn.setBounds(498, 347, 103, 23);
		getContentPane().add(loadSpriteBtn);
		
		booleanName = new JTextField();
		booleanName.setColumns(10);
		booleanName.setBounds(98, 174, 124, 20);
		getContentPane().add(booleanName);
		
		booleanValue = new JCheckBox("true?");
		booleanValue.setBounds(240, 173, 97, 23);
		getContentPane().add(booleanValue);
		
		attributesList = new JList<Object>();
		attributesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		attributesList.setBounds(458, 74, 143, 104);
		getContentPane().add(attributesList);
		
		saveAttrNumeric = new JButton("Add/Edit");
		saveAttrNumeric.addMouseListener(new AddNumericAttributeHandler());
		saveAttrNumeric.setBounds(356, 102, 81, 23);
		getContentPane().add(saveAttrNumeric);
		
		saveAttrString = new JButton("Add/Edit");
		saveAttrString.setBounds(356, 137, 81, 23);
		getContentPane().add(saveAttrString);
		
		saveAttrBoolean = new JButton("Add/Edit");
		saveAttrBoolean.setBounds(356, 173, 81, 23);
		getContentPane().add(saveAttrBoolean);
		
		behaviorList = new JList<Object>();
		behaviorList.setBounds(25, 251, 412, 164);
		getContentPane().add(behaviorList);
		
		removeAttributeBtn = new JButton("Remove Attribute");
		removeAttributeBtn.setBounds(468, 189, 132, 23);
		getContentPane().add(removeAttributeBtn);
		
		saveBtn = new JButton("Save");
		saveBtn.setBounds(501, 381, 113, 49);
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(saveBtn);
	}
	
	@Override
	public void setHandlers(){
		loadSpriteBtn.addMouseListener(new LoadSpriteHandler());
		saveAttrNumeric.addMouseListener(new AddNumericAttributeHandler());
	}
	
	private class LoadSpriteHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			SpriteManagerDialog spriteManagerDialog = new SpriteManagerDialog(characterEditionFrame);
			spriteManagerDialog.setVisible(true);
		}
	}
	
	private class AddNumericAttributeHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
	}
}
