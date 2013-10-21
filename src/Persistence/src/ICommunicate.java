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
	 * Subscribe to the communications
	 */
	public boolean subscribe();
	
	/**
	 * Save current state of asked module (first ask method must be called)
	 * 
	 * @param module: Module number
	 * @param className: Class name
	 * @param id: class's object id
	 * @param data: Information to save. String as JSON
	 * @return true if saved
	 */
	public boolean save(int module, String className, int id, String data);

	/**
	 * Load state from asked module (first ask method must be called)
	 * @param module: module id
	 * @return Dictionary with all the information of the module. Dictionary pointing to another dictionary, like a tree structure.
	 */
	public Dictionary<String, String> load(int module);
	
	
	
}
