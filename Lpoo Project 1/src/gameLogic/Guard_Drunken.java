package gameLogic;

import java.util.ArrayList;



public class Guard_Drunken extends Guard
{
	
	private ArrayList<String> guardMovement = new ArrayList<String>();

	private static char GUARDCHAR = 'G';

	private int currentMovement;

	private int movementLength;
	
	boolean isGuardAsleep;
	
	private int SleepCounter;	//turns until Drunken Guard might fall asleep again
	
	private int SleepDuration;   //turns Drunken Guard stays asleep
	
	private int theDirection;
	
	
	public Guard_Drunken(int x, int y, String[] movement) 
	{
		super(x, y, movement);
		currentMovement = 0;
		theDirection = 1;
		isGuardAsleep = false;
		SleepCounter = 0;
		SleepDuration = 4;
		movementLength = movement.length;
		readmovement(movement);
		// TODO Auto-generated constructor stub
	}

	public void changeChar()
	{
		if(GUARDCHAR == 'G')
		GUARDCHAR = 'g';
		else
			GUARDCHAR = 'G';
	}
	
	public char getc()
	{
		return GUARDCHAR;
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
	
	
	public void tryToFallAsleep()
	{
		int theDirectionChangeRate = 1 + (int)(Math.random() * ((10 - 1) + 1));		//determines if the Guard changes direction after waking up or not
		int theRandomNumber = 1 + (int)(Math.random() * ((10 - 1) + 1));	//determines if the Guard falls asleep or not
		
		if (theRandomNumber >= 8)
		{
			isGuardAsleep = true;
			changeChar();
			SleepCounter = -1;
			//Falta meter aqui a cena de ele ficar com o char 'g' e de o heri nao morrer se ficar ao pe dele
			
			if(theDirectionChangeRate > 5)
			{
				if(theDirection == 1)
				{
					theDirection = -1;
					currentMovement++;
				}
				else if (theDirection == -1)
				{
					theDirection = 1;
					currentMovement--;
				}
			}			
		}
	}
	
	
	public void update() 
	{
		if(isGuardAsleep == true)
		{
			SleepDuration--;
			SleepCounter++;
			if(SleepDuration == 0)
			{
				isGuardAsleep = false;
				changeChar();
				SleepDuration = 4;
			}
		}
		else
		{
			makeMove();
		}
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
		
		if(SleepCounter >= 9)
		{
			tryToFallAsleep();
		}
		
		SleepCounter++;
		
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
