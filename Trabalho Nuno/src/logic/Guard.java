package logic;

import java.util.ArrayList;

public class Guard extends DynamicObject {

	private ArrayList<String> guardMovement = new ArrayList<String>();

	private static char GUARDCHAR = 'G';

	private int currentMovement = 0;

	public String getCurrentMovement()
	{
		currentMovement++;
		return guardMovement.get(currentMovement);
		
		
	}

	public Guard(int x, int y, String movement[]) {
		super(x, y, GUARDCHAR);
		readmovement(movement);


	}

	private void readmovement(String[] movement) {
		//movementLength = movement.length;

		for (int i = 0; i < movement.length; i++) {

			guardMovement.add(movement[i]);

		}
	}

}
