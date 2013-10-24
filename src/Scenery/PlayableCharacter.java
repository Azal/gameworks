package Scenery;

/**
Class for playable characters. It inherits from Character
 	-Reference to external code-
*
*	@version  0.1
@created_by @group5/,gevalenz,javicabello,ngbravo
@update_log
	26/09/2013 - @group5/ngbravo,gevalenz, javicabello
*/

public class PlayableCharacter extends Character{
	/**
	 * gold: amount for game-money this character has
	 */
	protected int gold;
	
	/**
	 * Constructor
	 * @param name unique name that identifies the character
	 */
	public PlayableCharacter( String _name){
		super(_name);
		gold = 100;
	}
	

	/**
	 * Makes the character interact with a certain mapObject
	 * @param mapObject the mapObject
	 */
	@Override
	public void interact(MapObject mapObject){
		mapObject.activate();
	}
	
	/**
	 * Getter for gold
	 * @return value of gold
	 */
	public int getGold(){
		return gold;
	}
	
	/**
	 * Setter for gold
	 * @param newGold new value of gold
	 */
	public void setGold(int newGold){
		gold=newGold;
	}
	
	public PlayableCharacter clone(){
		PlayableCharacter newPC = new PlayableCharacter("Default Name");
		newPC.setAttackable(getAttackable());
		newPC.setGold(getGold());
		newPC.setHP(getHP());
		newPC.setKillable(getKillable());
		newPC.setPower(getPower());
		newPC.setSpritePath(getSpritePath());
		newPC.setStamina(getStamina());
		newPC.setXPosition(getXPosition());
		newPC.setYPosition(getYPosition());
		
		return newPC;
	}
}
