package PreviewModule;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class MapEditonFrame extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public MapEditonFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MapPanel panel = new MapPanel();
		panel.setBounds(123, 98, 153, 127);
		contentPane.add(panel);
		
		Image img = new ImageIcon("orangeball.png").getImage();
		panel.paintComponent(panel.getGraphics(), img);
	}
	
	
}
