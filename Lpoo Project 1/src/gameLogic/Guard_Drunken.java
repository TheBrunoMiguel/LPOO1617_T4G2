package gameLogic;

import java.util.ArrayList;

public class Guard_Drunken extends DynamicObject
{

	private ArrayList<String> guardMovement = new ArrayList<String>();

	private static char GUARDCHAR = 'G';

	//private int currentMovement = 0;

	private int movementLength;
	
//	private boolean asleep;
	
	private int theDirection;
	
	
	public Guard_Drunken(int x, int y, String[] movement) 
	{
		super(x, y, GUARDCHAR);
//		asleep = false;
		//readmovement(movement);
		// TODO Auto-generated constructor stub
	}


}
