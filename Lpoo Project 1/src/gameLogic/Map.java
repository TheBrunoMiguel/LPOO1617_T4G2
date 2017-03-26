package gameLogic;

//import java.lang.reflect.MalformedParametersException;
import java.util.*;

public class Map {

	private ArrayList<GameObject> staticObject = new ArrayList<GameObject>(); // readysetgo

	private ArrayList<DynamicObject> dynamicObject = new ArrayList<DynamicObject>(); // array
	// em
	// esteroides,
	// pa
	// adicionar
	// objetos
	// usa-se
	// staticObject//dynamicObject.add

	private int theGuardPersonality;
	
	private int NumberOfOgres;
	
	//private int NumberOfOgres;

	private int hx, hy, mapwidth, maplength;

	private static char SPACECHAR = ' ', LINECHAR = '\n';

	public Map(char map[][], String movement[], int currentmap) {
		theGuardPersonality = 0;
		readMap(map, movement, currentmap);
	}
	
	public Map(char map[][], String movement[], int guardPersonality, int numberOfOgres, int currentmap)
	{
		theGuardPersonality = guardPersonality;
		NumberOfOgres = numberOfOgres;
		readMap(map, movement, currentmap);
	}
	
	
	public Map(char map[][], String movement[], int numberOfOgres, char AbsNothing, int currentmap)
	{
		NumberOfOgres = numberOfOgres;
		readMap(map, movement, currentmap);
	}

	public int getstarty() {
		return hy;
	}

	public int getstartx() {
		return hx;
	}

	public void printObjectHere(Hero hero, int x, int y) {
		if (x == hero.getx() && y == hero.gety()) {
			System.out.print(hero.getc());
			return; // atençao lol
		}

		for (int i = 0; i < staticObject.size(); i++) {
			if (x == staticObject.get(i).getx() && y == staticObject.get(i).gety()) {
				System.out.print(staticObject.get(i).getc());
				return;

			}
		}
		for (int i = 0; i < dynamicObject.size(); i++) {

			if (x == dynamicObject.get(i).getx() && y == dynamicObject.get(i).gety()) {
				System.out.print(dynamicObject.get(i).getc());
				return;
			}
		}
		System.out.print(SPACECHAR);

	}
	
	
	public String printObjectHere2(Hero hero, int x, int y)
	{
		String theString = "";
		if (x == hero.getx() && y == hero.gety()) {
			
			theString = String.valueOf(hero.getc());
			return theString;
		}

		for (int i = 0; i < staticObject.size(); i++) {
			if (x == staticObject.get(i).getx() && y == staticObject.get(i).gety()) {
				theString = String.valueOf(staticObject.get(i).getc());
				return theString;

			}
		}
		for (int i = 0; i < dynamicObject.size(); i++) {

			if (x == dynamicObject.get(i).getx() && y == dynamicObject.get(i).gety()) {
				theString = String.valueOf(dynamicObject.get(i).getc());
				return theString;
			}
		}
		theString = theString + SPACECHAR;
		return theString;
	}

	public void printMap(Hero hero) {
		for (int y = 0; y < mapwidth; y++) {
			for (int x = 0; x < maplength; x++) {
				printObjectHere(hero, x, y);
			}
			System.out.print(LINECHAR);
		}
	}
	
	public String printMap2(Hero hero)
	{
		String theString = "";
		for(int y = 0; y < mapwidth; y++)
		{
			for(int x = 0; x < maplength; x++)
			{
				theString = theString + printObjectHere2(hero, x, y);
			}	
			theString = theString + LINECHAR;
		}
		theString = theString + LINECHAR;
		return theString;
	}

