
public class Map 
{
	char map[][] = new char [10][10];   //map[columns][lines]
	map[0][0] = 'X'; map[1][0] = 'X'; map[2][0] = 'X'; map[3][0] = 'X'; map[4][0] = 'X'; map[5][0] = 'X'; map[6][0] = 'X';
	map[0][1] = 'X'; map[1][1] = 'H'; map[2][1] = '0'; map[3][1] = '0'; map[4][1] = 'I'; map[5][1] = '0'; map[6][1] = 'X';
	map[0][2] = 'X'; map[1][2] = 'X'; map[2][2] = 'X'; map[3][2] = '0'; map[4][2] = 'X'; map[5][2] = 'X'; map[6][2] = 'X';
	map[0][3] = 'X'; map[1][3] = '0'; map[2][3] = 'I'; map[3][3] = '0'; map[4][3] = 'I'; map[5][3] = '0'; map[6][3] = 'X';
	map[0][4] = 'X'; map[1][4] = 'X'; map[2][4] = 'X'; map[3][4] = '0'; map[4][4] = 'X'; map[5][4] = 'X'; map[6][4] = 'X';
	map[0][5] = 'I'; map[1][5] = '0'; map[2][5] = '0'; map[3][5] = '0'; map[4][5] = '0'; map[5][5] = '0'; map[6][5] = '0';
	map[0][6] = 'I'; map[1][6] = '0'; map[2][6] = '0'; map[3][6] = '0'; map[4][6] = '0'; map[5][6] = '0'; map[6][6] = '0';
	map[0][7] = 'X'; map[1][7] = 'X'; map[2][7] = 'X'; map[3][7] = '0'; map[4][7] = 'X'; map[5][7] = 'X'; map[6][7] = 'X';
	map[0][8] = 'X'; map[1][8] = '0'; map[2][8] = 'I'; map[3][8] = '0'; map[4][8] = 'I'; map[5][8] = '0'; map[6][8] = 'X';
	map[0][9] = 'X'; map[1][9] = 'X'; map[2][9] = 'X'; map[3][9] = 'X'; map[4][9] = 'X'; map[5][9] = 'X'; map[6][9] = 'X';
		
	map[7][0] = 'X'; map[8][0] = 'X'; map[9][0] = 'X';
	map[7][1] = '0'; map[8][1] = 'G'; map[9][1] = 'X';
	map[7][2] = '0'; map[8][2] = '0'; map[9][2] = 'X';
	map[7][3] = '0'; map[8][3] = '0'; map[9][3] = 'X';
	map[7][4] = '0'; map[8][4] = '0'; map[9][4] = 'X';
	map[7][5] = '0'; map[8][5] = '0'; map[9][5] = 'X';
	map[7][6] = '0'; map[8][6] = '0'; map[9][6] = 'X';
	map[7][7] = 'X'; map[8][7] = '0'; map[9][7] = 'X';
	map[7][8] = 'k'; map[8][8] = '0'; map[9][8] = 'X';
	map[7][9] = 'X'; map[8][9] = 'X'; map[9][9] = 'X';

	
	public void showMap()
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				System.out.println(" ");
				System.out.println(map[j][i]);
			}
			System.out.println("\n");
		}
	}
	
}