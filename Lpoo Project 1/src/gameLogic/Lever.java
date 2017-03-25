package gameLogic;

public class Lever extends GameObject {

	
	protected static char LEVERCHAR='k';
	protected static char LEVERCHAR_STEP='$';
	
	//private boolean Leverused=0;
	public Lever(int x, int y) 
	{
		super(x, y, LEVERCHAR);
	
	}
	public void leverStepByOgre() {
		this.c=LEVERCHAR_STEP;
		
	}
	
	public void leverNotStepByOgre() {
		this.c=LEVERCHAR;
		
	}
	
//	public void changeLever(){
//		LEVERCHAR='$';
//		System.out.println(getc());
//		
//	}

}
