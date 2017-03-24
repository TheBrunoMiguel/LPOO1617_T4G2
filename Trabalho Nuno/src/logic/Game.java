package logic;

import cli.ReadInput; 
import java.util.ArrayList;


public class Game { // vars dde qqr objeto game

	private Hero hero; // Hero= classe, hero= objeto de Hero(tipo int i lul)

	private ArrayList<Map> maps = new ArrayList<Map>(); 

	private boolean running;

	private int currentmap = 0;

//	private String currentmapname;

	public Game() // construtor
	{
		//maps.add(new Map(map0));
//		currentmapname="map"+currentmap;
		//System.out.println(currentmapname);
		maps.add(new Map(map0, lvl0guardmovement));
		maps.add(new Map(map1, lvl1guardmovement));	


		running = true;
		hero = new Hero(maps.get(currentmap).getstartx(), maps.get(currentmap).getstarty());

	}

	public void update(char c) { //se tivesse tempo usava-se args

		updatehero(c);
		
		updatemap();
		checkGameStatus();
		maps.get(currentmap).printMap(hero);

	}

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
			if(currentmap==maps.size()-1){ 
				hero.win();
				running=false;
				printEndGameMessage();
			}													
			else nextlevel();

		}																			
	}																				

	private void nextlevel() {
//		System.out.println("mapa 0: " + maps.get(0).getstartx()+hero.getx()+" "+maps.get(0).getstartx()+hero.gety());
		currentmap++; 
		printNextLevelMessage();
		hero.reset(maps.get(currentmap).getstartx() , maps.get(currentmap).getstarty());
		
//		System.out.println("mapa 1:" + maps.get(1).getstartx()+hero.getx()+" "+maps.get(1).getstartx()+hero.gety());
		
//		System.out.println("mapa 1:" + maps.get(1).getstartx()+hero.getx()+" "+maps.get(1).getstartx()+hero.gety());
	}

	public void checkHeroAlive() {
		
		if (hero.isAlive() == false) {
			running = false;
		}
	}


	public void checkLever() {
		System.out.println(hero.getx());
		System.out.println(hero.gety());
		GameObject heropos = maps.get(currentmap).readCoord(hero.getx(), hero.gety());
		
		if(heropos == null)
		{
			return;
		}
		
		if (heropos instanceof Lever){
			maps.get(currentmap).openDoors();
			
		}
		if (heropos instanceof Key){
			((Key)maps.get(currentmap).returnLever()).deleteKey();
		}
//		maps.get(currentmap).checkOgreLever();
	}

	public void updatehero(char c) {		
		movehero(c);
	}

	public void movehero(char m) {		//colocar isto para o ogre no Map
		int x, y;
		x = hero.getx();
		y = hero.gety();
		trymove(m, x, y);

	}

	public void checkSurround(int hx, int hy) { // check surround para hero nao morrer
		GameObject positiontocheckright = maps.get(currentmap).readCoord(hx + 1, hy);
		if (positiontocheckright instanceof Guard || positiontocheckright instanceof Ogre) {
			hero.getHit();
		}
		GameObject positiontocheckleft = maps.get(currentmap).readCoord(hx - 1, hy);
		if (positiontocheckleft instanceof Guard || positiontocheckleft instanceof Ogre) {
			hero.getHit();
		}
		GameObject positiontocheckdown = maps.get(currentmap).readCoord(hx, hy + 1);
		if (positiontocheckdown instanceof Guard || positiontocheckdown instanceof Ogre) {
			hero.getHit();
		}
		GameObject positiontocheckup = maps.get(currentmap).readCoord(hx, hy - 1);
		if (positiontocheckup instanceof Guard || positiontocheckup instanceof Ogre) {
			hero.getHit();
		}
		GameObject positiontochecktop = maps.get(currentmap).readCoord(hx, hy);
		if (positiontochecktop instanceof Guard || positiontochecktop instanceof Ogre) {
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
			System.out.println("You died!");
			System.out.println("Game Over!");}
		else if (hero.hasWon() == true){
			System.out.println("You won!");
			System.out.println("Game Over!");
		}

	}

	public Object  checkObjectAbove(){
		
		return null;
	}
	
//	public void play() {			
//
//
//
//	}

	private static String lvl0guardmovement[]={"left","down","down","down","down","left","left","left","left","left",
			"left","down","right","right","right","right","right","right","right","up","up","up","up","up",};
//	private static String lvl1guardmovement[]={"up","down","right","left"};
	private static String lvl1guardmovement[]={"up","right","up","down"};

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
