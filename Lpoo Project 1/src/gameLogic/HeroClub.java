package gameLogic;

import java.util.ArrayList;

public class HeroClub extends Club {

	private static char HEROCLUBCHAR = '*';
	private static char HEROCLUBCHAR_ON_LEVER = '$';
	private ArrayList<String> heroClubMovement = new ArrayList<String>();
	private int movementLength;
	private int heroClubID;
	
	public HeroClub(int x, int y, Hero hero, String[] movement, int clubID) {
		super(x, y, movement, clubID);//atençao ao id
		movementLength = movement.length;
		readmovement(movement);
		
	}

	public int getID(){
		return heroClubID;
	}

	public void clubStepsLever() {
		this.c = HEROCLUBCHAR_ON_LEVER;
	}

	public void clubDoesntStepLever() {
		this.c = HEROCLUBCHAR;
	}
	
	public void placeClubOnHero(int hx, int hy) {

		while (this.getx() != hx) {
			if (this.getx() > hx) {
				this.moveLeft();
			}
			if (this.getx() < hx) {
				this.moveRight();
			}
		}
		while (this.gety() != hy) {
			if (this.gety() > hy) {
				this.moveUp();
			}
			if (this.gety() < hy) {
				this.moveDown();
			}

		}

	}
	
	public void update(ArrayList<GameObject> staticObject, int hx, int hy) {
		// System.out.println("hero x:" + hx);
		// System.out.println("hero y:" + hy);
		// System.out.println("club x:" + this.getx());
		// System.out.println("club y:" + this.gety());

		placeClubOnHero(hx, hy);
		moveClubToValidPos(staticObject);

	}
	
}
