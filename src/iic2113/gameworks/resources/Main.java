package iic2113.gameworks.resources;

import static org.junit.Assert.fail;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Main {

	/**
	-Class description goes here.-
		-Reference to external code-
	 *
	 *	@version  0.1
	    @created_by @group2/ijcarmach
	    @update_log
	    	26/09/2013 - @group8/maxfindel
	    	26/09/2013 - @group2/ijcarmach
	    	dd/mm/yyyy - @groupX/author[,author2,...]          
	 */
	
	/**  
    main documentation comment */
	public static void main(String[] args) {
		SoundFactory sf = new SoundFactory();

		ISound sound = sf.createSound("/sounds/sound_ambience_nature.wav");
		sound.playAsynchronous();

		System.out.println("hola");
		
		JFrame f = new JFrame("Load Image Sample");
        
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
 
        ImageFactory iff = new ImageFactory();
         IImage iim = iff.createImage("/images/megaman.gif");
         iim.filterGreyScale(1);
         JLabel picLabel = new JLabel(new ImageIcon(iim.getImageObject()));
         f.add(picLabel);
         f.pack();
        f.setVisible(true);
        try {
           
            File outputfile = new File("saved1.gif");
            ImageIO.write((RenderedImage) iim.getImageObject(), "gif", outputfile);
        } catch (IOException e) {
        }
		
//		ISound cancionMidi = sf.createSound("/sounds/N64_MarioKart64.mid");
//		cancionMidi.playSynchronous();
        
        
	}

}
