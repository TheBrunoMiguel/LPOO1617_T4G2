import java.util.Scanner;
//import java.lang.*;


public class Main 
{

	public static boolean DoesGuardDefeatHero(Map TheMap, Hero TheHero, Guard TheGuard)  // Function that returns true or false, depending on whether the Guard defeats the hero after the Guard's move
	{
		if (TheMap.map[TheGuard.y-1][TheGuard.x] == 'H')  //detetar se o heroi está acima do guarda
		{
			TheMap.showMap();
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap.map[TheGuard.y+1][TheGuard.x] == 'H')  //detetar se o heroi está abaixo do guarda
		{
			TheMap.showMap();
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap.map[TheGuard.y][TheGuard.x-1] == 'H')  //detetar se o heroi está à esquerda do guarda
		{
			TheMap.showMap();
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap.map[TheGuard.y][TheGuard.x+1] == 'H')  //detetar se o heroi está à direita do guarda
		{
			TheMap.showMap();
			System.out.println("You Lost!\n");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean DoesOgreDefeatHero(Map2 TheMap2, Hero TheHero, Ogre TheOgre)	 // Function that returns true or false, depending on whether the Ogre defeats the hero after the Ogre's move
	{
		if (TheMap2.map2[TheOgre.y-1][TheOgre.x] == 'H' || TheMap2.map2[TheOgre.y-1][TheOgre.x] == 'K')  //detetar se o heroi está acima do ogre
		{
			TheMap2.showMap2();
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap2.map2[TheOgre.y+1][TheOgre.x] == 'H' || TheMap2.map2[TheOgre.y+1][TheOgre.x] == 'K')  //detetar se o heroi está abaixo do ogre
		{
			TheMap2.showMap2();
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap2.map2[TheOgre.y][TheOgre.x-1] == 'H' || TheMap2.map2[TheOgre.y][TheOgre.x-1] == 'K')  //detetar se o heroi está à esquerda do ogre
		{
			TheMap2.showMap2();
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap2.map2[TheOgre.y][TheOgre.x+1] == 'H' || TheMap2.map2[TheOgre.y][TheOgre.x+1] == 'K')  //detetar se o heroi está à direita do ogre
		{
			TheMap2.showMap2();
			System.out.println("You Lost!\n");
			return true;
		}
		else
		{
			return false;
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
		
		while (GameOver == false)		//Game Cycle
		{
			map1.showMap();
			System.out.println("\n\n What's your move (A for left, S for down, W for up, D for right, and N for not moving) : ");
			Scanner reader1 = new Scanner(System.in);
			char TheMove = reader1.next(".").charAt(0);
		
			switch(TheMove)		//Hero's Move
			{
			case 'W': 
			{
				
				if(map1.map[hero1.y-1][hero1.x] != 'X')
				{
					hero1.MoveW();
				}
			}
			break;
			case 'A':
			{
				if(map1.map[hero1.y][hero1.x-1] == 'k')
				{
					map1.map[5][0] = 'S';
					map1.map[6][0] = 'S';
					map1.map[8][7] = 'K';
					hero1.MoveA();
				}
				else if (map1.map[hero1.y][hero1.x-1] == 'S')
				{
					GameOver = true;
					first_level_win = true;
					System.out.println("You Won!\n");
				}
				else if (map1.map[hero1.y][hero1.x-1] != 'X')
				{
					hero1.MoveA();
				}
			}
			break;
			case 'S':
			{
				
				if(map1.map[hero1.y+1][hero1.x] != 'X')
				{
					hero1.MoveS();
				}
			}
			break;
			case 'D': 
			{		
				if(map1.map[hero1.y][hero1.x+1] != 'X')
				{
					hero1.MoveD();
				}
			}
			break;
			default: 
				break;
			}
			
			reader1.close();
			
			if (GameOver == false)	//Guard's Move
			{	
				if(Guard_Counter> 23)
				{
					if(map1.map[guard1.y][guard1.x-1] != 'H')
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
					if(map1.map[guard1.y+1][guard1.x] != 'H')
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
					if(map1.map[guard1.y][guard1.x-1] != 'H')
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
					if(map1.map[guard1.y+1][guard1.x] != 'H')
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
					if(map1.map[guard1.y][guard1.x+1] != 'H')
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
					if(map1.map[guard1.y-1][guard1.x] != 'H')
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
					if(map1.map[guard1.y-1][guard1.x] != 'H')
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
			boolean OgreStepedOverKey = false;
			boolean ClubHitsKey = false;
			boolean GameOver2 = false;
			int PreviousClubColumn = 20;
			int PreviousClubRow = 20;
			
			while (GameOver2 == false)			//Game Cycle
			{
				map2.showMap2();
				System.out.println("\n\n What's your move (A for left, S for down, W for up, D for right, and N for not moving) : ");
				Scanner reader2 = new Scanner(System.in);
				char TheMove = reader2.next(".").charAt(0);
			
				switch(TheMove)		//Hero's Move
				{
				case 'W': 
				{
					if(map2.map2[hero2.y-1][hero2.x] == 'k' || map2.map2[hero2.y-1][hero2.x] == '&')
					{
						map2.map2[hero2.y][hero2.x] = 'K';
						map2.map2[hero2.y-1][hero2.x] = '0';
						hero2.MoveW();
					}
					else if (map2.map2[hero2.y-1][hero2.x] != 'X')
					{
						hero2.MoveW();
					}
				}
				break;
				case 'A':
				{
					if (map2.map2[hero2.y][hero2.x-1] == 'I')
					{
						if(map2.map2[hero2.y][hero2.x] == 'K')
						{
							map2.map2[hero2.y][hero2.x-1] = 'S';
						}
					}
					else if (map2.map2[hero2.y][hero2.x-1] == 'S')
					{
						GameOver2 = true;
						System.out.println("You Won!\n");
					}
					
					else if(map2.map2[hero2.y][hero2.x-1] != 'X')
					{
						hero2.MoveA();
					}
				}
				break;
				case 'S':
				{
					
					if(map2.map2[hero2.y+1][hero2.x] != 'X')
					{
						hero2.MoveS();
					}
				}
				break;
				case 'D': 
				{		
					if(map2.map2[hero2.y][hero2.x+1] == 'k' || map2.map2[hero2.y][hero2.x+1] == '&')
					{
						map2.map2[hero2.y][hero2.x] = 'K';
						map2.map2[hero2.y][hero2.x+1] = '0';
						hero2.MoveD();
					}
					else if (map2.map2[hero2.y][hero2.x+1] != 'X')
					{
						hero2.MoveW();
					}
				}
				break;
				default: 
					break;
				}
				
				reader2.close();
				
				if(GameOver2 == false)		//Ogre's Move
				{
					int OgreMove = 1 + (int)(Math.random() * ((4 - 1) + 1));		// 4 -> W; 3 -> A; 2 -> S; 1 -> D
				
					if(OgreMove == 4)  // 4 -> W
					{
						if(map2.map2[ogre1.y-1][ogre1.x] == 'H' || map2.map2[ogre1.y-1][ogre1.x] == 'K')
						{
							GameOver2 = true;
							System.out.println("You Lost!");
						}
						else if (map2.map2[ogre1.y-1][ogre1.x] == 'k' || map2.map2[ogre1.y-1][ogre1.x] == '&')
						{
							map2.map2[7][1] = '0';
							map2.map2[ogre1.y][ogre1.x] = '$';
							ogre1.MoveW();
							OgreStepedOverKey = true;
							GameOver2 = DoesOgreDefeatHero(map2, hero2, ogre1);
						}
						else if (map2.map2[ogre1.y-1][ogre1.x] != 'X')
						{
							ogre1.MoveW();
							GameOver2 = DoesOgreDefeatHero(map2, hero2, ogre1);
						}
					}
					else if (OgreMove == 3) // 3 -> A
					{
						if(map2.map2[ogre1.y][ogre1.x-1] == 'H' || map2.map2[ogre1.y][ogre1.x-1] == 'K')
						{
							GameOver2 = true;
							System.out.println("You Lost!");
						}
						else if(map2.map2[ogre1.y][ogre1.x-1] != 'X' && map2.map2[ogre1.y][ogre1.x-1] != 'I' && map2.map2[ogre1.y][ogre1.x-1] != 'S')
						{
							ogre1.MoveA();
							if(OgreStepedOverKey == true)
							{
								map2.map2[ogre1.y][ogre1.x] = 'O';
								if(map2.map2[hero2.y][hero2.x] != 'K')
								{
									map2.map2[7][1] = 'k';
								}
								OgreStepedOverKey = false;
							}
							GameOver2 = DoesOgreDefeatHero(map2, hero2, ogre1);
						}
					}	
					else if (OgreMove == 2)  // 2 -> S
					{
						if(map2.map2[ogre1.y+1][ogre1.x] == 'H' || map2.map2[ogre1.y+1][ogre1.x] == 'K')
						{
							GameOver2 = true;
							System.out.println("You Lost!");
						}
						else if(map2.map2[ogre1.y+1][ogre1.x] != 'X')
						{
							ogre1.MoveS();
							if(OgreStepedOverKey == true)
							{
								map2.map2[ogre1.y][ogre1.x] = 'O';
								if(map2.map2[hero2.y][hero2.x] != 'K')
								{
									map2.map2[7][1] = 'k';
								}
								OgreStepedOverKey = false;
							}
							GameOver2 = DoesOgreDefeatHero(map2, hero2, ogre1);
						}
					}
					else if(OgreMove == 1) // 1 -> D
					{
						if(map2.map2[ogre1.y][ogre1.x+1] == 'H' || map2.map2[ogre1.y][ogre1.x+1] == 'K')
						{
							GameOver2 = true;
							System.out.println("You Lost!");
						}
						else if (map2.map2[ogre1.y][ogre1.x+1] == 'k' || map2.map2[ogre1.y][ogre1.x+1] == '&')
						{
							map2.map2[1][7] = '0';
							map2.map2[ogre1.y][ogre1.x] = '$';
							ogre1.MoveD();
							OgreStepedOverKey = true;
							GameOver2 = DoesOgreDefeatHero(map2, hero2, ogre1);
						}
						else if (map2.map2[ogre1.y-1][ogre1.x] != 'X')
						{
							ogre1.MoveW();
							GameOver2 = DoesOgreDefeatHero(map2, hero2, ogre1);
						}
					}
					
					
					if(GameOver2 == false)		//Ogre's Club's Move
					{
						int ClubMove = 1 + (int)(Math.random() * ((4 - 1) + 1));		// 4 -> W; 3 -> A; 2 -> S; 1 -> D
						if(map2.map2[PreviousClubColumn][PreviousClubRow] == '*')
						{
							map2.map2[PreviousClubColumn][PreviousClubRow] = '0';
						}
						if(ClubHitsKey == true)
						{
							if(map2.map2[7][1] == '&')
							{
								if(map2.map2[hero2.y][hero2.x] != 'K')
								{
									map2.map2[7][1] = 'k';
								}
							}
							ClubHitsKey = false;
						}
						
						if (ClubMove == 4)  // 4 -> W
						{
							if(map2.map2[ogre1.y-2][ogre1.x] == 'H' || map2.map2[ogre1.y-2][ogre1.x] == 'K' || map2.map2[ogre1.y-1][ogre1.x+1] == 'H' || map2.map2[ogre1.y-1][ogre1.x+1] == 'K' || map2.map2[ogre1.y-1][ogre1.x-1] == 'H' || map2.map2[ogre1.y-1][ogre1.x-1] == 'K')
							{
								map2.map2[ogre1.y-1][ogre1.x] = '*';
								map2.showMap2();
								GameOver2 = true;
								System.out.println("You Lost!");
							}
							else if (map2.map2[ogre1.y-1][ogre1.x] == 'k')
							{
								map2.map2[7][1] = '$';
								ClubHitsKey = true;
							}
							else if (map2.map2[ogre1.y-1][ogre1.x] != 'X')
							{
								map2.map2[ogre1.y-1][ogre1.x] = '*';
								PreviousClubColumn = ogre1.y-1;
								PreviousClubRow = ogre1.x;
							}
						}
						else if (ClubMove == 3) // 3 -> A
						{
							if(map2.map2[ogre1.y][ogre1.x-2] == 'H' || map2.map2[ogre1.y][ogre1.x-2] == 'K' || map2.map2[ogre1.y-1][ogre1.x-1] == 'H' || map2.map2[ogre1.y-1][ogre1.x-1] == 'K' || map2.map2[ogre1.y+1][ogre1.x-1] == 'H' || map2.map2[ogre1.y+1][ogre1.x-1] == 'K')
							{
								map2.map2[ogre1.y][ogre1.x-1] = '*';
								map2.showMap2();
								GameOver2 = true;
								System.out.println("\n\nYou Lost!");
							}
							else if(map2.map2[ogre1.y][ogre1.x-1] != 'X' && map2.map2[ogre1.y][ogre1.x-1] != 'I' && map2.map2[ogre1.y][ogre1.x-1] != 'S')
							{
								map2.map2[ogre1.y][ogre1.x-1] = '*';
								PreviousClubColumn = ogre1.y;
								PreviousClubRow = ogre1.x-1;
							}
						}	
						else if (ClubMove == 2)  // 2 -> S
						{
							if(map2.map2[ogre1.y+2][ogre1.x] == 'H' || map2.map2[ogre1.y+2][ogre1.x] == 'K' || map2.map2[ogre1.y+1][ogre1.x-1] == 'H' || map2.map2[ogre1.y+1][ogre1.x-1] == 'K' || map2.map2[ogre1.y+1][ogre1.x+1] == 'H' || map2.map2[ogre1.y+1][ogre1.x+1] == 'K')
							{
								map2.map2[ogre1.y+1][ogre1.x] = '*';
								map2.showMap2();
								GameOver2 = true;
								System.out.println("You Lost!");
							}
							else if(map2.map2[ogre1.y+1][ogre1.x] != 'X')
							{
								map2.map2[ogre1.y+1][ogre1.x] = '*';
								PreviousClubColumn = ogre1.y+1;
								PreviousClubRow = ogre1.x;
							}
						}
						else if(ClubMove == 1) // 1 -> D
						{
							if(map2.map2[ogre1.y][ogre1.x+2] == 'H' || map2.map2[ogre1.y][ogre1.x+2] == 'K' || map2.map2[ogre1.y-1][ogre1.x+1] == 'H' || map2.map2[ogre1.y-1][ogre1.x+1] == 'K' || map2.map2[ogre1.y+1][ogre1.x+1] == 'H' || map2.map2[ogre1.y+1][ogre1.x+1] == 'K')
							{
								map2.map2[ogre1.y][ogre1.x+1] = '*';
								map2.showMap2();
								GameOver2 = true;
								System.out.println("You Lost!");
							}
							else if (map2.map2[ogre1.y][ogre1.x+1] == 'k')
							{
								map2.map2[7][1] = '$';
								ClubHitsKey = true;
							}
							else if (map2.map2[ogre1.y][ogre1.x+1] != 'X')
							{
								map2.map2[ogre1.y][ogre1.x+1] = '*';
								PreviousClubColumn = ogre1.y-1;
								PreviousClubRow = ogre1.x;
							}
						}
					}
				}
				
			}
			
			if(GameOver2 == true)
			{
				System.out.println("Game Over!");
			}
			}
		}
	}