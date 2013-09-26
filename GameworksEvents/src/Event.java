import java.util.ArrayList;

public class Event {
	// new Event(String identifier, List<Restriction> Restrictions, List<Result> Results);
	private ArrayList<Restriction> restrictions;
	
	public Event()
	{
		restrictions = new ArrayList<Restriction>();
	}
	public boolean getStatus()
	{
		//Iterate through the list of restrictions
		boolean done = true;
		for(int i=0; i<restrictions.size(); i++)
		{
			if(!restrictions.get(i).done)
				done = false;
		}
		//If even a single restrictions has yet to be completed, the event still is not complete.
		return done;
	}
}
