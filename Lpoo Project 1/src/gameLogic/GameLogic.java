package gameLogic;
import userInterface.UserInterface;


public class GameLogic 
{
	public static boolean DoesGuardDefeatHero(Map TheMap, Hero TheHero, Guard TheGuard)  // Function that returns true or false, depending on whether the Guard defeats the hero after the Guard's move
	{
		if (TheMap.map[TheGuard.y-1][TheGuard.x] == 'H')  //detetar se o heroi está acima do guarda
		{
			UserInterface.showMap(TheMap);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap.map[TheGuard.y+1][TheGuard.x] == 'H')  //detetar se o heroi está abaixo do guarda
		{
			UserInterface.showMap(TheMap);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap.map[TheGuard.y][TheGuard.x-1] == 'H')  //detetar se o heroi está à esquerda do guarda
		{
			UserInterface.showMap(TheMap);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap.map[TheGuard.y][TheGuard.x+1] == 'H')  //detetar se o heroi está à direita do guarda
		{
			UserInterface.showMap(TheMap);
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
			UserInterface.showMap2(TheMap2);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap2.map2[TheOgre.y+1][TheOgre.x] == 'H' || TheMap2.map2[TheOgre.y+1][TheOgre.x] == 'K')  //detetar se o heroi está abaixo do ogre
		{
			UserInterface.showMap2(TheMap2);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap2.map2[TheOgre.y][TheOgre.x-1] == 'H' || TheMap2.map2[TheOgre.y][TheOgre.x-1] == 'K')  //detetar se o heroi está à esquerda do ogre
		{
			UserInterface.showMap2(TheMap2);
			System.out.println("You Lost!\n");
			return true;
		}
		else if (TheMap2.map2[TheOgre.y][TheOgre.x+1] == 'H' || TheMap2.map2[TheOgre.y][TheOgre.x+1] == 'K')  //detetar se o heroi está à direita do ogre
		{
			UserInterface.showMap2(TheMap2);
			System.out.println("You Lost!\n");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void GameLogic_Level1(Map TheMap, Hero TheHero, Guard TheGuard, boolean gameover, int guard_counter, boolean first_level_win)
	{
		
		
	}

	
	public void GameLogic_Level2()
	{
		
	}
}
