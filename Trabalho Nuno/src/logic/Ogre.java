package logic;

import java.util.ArrayList;

//import cli.*;

public class Ogre extends DynamicObject {

	private static char OGRECHAR = 'O';
	private static char OGRECHAR_ON_LEVER = '$';
	private static char OGRECHAR_HIT = '8';
	private int stunLevel = 2;

	private ArrayList<String> ogreMovement = new ArrayList<String>();

	// private int currentMovement;

	private int movementLength;

	private int ogreID;

	public Ogre(int x, int y, String movement[], int ogreID) {
		super(x, y, OGRECHAR);
		// currentMovement = 0;
		movementLength = movement.length;
		readmovement(movement);
		this.ogreID = ogreID;

		// club = new Club(xClub,yClub,'*'); //criar classe club, geri-la no map
	}

	public int getID() {
		return ogreID;
	}

	public void getHit() {
		this.c = OGRECHAR_HIT;
		setStunZero();
		System.out.println("You hit an ogre!");
		}
	public void notHit(){
		this.c=OGRECHAR;
	}
	public void setStunZero()
	{
		stunLevel = 0;
	}
	public void incrementStun(){
		stunLevel=stunLevel+1;
	}
	public int returnStun(){
		return stunLevel;
	}

	public void ogreStepsLever() {
		this.c = OGRECHAR_ON_LEVER;
	}

	public void ogreDoesntStepLever() {
		this.c = OGRECHAR;
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
		// else ogreDoesntStepLever();
		for (int i = 0; i < staticObject.size(); i++) {
			if ((this.getx() + x == (staticObject.get(i)).getx())
					&& (this.gety() + y == (staticObject.get(i)).gety())) {

				if (staticObject.get(i) instanceof Lever)

					return true;

				return false;
			}
		}
		return true;
	}

	public void update(ArrayList<GameObject> staticObject) {
		incrementStun();
		if (returnStun() > 2) {  //quando é stunned, stunlevel volta a 1, precisando de 2 rondas pa se mover
			notHit();
			tryMove(staticObject);
		}
	}

}
