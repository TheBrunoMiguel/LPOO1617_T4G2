package gameLogic;

import java.util.ArrayList;

public class Guard_Rookie extends DynamicObject
{

	private ArrayList<String> guardMovement = new ArrayList<String>();

	private static char GUARDCHAR = 'G';

	private int currentMovement = 0;

	private int movementLength;
	
	
	public Guard_Rookie(int x, int y, String[] movement) 
	{
		super(x, y, GUARDCHAR);
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

	
	
	public void update() {
		
		makeMove();
		
	}
	
	private void makeMove() {
		String move = getCurrentMovement();
		switch(move){
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
		
		currentMovement++;
		if(currentMovement==movementLength)
			currentMovement=0;
	}
}
