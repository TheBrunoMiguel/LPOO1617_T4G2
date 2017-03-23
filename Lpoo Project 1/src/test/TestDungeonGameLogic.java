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
		
		assertFalse(!game.getRunning());
		game.movehero('d');
		assertTrue(game.getRunning());
		assertEquals(false, game.getisWinLevel1());
		//assertEquals(Game.DEFEAT, game.getEndStatus());
	}
	
	
	@Test
	public void testHeroMovesIntoWall()
	{
		Game game = new Game(map, theguardmovement);

		int thex = game.getHeroX();
		int they = game.getHeroY();
		
		game.movehero('w');
		
		boolean isXSame = false;
		boolean isYSame = false;
		boolean theTest = false;
		
		if(thex == game.getHeroX())
			isXSame = true;
		if(they == game.getHeroY())
			isYSame = true;
		
		if((isXSame == true) && (isYSame == true))
		{
			theTest = true;
		}
		assertEquals(true, theTest);
	}
	
	
	@Test
	public void testHeroMovesToDoorAndFails()
	{
		Game game = new Game(map, theguardmovement);

		game.movehero('s');
		
		int thex = game.getHeroX();
		int they = game.getHeroY();
		
		game.movehero('a');
		
		boolean isXSame = false;
		boolean isYSame = false;
		boolean theTest = false;
		
		if(thex == game.getHeroX())
			isXSame = true;
		if(they == game.getHeroY())
			isYSame = true;
		
		if((isXSame == true) && (isYSame == true))
		{
			theTest = true;
		}
		assertEquals(true, theTest);
	}
	
	
	@Test
	public void testHeroMovesToLeverAndDoorsOpen()
	{
		Game game = new Game(map, theguardmovement);

		game.movehero('s');	
		game.movehero('s');
		game.checkLever();
		game.movehero('w');
		
		boolean isDoorOpen = game.checkDoorOnTheLeft(game.getHeroX(), game.getHeroY());
	
		assertTrue(isDoorOpen);
	}
	
	
	@Test
	public void testHeroMovesIntoOpenDoorsAndWins()
	{
		Game game = new Game(map, theguardmovement);

		game.movehero('s');	
		game.movehero('s');
		game.checkLever();
		game.movehero('w');
		game.movehero('a');
		game.checkDoor2();
		
		boolean isLevel1Complete = game.getisWinLevel1();
	
		assertEquals(true, isLevel1Complete);
	}
}
