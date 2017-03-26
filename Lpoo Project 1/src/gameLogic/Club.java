package gameLogic;

import java.util.ArrayList;

public class Club extends DynamicObject { // classe independente ou static
											// object/dynamic?

	private static char CLUBCHAR = '*';
	private static char CLUBCHAR_ON_LEVER = '$';
	private ArrayList<String> clubMovement = new ArrayList<String>();
	private int movementLength;
	private int clubID;
	private int a=0;
	// private Ogre ogreTmp;

	public Club(int x, int y, String movement[],int clubID) {
		super(x, y, CLUBCHAR);
		movementLength = movement.length;
		readmovement(movement);
		this.clubID=clubID;
		// ogreTmp=ogre;

	}
	public int getID(){
		return clubID;
	}

	public void clubStepsLever() {
		this.c = CLUBCHAR_ON_LEVER;
	}

	public void clubDoesntStepLever() {
		this.c = CLUBCHAR;
	}

	public void readmovement(String[] movement) {

		for (int i = 0; i < movement.length; i++) {

			clubMovement.add(movement[i]);

		}
	}

	public String getRandomMovement() {
		return clubMovement.get(0 + (int) (Math.random() * movementLength));

	}

	public void placeClubOnOgre(int ox, int oy) {

		while (this.getx() != ox) {
			if (this.getx() > ox) {
				this.moveLeft();
			}
			if (this.getx() < ox) {
				this.moveRight();
			}
		}
		while (this.gety() != oy) {
			if (this.gety() > oy) {
				this.moveUp();
			}
			if (this.gety() < oy) {
				this.moveDown();
			}

		}

	}

	public void moveClubToValidPos(ArrayList<GameObject> staticObject) {
		switch (getRandomMovement()) {

		case "up":
			if (trymoveUp(staticObject))
				;
			else
				moveClubToValidPos(staticObject);
			break;

		case "down":
			if (trymoveDown(staticObject))
				;
			else
				moveClubToValidPos(staticObject);

			break;

		case "right":
			if (trymoveRight(staticObject))
				;
			else
				moveClubToValidPos(staticObject);
			break;

		case "left":
			if (trymoveLeft(staticObject))
				;
			else
				moveClubToValidPos(staticObject);
			break;

		default:
			moveClubToValidPos(staticObject);
		}

	}

	public boolean trymoveLeft(ArrayList<GameObject> staticObject) {
		if (canClubMove(staticObject, -1, 0)) {
			moveLeft();
			return true;
		}
		return false;

	}

	public boolean trymoveRight(ArrayList<GameObject> staticObject) {
		if (canClubMove(staticObject, 1, 0)) {
			moveRight();
			return true;
		}
		return false;

	}

	public boolean trymoveUp(ArrayList<GameObject> staticObject) {
		if (canClubMove(staticObject, 0, -1)) {
			moveUp();
			return true;
		}
		return false;

	}

	public boolean trymoveDown(ArrayList<GameObject> staticObject) {
		if (canClubMove(staticObject, 0, 1)) {
			moveDown();
			return true;
		}
		return false;

	}

	public boolean canClubMove(ArrayList<GameObject> staticObject, int x, int y) {
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

	public void update(ArrayList<GameObject> staticObject, int ox, int oy) {
		// System.out.println("ogre x:" + ox);
		// System.out.println("ogre y:" + oy);
		// System.out.println("club x:" + this.getx());
		// System.out.println("club y:" + this.gety());

		placeClubOnOgre(ox, oy);
		moveClubToValidPos(staticObject);

	}

}