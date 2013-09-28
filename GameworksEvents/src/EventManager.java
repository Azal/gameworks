import java.util.ArrayList;

/**
   The EventManager, as the name implies, is in charge of managing the Events.
   It does this by managing a list of Events, which have a list of Restrictions (conditions that must be met to declare the Event as done)
   and Results (actions that will be taken when the Event is marked as done).
   This manager also handles a list of the Restrictions, which can be applied to more than one Event. To do this, the EventManager simply adds a
   previously created Restriction to the list that each Event has. Then, when the Restriction is marked as done, every single Event that requires it
   will have it marked as done.
   
   @version  1.0  
   @created_by @group4/Squirrels
   @update_log
        26/09/2013 * @group4/Squirrels - Created the class using the Singleton pattern. 
        27/09/2013 * @group4/Kulppi - Return values in many methods, create event, also add restrictions.
   @todo
   		- Perhaps using Exceptions to check the uniqueness of the identifiers is too much. This could be switched to simple boolean methods.
        *
        */
public class EventManager {
		
		/*
	    	Instance of the EventManager class, using the Singleton design pattern.
	    	When an instance is required, this variable is checked to see if it's null.
    	*/
        private static EventManager instance = null;
        /* 
         * ArrayList of Events. By having the complete list of Events, the Manager can check each Event to see if it's done or not(Restrictions) and run the correct
         * response (Results).
         */
        public ArrayList<Event> events;
        
        //Since restrictions can be applied to more than one event, we have a general list of Restrictions that will be passed to each Event by reference
        public ArrayList<Restriction> restrictions;
        
        //We make the constructor private so that it can only be accessed by the getInstance() method, forcing the singleton design pattern
        //Our constructor simply initializes the lists the EventManager uses.
        private EventManager() {
        	events = new ArrayList<Event>(); 
        	restrictions = new ArrayList<Restriction>();
        }
        
        //This method forces the singleton design pattern:
        // - If there's already an instance of EventManager created, it returns it
        // - If there's not,we create one and THEN we return it.
        public static synchronized EventManager getInstance() {
                if (instance == null) {
                        instance = new EventManager ();
                }
                return instance;
        }
        
        
        // Methods that handle Events
        
        //This method creates a new event with the parameters given, checks that the identifier is unique and adds it to the event list.
        public Event createEvent(String identifier, ArrayList<Restriction> restrictions, ArrayList<Result> results) {
           //We need to create the new Event with the parameters given
        	Event newEvent = new Event(identifier, restrictions, results);
        	//Check to see the identifier is unique
        	for(Event e: events){
        		if(e.getIdentifier().equals(identifier))
        			throw new IllegalArgumentException("There's already an event with that identifier. Identifiers need to be unique.");
        		}
           //Then we add that Event to our list
        	events.add(newEvent);

                       
            for(Restriction r: restrictions){
                boolean check = true;
                for(Restriction r_in: this.restrictions){
                    if(r_in.getIdentifier().equals(r.getIdentifier()))
                        check = false;
                }
                //We add it normally
                if (check)
                    this.restrictions.add(r);
            }

            return newEvent;
        }
        
        //This get the current status of a certain event
        //The status will be true if all conditions have been satisfied and false otherwise.
        public boolean checkEventStatus(String identifier)
        {
        	//We iterate through the whole list, checking for the Event with that identifier
        	//If we don't find any events with that identifier, we throw an exception
        	for(Event e: events){
        		if(e.getIdentifier().equals(identifier))
         		   return e.isDone();
        		}
	        //If we arrive here, there were no events with that identifier, so we throw an exception
        	throw new IllegalArgumentException("There's no Event with identifier '"+identifier+"'.");
        }
        
        
        
        //Remove event from the list
        public void removeEvent(String identifier)
        {
        	for(Event e: events){
        		if(e.getIdentifier().equals(identifier))
        			events.remove(e);
        		}
        }
        