	public void createNewObject(char c, int x, int y, String movement[], int currentmap) {
		int ndeogres = 1 + (int) (Math.random() * 5); // cria numero de 1 a 3
		switch (c) {
		case 'X':
			staticObject.add(new Wall(x, y));
			break;
		case 'I':
			staticObject.add(new Door(x, y));
			break;
		case 'G':
			getRandomPersonalityGuard(x, y, movement);
			break;
		case 'O':
			System.out.println("nº de ogres:" + ndeogres); // usar ids pa
															// identificar cada
															// par, usar ids no
															// update e no
															// return?
			for (int i = 1; i <= ndeogres; i++) {

				dynamicObject.add(new Ogre(x, y, movement, i)); // mudar com
																// files

				dynamicObject.add(new OgreClub(x, y, movement, i));
			}

			break;
		case 'k':
			staticObject.add(new Key(x, y));
			break;
		case 'H':
			hx = x;
			hy = y;
			if (currentmap > 0) {
				dynamicObject.add(new HeroClub(hx, hy, returnHero(), movement, 0));
			}
			break;

		}

	}

	public void getRandomPersonalityGuard(int x, int y, String movement[]) {
		if (theGuardPersonality == 0) {
			theGuardPersonality = 1 + (int) (Math.random() * ((3 - 1) + 1));
			// System.out.println("personality:" + theGuardPersonality);
		}
		// theGuardPersonality =2;
		// System.out.println("personality:" + theGuardPersonality);
		switch (theGuardPersonality) {
		case 1:
			System.out.println("GUARD ROOKIE");
			dynamicObject.add(new Guard_Rookie(x, y, movement));
			break;
		case 2:
			System.out.println("GUARD DRUNKEN");
			dynamicObject.add(new Guard_Drunken(x, y, movement));
			break;
		case 3:
			System.out.println("GUARD Suspicious");
			dynamicObject.add(new Guard_Suspicious(x, y, movement));
			break;
		default:
			System.out.println("ERROR: NO GUARD TYPE CREATED");

		}
	}

	public GameObject readCoord(int x, int y) {
		for (int i = 0; i < staticObject.size(); i++) {
			int nx = staticObject.get(i).getx(), ny = staticObject.get(i).gety();
			if (x == nx && y == ny) {
				return staticObject.get(i);
			}
		}
		for (int i = 0; i < dynamicObject.size(); i++) {
			int nx = dynamicObject.get(i).getx(), ny = dynamicObject.get(i).gety();
			if (x == nx && y == ny) {
				return dynamicObject.get(i);
			}
		}
		return null;
	}

