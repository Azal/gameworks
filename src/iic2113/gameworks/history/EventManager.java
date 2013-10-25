package iic2113.gameworks.history;

import java.util.ArrayList;

/**
   The EventManager, as the name implies, is in charge of managing the Events.
   It does this by managing a list of Events, with each Event having a list of Results and Restrictions. This manager is in charge of handling
   everything related to Results as well, since it's just related to Events. It's not in charge of handling the list of Restrictions, that's the RestrictionManager's job.
   
   @version  1.0  
   @created_by @group4/Squirrels
   @update_log
        26/09/2013 * @group4/Squirrels - Created the class using the Singleton pattern. 
        27/09/2013 * @group4/Kulppi - Return values in many methods, create event, also add restrictions.
        24/10/2013 * @group4/Squirrels - Modified the class so that it's no longer a Singleton and instead is just in charge of handling events and results.
        *
        */
public class EventManager {
		

        /* 
         * ArrayList of Events. By having the complete list of Events, the Manager can check each Event to see if it's done or not(Restrictions) and run the correct
         * response (Results).
         */
        public ArrayList<Event> events;
        
        
        //Our constructor simply initializes the list the EventManager uses.
        public EventManager() {
        	events = new ArrayList<Event>(); 
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
        public void changeEventIdentifier(String oldIdentifier, String newIdentifier)
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
        
        //Gets a particular event by it's identifier. If none are found, returns null
        public Event getEventByIdentifier(String identifier)
        {
        	for(Event e: events){
        		if(e.getIdentifier().equals(identifier))
        			return e;
        		}
        	return null;
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
        
        
}