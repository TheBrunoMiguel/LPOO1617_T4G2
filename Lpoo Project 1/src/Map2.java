public class Map2 
{
	//char map2[][] = new char [9][9];   //map[columns][lines]
	
	public char map2[][] = { {'X', 'I', 'X', 'X', 'X', 'I', 'I', 'X', 'X', 'X'}, {'X', '0', '0', '0', '0', '0', '0', '0', 'H', 'X'},
							  {'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X'}, {'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X'}, 
							  {'X', 'O', '0', '0', '0', '0', '0', '0', '0', 'X'}, {'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X'}, 
							  {'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X'}, {'X', '0', '0', '0', '0', '0', '0', '0', '0', 'X'}, 
							  {'X', 'k', '0', '0', '0', '0', '0', '0', '0', 'X'}, {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
	
/*	
	map[0][0] = 'X'; map[1][0] = 'X'; map[2][0] = 'X'; map[3][0] = 'X'; map[4][0] = 'X'; map[5][0] = 'X'; map[6][0] = 'X';
	map[0][1] = 'I'; map[1][1] = '0'; map[2][1] = '0'; map[3][1] = '0'; map[4][1] = 'O'; map[5][1] = '0'; map[6][1] = '0';
	map[0][2] = 'X'; map[1][2] = '0'; map[2][2] = '0'; map[3][2] = '0'; map[4][2] = '0'; map[5][2] = '0'; map[6][2] = '0';
	map[0][3] = 'X'; map[1][3] = '0'; map[2][3] = '0'; map[3][3] = '0'; map[4][3] = '0'; map[5][3] = '0'; map[6][3] = '0';
	map[0][4] = 'X'; map[1][4] = '0'; map[2][4] = '0'; map[3][4] = '0'; map[4][4] = '0'; map[5][4] = '0'; map[6][4] = '0';
	map[0][5] = 'X'; map[1][5] = '0'; map[2][5] = '0'; map[3][5] = '0'; map[4][5] = '0'; map[5][5] = '0'; map[6][5] = '0';
	map[0][6] = 'X'; map[1][6] = '0'; map[2][6] = '0'; map[3][6] = '0'; map[4][6] = '0'; map[5][6] = '0'; map[6][6] = '0';
	map[0][7] = 'X'; map[1][7] = '0'; map[2][7] = '0'; map[3][7] = '0'; map[4][7] = '0'; map[5][7] = '0'; map[6][7] = '0';
	map[0][8] = 'X'; map[1][8] = 'H'; map[2][8] = '0'; map[3][8] = '0'; map[4][8] = '0'; map[5][8] = '0'; map[6][8] = '0';
	map[0][9] = 'X'; map[1][9] = 'X'; map[2][9] = 'X'; map[3][9] = 'X'; map[4][9] = 'X'; map[5][9] = 'X'; map[6][9] = 'X';
		
	map[7][0] = 'X'; map[8][0] = 'X'; map[9][0] = 'X';
	map[7][1] = '0'; map[8][1] = 'k'; map[9][1] = 'X';
	map[7][2] = '0'; map[8][2] = '0'; map[9][2] = 'X';
	map[7][3] = '0'; map[8][3] = '0'; map[9][3] = 'X';
	map[7][4] = '0'; map[8][4] = '0'; map[9][4] = 'X';
	map[7][5] = '0'; map[8][5] = '0'; map[9][5] = 'X';
	map[7][6] = '0'; map[8][6] = '0'; map[9][6] = 'X';
	map[7][7] = '0'; map[8][7] = '0'; map[9][7] = 'X';
	map[7][8] = '0'; map[8][8] = '0'; map[9][8] = 'X';
	map[7][9] = 'X'; map[8][9] = 'X'; map[9][9] = 'X';

*/
	
	public void showMap2()
	{
		for(int i = 0; i < 10; i++)
		{
			String Each_Line = " ";
			for(int j = 0; j < 10; j++)
			{
				if(map2[j][i] == '0')
				{
					Each_Line = Each_Line + "  ";
				}
				else
				{
					Each_Line = Each_Line + map2[j][i] + " ";
				}
			}
			Each_Line = Each_Line + "\n";
			System.out.println(Each_Line);
		}
	}
	
}
