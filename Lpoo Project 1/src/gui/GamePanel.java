package gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import gameLogic.DynamicObject;
import gameLogic.Game;
import gameLogic.GameObject;
import gameLogic.Map;

public class GamePanel extends JPanel implements KeyListener{
	
	private Game game;
	
	private BufferedImage floor;
	
	public GamePanel(Game game)
	{		
		this.game = game;
		
		try
		{
			floor =ImageIO.read(new File("Sprites/Floor/floor.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawBackground(g);
		drawWalls(g);
	}
	
	private void drawBackground(Graphics g) {
			g.drawImage(floor, 0, 0, null);
	}
	private void drawWalls(Graphics g){
		ArrayList<GameObject> walls = game.getMap().returnWalls(); 
		for(int i=0; i<walls.size();i++)
		{
			g.drawImage(walls.get(i).getCurrentSprite(), walls.get(i).getx()*40, walls.get(i).gety()*40, null);
		}
	}
	

	public void keyPressed(KeyEvent e)
	{
		repaint();
	}
	
	public void keyReleased(KeyEvent e) {}
	
	public void keyTyped(KeyEvent e) {}
}
