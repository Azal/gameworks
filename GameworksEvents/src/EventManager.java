import java.util.ArrayList;

/**
        Class description goes here.
        Reference to external code
   @version  1.0  
   @created_by @group4/Squirrels
   @update_log
 		26/09/2013 * @group4/Squirrels - Created the class using the Singleton pattern.         
        */
public class EventManager {
		/*
	    	Instance of the EventManager class, using the Singleton design pattern.
	    	When an instance is required, this variable is checked to see if it's null.
    	*/
        private static EventManager instance = null;
        /* 
         * ArrayList of Events. By having the complete list of Events, the Manager can check 
         */
        private ArrayList<Event> stringList = new ArrayList<Event>(); 
        /* 
        constructor Blah documentation comment...     */
        private EventManager() {       }
        
        /*
        method doSomething documentation comment...     */
        public static synchronized EventManager getInstance() {
                if (instance == null) {
                        instance = new EventManager ();
                }
                return instance;
        }
        /* Methods that handle Events (Creation, check status, etc...)*/
}