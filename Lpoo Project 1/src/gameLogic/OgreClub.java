package gameLogic;

import java.util.ArrayList;

public class OgreClub extends Club {

	private static char OGRECLUBCHAR = '*';
	private static char OGRECLUBCHAR_ON_LEVER = '$';
//	private ArrayList<String> ogreClubMovement = new ArrayList<String>();
	private int movementLength;
	private int ogreClubID;
	
	public OgreClub(int x, int y, String[] movement, int clubID) {
		super(x, y, movement, clubID);
		movementLength = movement.length;
		readmovement(movement);
		this.ogreClubID=clubID;
		
		
	}
	
	public int getID(){
		return ogreClubID;
	}

	public void clubStepsLever() {
		this.c = OGRECLUBCHAR_ON_LEVER;
	}

	public void clubDoesntStepLever() {
		this.c = OGRECLUBCHAR;
	}

	

}
