package gameLogic;

import userInterface.ReadInput; 
import java.util.ArrayList;


public class Game { // vars dde qqr objeto game

	private Hero hero; // Hero= classe, hero= objeto de Hero(tipo int i lul)

	private ArrayList<Map> maps = new ArrayList<Map>(); // magic

	private boolean running;

	private int currentmap;

	private boolean isWinLevel1;

	public Game() // construtor
	{
		currentmap = 0;
		maps.add(new Map(map0, lvl0guardmovement));
		maps.add(new Map(map1, lvl1guardmovement));	


		running = true;
		hero = new Hero(maps.get(currentmap).getstartx(), maps.get(currentmap).getstarty());

	}

	
	public Game(int theGuardPersonality, int numberOfOgres, Hero theHero)
	{
		currentmap = 0;
		maps.add(new Map(map0, lvl0guardmovement, theGuardPersonality, numberOfOgres));
		maps.add(new Map(map1, lvl1guardmovement, theGuardPersonality, numberOfOgres));
		
		running = true;
		hero = new Hero(maps.get(currentmap).getstartx(), maps.get(currentmap).getstarty());
		theHero = hero;
	}
	
	
	public Game(char[][] theMap, String[] theGuardMovement)
	{
		currentmap = 0;
		maps.add(new Map(theMap, theGuardMovement));
		
		running = true;
		hero = new Hero(maps.get(currentmap).getstartx(), maps.get(currentmap).getstarty());		
	}
	
	
	public Game(char[][] theMap, String[] theOgreMovement, int numberOfOgres, Hero theHero)
	{
			currentmap = 0;
			maps.add(new Map(map0, lvl0guardmovement));
			maps.add(new Map(theMap, theOgreMovement, numberOfOgres));
			currentmap++;
			
			running = true;
			hero = new Hero(maps.get(currentmap).getstartx(), maps.get(currentmap).getstarty());
			hero.reset(maps.get(currentmap).getstartx() , maps.get(currentmap).getstarty());
			theHero = hero;
	}

	
	
	
	public Map getfirstMap()
	{
		return maps.get(0);
	}
	
	public int getHeroY()
	{
		return hero.gety();
	}
	
	public int getHeroX()
	{
		return hero.getx();
	}
	
	
	public char getinput() {
		char c = ReadInput.read();
		return c;
	}

	
	public boolean getRunning()
	{
		return running;
	}
	
	
	public void update(char c) { 

		updatehero(c);
		
		updatemap();
		checkGameStatus();
		maps.get(currentmap).printMap(hero);

	}
	
/*	
	public void update() { //se tivesse tempo usava-se args
		updatehero();
		updatemap(); 
		checkGameStatus();
		maps.get(currentmap).printMap(hero);
	}
*/


	private void updatemap() {

		maps.get(currentmap).update();
	}

	public void checkGameStatus() {
		checkSurround(hero.getx(), hero.gety());
		checkHeroAlive();
		checkDoor();
		checkLever();
	}

	private void checkDoor() {
		GameObject positiontocheckdoor = maps.get(currentmap).readCoord(hero.getx(), hero.gety());
		if ((positiontocheckdoor instanceof Door) && (((Door) positiontocheckdoor).isOpen())){	
			if(currentmap==1){ 
				hero.win();
				running=false;
//				printEndGameMessage();
			}													//fix1trocar por currentmap++
			else nextlevel();

		}																			//fix2 tips. maps.size== n de mapas. index 0 = mapa nº1
	}																				//if currentmap==maps.size() entao running =false

	private void nextlevel() {
		currentmap++; //pode ser 0 (map0), 1(map0 etc)

		printNextLevelMessage();
		hero.reset(maps.get(currentmap).getstartx() , maps.get(currentmap).getstarty());

	}

	public void checkHeroAlive() {
		if (hero.isAlive() == false) {
			running = false;
		}
	}


	public void checkLever() {
		System.out.println(hero.getx());
//		System.out.println(hero.gety());
		GameObject heropos = maps.get(currentmap).readCoord(hero.getx(), hero.gety());
		
		if(heropos == null)
		{
			return;
		}
		
		if (heropos instanceof Lever){
			maps.get(currentmap).openDoors();
			
		}
		if (heropos instanceof Key&& currentmap==1){  //ver isto, so funciona direito com currentmap==1 !!!!!!!!!!!!!!
			((Key)maps.get(currentmap).returnLever()).deleteKey();
		}
//		maps.get(currentmap).checkOgreLever();
	}

	public void updatehero(char c) {		
		movehero(c);
	}

	public void movehero(char m) {
		int x, y;
		x = hero.getx();
		y = hero.gety();
		trymove(m, x, y);

	}
	
	
	public void checkDoor2()
	{
		GameObject positiontocheckdoor = maps.get(currentmap).readCoord(hero.getx(), hero.gety());
		if ((positiontocheckdoor instanceof Door) && (((Door) positiontocheckdoor).isOpen()))
		{	 
			hero.win();
			isWinLevel1 = true;
			running=false;
		}													
		else nextlevel();
	}