        //Changes an event type from repeating to not repeating.
        //Note: While this method and the next one could be combined into one "toggleRepeating", I decided to leave it like this to make "forcing" a 
        //certain type of event easier.
        public void setEventAsRepeating(String identifier)
        {
        	for(Event e: events){
        		if(e.getIdentifier().equals(identifier))
        			e.setEventAsRepeating();
        		}
        }
        
        //Changes a repeating event to non-repeating.
        public void setEventAsNonRepeating(String identifier)
        {
        	for(Event e: events){
        		if(e.getIdentifier().equals(identifier))
        			e.setEventAsNonRepeating();
        		}
        }
        
        //This method changes the identifier of an Event, checking first that the new one hasn't been taken.
        public void setEventAsNonRepeating(String oldIdentifier, String newIdentifier)
        {
        	for(Event e: events){
        		if(e.getIdentifier().equals(newIdentifier))
        			throw new IllegalArgumentException("There's already an event with that identifier. Identifiers need to be unique.");
        		}
        	//Now that we know the new one is unique too, we change the old one's.
        	for(Event e: events){
	        		if(e.getIdentifier().equals(oldIdentifier))
	        		{
	        			e.setIdentifier(newIdentifier);
	        			return;
	        		}
        		}
        	throw new IllegalArgumentException("There's no Event with identifier '"+oldIdentifier+"'.");
        }
        
        //Methods to handle restrictions
        
        //Add a new Restriction to the general restriction list.
        public void addRestriction(Restriction newRestriction)
        {
        	//Check that it hasn't been added yet
        	for(Restriction r: restrictions){
        		if(r.getIdentifier().equals(newRestriction.getIdentifier()))
        			throw new IllegalArgumentException("There's already a restriction with that identifier. Identifiers need to be unique.");
        		}
        	//We add it normally
        	restrictions.add(newRestriction);
        }
        
        //Add a restriction from the general list to an event
        public void addRestrictionToEvent(String eventIdentifier, String restrictionIdentifier)
        {
        	//Get that restriction
        	Restriction restrictionToAdd = null;
        	for(Restriction r: restrictions){
        		if(r.getIdentifier().equals(restrictionIdentifier))
        			restrictionToAdd = r;
        		}
        	//Check that it exists
        	if(restrictionToAdd == null)
        		throw new IllegalArgumentException("There's no restriction with the identifier '"+restrictionIdentifier+"'.");
        	
        	for(Event e: events){
        		if(e.getIdentifier().equals(eventIdentifier))
        		{
        			//We check if the restriction is already there
        			for(Restriction r: e.getRestrictions()){
                		if(r.getIdentifier().equals(restrictionIdentifier))
                			throw new IllegalArgumentException("There's already a restriction with that identifier. Identifiers need to be unique.");
                		}
        			//If not, just add it
        			e.getRestrictions().add(restrictionToAdd);
        			return;
        		}	
        	}
        	throw new IllegalArgumentException("There's no event with the identifier '"+eventIdentifier+"'.");
        }
        
        //Remove a restriction from the general list
        public void removeRestriction(String identifier)
        {
        	//Check that it hasn't been added yet
        	for(Restriction r: restrictions){
        		if(r.getIdentifier().equals(identifier))
        			restrictions.remove(r);
        		}
        	//We add it normally
        	
        }
        
        //Remove a restriction from an specific event
        public void removeRestriction(String eventIdentifier, String restrictionIdentifier)
        {
        	//Check that it hasn't been added yet
        	for(Event e: events){
        		if(e.getIdentifier().equals(eventIdentifier))
        		{
        			for(Restriction r: e.getRestrictions()){
                		if(r.getIdentifier().equals(restrictionIdentifier))
                			e.getRestrictions().remove(r);
                		}
        		}
        			
        	}
        	
        }
        
        //Get restrictions from an event
        public ArrayList<Restriction> getRestrictionsFromEvent(String identifier)
        {
        	//We iterate through the whole list, checking for the Event with that identifier
        	//If we don't find any events with that identifier, we throw an exception
        	for(Event e: events){
        		if(e.getIdentifier().equals(identifier))
         		   return e.getRestrictions();
        		}
	        //If we arrive here, there were no events with that identifier, so we throw an exception
        	throw new IllegalArgumentException("There's no Event with the identifier '"+identifier+"'.");
        }
        
