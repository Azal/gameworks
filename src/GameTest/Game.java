package GameTest;

import game.*;
import iic2113.gameworks.Preview.MainFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import game.*;

/**
	Game example.

	@version  1.0  
	@created_by @group6/muZk,timartin,panchotron
	@update_log
	            26/09/2013 * @group6/muZk,timartin,panchotron - Created the class.
*/
public class Game extends GameWindows {
	
	/**
	 * Singleton instance
	 */
	private static Game instance;
	
	/**
	 * NOTE: RESOURCE SHOULD PROVIDE THIS
	 */
	final String BACKGROUND_PATH = "res/images/laberinto.jpg";
	
	/**
	 * NOTE: RESOURCE SHOULD PROVIDE THIS
	 */
	final String PACMAN_PATH = "res/images/pacman.png";
	
	/**
	 * Pacman Image
	 */
	ImageIcon pacman_img;
	
	/**
	 * Background Image
	 */
	ImageIcon background_img;
	
	/**
	 * Pacman Position in the screen
	 */
	int x = 0;
	int y = 144;
	
	private Game(){
		super("Example",216, 288);
	}
	
	public static Game Create(){
		if(instance == null)
			instance = new Game();
		return instance;
	}
	
	/**
	 * Game Initialization goes here
	 */
	public void Init(){
		// ========= INIT OBJECTS ===========
		pacman_img = new ImageIcon(PACMAN_PATH);
		background_img = new ImageIcon(BACKGROUND_PATH);
		//======== END INIT ========== 
		super.Init();
	}

	
	/**
	 * Game Logic goes here
	 */
	public void Update(){
		// ========= GAME LOGIC ===========
		if(IsKeyPressed(KeyEvent.VK_ESCAPE))
			Close();
		if(IsKeyPressed(KeyEvent.VK_P))
			System.out.println(getMousePositionX()+" "+getMousePositionY());
		if(IsKeyPressed(KeyEvent.VK_T))
			System.out.println(getGameTime().toString());
		if(IsKeyPressed(KeyEvent.VK_UP))
			y = Math.max(0, y-1);
		if(IsKeyPressed(KeyEvent.VK_DOWN))
			y = Math.min(288-pacman_img.getIconHeight(), y+1);
		if(IsKeyPressed(KeyEvent.VK_LEFT))
			x = Math.max(0, x-1);
		if(IsKeyPressed(KeyEvent.VK_RIGHT))
			x = Math.min(216-pacman_img.getIconWidth(), x+1);
		// ========= END LOGIC ===========
		super.Update();
	}
	
	/**
	 * Drawing logic goes here
	 */
	@Override
	public void Draw(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(background_img.getImage(),0,0,this);
        g2d.drawImage(pacman_img.getImage(), x,y, this);
	}
	
	/**
	 * Running Example
	 */
	public static void main(String[] args) {
		Game g = Game.Create();
		g.Init();
	}

}