	public boolean checkDoorOnTheLeft(int x, int y)
	{
		GameObject positiontocheckdoor = maps.get(currentmap).readCoord(x - 1 , y);
		if ((positiontocheckdoor instanceof Door) && (((Door) positiontocheckdoor).isOpen()))
		{
			return true;
		}
		return false;
	}


	public boolean getisWinLevel1()
	{
		return isWinLevel1;
	}

	
	public void checkSurround(int hx, int hy) { // check surround para hero nao
		// morrer
		/* ******************************** */
		GameObject positiontocheckright = maps.get(currentmap).readCoord(hx + 1, hy);
		if (positiontocheckright instanceof Guard_Drunken) {
			if (!((Guard_Drunken) positiontocheckright).isGuardAsleep) {
				hero.getHit();
			}
		} else if (positiontocheckright instanceof Guard || positiontocheckright instanceof Ogre
				|| positiontocheckright instanceof Club) {
			hero.getHit();
		}
		/* ******************************** */
		GameObject positiontocheckleft = maps.get(currentmap).readCoord(hx - 1, hy);
		if (positiontocheckleft instanceof Guard_Drunken) {
			if (!((Guard_Drunken) positiontocheckleft).isGuardAsleep) {
				hero.getHit();
			}
		} else if (positiontocheckleft instanceof Guard || positiontocheckleft instanceof Ogre
				|| positiontocheckleft instanceof Club) {
			hero.getHit();
		}
		/* ******************************** */
		GameObject positiontocheckdown = maps.get(currentmap).readCoord(hx, hy + 1);
		if (positiontocheckdown instanceof Guard_Drunken) {
			if (!((Guard_Drunken) positiontocheckdown).isGuardAsleep) {
				hero.getHit();
			}
		} else if (positiontocheckdown instanceof Guard || positiontocheckdown instanceof Ogre
				|| positiontocheckdown instanceof Club) {
			hero.getHit();
		}
		/* ******************************** */
		GameObject positiontocheckup = maps.get(currentmap).readCoord(hx, hy - 1);
		if (positiontocheckup instanceof Guard_Drunken) {
			if (!((Guard_Drunken) positiontocheckup).isGuardAsleep) {
				hero.getHit();
			}
		} else if (positiontocheckup instanceof Guard || positiontocheckup instanceof Ogre
				|| positiontocheckup instanceof Club) {
			hero.getHit();
		}
		/* ******************************** */
		GameObject positiontochecktop = maps.get(currentmap).readCoord(hx, hy);
		if (positiontochecktop instanceof Guard || positiontochecktop instanceof Ogre
				|| positiontochecktop instanceof Club) {
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

	public void printNextLevelMessage() {
		System.out.println("Congratulations!");
		System.out.println("You beat this level!");


	}

	public void printEndGameMessage() {
		if (hero.isAlive() == false){
			isWinLevel1 = false;
			System.out.println("You died!");
			System.out.println("Game Over!");}
		else if (hero.hasWon() == true){
			isWinLevel1 = true;
			System.out.println("You won!");
			System.out.println("Game Over!");
		}

	}
	
	
public Object  checkObjectAbove(){
		
		return null;
	}
	
/*
	public void play() {
		maps.get(currentmap).printMap(hero);
		while (running) {
			update();
		}
		printEndGameMessage();
	}
	
	*/

	private static String lvl0guardmovement[]={"left","down","down","down","down","left","left","left","left","left",
			"left","down","right","right","right","right","right","right","right","up","up","up","up","up",};
//	private static String lvl1guardmovement[]={"up","down","right","left"};
	private static String lvl1guardmovement[]={"up","right","left","down"};

	private static char map0[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'H', '0', '0', 'I', '0', 'X', '0', 'G', 'X' }, 
			{ 'X', 'X', 'X', '0', 'X', 'X', 'X', '0', '0', 'X' },
			{ 'X', '0', 'I', '0', 'I', '0', 'X', '0', '0', 'X' },
			{ 'X', 'X', 'X', '0', 'X', 'X', 'X', '0', '0', 'X' },
			{ 'I', '0', '0', '0', '0', '0', '0', '0', '0', 'X' }, 
			{ 'I', '0', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', 'X', 'X', '0', 'X', 'X', 'X', 'X', '0', 'X' }, 
			{ 'X', '0', 'I', '0', 'I', '0', 'X', 'k', '0', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

	public static char map1[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', '0', '0', '0', 'O', '0', '0', '0', 'k', 'X' }, 
			{ 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' }, 
			{ 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X' }, 
			{ 'X', 'H', '0', '0', '0', '0', '0', '0', '0', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

	public void printmap() {
		maps.get(currentmap).printMap(hero);
		
	}

	public boolean isRunning() {
		
		return running;
	}

}