package iic2113.gameworks.Preview;

import iic2113.gameworks.Preview.Interfaces.IGameworksWindow;
import iic2113.gameworks.Preview.Utils.CharacterAttributeList;
import iic2113.gameworks.Preview.Utils.JDoubleSpinner;
import iic2113.gameworks.scenery.ISprite;

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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
* Class CharacterEditionFrame
*  Class which contains the logic associated with the window displayed to make character editions: 
*  manage attributes, behaviors and sprites linked to the character.
*	@version  0.7
* @created_by @group1/fjsandov
* @update_log
		24/10/2013 * @group1/fjsandov - updated to work with scenery module (as it was on this date). 
		25/10/2013 * @group1/fjsandov - updated to work with ScenaryFactory interface (on attributes). 
*/

public class CharacterEditionFrame extends JFrame implements IGameworksWindow
{
	private static final long serialVersionUID = -7491192988502147491L;
	private static CharacterEditionFrame characterEditionFrame = null;
	private ISprite character;
	private CharacterAttributeList characterAttrList; 
	
	private JList<String> attributesList;
	private JTextField stringName;
	private JTextField stringValue;
	private JButton saveAttrString;
	private JTextField integerName;
	private JSpinner integerValue;
	private JButton saveAttrInteger;
	private JTextField booleanName;
	private JCheckBox booleanValue;
	private JButton saveAttrBoolean;
	private JButton removeAttributeBtn;
	private JTextField doubleName;
	private JDoubleSpinner doubleValue;
	private JButton saveAttrDouble;
	
	private JList<Object> behaviorList;
	
	private JButton loadSpriteBtn;
	private JPanel spritePanel;

	private JButton saveBtn;	
	
	private CharacterEditionFrame() {
		initGraphicalInterface();
		setHandlers();
		characterAttrList = new CharacterAttributeList(attributesList);
	}
	
	public void setCharacter(ISprite character) {
		clean();
		this.character = character;
		loadCharacterData();
	}
	
	private void loadCharacterData() {
		characterAttrList.setAttributes(character);
	}
	
	public void clean() {
		attributesList.removeAll();
		characterAttrList.removeAll();
		doubleName.setText("");
		doubleValue.setValue((double)0);
		integerName.setText("");
		integerValue.setValue((int)0);
		stringName.setText("");
		stringValue.setText("");
		booleanName.setText("");
		booleanValue.setSelected(false);
		behaviorList.removeAll();		
	}
	
	public static CharacterEditionFrame getInstance(ISprite character) {
		if(characterEditionFrame == null) {
			characterEditionFrame = new CharacterEditionFrame();
		}
		characterEditionFrame.setCharacter(character);
		characterEditionFrame.setVisible(true);
		return characterEditionFrame;
	}
	
	@Override
	public void initGraphicalInterface() {
		setBounds(100, 100, 648, 480);
		
		JLabel lblEditingCharacter = new JLabel("Editing Character");
		lblEditingCharacter.setBounds(10, 17, 604, 47);
		lblEditingCharacter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditingCharacter.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblEditingCharacter);
		
