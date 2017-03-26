package gameLogic;

public class Hero extends DynamicObject {

	private static char HEROCHAR = 'H'; // maiuscula=constantes
										// PI=3.141eirjquiot

	private static char HEROCLUB='A';
	private static char HEROCLUBKEY='K';
	private boolean won;

	public Hero(int x, int y) {
		super(x, y, HEROCHAR);
		won = false;

	}
	
	public void heroHasClub(){
		this.c=HEROCLUB;
	}
	public void heroHasClubKey(){
		this.c=HEROCLUBKEY;
	}

	public boolean hasWon() {
		return won;
	}
	public void win() {
		won=true;
	}
	public void reset(int x,int y){
		//hero = new Hero(maps.get(currentmap).getstartx(), maps.get(currentmap).getstarty()); //criar fun�ao reset dynamic object passar posi�ao vida etc
		this.x=x;
		this.y=y;
		
	}

}
