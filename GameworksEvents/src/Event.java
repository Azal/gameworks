import java.util.ArrayList;

/**
An Event is the minimal part of a story.
It has a list of Restrictions (conditions that must be fulfilled before it can be marked as done) and a list of Results
(the actions that will be taken when the Event is marked as done).

@version  1.0  
@created_by @group4/Squirrels
@update_log
		26/09/2013 * @group4/Squirrels - Created the class.         
     *
     */
public class Event {
	//The unique identifier for each Event
	private String identifier;
	//The list of Restrictions that must be completed to mark the event as done.
	private ArrayList<Restriction> restrictions;
	//The list of Results: the actions to be taken when the Event is done.
	private ArrayList<Result> results;
	//To check if it has been executed. All Events start without having been executed.
	private boolean triggerred = false;
	//Repeating event. By default all Events are one-time-only.
	private boolean repeatingEvent = false;
	
	//The identifier must be unique for each Event, and it can't be empty.
	//Both lists can be passed as null to the constructor, and they will be just be initialized as empty.
	//With this constructor, we don't define if the Event is a repeating one or not: by default it's not.
	public Event(String identifierIn, ArrayList<Restriction> restrictionsIn, ArrayList<Result> resultsIn)
	{
		//Check to see if identifier is empty.
		//If it is, we throw an exception: it CAN'T be empty.
		if(identifierIn.equals(""))
			throw new IllegalArgumentException("The identifier for an Event can't be empty.");
		//If it isn't we continue normally	
		identifier = identifierIn;
		//Check both restrictions and results to make sure the lists are never null
		if(restrictionsIn != null)
			restrictions = restrictionsIn;
		else
			restrictions = new ArrayList<Restriction>();
		
		if(resultsIn != null)
			results = resultsIn;
		else
			 results = new ArrayList<Result>();
		
	}
	
	//In this case we define if the Event is a repeating one or not
	public Event(String identifierIn, ArrayList<Restriction> restrictionsIn, ArrayList<Result> resultsIn, boolean repeatIn)
	{
		//Same as before
		//Check to see if identifier is empty.
		//If it is, we throw an exception: it CAN'T be empty.
		if(identifier.equals(""))
			throw new IllegalArgumentException("The identifier for an Event can't be empty.");
		//If it isn't we continue normally	
		identifier = identifierIn;
		//Check both restrictions and results to make sure the lists are never null
		if(restrictionsIn != null)
			restrictions = restrictionsIn;
		else
			restrictions = new ArrayList<Restriction>();
		
		if(resultsIn != null)
			results = resultsIn;
		else
			 results = new ArrayList<Result>();
		//This time repeating is defined
		repeatingEvent = repeatIn;
	}
	
	//This method check if all Restrictions in an Event have been fulfilled.
	//Returns true if they have, false if any of them haven't.
	public boolean isDone()
	{
		//Iterate through the list of restrictions
		//Check to see if it's empty
		if(restrictions.size() > 0)
		{
			boolean allRestrictionsDone = true;
			for(int i=0; i<restrictions.size(); i++)
			{
				if(!restrictions.get(i).done)
					allRestrictionsDone= false;
			}
			//If even a single restriction has yet to be completed, the event still is not complete.
			return allRestrictionsDone;
		}
		else //If we have no restrictions, it can obviously be executed
			return true;
		
	}
	
	//Getters and setters
	
	//We get the unique identifier
	public String getIdentifier()
	{
		return identifier;
	}
	
	//With this method we can change the unique identifier
	public void setIdentifier(String identifierIn)
	{
		identifier = identifierIn;
	}
	
	//We mark the event as a repeating one
	public void setEventAsRepeating()
	{
		this.repeatingEvent = true;
	}
	
	
	//Exactly the opposite of the previous method
	public void setEventAsNonRepeating()
	{
		this.repeatingEvent = false;
	}
	
	//Restriction methods
	
	//Get the list of Restrictions
	public ArrayList<Restriction> getRestrictions()
	{
		return restrictions;
	}
	
	//Add restriction to the list
	public void addRestriction(Restriction newRestriction)
	{
		restrictions.add(newRestriction);
	}
	
	//Remove restriction from the list
	public void removeRestriction(String restrictionIdentifier)
	{
		for(Restriction r: restrictions){
    		if(r.getIdentifier().equals(identifier))
    			restrictions.remove(r);
    		}
	}
	
	//Results methods
	
	//Getter for the list of Results
	public ArrayList<Result> getResults()
	{
		return results;
	}
	
	//This method checks to see if the Event has completed all the Restrictions.
	//If it has, it executes all the Results.
	public void triggerEvent()
	{
		//Check to see if all the restrictions have been completed
		if(this.isDone() && this.triggerred == false)
		{
			triggerred = true;
			//We execute each of the results
			//Check to see if it's empty
			if(results.size() > 0)
			{
				for(int i=0; i<results.size(); i++)
				{
					results.get(i).execute();	
				}
			}
		}
	}
	
	
	
}
