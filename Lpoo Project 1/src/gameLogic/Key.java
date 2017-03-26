package gameLogic;

public class Key extends Lever {

	public Key(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void deleteKey(){
		LEVERCHAR='0';
		this.c=LEVERCHAR;
		
	}

}
