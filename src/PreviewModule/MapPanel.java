package PreviewModule;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

class MapPanel extends JPanel {

	  public void paintComponent(Graphics g, Image img) {
		  g.drawImage(img, 0, 0, null);
	  }

}
//http://stackoverflow.com/questions/4051408/jpanel-with-image-background