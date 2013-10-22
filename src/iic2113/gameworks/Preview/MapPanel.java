package iic2113.gameworks.Preview;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import iic2113.gameworks.Preview.Placeholders.MapObject;

/**
* Class MapPanel
*  Class which contains the logic associated with the panel that will represent 
*  the Map in the map editor window.
*	@version  1
* @created_by @group1/jarizti1       
*/

class MapPanel extends JPanel {
	
	private static final long serialVersionUID = -756677306651426444L;
	public BufferedImage backTile;		//background tile image
	public int cellPix = 0; 			//size of the tiles in pixels
	public int width = 0; 				//of the map in cells
	public int height = 0; 				//of the map in cells
	public List<MapObject> objects = new ArrayList<MapObject>(); //objects in the map
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//fills the background of the map using the properties backtile as image, and cellPix to determine the size of the tiles
		for(int i = 0; i < width;i++){
			for(int j = 0; j < height;j++){
				g.drawImage(backTile, i*cellPix, j*cellPix, null);
			}
		}
		
		//draw the objects in the map
		for (MapObject obj : objects){
			g.drawImage(obj.sprite, obj.x*cellPix, obj.y*cellPix, null);
		}
	}

}