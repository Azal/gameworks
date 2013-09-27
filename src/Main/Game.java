package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.MouseInfo;
import java.awt.Point;

public class Game {
	
	private static Game game;
	
	private JFrame container;
	private JPanel panel;
	private BufferStrategy strategy;
	
	private Game(String name, int width, int height)
	{
		container = new JFrame(name);

		panel = (JPanel) container.getContentPane();
		panel.setPreferredSize(new Dimension(width,height));
		panel.setLayout(null);
		
		panel.setBounds(0,0,800,600);
		
		container.pack();
		container.setResizable(false);
		//container.setVisible(true);
		
		container.createBufferStrategy(2);
		
		strategy = container.getBufferStrategy();
	}
	
	public static Game Create(String name, int width, int height) throws Exception
	{
		if(game == null)
		{
			game = new Game(name, width, height);
		}
		else
		{
			throw new Exception();
		}
		
		return game;
	}

	public static Game GetGame() throws Exception
	{
		if(game == null)
		{
			throw new Exception();
		}
		return game;
	}
	
	public void Init() throws Exception
	{
		container.setVisible(true);
		
		GameThread gt = new GameThread(game);
		gt.run();
		
	}
	
	public BufferStrategy GetStrategy()
	{
		return strategy;
	}
	
	public double getMousePositionX()
	{
		Point p = MouseInfo.getPointerInfo().getLocation();
		return p.getX();
	}
	
	public double getMousePositionY()
	{
		Point p = MouseInfo.getPointerInfo().getLocation();
		return p.getY();
	}
}
