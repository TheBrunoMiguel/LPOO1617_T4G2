package gameLogic;

public class Door extends GameObject {

	
	private static char DOORCLOSEDCHAR='I';
	
	private static char DOOROPENCHAR='S';
	
	private boolean dooropen;
	
	
	public Door(int x, int y) 
	{
		super(x, y, DOORCLOSEDCHAR);
		dooropen=false;
	}
	
	public void openDoor()
	{
		dooropen=true;
		c=DOOROPENCHAR;
	}
	
	public boolean isOpen()
	{
		return dooropen;
	}
	
	
	

}