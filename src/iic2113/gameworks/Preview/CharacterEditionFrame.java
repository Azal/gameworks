package iic2113.gameworks.Preview;

import iic2113.gameworks.Preview.Interfaces.IGameworksWindow;
import iic2113.gameworks.Preview.Utils.CharacterAttributeList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Scenery.Character;

/**
* Class CharacterEditionFrame
*  Class which contains the logic associated with the window displayed to make character editions: 
*  manage attributes, behaviors and sprites linked to the character.
*	@version  0.7
* @created_by @group1/fjsandov
* @update_log
		25/10/2013 * @group1/fjsandov - updated to work with scenery module (as it was on this date).   
* 
*/

public class CharacterEditionFrame extends JFrame implements IGameworksWindow
{
	private static final long serialVersionUID = -7491192988502147491L;
	private static CharacterEditionFrame characterEditionFrame = null;
	private Character character = null;
	private CharacterAttributeList characterAttrList; 
	
	private JList<Object> attributesList;
	private JTextField stringName;
	private JTextField stringValue;
	private JButton saveAttrString;
	private JButton saveAttrBoolean;
	private JTextField numericName;
	private JButton saveAttrNumeric;
	private JSpinner numericValue;
	private JTextField booleanName;
	private JCheckBox booleanValue;
	private JButton removeAttributeBtn;
	
	private JList<Object> behaviorList;
	
	private JButton loadSpriteBtn;
	private JPanel spritePanel;

	private JButton saveBtn;
	
	private CharacterEditionFrame() {
		initGraphicalInterface();
		setHandlers();
		characterAttrList = new CharacterAttributeList(attributesList);
	}
	
	public void setCharacter(Character character) {
		clean();
		this.character = character;
		loadCharacterData();
	}
	
	private void loadCharacterData() {
		characterAttrList.addAttr("name", character.getName());
		characterAttrList.addAttr("hp", character.getHP());
		characterAttrList.addAttr("stamina", character.getStamina());
		characterAttrList.addAttr("power", character.getPower());
		characterAttrList.addAttr("killable", character.getKillable());
		characterAttrList.addAttr("attackable", character.getAttackable());
		characterAttrList.addAttr("x_position", character.getXPosition());
		characterAttrList.addAttr("y_position", character.getYPosition());
	}
	
	public void clean() {
		attributesList.removeAll();
		characterAttrList.removeAll();
	}
	
	public static CharacterEditionFrame getInstance(Character character) {
		if(characterEditionFrame == null) {
			characterEditionFrame = new CharacterEditionFrame();
		}
		characterEditionFrame.setCharacter(character);
		characterEditionFrame.setVisible(true);
		return characterEditionFrame;
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
		saveAttrNumeric.addMouseListener(new SaveNumericAttributeHandler());
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
		removeAttributeBtn.setEnabled(false);
		removeAttributeBtn.setBounds(468, 189, 132, 23);
		getContentPane().add(removeAttributeBtn);
		
		saveBtn = new JButton("Save");
		saveBtn.setBounds(501, 381, 113, 49);
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(saveBtn);
	}
	
	@Override
	public void setHandlers() {
		loadSpriteBtn.addMouseListener(new LoadSpriteHandler());
		saveAttrNumeric.addMouseListener(new SaveNumericAttributeHandler());
		saveAttrString.addMouseListener(new SaveStringAttributeHandler());
		saveAttrBoolean.addMouseListener(new SaveBooleanAttributeHandler());
		attributesList.addListSelectionListener(new AttributeListSelectionListener());
		saveBtn.addMouseListener(new SaveButtonListener());
	}
	
	private class SaveButtonListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			character.setName((String)characterAttrList.getAttr("name"));
			character.setHP((int)characterAttrList.getAttr("hp"));
			character.setStamina((int)characterAttrList.getAttr("stamina"));
			character.setPower((int)characterAttrList.getAttr("power"));
			character.setKillable((boolean)characterAttrList.getAttr("killable"));
			character.setAttackable((boolean)characterAttrList.getAttr("attackable"));
			character.setXPosition((int)characterAttrList.getAttr("x_position"));
			character.setYPosition((int)characterAttrList.getAttr("y_position"));
			
			//METHOD MISSING FOR SAVING THE CHARACTER.
		}
	}
	
	private class AttributeListSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent listSelectionEvent) {
	        boolean adjust = listSelectionEvent.getValueIsAdjusting();
	        if(!adjust) {
	          JList list = (JList) listSelectionEvent.getSource();
	          
	          @SuppressWarnings("unchecked")
	          List<Object> selectionValues = list.getSelectedValuesList();
	          String key = selectionValues.get(0).toString();
	          
	          switch(characterAttrList.getType(key)) {
	          	case STRING: {
	          		stringName.setText(key);
	          		stringValue.setText((String)characterAttrList.getAttr(key));
	          		break;
	          	}
	          	case INT: {
	          		numericName.setText(key);
	          		numericValue.setValue((int)characterAttrList.getAttr(key));
	          		break;
	          	}
	          	case BOOLEAN: {
	          		booleanName.setText(key);
	          		booleanValue.setSelected((boolean)characterAttrList.getAttr(key));
	          		break;
	          	}
	          	default: {
	          		break;
	          	}   	 
	          }
	        }
		}
	}
	
	private class LoadSpriteHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			SpriteManagerDialog spriteManagerDialog = new SpriteManagerDialog(characterEditionFrame);
			spriteManagerDialog.setVisible(true);
		}
	}
	
	private class SaveNumericAttributeHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			characterAttrList.setAttr(numericName.getText(), (int)numericValue.getValue());
		}
	}
	
	private class SaveStringAttributeHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			characterAttrList.setAttr(stringName.getText(), stringValue.getText());
		}
	}
	
	private class SaveBooleanAttributeHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			characterAttrList.setAttr(booleanName.getText(), booleanValue.isSelected());
		}
	}
}
