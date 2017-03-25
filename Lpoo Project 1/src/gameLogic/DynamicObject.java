package gameLogic;

import java.util.ArrayList;


public class DynamicObject extends GameObject 
{
	private boolean alive;  
	public DynamicObject(int x,int y,char c) 
	{
		super(x, y, c);
		alive=true;
	}

	public void moveLeft()
	{
		x--; 	
	}
	public void moveRight()
	{
		x++; 
	}
	public void moveUp()
	{
		y--; 
	}
	public void moveDown()
	{
		y++; 
	}
	public void getHit()
	{
		alive=false;
	}
	public boolean isAlive()
	{
		return alive;
	}
	public void update()
	{
			
	}
	public void update(ArrayList<GameObject> staticObject)
	{
	}
	public void update(ArrayList<GameObject> staticObject, int ox, int oy) {

	}
	public void reset(int x, int y){	
	}
}