package gameLogic;
import java.util.ArrayList;


public class Guard extends DynamicObject 
{

	private ArrayList<String> GuardMovement = new ArrayList<String>();
	
	private static char GUARDCHAR='G';

	
	public Guard(int x, int y) 
	{
		super(x, y, GUARDCHAR);

		
		
	}

}
