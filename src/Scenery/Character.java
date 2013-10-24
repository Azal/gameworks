package Scenery;

/**
Abstract class for all characters: playable and NPC's
 	-Reference to external code-
 *
 *	@version  0.1
@created_by @group5/,gevalenz,javicabello,ngbravo
@update_log
	26/09/2013 - @group5/ngbravo,gevalenz,javicabello
 */

public abstract class Character {
	/**
	 * name: character's name
	 */
	protected String name;
	/**
	 * hp: character's health
	 */
	protected int hp;
	/**
	 * stamina: character's stamina
	 */
	protected int stamina;
	/**
	 * power: damage this character does
	 */
	protected int power;
	/**
	 * isKillable: true if it can die
	 */
	protected boolean isKillable;
	/**
	 * isAttackable: true if it can be attacked
	 */
	protected boolean isAttackable;
	/**
	 * xPosition: X coordinate in the grid
	 */
	protected int xPosition;
	/**
	 * yPosition: Y coordinate in the grid
	 */
	protected int yPosition;
	/**
	 * spritePath: path to the sprite for this character
	 */
	protected String spritePath;
	
	/**
	 * Constructor
	 */
	public Character(){
		name = null;
		hp = 100;
		stamina = 100;
		power = 100;
		isKillable = false;
		isAttackable = false;
		xPosition = 0;
		yPosition = 0;
		spritePath = null;
	}
	
	/**
	 * Constructor
	 * @param name unique name that identifies the character
	 */
	public Character( String _name){
		name = _name;
		hp = 100;
		stamina = 100;
		power = 100;
		isKillable = false;
		isAttackable = false;
		xPosition = 0;
		yPosition = 0;
		spritePath = null;
	}

	/**
	 * Method that kills the character
	 */
	public void die(){

	}

	/**
	 * Method to move the character in a given direction and amount of steps
	 * @param direction move: up=1/right=2/down=3/left=4
	 * @param distance how many steps
	 */
	public void move(int direction, int distance){
		switch (direction){
		case 1:
			yPosition-=distance;
			break;
		case 2:
			xPosition+=distance;
			break;
		case 3:
			yPosition+=distance;
			break;
		case 4:
			xPosition-=distance;
			break;
		}
	}

	/**
	 * Method to make the character attack in a given direction
	 * @param direction attack: up=1/right=2/down=3/left=4
	 */
	public void attack(int direction){
		
	}

	/**
	 * Setter for the character's name
	 * @param newName new name for the character
	 */
	public void setName(String newName){
		name=newName;
	}

	/**
	 * Getter for the character's name
	 * @return the name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Setter for the character's HP
	 * @param newHP the character's new HP
	 */
	public void setHP(int newHP){
		hp=newHP;
	}

	/**
	 * Getter for the character's HP
	 * @return the character's HP
	 */
	public int getHP(){
		return hp;
	}

	/**
	 * Setter for the character's stamina
	 * @param newStamina the new stamina
	 */
	public void setStamina(int newStamina){
		stamina=newStamina;
	}

	/**
	 * Getter for the character's stamina
	 * @return the character's stamina
	 */
	public int getStamina(){
		return stamina;
	}

	/**
	 * Setter for the character's power
	 * @param newPower the new power
	 */
	public void setPower(int newPower){
		power=newPower;
	}

	/**
	 * Getter for the character's power
	 * @return the character's power
	 */
	public int getPower(){
		return 0;
	}

	/**
	 * Makes the character interact with a certain mapObject
	 * @param mapObject the mapObject
	 */
	public void interact(MapObject mapObject){
		mapObject.activate();
	}

	/**
	 * Setter for isKillable
	 * @param newIsKillable new value for isKillable
	 */
	public void setKillable(boolean newIsKillable){
		isKillable=newIsKillable;
	}

	/**
	 * Getter for isKillable
	 * @return isKillable
	 */
	public boolean getKillable(){
		return isKillable;
	}

	/**
	 * Setter for isAttackable
	 * @param newIsAttackable new value for isAttackable
	 */
	public void setAttackable(boolean newIsAttackable){
		isAttackable=newIsAttackable;
	}

	/**
	 * Getter for isAttackable
	 * @return isAttackable
	 */
	public boolean getAttackable(){
		return isAttackable;
	}

	/**
	 * Setter for xPosition
	 * @param newXPosition new value for xPosition
	 */
	public void setXPosition(int newXPosition){
		xPosition=newXPosition;
	}

	/**
	 * Getter for xPosition
	 * @return xPosition
	 */
	public int getXPosition(){
		return xPosition;
	}

	/**
	 * Setter for yPosition
	 * @param newYPosition new value for yPosition
	 */
	public void setYPosition(int newYPosition){
		yPosition=newYPosition;
	}

	/**
	 * Getter for yPosition
	 * @return yPosition
	 */
	public int getYPosition(){
		return yPosition;
	}

	/**
	 * Setter for spritePath
	 * @param path the new path to the sprite
	 */
	public void setSpritePath(String path){
		spritePath=path;
	}

	/**
	 * Getter for spritePath
	 * @return spritePath
	 */
	public String getSpritePath(){
		return spritePath;
	}
	
	//PROBANDO Integracion continua
	//asdasd
}
