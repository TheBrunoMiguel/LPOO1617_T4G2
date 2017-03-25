package logic;

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

	private int hx, hy, mapwidth, maplength;

	private static char SPACECHAR = ' ', LINECHAR = '\n';

	public Map(char map[][], String movement[]) {
		readMap(map, movement);
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

	public void printMap(Hero hero) {
		for (int y = 0; y < mapwidth; y++) {
			for (int x = 0; x < maplength; x++) {
				printObjectHere(hero, x, y);
			}
			System.out.print(LINECHAR);
		}
	}

	public void createNewObject(char c, int x, int y, String movement[]) {

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
			dynamicObject.add(new Ogre(x, y, movement)); //mudar com files
			dynamicObject.add(new Club(x,y, returnOgre(), movement));
			break;
		case 'k':
			staticObject.add(new Key(x, y));
			break;
		case 'H':
			hx = x;
			hy = y;
			break;

		}

	}
	
	public void getRandomPersonalityGuard(int x, int y, String movement[])
	{
		if(theGuardPersonality == 0)
		{
			theGuardPersonality = 1 + (int)(Math.random() * ((3 - 1) + 1));
			System.out.println("personality:" + theGuardPersonality);
		}
//		theGuardPersonality =2;
//		System.out.println("personality:" + theGuardPersonality);
		switch(theGuardPersonality)
		{
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

	public void readMap(char map[][], String movement[]) {
		maplength = map[0].length;
		mapwidth = map.length;
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				createNewObject(map[y][x], x, y, movement);

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
				return  (Club) dynamicObject.get(i);
		return null;
	}


 
	private void updateLeverOgre() { //FAZER UM PARA CLUB E FAZER O RETURNCLUB
		Ogre tmpOgre = returnOgre();
		Lever tmpLever = returnLever();
		Club tmpClub = returnClub();
		
		if(tmpOgre == null)
			return;
		if((tmpOgre.getx()==tmpLever.getx()) && (tmpOgre.gety()==tmpLever.gety()))
		{
			tmpOgre.ogreStepsLever();
			tmpLever.leverStepByOgre();
			
		}
		
		else 	if((tmpClub.getx()==tmpLever.getx()) && (tmpClub.gety()==tmpLever.gety()))
		{
			tmpClub.clubStepsLever();
			tmpLever.leverStepByOgre();
			
		}
		else
		{
			tmpOgre.ogreDoesntStepLever();
			tmpLever.leverNotStepByOgre();
			tmpClub.clubDoesntStepLever();
			
		}
		
	}

	
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
}
