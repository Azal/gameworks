package iic2113.gameworks.Preview.Widgets;

import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JList;

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
	
	public void addAttr(String key, int value){
		intAttrs.put(key, value);
		listModel.addElement(key); 
	}
	public void addAttr(String key, boolean value){
		booleanAttrs.put(key, value);
		listModel.addElement(key);
	}
	public void addAttr(String key, String value){
		stringAttrs.put(key, value);
		listModel.addElement(key); 
	}
	
	public void removeAll() {
		stringAttrs.clear();
		intAttrs.clear();
		booleanAttrs.clear();
	}
		
	public AttributeType getType(String key) {
		if(intAttrs.containsKey(key))
		{
			return AttributeType.INT;
		}
		else if(stringAttrs.containsKey(key))
		{
			return AttributeType.STRING;
		}
		else if(booleanAttrs.containsKey(key))
		{
			return AttributeType.BOOOLEAN;
		}
		else
		{
			return AttributeType.NULL;
		}	
	}
}