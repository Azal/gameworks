package iic2113.gameworks.history;
import java.util.ArrayList;


/**
   The RestrictionManager is in charge of handling everything related to Restrictions.
   It achieves this by handling a list of restrictions, and by adding, removing and marking them as completed.
   Some of the methods that simply require returning the restrictions of a certain event were moved to the HistoryManger.
   
   @version  1.0  
   @created_by @group4/Squirrels
   @update_log
        24/10/2013 * @group4/Squirrels - Created the class. 
        *
        */
public class RestrictionManager {
	
	//Since restrictions can be applied to more than one event, we have a general list of Restrictions that will be passed to each Event by reference
    public ArrayList<Restriction> restrictions;
    
    //Constructor simply initializes the list
    public RestrictionManager()
    {
    	restrictions = new ArrayList<Restriction>();
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
    
    
    //Add a new Restriction to the general restriction list.
    public void addRestrictions(ArrayList<Restriction> restrictions_in)
    {
    	if(restrictions_in != null )              
            for(Restriction r_in: restrictions_in){
                boolean check = true;
                for(Restriction r: this.restrictions){
                    if(r_in.getIdentifier().equals(r.getIdentifier()))
                        check = false;
                }
                //We add it normally
                if (check)
                    this.restrictions.add(r_in);
            }
    }
    
    //Add a restriction from the general list to an event
    public void addRestrictionToEvent(Event e, String restrictionIdentifier)
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
    	
    			//We check if the restriction is already there
    			for(Restriction r: e.getRestrictions()){
            		if(r.getIdentifier().equals(restrictionIdentifier))
            			throw new IllegalArgumentException("There's already a restriction with that identifier. Identifiers need to be unique.");
            		}
    			//If not, just add it
    			e.getRestrictions().add(restrictionToAdd);
    			return;
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
    public void removeRestriction(Event e, String restrictionIdentifier)
    {
    	//Check that it hasn't been added yet
    	for(Restriction r: e.getRestrictions()){
            if(r.getIdentifier().equals(restrictionIdentifier))
            	e.getRestrictions().remove(r);
            }	
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
    
    public void markRestrictionAsDone(String identifier, Object parameter)
    {
    	//Check that it exists
    	for(Restriction r: restrictions){
    		if(r.getIdentifier().equals(identifier))
    		{
    			r.check(parameter);
    			return ;
    		}
    			
    	}
    	//If we make it here, there's no such exception, throw an ... error
    	throw new IllegalArgumentException("There's no Restriction with the identifier '"+identifier+"'.");
    }
    
    public void markRestrictionAsDone(String identifier, Object[] parameter)
    {
    	//Check that it exists
    	for(Restriction r: restrictions){
    		if(r.getIdentifier().equals(identifier))
    		{
    			r.check(parameter);
    			return ;
    		}
    			
    	}
    	//If we make it here, there's no such exception, throw an ... error
    	throw new IllegalArgumentException("There's no Restriction with the identifier '"+identifier+"'.");
    }
    
    //Check all Restrictions
    public void checkAllRestrictions()
    {
    	//Iterate through all of them
    	for(Restriction r: restrictions){
    		r.check();	
    	}	
    }
    
}
