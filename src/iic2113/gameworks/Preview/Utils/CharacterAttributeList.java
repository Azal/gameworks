package iic2113.gameworks.Preview.Utils;

import iic2113.gameworks.scenery.ISprite;
import iic2113.gameworks.scenery.SceneryFactory;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
* Class CharacterAttributeList
*  Class which propose contains the logic associated with the multiple kind of attributes
*  (string, int, double and boolean) of a character. It is used to manage the attribute 
*  list of CharacterEditionFrame.
*	@version  1.0
* @created_by @group1/fjsandov
*/

public class CharacterAttributeList {
	
	private HashMap<String, String> stringAttrs;
	private HashMap<String, Integer> intAttrs;
	private HashMap<String, Double> doubleAttr;
	private HashMap<String, Boolean> booleanAttrs;
	private DefaultListModel<String> listModel;
	
	public CharacterAttributeList(JList<String> jlist) {
		this.listModel = new DefaultListModel<String>();
		jlist.setModel(listModel);
		stringAttrs = new HashMap<String, String>();
		intAttrs = new HashMap<String, Integer>();
		doubleAttr = new HashMap<String, Double>();
		booleanAttrs = new HashMap<String, Boolean>();
	}
	
	public void setAttr(String key, int value) {
		intAttrs.put(key, value);
		if(!listModel.contains(key)) {
			listModel.addElement(key);
		}
	}
	public void setAttr(String key, boolean value) {
		booleanAttrs.put(key, value);
		if(!listModel.contains(key)) {
			listModel.addElement(key);
		}
	}
	public void setAttr(String key, String value) {
		stringAttrs.put(key, value);
		if(!listModel.contains(key)) {
			listModel.addElement(key);
		}
	}
	public void setAttr(String key, double value) {
		doubleAttr.put(key, value);
		if(!listModel.contains(key)) {
			listModel.addElement(key);
		}
	}
		
	public void removeAttr(ISprite character, int index, String key) {
		if(listModel.contains(key)) {
			listModel.remove(index);
			SceneryFactory.deleteParameter(character.getId(), key);
			removeFromInternalHashAttr(key);
		}
	}
	
	private void removeFromInternalHashAttr(String key) {
		stringAttrs.remove(key);
		intAttrs.remove(key);
		doubleAttr.remove(key);
		booleanAttrs.remove(key);
	}
	
	public void setAttributes(ISprite character) {	
		this.removeAll();
		Set<Entry<String,String>> str_entries = character.getStringParameters().entrySet();
		for (Entry<String, String> entry : str_entries) {
			setAttr(entry.getKey(),entry.getValue());
		}
		Set<Entry<String,Integer>> int_entries = character.getIntParameters().entrySet();
		for (Entry<String, Integer> entry : int_entries) {
			setAttr(entry.getKey(),entry.getValue());
		}
		Set<Entry<String,Double>> double_entries = character.getDoubleParameters().entrySet();
		for (Entry<String, Double> entry : double_entries) {
			setAttr(entry.getKey(),entry.getValue());
		}
		Set<Entry<String,Boolean>> boolean_entries = character.getBooleanParameters().entrySet();
		for (Entry<String,Boolean> entry : boolean_entries) {
			setAttr(entry.getKey(),entry.getValue());
		}
	}
	
	/**
	 * Returns the attribute if it exists. It must be casted to the type determined by getType method. 
	 */
	public Object getAttr(String key) {
		switch(this.getType(key)) {
			case STRING: {
				return stringAttrs.get(key);
			}
			case INT: {
				return intAttrs.get(key);
			}
			case DOUBLE: {
				return doubleAttr.get(key);
			}
			case BOOLEAN: {
				return booleanAttrs.get(key);
			}
			default: {
				return null;
			}
		}
	}
	
	/**
	 * Clear attribute lists.
	 */
	public void removeAll() {
		stringAttrs.clear();
		intAttrs.clear();
		booleanAttrs.clear();
		doubleAttr.clear();
		listModel.clear();
	}
		
	/**
	 * Search for a coincidence on attribute lists and return the type if it exist or AttributeType.NULL if it doesnt exist.
	 */
	public AttributeType getType(String key) {
		if(intAttrs.containsKey(key)) {
			return AttributeType.INT;
		}
		else if(doubleAttr.containsKey(key)) {
			return AttributeType.DOUBLE;
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
	
	/**
	 * Save current attributes on AttributeList on the MapCharacter attributes.
	 * */
	public void setAttrToCharacter(ISprite character) {
		int character_id = character.getId();
		//character.clearParametters();
		Set<Entry<String,String>> str_entries = stringAttrs.entrySet();
		for (Entry<String,String> entry : str_entries) {
			SceneryFactory.setParameter(character_id,entry.getKey(),entry.getValue());
		}
		Set<Entry<String,Integer>> int_entries = intAttrs.entrySet();
		for (Entry<String,Integer> entry : int_entries) {
			SceneryFactory.setParameter(character_id,entry.getKey(),entry.getValue());
		}
		Set<Entry<String,Double>> double_entries = doubleAttr.entrySet();
		for (Entry<String,Double> entry : double_entries) {
			SceneryFactory.setParameter(character_id,entry.getKey(),entry.getValue());
		}
		Set<Entry<String,Boolean>> boolean_entries = booleanAttrs.entrySet();
		for (Entry<String,Boolean> entry : boolean_entries) {
			SceneryFactory.setParameter(character_id,entry.getKey(),entry.getValue());
		}
		
		/*
		 * TODO: INTERFACES NEEDED:
	   	 *  		- MapCharacter.clearParameters()
		 */ 
	}
}