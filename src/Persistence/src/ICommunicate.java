import java.util.Dictionary;


/**
-Class description goes here.-
	-Reference to external code-
 *
 *	@version  0.1
    @author @group7/slakat
    @since 26/09/2013 - @group7/slakat
    @update_log
       
 */


public interface ICommunicate {
	
	/**
	 * Send message
	 */
	public boolean send(char module);
	
	/**
	 * Identify class and type of object to save
	 * 
	 * @param module: Module number
	 * @param asktype: Type of object
	 * @return true if correct
	 */
	public boolean ask(int module, int asktype);
	
	/**
	 * Subscribe to the communications
	 */
	public boolean subscribe();
	
	/**
	 * Save current state of asked module (first ask method must be called)
	 * 
	 * @param tag: Class name
	 * @param id: class's object id
	 * @param data: Information to save. String as JSON
	 * @return true if saved
	 */
	public boolean save(String tag, int id, String data);

	/**
	 * Load state from asked module (first ask method must be called)
	 * @param module: module id
	 * @return Dictionary with all the information of the module. Dictionary pointing to another dictionary, like a tree structure.
	 */
	public Dictionary<String, String> load(int module);
	
	
	
}
