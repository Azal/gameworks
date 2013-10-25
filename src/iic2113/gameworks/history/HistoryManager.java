package iic2113.gameworks.history;

import java.util.ArrayList;

/**
   The HistoryManage is in charge of handling both managers: the Event and Restriction managers.
   It's the manager in charge of allowing the user to communicate with each of these managers, and handle the sub-elements easily.
   To ensure that we only have one instance, the Singleton pattern was used.
   
   @version  1.0  
   @created_by @group4/Squirrels
   @update_log
        24/10/2013 * @group4/Squirrels - Created the class using the Singleton pattern. 
        *
        */
public class HistoryManager {
		

        //Event Manager, in charge of everything Event related.
		EventManager eventManager;
		//RestrictionManager, in charge of everything that has to do with Restrictions
        RestrictionManager restrictionManager;
        
		/*
    	Instance of the HistoryManager  class, using the Singleton design pattern.
    	When an instance is required, this variable is checked to see if it's null.
		*/
	    private static HistoryManager  instance = null;
    
        //Our constructor simply initializes the list the HistoryManager uses.
        private HistoryManager() {
        	eventManager = new EventManager();
        }
        
        //This method forces the singleton design pattern:
        // - If there's already an instance of HistoryManager  created, it returns it
        // - If there's not,we create one and THEN we return it.
        public static synchronized HistoryManager getInstance() {
                if (instance == null) {
                        instance = new HistoryManager();
                }
                return instance;
        }
        
        // Methods that handle Events
        
        //This method creates a new event with the parameters given, checks that the identifier is unique and adds it to the event list.
        public Event createEvent(String identifier, ArrayList<Restriction> restrictions, ArrayList<Result> results) {
           
        	//Add events to restrictionManager
        	restrictionManager.addRestrictions(restrictions);
        	return eventManager.createEvent(identifier, restrictions, results);
        }
        
        //This get the current status of a certain event
        //The status will be true if all conditions have been satisfied and false otherwise.
        public boolean checkEventStatus(String identifier)
        {
        	return eventManager.checkEventStatus(identifier);
        }
        
        
        
        //Remove event from the list
        public void removeEvent(String identifier)
        {
        	eventManager.removeEvent(identifier);
        }
        
        //Changes an event type from repeating to not repeating.
        //Note: While this method and the next one could be combined into one "toggleRepeating", I decided to leave it like this to make "forcing" a 
        //certain type of event easier.
        public void setEventAsRepeating(String identifier)
        {
        	eventManager.setEventAsRepeating(identifier);
        }
        
        //Changes a repeating event to non-repeating.
        public void setEventAsNonRepeating(String identifier)
        {
        	eventManager.setEventAsNonRepeating(identifier);
        }
        
        //This method changes the identifier of an Event, checking first that the new one hasn't been taken.
        public void changeEventIdentifier(String oldIdentifier, String newIdentifier)
        {
        	eventManager.changeEventIdentifier(oldIdentifier, newIdentifier);
        }
        
        //Gets a particular event by it's identifier. If none are found, returns null
        public Event getEventByIdentifier(String identifier)
        {
        	return eventManager.getEventByIdentifier(identifier);
        }
        
        
        //Get restrictions from an event
        public ArrayList<Restriction> getRestrictionsFromEvent(String identifier)
        {
        	return eventManager.getRestrictionsFromEvent(identifier);
        }
        
      //Trigger one event (will only be triggered if all restrictions have been completed).
        public boolean triggerEvent(String identifier)
        {
        	return eventManager.triggerEvent(identifier);
        }
        
      //Trigger all events
        //The idea is for this method to be called per tick, so that all methods that haven't been triggered yet and have all their restrictions
        //completed can be triggered.
        public void triggerAllDoneEvents()
        {
        	eventManager.triggerAllDoneEvents();
        }
        
      //Get all the results from an event
        public ArrayList<Result> getResultsFromEvent(String identifier)
        {
        	return eventManager.getResultsFromEvent(identifier);
        }
        
        //Add Result to event
        public void addResultToEvent(String eventIdentifier, Result newResult)
        {
        	eventManager.addResultToEvent(eventIdentifier, newResult);
        }
        
        //Remove a Result from an event
        public void removeResultFromEvent(String eventIdentifier, String resultIdentifier)
        {
        	eventManager.removeResultFromEvent(eventIdentifier, resultIdentifier);
        }
        

        //Methods to handle restrictions
        
        //Add a new Restriction to the general restriction list.
        public void addRestriction(Restriction newRestriction)
        {
        	restrictionManager.addRestriction(newRestriction);
        }
        
        //Add a restriction from the general list to an event
        public void addRestrictionToEvent(String eventIdentifier, String restrictionIdentifier)
        {
        	Event e = eventManager.getEventByIdentifier(eventIdentifier);
        	if(e != null)
        		restrictionManager.addRestrictionToEvent(e, restrictionIdentifier);
        }
        
        //Remove a restriction from the general list
        public void removeRestriction(String identifier)
        {
        	restrictionManager.removeRestriction(identifier);
        }
        
        //Remove a restriction from an specific event
        public void removeRestriction(String eventIdentifier, String restrictionIdentifier)
        {
        	Event e = eventManager.getEventByIdentifier(eventIdentifier);
        	if(e != null)
        		restrictionManager.removeRestriction(e, restrictionIdentifier);
        	
        }
        
        
        //Mark a specific restriction as done
        public void markRestrictionAsDone(String identifier)
        {
        	restrictionManager.markRestrictionAsDone(identifier);
        }
        
        //Check all Restrictions
        //Mark a specific restriction as done
        public void checkAllRestrictions()
        {
        	restrictionManager.checkAllRestrictions();
        }
        
        //Persistency
        //This method will be used by the persistency module to load a saved HistoryManager
        //To get the current History Manager, we use the getInstance() method, defined previously.
        public void loadHistoryManager(HistoryManager existingHistoryManager)
        {
     	   //We simply load the values from the existing History Manager
     	   instance = existingHistoryManager;
     	   
        }
        
        
}