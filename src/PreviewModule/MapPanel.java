package PreviewModule;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

class MapPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -756677306651426444L;
	public BufferedImage backTile;
	public int cellPix = 0;
	public int width = 0; //in cells
	public int height = 0; //in cells
	public List<MapObject> objects = new ArrayList<MapObject>();
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < width;i++){
			for(int j = 0; j < height;j++){
				g.drawImage(backTile, i*cellPix, j*cellPix, null);
			}
		}
		
		for (MapObject obj : objects){
			g.drawImage(obj.sprite, obj.x*cellPix, obj.y*cellPix, null);
		}
	}

}