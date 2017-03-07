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

	private int hx, hy, mapwidth, maplength;

	private static char SPACECHAR = ' ', LINECHAR = '\n';

	public Map(char map[][],String movement[]) {
		readMap(map,movement);
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
			dynamicObject.add(new Guard(x, y, movement));
			break;
		case 'k':
			staticObject.add(new Lever(x, y));
			break;
		case 'H':
			hx = x;
			hy = y;
			break;

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

	public void readMap(char map[][],String movement[]) {
		maplength = map[0].length;
		mapwidth = map.length;
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				createNewObject(map[y][x], x, y,movement);

			}
		}
	}

	public void openDoors()
	{
		for(int i=0 ; i<staticObject.size() ; i++)
		{
			int x=staticObject.get(i).getx(),y=staticObject.get(i).gety();

			if(staticObject.get(i) instanceof Door){
				if(x==0||x==maplength||y==0||y==mapwidth)
				{
					((Door) staticObject.get(i)).openDoor();
				}	
			}
		}

	}
	
	public void update()
	{
		for(int i=0 ; i<dynamicObject.size() ; i++)
		{
			if(dynamicObject.get(i) instanceof Guard){
				dynamicObject.get(i).update();
			}
		}
	}
}
