package iic2113.gameworks.Preview.Utils;

import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
* Class CharacterAttributeList
*  Class which propose contains the logic associated with the multiple kind of attributes
*  (string, int and boolean) of a character. It is used to manage the list of 
*  attributes of the CharacterEditionFrame.
*	@version  0.5
* @created_by @group1/fjsandov
*/

public class CharacterAttributeList {
	
	private HashMap<String, String> stringAttrs = new HashMap<String, String>();
	private HashMap<String, Integer> intAttrs = new HashMap<String, Integer>();
	private HashMap<String, Boolean> booleanAttrs = new HashMap<String, Boolean>();
	private DefaultListModel<Object> listModel;
	
	public CharacterAttributeList(JList<Object> jlist) {
		this.listModel = new DefaultListModel<Object>();
		jlist.setModel(listModel);
		stringAttrs = new HashMap<String, String>();
		intAttrs = new HashMap<String, Integer>();
		booleanAttrs = new HashMap<String, Boolean>();
	}
	
	public void addAttr(String key, int value) {
		intAttrs.put(key, value);
		listModel.addElement(key);
	}
	public void addAttr(String key, boolean value) {
		booleanAttrs.put(key, value);
		listModel.addElement(key);
	}
	public void addAttr(String key, String value) {
		stringAttrs.put(key, value);
		listModel.addElement(key); 
	}
	
	public void setAttr(String key, int value) {
		intAttrs.put(key, value);
	}
	public void setAttr(String key, boolean value) {
		booleanAttrs.put(key, value);
	}
	public void setAttr(String key, String value) {
		stringAttrs.put(key, value);
	}
	
	public Object getAttr(String key) {
		switch(this.getType(key)) {
			case STRING: {
				return stringAttrs.get(key);
			}
			case INT: {
				return intAttrs.get(key);
			}
			case BOOLEAN: {
				return booleanAttrs.get(key);
			}
			default: {
				return null;
			}
		}
	}
	
	public void removeAll() {
		stringAttrs.clear();
		intAttrs.clear();
		booleanAttrs.clear();
	}
		
	public AttributeType getType(String key) {
		if(intAttrs.containsKey(key)) {
			return AttributeType.INT;
		}
		else if(stringAttrs.containsKey(key)) {
			return AttributeType.STRING;
		}
		else if(booleanAttrs.containsKey(key)) {
			return AttributeType.BOOLEAN;
		}
		else {
			return AttributeType.NULL;
		}	
	}
}