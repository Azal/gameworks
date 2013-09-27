package module;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.runners.Parameterized.Parameters;
 
/**
-save&read project progress info in json files.-
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */

/**  
main documentation comment */

public class Encrypter {
	

public Encrypter(){
	//save();
	//read();
	
}
	

/**
 * <p>
 * 
 * <p>
 * 
 * @param message
 * @return
 */
@SuppressWarnings("unchecked")
public boolean write(String message){
	boolean success = false;
	JSONObject obj = new JSONObject();
	obj.put("name", "Katherine");
	obj.put("age", new Integer(22));
 
	JSONArray list = new JSONArray();
	list.add("msg 1");
	list.add("msg 2");
	list.add("msg 3");
 
	obj.put("messages", list);
 
	try {
 
		FileWriter file = new FileWriter("archivos/test.json");
		file.write(obj.toJSONString());
		file.flush();
		file.close();
		success = true;
 
	} catch (IOException e) {
		e.printStackTrace();
	}
 
	System.out.print(obj);
	return success;
}

public boolean read(String route){
	boolean success=false;
	JSONParser parser = new JSONParser();
	 
	try {
 
		Object obj = parser.parse(new FileReader("archivos/test.json"));
 
		JSONObject jsonObject = (JSONObject) obj;
 
		String name = (String) jsonObject.get("name");
		System.out.println(name);
 
		long age = (Long) jsonObject.get("age");
		System.out.println(age);
 
		// loop array
		JSONArray msg = (JSONArray) jsonObject.get("messages");
		Iterator<String> iterator = msg.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		success = true;
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	return success;
 
}

public void encoding()
{
	
}

public void decoding()
{
	
}


}
