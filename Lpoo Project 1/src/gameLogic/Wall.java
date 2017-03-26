package gameLogic;

public class Wall extends GameObject {

	private static char WALLCHAR='X';
	
	
	public Wall(int x, int y) {
		super(x, y, WALLCHAR);
	}

}
