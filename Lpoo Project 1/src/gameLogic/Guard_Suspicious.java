package gameLogic;

import java.util.ArrayList;



public class Guard_Suspicious extends Guard
{
	
	private ArrayList<String> guardMovement = new ArrayList<String>();

	private static char GUARDCHAR = 'G';

	private int currentMovement;

	private int movementLength;
	
	private int DirectionChangeCounter;
	
	
	private int theDirection;
	
	
	public Guard_Suspicious(int x, int y, String[] movement) 
	{
		super(x, y, movement);
		currentMovement = 0;
		theDirection = 1;
		DirectionChangeCounter = 0;
		movementLength = movement.length;
		readmovement(movement);
		// TODO Auto-generated constructor stub
	}

	
	private void readmovement(String[] movement) 
	{
		movementLength = movement.length;

		for (int i = 0; i < movement.length; i++) 
		{
			guardMovement.add(movement[i]);
		}
	}
	
	
	public String getCurrentMovement() 
	{
		return guardMovement.get(currentMovement);
	}
	
	
	public void tryToChangeDirection()
	{
		int theRandomNumber = 1 + (int)(Math.random() * ((10 - 1) + 1));
		if (theRandomNumber >= 10)
		{
			if(theDirection == 1)
			{
				theDirection = -1;
				DirectionChangeCounter = -1;
				currentMovement++;
			}
			else if(theDirection == -1)
			{
				theDirection = 1;
				DirectionChangeCounter = -1;
				currentMovement--;
			}
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
		
		if(DirectionChangeCounter >= 5)
		{
			tryToChangeDirection();
		}
		
		DirectionChangeCounter++;
		
		if(theDirection == 1)
		{
			if(currentMovement == (movementLength - 1))
			{
				currentMovement = 0;
			}
			else
			{
				currentMovement++;
			}	
		}
		else
		{
			if(currentMovement == 0)
			{
				currentMovement = movementLength - 1;
			}
			else
			{
				currentMovement--;
			}
		}	
	}
}
