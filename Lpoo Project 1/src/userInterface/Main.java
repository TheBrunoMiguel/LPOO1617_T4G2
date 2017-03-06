package userInterface;
import gameLogic.*;


public class Main 
{
	public static void main(String[] args) 
	{
		
		//level 1
		
		System.out.println("Welcome to the Dungeon!\n\n");
		UserInterface UI = new UserInterface();
		gameLogic.GameLogic TheGameLogic = new GameLogic();
		Map map1 = new Map();
		Hero hero1 = new Hero(1, 1);
		//int guardPersonality = 1 + (int)(Math.random() * ((3 - 1) + 1));
		int guardPersonality = 1;
		Guard guard1 = new Guard(guardPersonality);
		boolean GameOver = false;
		int Guard_Counter = 24;
		boolean first_level_win = false;
		
		if(guardPersonality == 1)
		{
			while (GameOver == false)		//Game Cycle
			{
				UI.showMap(map1);
				String TheMove = UI.MoveInput();
				TheGameLogic.Level1_Rookie(map1, hero1, guard1, GameOver, Guard_Counter, first_level_win, TheMove);
			}
		}
		else if(guardPersonality == 2)
		{
			while(GameOver == false)
			{
				UI.showMap(map1);
				String TheMove = UI.MoveInput();
				TheGameLogic.Level1_Drunken(map1, hero1, guard1, GameOver, Guard_Counter, first_level_win, TheMove);
			}
		}
		
		else if (guardPersonality == 3)
		{
			while(GameOver == false)
			{
				UI.showMap(map1);
				String TheMove = UI.MoveInput();
				TheGameLogic.Level1_Suspicious(map1, hero1, guard1, GameOver, Guard_Counter, first_level_win, TheMove);
			}
		}
/*			
			switch(TheMove)		//Hero's Move 
			{
			case "w": 
			{
				
				if(map1.map[hero1.y-1][hero1.x] != 'X')
				{
					hero1.MoveW(map1, 'H');
				}
			}
			break;
			case "a":
			{
				if(map1.map[hero1.y][hero1.x-1] == 'k')
				{
					map1.map[5][0] = 'S';
					map1.map[6][0] = 'S';
					map1.map[8][7] = 'K';
					hero1.MoveA(map1, 'H');
				}
				else if (map1.map[hero1.y][hero1.x-1] == 'S')
				{
					GameOver = true;
					first_level_win = true;
					System.out.println("You Won!\n");
				}
				else if (map1.map[hero1.y][hero1.x-1] != 'X')
				{
					hero1.MoveA(map1, 'H');
				}
			}
			break;
			case "s":
			{
				
				if(map1.map[hero1.y+1][hero1.x] != 'X')
				{
					hero1.MoveS(map1, 'H');
				}
			}
			break;
			case "d": 
			{		
				if(map1.map[hero1.y][hero1.x+1] != 'X')
				{
					hero1.MoveD(map1, 'H');
				}
			}
			break;
			default:
				System.out.println("DEFAULT");
				break;
			}
			
			if (GameOver == false)	//Guard's Move
			{	
				if(Guard_Counter> 23)
				{
					if(map1.map[guard1.y][guard1.x-1] != 'H')
					{
						Guard_Counter--;
						guard1.MoveA(map1, 'G');
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
						guard1.MoveS(map1, 'G');
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
						guard1.MoveA(map1, 'G');
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
						guard1.MoveS(map1, 'G');
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
						guard1.MoveD(map1, 'G');
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
						guard1.MoveW(map1, 'G');
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
						guard1.MoveW(map1, 'G');
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
		
*/		
			
		if(GameOver == true && first_level_win == false)
		{
			System.out.println("Game Over!");
		}
		
		
		//level 2
		
		else if (GameOver == true && first_level_win == true)
		{
			System.out.println("Welcome to Level 2!\n\n");
			Map2 map2 = new Map2();
			Hero hero2 = new Hero(1, 7);
			Ogre ogre1 = new Ogre();
			boolean OgreStepedOverKey = false;
			boolean ClubHitsKey = false;
			boolean GameOver2 = false;
			int PreviousClubColumn = 20;
			int PreviousClubRow = 20;
			
			
			while (GameOver2 == false)			//Game Cycle
			{
				UI.showMap2(map2);
				String TheMove2 = UI.MoveInput();
				TheGameLogic.Level2(map2, hero2, ogre1, GameOver2, OgreStepedOverKey, ClubHitsKey, PreviousClubColumn, PreviousClubRow, TheMove2);
			}
/*			
				switch(TheMove)		//Hero's Move
				{
				case "w": 
				{
					if(map2.map2[hero2.y-1][hero2.x] == 'k' || map2.map2[hero2.y-1][hero2.x] == '&')
					{
						map2.map2[hero2.y][hero2.x] = 'K';
						map2.map2[hero2.y-1][hero2.x] = '0';
						hero2.MoveW(map2, 'H');
					}
					else if (map2.map2[hero2.y-1][hero2.x] != 'X')
					{
						hero2.MoveW(map2, 'H');
					}
				}
				break;
				case "a":
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
						hero2.MoveA(map2, 'H');
					}
				}
				break;
				case "s":
				{
					
					if(map2.map2[hero2.y+1][hero2.x] != 'X')
					{
						hero2.MoveS(map2, 'H');
					}
				}
				break;
				case "d": 
				{		
					if(map2.map2[hero2.y][hero2.x+1] == 'k' || map2.map2[hero2.y][hero2.x+1] == '&')
					{
						map2.map2[hero2.y][hero2.x] = 'K';
						map2.map2[hero2.y][hero2.x+1] = '0';
						hero2.MoveD(map2, 'H');
					}
					else if (map2.map2[hero2.y][hero2.x+1] != 'X')
					{
						hero2.MoveW(map2, 'H');
					}
				}
				break;
				default: 
					break;
				}
				
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
							ogre1.MoveW(map2, 'O');
							OgreStepedOverKey = true;
							GameOver2 = DoesOgreDefeatHero(map2, hero2, ogre1);
						}
						else if (map2.map2[ogre1.y-1][ogre1.x] != 'X')
						{
							ogre1.MoveW(map2, 'O');
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
							ogre1.MoveA(map2, 'O');
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
							ogre1.MoveS(map2, 'O');
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
							ogre1.MoveD(map2, 'O');
							OgreStepedOverKey = true;
							GameOver2 = DoesOgreDefeatHero(map2, hero2, ogre1);
						}
						else if (map2.map2[ogre1.y-1][ogre1.x] != 'X')
						{
							ogre1.MoveW(map2, 'O');
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
								UserInterface.showMap2(map2);
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
								UserInterface.showMap2(map2);
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
								UserInterface.showMap2(map2);
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
								UserInterface.showMap2(map2);
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
*/			
			if(GameOver2 == true)
			{
				System.out.println("Game Over!");
			}
		}
	}
}