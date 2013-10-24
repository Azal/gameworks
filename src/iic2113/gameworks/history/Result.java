package iic2113.gameworks.history;
/**
 A Result is one of the actions an Event performs when it is done.
 The most important part in this element (besides the unique identifier, which is simply used to recognize Results) is
 the execute() method, which all possible Results must have, but performs differently for each Result.

@version  1.0  
@created_by @group4/Squirrels
@update_log
		26/09/2013 * @group4/Squirrels - Created the class.         
     *
     */
public class Result {
	/* Examples of Results: 
	 * - Change a character's hp
	 * - Change the level of a character
	 * - Give a character experience
	 * - Move the player to a position
	 * - Spawn an item
	 */
	
	//The constructor just takes the unique identifier
	public Result(String identifierIn)
	{
		identifier = identifierIn;
	}
	//The unique identifier
	private String identifier;
	
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
		

	public void execute()
	{
		//Perform the action
	}
}
