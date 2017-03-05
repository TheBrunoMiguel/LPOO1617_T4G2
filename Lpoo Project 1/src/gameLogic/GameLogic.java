package gameLogic;
import userInterface.UserInterface;


public class GameLogic 
{
	public boolean DoesGuardDefeatHero(Map TheMap, Hero TheHero, Guard TheGuard)  // Function that returns true or false, depending on whether the Guard defeats the hero after the Guard's move
	{
		userInterface.UserInterface TheUI = new UserInterface();
		if (TheMap.map[TheGuard.y-1][TheGuard.x] == 'H')  //detetar se o heroi está acima do guarda
		{
			TheUI.showMap(TheMap);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap.map[TheGuard.y+1][TheGuard.x] == 'H')  //detetar se o heroi está abaixo do guarda
		{
			TheUI.showMap(TheMap);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap.map[TheGuard.y][TheGuard.x-1] == 'H')  //detetar se o heroi está à esquerda do guarda
		{
			TheUI.showMap(TheMap);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap.map[TheGuard.y][TheGuard.x+1] == 'H')  //detetar se o heroi está à direita do guardaa
		{
			TheUI.showMap(TheMap);
			System.out.println("You Lost!\n");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean DoesOgreDefeatHero(Map2 TheMap2, Hero TheHero, Ogre TheOgre)	 // Function that returns true or false, depending on whether the Ogre defeats the hero after the Ogre's move
	{
		userInterface.UserInterface TheUI = new UserInterface();
		if (TheMap2.map2[TheOgre.y-1][TheOgre.x] == 'H' || TheMap2.map2[TheOgre.y-1][TheOgre.x] == 'K')  //detetar se o heroi está acima do ogre
		{
			TheUI.showMap2(TheMap2);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap2.map2[TheOgre.y+1][TheOgre.x] == 'H' || TheMap2.map2[TheOgre.y+1][TheOgre.x] == 'K')  //detetar se o heroi está abaixo do ogre
		{
			TheUI.showMap2(TheMap2);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap2.map2[TheOgre.y][TheOgre.x-1] == 'H' || TheMap2.map2[TheOgre.y][TheOgre.x-1] == 'K')  //detetar se o heroi está à esquerda do ogre
		{
			TheUI.showMap2(TheMap2);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap2.map2[TheOgre.y][TheOgre.x+1] == 'H' || TheMap2.map2[TheOgre.y][TheOgre.x+1] == 'K')  //detetar se o heroi está à direita do ogre
		{
			TheUI.showMap2(TheMap2);
			System.out.println("You Lost!\n");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void Level1(Map TheMap, Hero TheHero, Guard TheGuard, boolean gameover, int guard_counter, boolean first_level_win, String TheMove)
	{
		switch(TheMove)		//Hero's Move
		{
		case "w": 
		{
			
			if(TheMap.map[TheHero.y-1][TheHero.x] != 'X')
			{
				TheHero.MoveW(TheMap, 'H');
			}
		}
		break;
		case "a":
		{
			if(TheMap.map[TheHero.y][TheHero.x-1] == 'k')
			{
				TheMap.map[5][0] = 'S';
				TheMap.map[6][0] = 'S';
				TheMap.map[8][7] = 'K';
				TheHero.MoveA(TheMap, 'H');
			}
			else if (TheMap.map[TheHero.y][TheHero.x-1] == 'S')
			{
				gameover = true;
				first_level_win = true;
				System.out.println("You Won!\n");
			}
			else if (TheMap.map[TheHero.y][TheHero.x-1] != 'X')
			{
				TheHero.MoveA(TheMap, 'H');
			}
		}
		break;
		case "s":
		{
			
			if(TheMap.map[TheHero.y+1][TheHero.x] != 'X')
			{
				TheHero.MoveS(TheMap, 'H');
			}
		}
		break;
		case "d": 
		{		
			if(TheMap.map[TheHero.y][TheHero.x+1] != 'X')
			{
				TheHero.MoveD(TheMap, 'H');
			}
		}
		break;
		default:
			System.out.println("DEFAULT");
			break;
		}
		
		if (gameover == false)	//Guard's Move
		{	
			if(guard_counter> 23)
			{
				if(TheMap.map[TheGuard.y][TheGuard.x-1] != 'H')
				{
					guard_counter--;
					TheGuard.MoveA(TheMap, 'G');
					gameover = DoesGuardDefeatHero(TheMap, TheHero, TheGuard);
				}
				else
				{
					gameover = true;
					System.out.println("You Lost!");
				}
			}
			else if (guard_counter > 19)
			{
				if(TheMap.map[TheGuard.y+1][TheGuard.x] != 'H')
				{
					guard_counter--;
					TheGuard.MoveS(TheMap, 'G');
					gameover = DoesGuardDefeatHero(TheMap, TheHero, TheGuard);
				}
				else
				{
					gameover = true;
					System.out.println("You Lost!");
				}
			}
			else if (guard_counter > 13)
			{
				if(TheMap.map[TheGuard.y][TheGuard.x-1] != 'H')
				{
					guard_counter--;
					TheGuard.MoveA(TheMap, 'G');
					gameover = DoesGuardDefeatHero(TheMap, TheHero, TheGuard);
				}
				else
				{
					gameover = true;
					System.out.println("You Lost!");
				}	
			}
			else if(guard_counter > 12)
			{
				if(TheMap.map[TheGuard.y+1][TheGuard.x] != 'H')
				{
					guard_counter--;
					TheGuard.MoveS(TheMap, 'G');
					gameover = DoesGuardDefeatHero(TheMap, TheHero, TheGuard);
				}
				else
				{
					gameover = true;
					System.out.println("You Lost!");
				}
			}	
			else if(guard_counter > 5)
			{
				if(TheMap.map[TheGuard.y][TheGuard.x+1] != 'H')
				{
					guard_counter--;
					TheGuard.MoveD(TheMap, 'G');
					gameover = DoesGuardDefeatHero(TheMap, TheHero, TheGuard);
				}
				else
				{
					gameover = true;
					System.out.println("You Lost!");
				}
			}
			else if (guard_counter > 1)
			{
				if(TheMap.map[TheGuard.y-1][TheGuard.x] != 'H')
				{
					guard_counter--;
					TheGuard.MoveW(TheMap, 'G');
					gameover = DoesGuardDefeatHero(TheMap, TheHero, TheGuard);
				}
				else
				{
					gameover = true;
					System.out.println("You Lost!");
				}
			}
			else if (guard_counter == 1)
			{
				if(TheMap.map[TheGuard.y-1][TheGuard.x] != 'H')
				{
					guard_counter= 24;
					TheGuard.MoveW(TheMap, 'G');
					gameover = DoesGuardDefeatHero(TheMap, TheHero, TheGuard);
				}
				else
				{
					gameover = true;
					System.out.println("You Lost!");
				}
			}
		}
	}

	public void Level2(Map2 TheMap2, Hero TheHero, Ogre TheOgre, boolean gameover2, boolean ogrestepedoverkey, boolean clubhitskey, int previousclubcolumn, int previousclubrow, String TheMove2)
	{
		userInterface.UserInterface TheUI = new UserInterface();
		switch(TheMove2)		//Hero's Move
		{
		case "w": 
		{
			if(TheMap2.map2[TheHero.y-1][TheHero.x] == 'k' || TheMap2.map2[TheHero.y-1][TheHero.x] == '&')
			{
				TheMap2.map2[TheHero.y][TheHero.x] = 'K';
				TheMap2.map2[TheHero.y-1][TheHero.x] = '0';
				TheHero.MoveW(TheMap2, 'H');
			}
			else if (TheMap2.map2[TheHero.y-1][TheHero.x] != 'X')
			{
				TheHero.MoveW(TheMap2, 'H');
			}
		}
		break;
		case "a":
		{
			if (TheMap2.map2[TheHero.y][TheHero.x-1] == 'I')
			{
				if(TheMap2.map2[TheHero.y][TheHero.x] == 'K')
				{
					TheMap2.map2[TheHero.y][TheHero.x-1] = 'S';
				}
			}
			else if (TheMap2.map2[TheHero.y][TheHero.x-1] == 'S')
			{
				gameover2 = true;
				System.out.println("You Won!\n");
			}
			
			else if(TheMap2.map2[TheHero.y][TheHero.x-1] != 'X')
			{
				TheHero.MoveA(TheMap2, 'H');
			}
		}
		break;
		case "s":
		{
			
			if(TheMap2.map2[TheHero.y+1][TheHero.x] != 'X')
			{
				TheHero.MoveS(TheMap2, 'H');
			}
		}
		break;
		case "d": 
		{		
			if(TheMap2.map2[TheHero.y][TheHero.x+1] == 'k' || TheMap2.map2[TheHero.y][TheHero.x+1] == '&')
			{
				TheMap2.map2[TheHero.y][TheHero.x] = 'K';
				TheMap2.map2[TheHero.y][TheHero.x+1] = '0';
				TheHero.MoveD(TheMap2, 'H');
			}
			else if (TheMap2.map2[TheHero.y][TheHero.x+1] != 'X')
			{
				TheHero.MoveW(TheMap2, 'H');
			}
		}
		break;
		default: 
			break;
		}
		
		if(gameover2 == false)		//Ogre's Move
		{
			int OgreMove = 1 + (int)(Math.random() * ((4 - 1) + 1));		// 4 -> W; 3 -> A; 2 -> S; 1 -> D
		
			if(OgreMove == 4)  // 4 -> W
			{
				if(TheMap2.map2[TheOgre.y-1][TheOgre.x] == 'H' || TheMap2.map2[TheOgre.y-1][TheOgre.x] == 'K')
				{
					gameover2 = true;
					System.out.println("You Lost!");
				}
				else if (TheMap2.map2[TheOgre.y-1][TheOgre.x] == 'k' || TheMap2.map2[TheOgre.y-1][TheOgre.x] == '&')
				{
					TheMap2.map2[7][1] = '0';
					TheMap2.map2[TheOgre.y][TheOgre.x] = '$';
					TheOgre.MoveW(TheMap2, 'O');
					ogrestepedoverkey = true;
					gameover2 = DoesOgreDefeatHero(TheMap2, TheHero, TheOgre);
				}
				else if (TheMap2.map2[TheOgre.y-1][TheOgre.x] != 'X')
				{
					TheOgre.MoveW(TheMap2, 'O');
					gameover2 = DoesOgreDefeatHero(TheMap2, TheHero, TheOgre);
				}
			}
			else if (OgreMove == 3) // 3 -> A
			{
				if(TheMap2.map2[TheOgre.y][TheOgre.x-1] == 'H' || TheMap2.map2[TheOgre.y][TheOgre.x-1] == 'K')
				{
					gameover2 = true;
					System.out.println("You Lost!");
				}
				else if(TheMap2.map2[TheOgre.y][TheOgre.x-1] != 'X' && TheMap2.map2[TheOgre.y][TheOgre.x-1] != 'I' && TheMap2.map2[TheOgre.y][TheOgre.x-1] != 'S')
				{
					TheOgre.MoveA(TheMap2, 'O');
					if(ogrestepedoverkey == true)
					{
						TheMap2.map2[TheOgre.y][TheOgre.x] = 'O';
						if(TheMap2.map2[TheHero.y][TheHero.x] != 'K')
						{
							TheMap2.map2[7][1] = 'k';
						}
						ogrestepedoverkey = false;
					}
					gameover2 = DoesOgreDefeatHero(TheMap2, TheHero, TheOgre);
				}
			}	
			else if (OgreMove == 2)  // 2 -> S
			{
				if(TheMap2.map2[TheOgre.y+1][TheOgre.x] == 'H' || TheMap2.map2[TheOgre.y+1][TheOgre.x] == 'K')
				{
					gameover2 = true;
					System.out.println("You Lost!");
				}
				else if(TheMap2.map2[TheOgre.y+1][TheOgre.x] != 'X')
				{
					TheOgre.MoveS(TheMap2, 'O');
					if(ogrestepedoverkey == true)
					{
						TheMap2.map2[TheOgre.y][TheOgre.x] = 'O';
						if(TheMap2.map2[TheHero.y][TheHero.x] != 'K')
						{
							TheMap2.map2[7][1] = 'k';
						}
						ogrestepedoverkey = false;
					}
					gameover2 = DoesOgreDefeatHero(TheMap2, TheHero, TheOgre);
				}
			}
			else if(OgreMove == 1) // 1 -> D
			{
				if(TheMap2.map2[TheOgre.y][TheOgre.x+1] == 'H' || TheMap2.map2[TheOgre.y][TheOgre.x+1] == 'K')
				{
					gameover2 = true;
					System.out.println("You Lost!");
				}
				else if (TheMap2.map2[TheOgre.y][TheOgre.x+1] == 'k' || TheMap2.map2[TheOgre.y][TheOgre.x+1] == '&')
				{
					TheMap2.map2[1][7] = '0';
					TheMap2.map2[TheOgre.y][TheOgre.x] = '$';
					TheOgre.MoveD(TheMap2, 'O');
					ogrestepedoverkey = true;
					gameover2 = DoesOgreDefeatHero(TheMap2, TheHero, TheOgre);
				}
				else if (TheMap2.map2[TheOgre.y-1][TheOgre.x] != 'X')
				{
					TheOgre.MoveW(TheMap2, 'O');
					gameover2 = DoesOgreDefeatHero(TheMap2, TheHero, TheOgre);
				}
			}
			
			
			if(gameover2 == false)		//Ogre's Club's Move
			{
				int ClubMove = 1 + (int)(Math.random() * ((4 - 1) + 1));		// 4 -> W; 3 -> A; 2 -> S; 1 -> D
				if(TheMap2.map2[previousclubcolumn][previousclubrow] == '*')
				{
					TheMap2.map2[previousclubcolumn][previousclubrow] = '0';
				}
				if(clubhitskey == true)
				{
					if(TheMap2.map2[7][1] == '&')
					{
						if(TheMap2.map2[TheHero.y][TheHero.x] != 'K')
						{
							TheMap2.map2[7][1] = 'k';
						}
					}
					clubhitskey = false;
				}
				
				if (ClubMove == 4)  // 4 -> W
				{
					if(TheMap2.map2[TheOgre.y-2][TheOgre.x] == 'H' || TheMap2.map2[TheOgre.y-2][TheOgre.x] == 'K' || TheMap2.map2[TheOgre.y-1][TheOgre.x+1] == 'H' || TheMap2.map2[TheOgre.y-1][TheOgre.x+1] == 'K' || TheMap2.map2[TheOgre.y-1][TheOgre.x-1] == 'H' || TheMap2.map2[TheOgre.y-1][TheOgre.x-1] == 'K')
					{
						TheMap2.map2[TheOgre.y-1][TheOgre.x] = '*';
						TheUI.showMap2(TheMap2);
						gameover2 = true;
						System.out.println("You Lost!");
					}
					else if (TheMap2.map2[TheOgre.y-1][TheOgre.x] == 'k')
					{
						TheMap2.map2[7][1] = '$';
						clubhitskey = true;
					}
					else if (TheMap2.map2[TheOgre.y-1][TheOgre.x] != 'X')
					{
						TheMap2.map2[TheOgre.y-1][TheOgre.x] = '*';
						previousclubcolumn = TheOgre.y-1;
						previousclubrow = TheOgre.x;
					}
				}
				else if (ClubMove == 3) // 3 -> A
				{
					if(TheMap2.map2[TheOgre.y][TheOgre.x-2] == 'H' || TheMap2.map2[TheOgre.y][TheOgre.x-2] == 'K' || TheMap2.map2[TheOgre.y-1][TheOgre.x-1] == 'H' || TheMap2.map2[TheOgre.y-1][TheOgre.x-1] == 'K' || TheMap2.map2[TheOgre.y+1][TheOgre.x-1] == 'H' || TheMap2.map2[TheOgre.y+1][TheOgre.x-1] == 'K')
					{
						TheMap2.map2[TheOgre.y][TheOgre.x-1] = '*';
						TheUI.showMap2(TheMap2);
						gameover2 = true;
						System.out.println("\n\nYou Lost!");
					}
					else if(TheMap2.map2[TheOgre.y][TheOgre.x-1] != 'X' && TheMap2.map2[TheOgre.y][TheOgre.x-1] != 'I' && TheMap2.map2[TheOgre.y][TheOgre.x-1] != 'S')
					{
						TheMap2.map2[TheOgre.y][TheOgre.x-1] = '*';
						previousclubcolumn = TheOgre.y;
						previousclubrow = TheOgre.x-1;
					}
				}	
				else if (ClubMove == 2)  // 2 -> S
				{
					if(TheMap2.map2[TheOgre.y+2][TheOgre.x] == 'H' || TheMap2.map2[TheOgre.y+2][TheOgre.x] == 'K' || TheMap2.map2[TheOgre.y+1][TheOgre.x-1] == 'H' || TheMap2.map2[TheOgre.y+1][TheOgre.x-1] == 'K' || TheMap2.map2[TheOgre.y+1][TheOgre.x+1] == 'H' || TheMap2.map2[TheOgre.y+1][TheOgre.x+1] == 'K')
					{
						TheMap2.map2[TheOgre.y+1][TheOgre.x] = '*';
						TheUI.showMap2(TheMap2);
						gameover2 = true;
						System.out.println("You Lost!");
					}
					else if(TheMap2.map2[TheOgre.y+1][TheOgre.x] != 'X')
					{
						TheMap2.map2[TheOgre.y+1][TheOgre.x] = '*';
						previousclubcolumn = TheOgre.y+1;
						previousclubrow = TheOgre.x;
					}
				}
				else if(ClubMove == 1) // 1 -> D
				{
					if(TheMap2.map2[TheOgre.y][TheOgre.x+2] == 'H' || TheMap2.map2[TheOgre.y][TheOgre.x+2] == 'K' || TheMap2.map2[TheOgre.y-1][TheOgre.x+1] == 'H' || TheMap2.map2[TheOgre.y-1][TheOgre.x+1] == 'K' || TheMap2.map2[TheOgre.y+1][TheOgre.x+1] == 'H' || TheMap2.map2[TheOgre.y+1][TheOgre.x+1] == 'K')
					{
						TheMap2.map2[TheOgre.y][TheOgre.x+1] = '*';
						TheUI.showMap2(TheMap2);
						gameover2 = true;
						System.out.println("You Lost!");
					}
					else if (TheMap2.map2[TheOgre.y][TheOgre.x+1] == 'k')
					{
						TheMap2.map2[7][1] = '$';
						clubhitskey = true;
					}
					else if (TheMap2.map2[TheOgre.y][TheOgre.x+1] != 'X')
					{
						TheMap2.map2[TheOgre.y][TheOgre.x+1] = '*';
						previousclubcolumn = TheOgre.y-1;
						previousclubrow = TheOgre.x;
					}
				}
			}
		}
		
	}
}
