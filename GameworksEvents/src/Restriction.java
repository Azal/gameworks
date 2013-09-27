/**
 A Restriction is one of the conditions that must be completed before an Event can be marked as done.
 One Restriction can appear in more than one Event, so that when it is completed, more than one Event can be triggered.
@version  1.0  
@created_by @group4/Squirrels
@update_log
		26/09/2013 * @group4/Squirrels - Created the class.         
     *
     */

public class Restriction {

	
	/* Similar to the Result, the parts that all identifiers have in common are the unique identifier and the
	 * check() method, which simply validates the condition.
	 * Examples of conditions: 
	 * - When a Charater given has <, <=, >, >= or == hp, exp or level
	 * - Character reaches coordinates X and Y
	 */
	
	public boolean done = false;
	//The unique identifier
	private String identifier;
	
	//The constructor simply initializes the Restriction with its identifier.
	public Restriction(String identifierIn)
	{
		identifier = identifierIn;
	}
	
	//Gets the unique identifier
	public String getIdentifier()
	{
		return identifier;
	}
	
	//Sets the unique identifier
	public void setIdentifier(String newIdentifier)
	{
		identifier = newIdentifier;
	}
	
	//This method validates the condition for the Restriction (which varies depending on the Restriction).
	//If the condition is met, it changes the variable "done" to true.
	public void check()
	{
		done = true;
	}
}
