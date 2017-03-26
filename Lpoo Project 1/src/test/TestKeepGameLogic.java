package test;

import gameLogic.Ogre;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;
import org.junit.Test;

import gameLogic.Game;
import gameLogic.Hero;


public class TestKeepGameLogic 
{
	public class TestDungeonGameLogic 
	{
		char [][] map = {{'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
				{'X', ' ', ' ', ' ', ' ' ,' ', 'X'}, 
				{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
				{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
				{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
				{'X', 'O', 'H', ' ', ' ', ' ', 'X'},
				{'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
		
		String theOgreMovement[]={"up","right","left","down"};
		
		String testOgreMovement[]={"up","up","up","up"};
		
		char [][] map2 = {{'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
				{'I', ' ', ' ', ' ', ' ' ,'k', 'X'}, 
				{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
				{'X', ' ', ' ', 'H', ' ', ' ', 'X'}, 
				{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
				{'X', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
		
		
		
		
		@Test
		public void testDoesOgreDeafeatHero()
		{
			Hero theHero = new Hero(2, 5);
			Ogre theOgre = new Ogre(5, 5, theOgreMovement);
			
			Game game = new Game(map, theOgreMovement, 1, theHero);
			
			theHero.moveUp();
			theOgre.update();
			
			game.checkSurround(theHero.getx(), theHero.gety());
			assertFalse(game.getRunning());
		}
	}
}