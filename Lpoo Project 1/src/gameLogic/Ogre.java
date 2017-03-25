package gameLogic;

import java.util.ArrayList;

//import cli.*;

public class Ogre extends DynamicObject {

	private static char OGRECHAR = 'O';
	private static char OGRECHAR_ON_LEVER = '$';
	

	private ArrayList<String> ogreMovement = new ArrayList<String>();

	// private int currentMovement;

	private int movementLength;
	

	public Ogre(int x, int y, String movement[]) {
		super(x, y, OGRECHAR);
		// currentMovement = 0;
		movementLength = movement.length;
		readmovement(movement);
		
		//club = new Club(xClub,yClub,'*');  //criar classe club, geri-la no map
	}

	public void ogreStepsLever() {
		this.c=OGRECHAR_ON_LEVER;
	}

	public void ogreDoesntStepLever() {
		this.c=OGRECHAR;
	}

	public String getCurrentMovement() {
		return ogreMovement.get(0 + (int) (Math.random() * movementLength));

	}

	// public int getRandomNbr() {
	//
	// return randomNbr;
	// }

	private void readmovement(String[] movement) {

		for (int i = 0; i < movement.length; i++) {

			ogreMovement.add(movement[i]);

		}
	}

	public void tryMove(ArrayList<GameObject> staticObject) {
		switch (getCurrentMovement()) {

		case "up":
			if (trymoveUp(staticObject))
				;
			else
				tryMove(staticObject);
			break;

		case "down":
			if (trymoveDown(staticObject))
				;
			else
				tryMove(staticObject);

			break;

		case "right":
			if (trymoveRight(staticObject))
				;
			else
				tryMove(staticObject);
			break;

		case "left":
			if (trymoveLeft(staticObject))
				;
			else
				tryMove(staticObject);
			break;

		default:
			tryMove(staticObject);
		}

	}

	public boolean trymoveLeft(ArrayList<GameObject> staticObject) {
		if (canOgreMove(staticObject, -1, 0)) {
			moveLeft();
			return true;
		}
		return false;

	}

	public boolean trymoveRight(ArrayList<GameObject> staticObject) {
		if (canOgreMove(staticObject, 1, 0)) {
			moveRight();
			return true;
		}
		return false;

	}

	public boolean trymoveUp(ArrayList<GameObject> staticObject) {
		if (canOgreMove(staticObject, 0, -1)) {
			moveUp();
			return true;
		}
		return false;

	}

	public boolean trymoveDown(ArrayList<GameObject> staticObject) {
		if (canOgreMove(staticObject, 0, 1)) {
			moveDown();
			return true;
		}
		return false;

	}

	public boolean canOgreMove(ArrayList<GameObject> staticObject, int x, int y) {
//		else ogreDoesntStepLever();
		for (int i = 0; i < staticObject.size(); i++) {
			if ((this.getx() + x == ( staticObject.get(i)).getx())
					&& (this.gety() + y == ( staticObject.get(i)).gety())) {
				
				if(staticObject.get(i) instanceof Lever)
					
					return true;
				
				return false;
			}
		}
		return true;
	}

	public void update(ArrayList<GameObject> staticObject) {
		tryMove(staticObject);
	}

}