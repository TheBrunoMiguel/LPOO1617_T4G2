package gameLogic;


public class Hero extends DynamicObject {

	private static char HEROCHAR = 'H'; // maiuscula=constantes
										// PI=3.141eirjquiot

	private boolean won;

	
	public Hero(int x, int y) {
		super(x, y, HEROCHAR);
		won = false;

	}

	public boolean hasWon() {
		return won;
	}
	public void win() {
		won=true;
	}

}