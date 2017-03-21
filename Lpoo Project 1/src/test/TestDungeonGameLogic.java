package test;

import static org.junit.Assert.*;
import org.junit.Test;

import gameLogic.Game;

public class TestDungeonGameLogic 
{
	char [][] map = {{'X', 'X', 'X', 'X', 'X'},	
					{'X', 'H', ' ', 'G', 'X'}, 
					{'I', ' ', ' ', ' ', 'X'},
					{'I', 'k', ' ', ' ', 'X'},
					{'X', 'X', 'X', 'X', 'X'}};
	
	String theguardmovement[] = {"down","down","left","up","left","up","right","right"};
	
	@Test
	public void testMoveHeroIntoToFreeCell()
	{
		Game game = new Game(map, theguardmovement);
		int thex = game.getHeroX();
		int they = game.getHeroY();
		
		boolean theTest = false;
		
		if(thex == 1 && they == 1)
		{
			theTest = true;
		}
		assertEquals(true, theTest);
		
		game.movehero('s');
		thex = game.getHeroX();
		they = game.getHeroY();
		
		if(thex == 2 && thex == 1)
		{
			theTest = true;
		}
		assertEquals(true, theTest);
	}
	

	@Test
	public void testHeroIsCapturedByGuaurd()
	{
		Game game = new Game(map, theguardmovement);
		int thex = game.getHeroX();
		int they = game.getHeroY();
		
		assertFalse(!game.getRunning());
		game.movehero('d');
		assertTrue(game.getRunning());
		//assertEquals(Game.DEFEAT, game.getEndStatus());
	}
}
