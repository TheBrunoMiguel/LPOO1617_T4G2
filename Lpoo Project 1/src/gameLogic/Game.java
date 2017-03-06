package gameLogic;
import userInterface.ReadInput;
import java.util.ArrayList;


public class Game { // vars dde qqr objeto game

	private Hero hero; // Hero= classe, hero= objeto de Hero(tipo int i lul)

	private ArrayList<Map> maps = new ArrayList<Map>(); // magic

	private boolean running;

	private int currentmap = 0;

	public Game() // construtor
	{
		maps.add(new Map(map1));
		running = true;
		hero = new Hero(maps.get(currentmap).getstartx(), maps.get(currentmap).getstarty());

	}

	public char getinput() 
	{
		//userInterface.ReadInput TheInput = new ReadInput();
		char c = ReadInput.read();
		return c;
	}

	public void update() { // se tivesse tempo usava-se args
		updatehero();
		//updatemap(); // falta fazer
		checkGameStatus();
		maps.get(currentmap).printMap(hero);

	}

	/*private void updatemap() {
		// wat do

		// maps.get(currentmap)

	}*/

	public void checkGameStatus() {
		checkSurround(hero.getx(), hero.gety());
		checkHeroAlive();
		checkDoor();
		checkLever();
	}

	private void checkDoor() {
		GameObject positiontocheckdoor = maps.get(currentmap).readCoord(hero.getx(), hero.gety());
		if ((positiontocheckdoor instanceof Door) && (((Door) positiontocheckdoor).isOpen())){
			hero.win();
			running=false;
		}
	}

	public void checkHeroAlive() {
		if (hero.isAlive() == false) {
			running = false;
		}
	}

	/*
	 * public void checkDoor() { GameObject heropos =
	 * maps.get(currentmap).readCoord(hero.getx(), hero.gety()); if (heropos
	 * instanceof Door) gamewon=true; }
	 */
	public void checkLever() {
		GameObject heropos = maps.get(currentmap).readCoord(hero.getx(), hero.gety());
		if (heropos instanceof Lever)
			maps.get(currentmap).openDoors();
	}

	public void updatehero() {
		char c;
		c = getinput();
		movehero(c);
	}

	public void movehero(char m) {
		int x, y;
		x = hero.getx();
		y = hero.gety();
		trymove(m, x, y);

	}

	public void checkSurround(int hx, int hy) { // melhor maneira de fazer isto?
		GameObject positiontocheckright = maps.get(currentmap).readCoord(hx + 1, hy);
		if (positiontocheckright instanceof Guard) {
			hero.getHit();
		}
		GameObject positiontocheckleft = maps.get(currentmap).readCoord(hx - 1, hy);
		if (positiontocheckleft instanceof Guard) {
			hero.getHit();
		}
		GameObject positiontocheckdown = maps.get(currentmap).readCoord(hx, hy + 1);
		if (positiontocheckdown instanceof Guard) {
			hero.getHit();
		}
		GameObject positiontocheckup = maps.get(currentmap).readCoord(hx, hy - 1);
		if (positiontocheckup instanceof Guard) {
			hero.getHit();
		}

	}

	public void trymoveLeft(int x, int y) {
		GameObject positiontomove = maps.get(currentmap).readCoord(x - 1, y);
		if ((positiontomove instanceof Wall)|| ((positiontomove instanceof Door) && !(((Door) positiontomove).isOpen())))
			return;
		hero.moveLeft();

	}

	public void trymoveRight(int x, int y) {
		GameObject positiontomove = maps.get(currentmap).readCoord(x + 1, y);
		if ((positiontomove instanceof Wall)|| ((positiontomove instanceof Door) && !(((Door) positiontomove).isOpen())))
			return;
		hero.moveRight();

	}

	public void trymoveUp(int x, int y) {
		GameObject positiontomove = maps.get(currentmap).readCoord(x, y - 1);
		if ((positiontomove instanceof Wall)|| ((positiontomove instanceof Door) && !(((Door) positiontomove).isOpen())))
			return;
		hero.moveUp();

	}

	public void trymoveDown(int x, int y) {
		GameObject positiontomove = maps.get(currentmap).readCoord(x, y + 1);
		if ((positiontomove instanceof Wall)|| ((positiontomove instanceof Door) && !(((Door) positiontomove).isOpen())))
			return;
		hero.moveDown();

	}

	public void trymove(char m, int hx, int hy) {
		switch (m) {
		case 'A':
			trymoveLeft(hx, hy);
			break;
		case 'a':
			trymoveLeft(hx, hy);
			break;
		case 'S':
			trymoveDown(hx, hy);
			break;
		case 's':
			trymoveDown(hx, hy);
			break;
		case 'D':
			trymoveRight(hx, hy);
			break;
		case 'd':
			trymoveRight(hx, hy);
			break;
		case 'W':
			trymoveUp(hx, hy);
			break;
		case 'w':
			trymoveUp(hx, hy);
			break;

		default:
			System.out.println("Insert acceptable move character");
		}
	}

	public void printEndGameMessage() {
		if (hero.isAlive() == false){
			System.out.println("You died!");
			System.out.println("Game Over!");}
		else if (hero.hasWon() == true){
			System.out.println("You won!");
			System.out.println("Game Over!");
	}

	}

	public void play() {

		maps.get(currentmap).printMap(hero);
		while (running) {
			update();
		}
		printEndGameMessage();

	}

	private static String lvl1guardmovement[]={"left","down","down","down","down","left","left","left","left","left",
			"left","down","right","right","right","right","right","right","right","up","up","up","up","up",};
	
	private static char map1[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'H', '0', '0', 'I', '0', 'X', '0', 'G', 'X' }, { 'X', 'X', 'X', '0', 'X', 'X', 'X', '0', '0', 'X' },
			{ 'X', '0', 'I', '0', 'I', '0', 'X', '0', '0', 'X' }, { 'X', 'X', 'X', '0', 'X', 'X', 'X', '0', '0', 'X' },
			{ 'I', '0', '0', '0', '0', '0', '0', '0', '0', 'X' }, { 'I', '0', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', 'X', 'X', '0', 'X', 'X', 'X', 'X', '0', 'X' }, { 'X', '0', 'I', '0', 'I', '0', 'X', 'k', '0', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

	public static char map2[][] = { { 'X', 'I', 'X', 'X', 'X', 'I', 'I', 'X', 'X', 'X' },
			{ 'X', '0', '0', '0', '0', '0', '0', '0', 'H', 'X' }, { 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' }, { 'X', 'O', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' }, { 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' }, { 'X', 'k', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

}
