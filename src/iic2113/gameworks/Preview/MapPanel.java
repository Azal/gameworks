package iic2113.gameworks.Preview;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
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
	public Scenery.Map map;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//fills the background of the map
		for(int i = 0; i < map.getWidth();i++){
			for(int j = 0; j < map.getHeight();j++){
				g.drawImage(ImageIO.read(this.getClass().getResource(map.getSpritePath())), i*map.getPixelsPerCell(), j*map.getPixelsPerCell(), null);
			}
		}
		
		//draw the objects in the map
		for (Scenery.MapObject obj : map.getMapObjects()){
			g.drawImage(obj.getSpritePath(), obj.getPositionX()*map.getPixelsPerCell(), obj.getPositionY()*map.getPixelsPerCell(), null);
		}
	}
}