		JLabel lblString = new JLabel("String:");
		lblString.setBounds(25, 136, 69, 20);
		lblString.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblString);
				
		JLabel lblInteger = new JLabel("Integer:");
		lblInteger.setBounds(25, 101, 69, 20);
		lblInteger.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblInteger);
		
		JLabel lblDouble = new JLabel("Double:");
		lblDouble.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDouble.setBounds(25, 66, 69, 20);
		getContentPane().add(lblDouble);
		
		JLabel lblBoolean = new JLabel("Boolean:");
		lblBoolean.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBoolean.setBounds(25, 172, 69, 20);
		getContentPane().add(lblBoolean);
		
		JLabel lblBehaviors = new JLabel("Behaviors");
		lblBehaviors.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBehaviors.setBounds(25, 221, 97, 20);
		getContentPane().add(lblBehaviors);
		
		doubleName = new JTextField();
		doubleName.setColumns(10);
		doubleName.setBounds(98, 68, 124, 20);
		getContentPane().add(doubleName);
		
		doubleValue = new JDoubleSpinner();
		doubleValue.setBounds(232, 68, 118, 20);
		getContentPane().add(doubleValue);
		
		saveAttrDouble = new JButton("Add/Edit");
		saveAttrDouble.setBounds(356, 67, 81, 23);
		getContentPane().add(saveAttrDouble);
		
		integerName = new JTextField();
		integerName.setBounds(98, 103, 124, 20);
		integerName.setColumns(10);
		getContentPane().add(integerName);
				
		integerValue = new JSpinner();
		integerValue.setBounds(232, 103, 118, 20);
		getContentPane().add(integerValue);
		
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
		
		attributesList = new JList<String>();
		attributesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		attributesList.setBounds(476, 75, 143, 104);
				
		JScrollPane scrollPaneAttrList = new JScrollPane(attributesList);
		scrollPaneAttrList.setBounds(447, 59, 164, 130);
		getContentPane().add(scrollPaneAttrList);
		
		saveAttrInteger = new JButton("Add/Edit");
		saveAttrInteger.setBounds(356, 102, 81, 23);
		getContentPane().add(saveAttrInteger);
		
		saveAttrString = new JButton("Add/Edit");
		saveAttrString.setBounds(356, 137, 81, 23);
		getContentPane().add(saveAttrString);
		
		saveAttrBoolean = new JButton("Add/Edit");
		saveAttrBoolean.setBounds(356, 173, 81, 23);
		getContentPane().add(saveAttrBoolean);
		
		behaviorList = new JList<Object>();
		behaviorList.setBounds(25, 251, 412, 164);
		
		JScrollPane scrollPaneBehaviorList = new JScrollPane(behaviorList);
		scrollPaneBehaviorList.setBounds(13, 239, 438, 191);
		getContentPane().add(scrollPaneBehaviorList);
		
		removeAttributeBtn = new JButton("Remove Attribute");
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
		saveAttrDouble.addMouseListener(new SaveDoubleAttributeHandler());
		saveAttrInteger.addMouseListener(new SaveIntegerAttributeHandler());
		saveAttrString.addMouseListener(new SaveStringAttributeHandler());
		saveAttrBoolean.addMouseListener(new SaveBooleanAttributeHandler());
		attributesList.addListSelectionListener(new AttributeListSelectionListener());
		removeAttributeBtn.addMouseListener(new RemoveAttributeBtnHandler());
		saveBtn.addMouseListener(new SaveButtonHandler());
	}
	
	private class SaveButtonHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			characterAttrList.setAttrToCharacter(character);
			//TODO: Method missing for saving the character.
		}
	}
	
	private class RemoveAttributeBtnHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {			
			characterAttrList.removeAttr(character,attributesList.getSelectedIndex(),(String)attributesList.getSelectedValue());
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
	          if(selectionValues.size()>0){
		          String key = selectionValues.get(0).toString();
		          
		          switch(characterAttrList.getType(key)) {
		          	case STRING: {
		          		stringName.setText(key);
		          		stringValue.setText((String)characterAttrList.getAttr(key));
		          		break;
		          	}
		          	case INT: {
		          		integerName.setText(key);
		          		integerValue.setValue((int)characterAttrList.getAttr(key));
		          		break;
		          	}
		          	case DOUBLE: {
		          		doubleName.setText(key);
		          		doubleValue.setDouble((double)characterAttrList.getAttr(key));
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
	}
	
	private class LoadSpriteHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			SpriteManagerDialog spriteManagerDialog = new SpriteManagerDialog(characterEditionFrame);
			spriteManagerDialog.setVisible(true);
		}
	}
	
	private class SaveIntegerAttributeHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			characterAttrList.setAttr(integerName.getText(), (int)integerValue.getValue());
		}
	}
	
	private class SaveDoubleAttributeHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			characterAttrList.setAttr(doubleName.getText(), doubleValue.getDouble());
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