        //Mark a specific restriction as done
        public void markRestrictionAsDone(String identifier)
        {
        	//Check that it exists
        	for(Restriction r: restrictions){
        		if(r.getIdentifier().equals(identifier))
        		{
        			r.check();
        			return ;
        		}
        			
        	}
        	//If we make it here, there's no such exception, throw an ... error
        	throw new IllegalArgumentException("There's no Restriction with the identifier '"+identifier+"'.");
        }
        
        //Check all Restrictions
      //Mark a specific restriction as done
        public void checkAllRestrictions()
        {
        	//Iterate through all of them
        	for(Restriction r: restrictions){
        		r.check();	
        	}	
        }
        
        //Methods to handle results
        //This includes executing results
        //We can either trigger one event (if all it's restrictions have been completed) or all events that haven't been triggered (or repeating events)
        
        //Trigger one event (will only be triggered if all restrictions have been completed).
        public boolean triggerEvent(String identifier)
        {
        	for(Event e: events){
        		if(e.getIdentifier().equals(identifier))
         		   return e.triggerEvent();
        		}
            return false;
        }
        //Trigger all events
        //The idea is for this method to be called per tick, so that all methods that haven't been triggered yet and have all their restrictions
        //completed can be triggered.
        public void triggerAllDoneEvents()
        {
        	for(Event e: events){
        		e.triggerEvent();
        	}
        }
        
        //Get al the results from an event
        public ArrayList<Result> getResultsFromEvent(String identifier)
        {
        	//We iterate through the whole list, checking for the Event with that identifier
        	//If we don't find any events with that identifier, we throw an exception
        	for(Event e: events){
        		if(e.getIdentifier().equals(identifier))
         		   return e.getResults();
        		}
	        //If we arrive here, there were no events with that identifier, so we throw an exception
        	throw new IllegalArgumentException("There's no Event with identifier '"+identifier+"'.");
        }
        
        //Add Result to event
        public void addResultToEvent(String eventIdentifier, Result newResult)
        {
        	for(Event e: events){
        		if(e.getIdentifier().equals(eventIdentifier))
        		{
        			//We check if the result is already there
        			for(Result r: e.getResults()){
                		if(r.getIdentifier().equals(newResult.getIdentifier()))
                			throw new IllegalArgumentException("There's already a result with that identifier. Identifiers for results need to be unique per event.");
                		}
        			//If not, just add it
        			e.getResults().add(newResult);
        			return;
        		}	
        	}
        	throw new IllegalArgumentException("There's no event with the identifier '"+eventIdentifier+"'.");
        }
        
        //Remove a Result from an event
        public void removeResultFromEvent(String eventIdentifier, String resultIdentifier)
        {
        	for(Event e: events){
        		if(e.getIdentifier().equals(eventIdentifier))
        		{
        			//We check if the result is actually there
        			for(Result r: e.getResults()){
                		if(r.getIdentifier().equals(resultIdentifier))
	                		{
	                			e.getResults().remove(r);
	                			return;
	                		}
                		}
        			//If not, just add it
        			throw new IllegalArgumentException("There's no Result with thet identifier '"+resultIdentifier+"' in the Event with the identifier '"+resultIdentifier+"'.");
        		}	
        	}
        	throw new IllegalArgumentException("There's no event with the identifier '"+eventIdentifier+"'.");
        }
        
       //Methods used for persistency
        
       //This method will be used by the persistency module to load a saved EventManager
       //To get the current Event Manager, we use the getInstance() method, defined previously.
       public void loadEventManager(EventManager existingEventManager)
       {
    	   //We simply load the values from the exisitng Event Manager
    	   instance = existingEventManager;
    	   events = existingEventManager.events;
    	   restrictions = existingEventManager.restrictions;
    	   
    	   
       }
        
        
        
}