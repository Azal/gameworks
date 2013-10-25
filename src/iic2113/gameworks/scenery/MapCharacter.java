package iic2113.gameworks.scenery;

/**
Here reside all methods to create scenery
 	-Reference to external code: javax.swing.JLabel-
 *
 *	@version  0.1
 *  @created_by @group5/gevalenz,javicabello,ngbravo,vibaseta
 *  @update_log
	22/10/2013 - @group5/ngbravo,gevalenz,javicabello,vibaseta    
 */

public class MapCharacter extends MapObject{

	public MapCharacter(int id) {
		super(id);
	}

	/**
	 * Method to move the Character in a given direction and distance
	 * @param direction Direction of the movement. Can be UP, DOWN, LEFT, RIGHT
	 * @param distance How many grid spaces will it move in the given direction
	 */
	public void move(Direction direction, int distance){
		switch (direction) {
		case UP:
			posY+=distance;
			break;

		case DOWN:
			posY-=distance;
			break;	

		case LEFT:
			posX-=distance;
			break;	

		case RIGHT:
			posX+=distance;
			break;
		}
	}


	//AGREGAR ATRIBUTO DE COMPORTAMIENTO!!!!!!!!!!
	
}