	public void readMap(char map[][], String movement[], int currentmap) {
		maplength = map[0].length;
		mapwidth = map.length;
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				createNewObject(map[y][x], x, y, movement, currentmap);

			}
		}
	}

	public void openDoors() {
		for (int i = 0; i < staticObject.size(); i++) {
			int x = staticObject.get(i).getx(), y = staticObject.get(i).gety();

			if (staticObject.get(i) instanceof Door) {
				if (x == 0 || x == maplength || y == 0 || y == mapwidth) {
					((Door) staticObject.get(i)).openDoor();
				}
			}
		}

	}

	public Lever returnLever() {
		for (int i = 0; i < staticObject.size(); i++)
			if (staticObject.get(i) instanceof Lever)
				return (Lever) staticObject.get(i);
		return null;
	}

	public Ogre returnOgre() {
		for (int i = 0; i < dynamicObject.size(); i++)
			if (dynamicObject.get(i) instanceof Ogre)
				return (Ogre) dynamicObject.get(i);
		return null;
	}

	public Club returnClub() {
		for (int i = 0; i < dynamicObject.size(); i++)
			if (dynamicObject.get(i) instanceof Club)
				return (Club) dynamicObject.get(i);
		return null;
	}

	public Hero returnHero() {
		for (int i = 0; i < dynamicObject.size(); i++)
			if (dynamicObject.get(i) instanceof Hero)
				return (Hero) dynamicObject.get(i);
		return null;
	}

	public HeroClub returnHeroClub() {
		for (int i = 0; i < dynamicObject.size(); i++)
			if (dynamicObject.get(i) instanceof HeroClub)
				return (HeroClub) dynamicObject.get(i);
		return null;
	}

	private void updateLeverOgre() { // FAZER UM PARA CLUB E FAZER O RETURNCLUB
										// // e preciso alterar isto?
		Ogre tmpOgre = returnOgre();
		Lever tmpLever = returnLever();
		Club tmpClub = returnClub();

		if (tmpOgre == null)
			return;
		if ((tmpOgre.getx() == tmpLever.getx()) && (tmpOgre.gety() == tmpLever.gety())) {
			tmpOgre.ogreStepsLever();
			tmpLever.leverStepByOgre();

		}

		else if ((tmpClub.getx() == tmpLever.getx()) && (tmpClub.gety() == tmpLever.gety())) {
			tmpClub.clubStepsLever();
			tmpLever.leverStepByOgre();

		} else {
			tmpOgre.ogreDoesntStepLever();
			tmpLever.leverNotStepByOgre();
			tmpClub.clubDoesntStepLever();

		}

	}

	public void updateOgreClub(int ogreID, int ox, int oy) {
		for (int i = 0; i < dynamicObject.size(); i++) {
			if (dynamicObject.get(i) instanceof Club) {
				if (dynamicObject.get(i).getID() == ogreID) {
					dynamicObject.get(i).update(staticObject, ox, oy);
				}

			}
		}

	}

	public void checkSurroundOgre(HeroClub heroclub, Ogre ogre) {
		int ox = ogre.getx(), oy = ogre.gety();
		int hx = heroclub.getx(), hy = heroclub.gety();
//		System.out.println("ogrex: "+ox+" ogrey: "+oy);
//		System.out.println("herox: "+hx+" heroy: "+hy);
		if (hx == ox && (oy == hy + 1)) { // heroclub a baixo de ogre
			ogre.getHit();
		}
		if ((hx == ox) && (oy == hy - 1)) { // heroclub acima de ogre
			ogre.getHit();
		}
		if ((hy==oy)&&(ox==hx+1)) { //heroclub a direita de ogre
			ogre.getHit();
		}
		if ((hy==oy)&&(ox==hx-1)) { //heroclub a esqerda de ogre
			ogre.getHit();
		}
		if ((hy==oy)&&(ox==hx)) { //heroclub em cima do ogre
			ogre.getHit();
		}

	}

	public void updateOgre(HeroClub heroclub) {
		int ox = 0, oy = 0;
		int ogreID = 0;
		for (int i = 0; i < dynamicObject.size(); i++) {

			if (dynamicObject.get(i) instanceof Ogre) {
				
				ogreID = dynamicObject.get(i).getID();
				dynamicObject.get(i).update(staticObject);

				ox = dynamicObject.get(i).getx();
				oy = dynamicObject.get(i).gety();

				updateOgreClub(ogreID, ox, oy);
				checkSurroundOgre(heroclub, (Ogre) dynamicObject.get(i));

			}

		}

	}

	public void updateHeroClub(Hero hero, int currentmap) {
		if (currentmap > 0) {
			int hx = hero.getx();
			int hy = hero.gety();
//			System.out.println(hx);
//			System.out.println(hy);
			for (int i = 0; i < dynamicObject.size(); i++) {

				if (dynamicObject.get(i) instanceof HeroClub) {
					dynamicObject.get(i).update(staticObject, hx, hy);

				}

			}
		}
	}

	public void updateDynamicObjects() { //updata todos menos heroclub, ogre e lever(esta n sei se é dynamic but wtv)
		for (int i = 0; i < dynamicObject.size(); i++) {
			dynamicObject.get(i).update();
		}
	}

	public void update(Hero hero, int currentmap) {
		updateDynamicObjects();
		updateHeroClub(hero, currentmap);
		updateOgre(returnHeroClub());
		updateLeverOgre();
	}
	
	/*
	public void update() {
		int ox=0,oy=0;
		for (int i = 0; i < dynamicObject.size(); i++) {
			dynamicObject.get(i).update();
			
			if (dynamicObject.get(i) instanceof Ogre) {
				dynamicObject.get(i).update(staticObject);
				ox=dynamicObject.get(i).getx();
				oy=dynamicObject.get(i).gety();
				
			}


		
		}
		for (int i = 0; i < dynamicObject.size(); i++) {
			if (dynamicObject.get(i) instanceof Club) {
				dynamicObject.get(i).update(staticObject, ox,oy);
			}
		}
		updateLeverOgre();
	}
	*/
}
