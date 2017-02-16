import java.util.Scanner;


public class Main 
{

	public static boolean DoesGuardDefeatHero(Map TheMap, Hero TheHero, Guard TheGuard)
	{
		if (TheMap[TheGuard.y-1][TheGuard.x] == 'H')  //detetar se o heroi está acima do guarda
		{
			TheMap.showMap();
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap[TheGuard.y+1][TheGuard.x] == 'H')  //detetar se o heroi está abaixo do guarda
		{
			TheMap.showMap();
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap[TheGuard.y][TheGuard.x-1] == 'H')  //detetar se o heroi está à esquerda do guarda
		{
			TheMap.showMap();
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap[TheGuard.y][TheGuard.x+1] == 'H')  //detetar se o heroi está à direita do guarda
		{
			TheMap.showMap();
			System.out.println("You Lost!\n");
			return true;
		}
	}
	
	
	public static void main(String[] args) 
	{
		
		//level 1
		
		System.out.println("Welcome to the Dungeon!\n\n");
		Map map1 = new Map();
		Hero hero1 = new Hero();
		Guard guard1 = new Guard();
		boolean GameOver = false;
		int Guard_Counter = 24;
		boolean first_level_win = false;
		
		while (GameOver = false)
		{
			map1.showMap();
			System.out.println("\n\n What's your move (A for left, S for down, W for up, D for right, and N for not moving) : ");
			Scanner reader = new Scanner(System.in);
			char TheMove = reader.next(".").charAt(0);
		
			switch(TheMove)
			{
			case 'W': 
			{
				
				if(map1[hero1.y-1][hero1.x] != 'X')
				{
					hero1.MoveW();
				}
			}
			break;
			case 'A':
			{
				if(map1[hero1.y][hero1.x-1] == 'k')
				{
					map1[5][0] = 'S';
					map1[6][0] = 'S';
					map1[8][7] = 'K';
					hero1.MoveA();
				}
				else if (map1[hero1.y][hero1.x-1] == 'S')
				{
					GameOver = true;
					first_level_win = true;
					System.out.println("You Won!\n");
				}
				else if (map1[hero1.y][hero1.x-1] != 'X')
				{
					hero1.MoveA();
				}
			}
			break;
			case 'S':
			{
				
				if(map1[hero1.y+1][hero1.x] != 'X')
				{
					hero1.MoveS();
				}
			}
			break;
			case 'D': 
			{		
				if(map1[hero1.y][hero1.x+1] != 'X')
				{
					hero1.MoveD();
				}
			}
			break;
			default: 
				break;
			}
		
			if(Guard_Counter> 23)
			{
				if(map1[guard1.y][guard1.x-1] != 'H')
				{
					Guard_Counter--;
					guard1.MoveA();
					GameOver = DoesGuardDefeatHero(map1, hero1, guard1);
				}
				else
				{
					GameOver = true;
					System.out.println("You Lost!");
				}
			}
			else if (Guard_Counter > 19)
			{
				if(map1[guard1.y+1][guard1.x] != 'H')
				{
					Guard_Counter--;
					guard1.MoveS();
					GameOver = DoesGuardDefeatHero(map1, hero1, guard1);
				}
				else
				{
					GameOver = true;
					System.out.println("You Lost!");
				}
			}
			else if (Guard_Counter > 13)
			{
				if(map1[guard1.y][guard1.x-1] != 'H')
				{
					Guard_Counter--;
					guard1.MoveA();
					GameOver = DoesGuardDefeatHero(map1, hero1, guard1);
				}
				else
				{
					GameOver = true;
					System.out.println("You Lost!");
				}	
			}
			else if(Guard_Counter > 12)
			{
				if(map1[guard1.y+1][guard1.x] != 'H')
				{
					Guard_Counter--;
					guard1.MoveS();
					GameOver = DoesGuardDefeatHero(map1, hero1, guard1);
				}
				else
				{
					GameOver = true;
					System.out.println("You Lost!");
				}
			}
			else if(Guard_Counter > 5)
			{
				if(map1[guard1.y][guard1.x+1] != 'H')
				{
					Guard_Counter--;
					guard1.MoveD();
					GameOver = DoesGuardDefeatHero(map1, hero1, guard1);
				}
				else
				{
					GameOver = true;
					System.out.println("You Lost!");
				}
			}
			else if (Guard_Counter > 1)
			{
				if(map1[guard1.y-1][guard1.x] != 'H')
				{
					Guard_Counter--;
					guard1.MoveW();
					GameOver = DoesGuardDefeatHero(map1, hero1, guard1);
				}
				else
				{
					GameOver = true;
					System.out.println("You Lost!");
				}
			}
			else if (Guard_Counter == 1)
			{
				if(map1[guard1.y-1][guard1.x] != 'H')
				{
					Guard_Counter= 24;
					guard1.MoveW();
					GameOver = DoesGuardDefeatHero(map1, hero1, guard1);
				}
				else
				{
					GameOver = true;
					System.out.println("You Lost!");
				}
			}
		}
		
		if(GameOver == true && first_level_win == false)
		{
			System.out.println("Game Over!");
		}
		
		
		//level 2
		
		else if (GameOver == true && first_level_win == true)
		{
			System.out.println("Welcome to Level 2!\n\n");
			Map2 map2 = new Map2();
			Hero hero2 = new Hero();
			Ogre ogre1 = new Ogre();
			boolean GameOver2 = false;
			
			while (GameOver2 = false)
			{
				map2.showMap();
				System.out.println("\n\n What's your move (A for left, S for down, W for up, D for right, and N for not moving) : ");
				Scanner reader = new Scanner(System.in);
				char TheMove = reader.next(".").charAt(0);
			
				switch(TheMove)
				{
				case 'W': 
				{
					if(map2[hero2.y-1][hero2.x] == 'k')
					{
						map2[hero2.y][hero2.x] = 'K';
						map2[hero2.y-1][hero2.x] = '0';
						hero2.MoveW();
					}
					else if (map2[hero2.y-1][hero2.x]!= 'X')
					{
						hero2.MoveW();
					}
				}
				break;
				case 'A':
				{
					if (map2[hero2.y][hero2.x-1] == 'I')
					{
						if(map2[hero2.y][hero2.x] == 'K')
						{
							map2[hero2.y][hero2.x-1] = 'S';
						}
					}
					else if (map2[hero2.y][hero2.x-1] == 'S')
					{
						GameOver2 = true;
						System.out.println("You Won!\n");
					}
					
					else if(map2[hero2.y][hero2.x-1] != 'X')
					{
						hero2.MoveA();
					}
				}
				break;
				case 'S':
				{
					
					if(map2[hero2.y+1][hero2.x] != 'X')
					{
						hero2.MoveS();
					}
				}
				break;
				case 'D': 
				{		
					if(map2[hero2.y][hero2.x+1] == 'k')
					{
						map2[hero2.y][hero2.x] = 'K';
						map2[hero2.y][hero2.x+1] = '0';
						hero2.MoveD();
					}
					else if (map2[hero2.y][hero2.x+1] != 'X')
					{
						hero2.MoveW();
					}
				}
				break;
				default: 
					break;
				}
					
		}
			if(GameOver2 == true)
			{
				System.out.println("Game Over!");
			}
			}
		}
}
