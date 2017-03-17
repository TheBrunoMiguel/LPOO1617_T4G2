package gameLogic;

import java.util.ArrayList;



public class Guard_Suspicious extends DynamicObject
{
	
	private ArrayList<String> guardMovement = new ArrayList<String>();

	private static char GUARDCHAR = 'G';

	private int currentMovement;

	private int movementLength;
	
	
	private int theDirection;
	
	
	public Guard_Suspicious(int x, int y, String[] movement) 
	{
		super(x, y, GUARDCHAR);
		currentMovement = 0;
		theDirection = 1;
		readmovement(movement);
		// TODO Auto-generated constructor stub
	}

	
	private void readmovement(String[] movement) 
	{
		movementLength = movement.length;

	for (int i = 0; i < movement.length; i++) {

		guardMovement.add(movement[i]);

	}
}
	
	public String getCurrentMovement() {
		return guardMovement.get(currentMovement);

	}
	
	public void tryToChangeDirection()
	{
		int theRandomNumber = 1 + (int)(Math.random() * ((10 - 1) + 1));
		if (theRandomNumber >= 8)
		{
			theDirection = (theDirection * (-1));
			currentMovement--;
		}
	}
	
	
	public void update() {
		
		makeMove();
		
	}
	
	private void makeMove() {
		String move = getCurrentMovement();
		if(theDirection == 1)
		{
			switch (move) 
			{
			case "up":
				moveUp();
				break;
			case "down":
				moveDown();
				break;
			case "right":
				moveRight();
				break;
			case "left":
				moveLeft();
				break;
			}
		}
		else
		{
			switch (move) 
			{
			case "up":
				moveDown();
				break;
			case "down":
				moveUp();
				break;
			case "right":
				moveLeft();
				break;
			case "left":
				moveRight();
				break;
			}
		}
		
		if(currentMovement > 2)
		{
			tryToChangeDirection();
		}
		
		
		/*
		if(theDirection == 1)
		{
			currentMovement++;	
		}
		else
		{
			currentMovement--;
		}
		*/
		
		currentMovement++;
		
		if(currentMovement==movementLength)
			currentMovement=0;
			
		
	}
}
