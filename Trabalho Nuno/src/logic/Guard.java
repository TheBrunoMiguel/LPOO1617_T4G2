package logic;

import java.util.ArrayList;

import java.util.Random;

public class Guard extends DynamicObject {

	private ArrayList<String> guardMovement = new ArrayList<String>();

	private static char GUARDCHAR='G';

	private int currentMovement;

	private int movementLength;
//	
//	private int direction;
//	
//	private int lastMovement;

	//private int randomNbr;

	public Guard(int x, int y, String movement[]) {
		super(x, y, GUARDCHAR);
	//	randomNbr = 0;
//		Guard.GUARDCHAR=GUARDCHAR;
		currentMovement = 0;
//		lastMovement =
		movementLength = movement.length;

		readmovement(movement);
	}


	public String getCurrentMovement() {

			return guardMovement.get(currentMovement);


	}

//	public int getRandomNbr() {
//
//		return randomNbr;
//	}

	private void readmovement(String[] movement) {

		for (int i = 0; i < movement.length; i++) {

			guardMovement.add(movement[i]);

		}
	}

	public void update() {

		makeMove();
	}

	private void makeMove() {		//FALTA CHECKAR MOVEMENT DO OGRE, HITREG DO OGRE, ver game.java a ver se da pa implementar movement do ogre como o do hero
		String move = getCurrentMovement();
		switch (move) {
		case "up":
			moveUp();
			break;
		case "w":
			moveUp();
			break;
		case "down":
			moveDown();
			break;
		case "s":
			moveDown();
			break;
		case "right":
			moveRight();
			break;
		case "d":
			moveRight();
			break;
		case "left":
			moveLeft();
			break;
		case "a":
			moveLeft();
			break;
		}
		
		currentMovement++;
//		if(direction==1)
//		currentMovement++;
//		
//		else(direction==-1) 
//		currentmovement--;
//		
//		
//		lastMovement=direction;
		
		if (GUARDCHAR == 'G') {
			if (currentMovement == movementLength)
				currentMovement = 0;
		}

	}

}
