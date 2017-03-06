package gameLogic;

public class Character
{
	public int x;
	public int y;

	public void MoveW(Map TheMap, char TheChar) 
	{
		x = x - 1;
		TheMap.map[y][x] = TheChar;
		TheMap.map[y][x+1] = '0';
	}

	public void MoveW(Map2 TheMap2, char TheChar) 
	{
		x = x - 1;
		TheMap2.map2[y][x] = TheChar;
		TheMap2.map2[y][x+1] = '0';
	}
	
	public void MoveA(Map TheMap, char TheChar) 
	{
		y = y - 1;
		TheMap.map[y][x] = TheChar;
		TheMap.map[y+1][x] = '0';
	}

	public void MoveA(Map2 TheMap2, char TheChar) 
	{
		y = y - 1;
		TheMap2.map2[y][x] = TheChar;
		TheMap2.map2[y+1][x] = '0';
	}
	
	public void MoveS(Map TheMap, char TheChar) 
	{
		x = x + 1;
		TheMap.map[y][x] = TheChar;
		TheMap.map[y][x-1] = '0';
	}
	
	public void MoveS(Map2 TheMap2, char TheChar) 
	{
		x = x + 1;
		TheMap2.map2[y][x] = TheChar;
		TheMap2.map2[y][x-1] = '0';
	}

	public void MoveD(Map TheMap, char TheChar) 
	{
		y = y + 1;
		TheMap.map[y][x] = TheChar;
		TheMap.map[y-1][x] = '0';
	}
	
	public void MoveD(Map2 TheMap2, char TheChar) 
	{
		y = y + 1;
		TheMap2.map2[y][x] = TheChar;
		TheMap2.map2[y-1][x] = '0';
	}
}
