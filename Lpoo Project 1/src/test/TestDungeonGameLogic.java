package test;

import gameLogic.Club;
import gameLogic.Hero;
import gameLogic.DynamicObject;
import gameLogic.Guard_Drunken;
import gameLogic.Guard_Rookie;
import gameLogic.Guard_Suspicious;
import gameLogic.Map;
import gameLogic.Ogre;

import static org.junit.Assert.*;

import java.awt.image.SampleModel;

import org.junit.Test;

import gameLogic.Door;
import gameLogic.Game;

public class TestDungeonGameLogic 
{
	char [][] map = {{'X', 'X', 'X', 'X', 'X'},	
					{'X', 'H', ' ', 'G', 'X'}, 
					{'I', ' ', ' ', ' ', 'X'},
					{'I', 'k', ' ', ' ', 'X'},
					{'X', 'X', 'X', 'X', 'X'}};
	
	String theguardmovement[] = {"down","down","left","up","left","up","right","right"};
	
	
	char [][] map2 = {{'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
			{'X', ' ', ' ', ' ', ' ' ,' ', 'X'}, 
			{'X', ' ', ' ', 'H', ' ', ' ', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', 'G', 'X'}};
	
	String theguardmovement2[] = {"up", "left", "down", "right"};
	
	char [][] map3 = {{'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
			{'X', ' ', ' ', ' ', ' ' ,' ', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
			{'X', ' ', ' ', 'G', ' ', ' ', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'}};
	
	String theguardmovement3[] = {"up", "left", "down", "right", "up", "left", "down", "right"};
	
	
	char [][] map4 = {{'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
			{'X', ' ', ' ', ' ', ' ' ,' ', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
			{'X', 'O', ' ', 'O', ' ', ' ', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
			{'X', 'H', ' ', 'O', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
	
	String theOgreMovement[]={"down","down","down","down"};
	
	char [][] map5 = {{'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
			{'I', ' ', ' ', ' ', ' ' ,'k', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
			{'X', ' ', ' ', 'H', ' ', ' ', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'}, 
			{'X', ' ', ' ', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
	
	String theOgreMovement2[]={"up","right","left","down"};
	
	
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
	
	
	@Test public void testHeroMovesRightAndLeft()
	{
		Game game = new Game(map, theguardmovement);
		
		boolean theTest = false;
		
		int thex = game.getHeroX();
		int they = game.getHeroY();
		
		game.trymoveRight(thex, they);
		
		int theNextX = game.getHeroX();
		int theNextY = game.getHeroY();
		
		if((thex + 1 == theNextX) && (they == theNextY))
		{
			theTest = true;
		}
		
		assertTrue(theTest);
		
		thex = game.getHeroX();
		they = game.getHeroY();
		
		game.trymoveLeft(thex, they);
		
		theNextX = game.getHeroX();
		theNextY = game.getHeroY();
		
		if((thex -1 == theNextX) && (they == theNextY))
		{
			theTest = true;
		}
		
		assertTrue(theTest);
	}
	
	
	@Test public void testHeroMovesDownAndUp()
	{
		Game game = new Game(map, theguardmovement);
		
		boolean theTest = false;
		
		int thex = game.getHeroX();
		int they = game.getHeroY();
		
		game.trymoveDown(thex, they);
		
		int theNextX = game.getHeroX();
		int theNextY = game.getHeroY();
		
		if((thex == theNextX) && (they  + 1 == theNextY))
		{
			theTest = true;
		}
		
		assertTrue(theTest);
		
		thex = game.getHeroX();
		they = game.getHeroY();
		
		game.trymoveLeft(thex, they);
		
		theNextX = game.getHeroX();
		theNextY = game.getHeroY();
		
		if((thex == theNextX) && (they - 1 == theNextY))
		{
			theTest = true;
		}
		
		assertTrue(theTest);
	}
	
	
	@Test
	public void testHeroWin()
	{
		Hero theHero = new Hero(1, 1);
		
		assertFalse(theHero.hasWon());
		
		theHero.win();
		
		assertTrue(theHero.hasWon());
	}
	
	@Test
	public void testDoorOpenAndClose()
	{
		Door theDoor = new Door(1, 1);
		
		assertFalse(theDoor.isOpen());
		
		theDoor.openDoor();
		
		assertTrue(theDoor.isOpen());
	}
	
	
	@Test
	public void testDynamicObject()
	{
		DynamicObject theDynamicObject = new DynamicObject(1, 1, 'H');
		
		assertTrue(theDynamicObject.isAlive());
		
		theDynamicObject.getHit();
		
		assertFalse(theDynamicObject.isAlive());
	}
	
	
	@Test
	public void testHeroMovement()
	{
		Game theGame = new Game(map2, theguardmovement2);
		
		Hero theHero = new Hero(3, 3);
		
		assertEquals(3, theHero.getx());
		assertEquals(3, theHero.gety());
		assertEquals('H', theHero.getc());
		
		theHero.moveDown();
		
		assertEquals(3, theHero.getx());
		assertEquals(4, theHero.gety());
		
		theHero.moveUp();
		
		assertEquals(3, theHero.getx());
		assertEquals(3, theHero.gety());
		
		theHero.moveUp();
		
		assertEquals(3, theHero.getx());
		assertEquals(2, theHero.gety());
		
		theHero.moveDown();
		
		theHero.moveRight();
		
		assertEquals(4, theHero.getx());
		assertEquals(3, theHero.gety());
		
		theHero.moveLeft();
		
		assertEquals(3, theHero.getx());
		assertEquals(3, theHero.gety());
		
		theHero.moveLeft();
		
		assertEquals(2, theHero.getx());
		assertEquals(3, theHero.gety());
	}
	
	
	@Test
	public void testGuardRookie()
	{
		Guard_Rookie theRookie = new Guard_Rookie(5, 5, theguardmovement2);
		
		int theCurrentMovement = 0;
		
		assertEquals("up", theRookie.getCurrentMovement());
		assertNotEquals("left", theRookie.getCurrentMovement());
		assertNotEquals("down", theRookie.getCurrentMovement());
		assertNotEquals("right", theRookie.getCurrentMovement());
		
		theRookie.makeMove();
		
		
		assertNotEquals(theCurrentMovement, theRookie.getCurrentMovement2());
		
		assertEquals("left", theRookie.getCurrentMovement());
		assertNotEquals("up", theRookie.getCurrentMovement());
		assertNotEquals("down", theRookie.getCurrentMovement());
		assertNotEquals("right", theRookie.getCurrentMovement());
		
		theRookie.makeMove();
		
		assertEquals("down", theRookie.getCurrentMovement());
		assertNotEquals("up", theRookie.getCurrentMovement());
		assertNotEquals("left", theRookie.getCurrentMovement());
		assertNotEquals("right", theRookie.getCurrentMovement());
		
		theRookie.makeMove();
		
		assertEquals("right", theRookie.getCurrentMovement());
		assertNotEquals("up", theRookie.getCurrentMovement());
		assertNotEquals("down", theRookie.getCurrentMovement());
		assertNotEquals("left", theRookie.getCurrentMovement());
		
		theRookie.makeMove();
		
		assertEquals("up", theRookie.getCurrentMovement());
		assertNotEquals("left", theRookie.getCurrentMovement());
		assertNotEquals("down", theRookie.getCurrentMovement());
		assertNotEquals("right", theRookie.getCurrentMovement());
		
		assertEquals(theCurrentMovement, theRookie.getCurrentMovement2());
		
		theRookie.update();
		
		assertEquals(theCurrentMovement +1, theRookie.getCurrentMovement2());
	}
	
	
	@Test
	public void testGuardSuspicious()
	{
		Guard_Suspicious theSuspicious = new Guard_Suspicious(4, 3, theguardmovement3);
		
		int theCurrentMovement = 0;
		
		assertEquals("up", theSuspicious.getCurrentMovement());
		assertNotEquals("left", theSuspicious.getCurrentMovement());
		assertNotEquals("down", theSuspicious.getCurrentMovement());
		assertNotEquals("right", theSuspicious.getCurrentMovement());
		
		theSuspicious.makeMove();
		
		
		assertNotEquals(theCurrentMovement, theSuspicious.getCurrentMovement2());
		
		assertEquals("left", theSuspicious.getCurrentMovement());
		assertNotEquals("up", theSuspicious.getCurrentMovement());
		assertNotEquals("down", theSuspicious.getCurrentMovement());
		assertNotEquals("right", theSuspicious.getCurrentMovement());
		
		theSuspicious.makeMove();
		
		assertEquals("down", theSuspicious.getCurrentMovement());
		assertNotEquals("up", theSuspicious.getCurrentMovement());
		assertNotEquals("left", theSuspicious.getCurrentMovement());
		assertNotEquals("right", theSuspicious.getCurrentMovement());
		
		theSuspicious.makeMove();
		
		assertEquals("right", theSuspicious.getCurrentMovement());
		assertNotEquals("up", theSuspicious.getCurrentMovement());
		assertNotEquals("left", theSuspicious.getCurrentMovement());
		assertNotEquals("down", theSuspicious.getCurrentMovement());
		
		theCurrentMovement = theSuspicious.getCurrentMovement2();
		int theCurrentDirection = theSuspicious.getDirection();
		
		theSuspicious.tryToChangeDirection();
		
		if(theCurrentMovement > theSuspicious.getCurrentMovement2())
		{
			assertEquals(theCurrentDirection, theSuspicious.getDirection());
		}
		else if(theCurrentMovement < theSuspicious.getCurrentMovement2())
		{
			assertNotEquals(theCurrentDirection, theSuspicious.getDirection());
			
		}
		
		theCurrentMovement = theSuspicious.getCurrentMovement2();
		
		if(theSuspicious.getDirection() == -1)
		{
			theSuspicious.update();
			assertEquals(theCurrentMovement -1, theSuspicious.getCurrentMovement2());
		}
		else
		{
			theSuspicious.update();
			assertEquals(theCurrentMovement + 1, theSuspicious.getCurrentMovement2());
		}
	}
	
	
	@Test
	public void testDoesOgreDeafeatHero()
	{
		Hero theHero = new Hero(2, 5);
		Ogre theOgre = new Ogre(5, 5, theOgreMovement, 1);
		
		Game game = new Game(map4, theOgreMovement, 1, theHero);
		
		theHero.moveRight();
		theOgre.update();
		
		game.checkSurround(theHero.getx(), theHero.gety());
		game.checkHeroAlive();
		assertEquals(false, game.getRunning());
	}
	
	
	@Test
	public void testOgre()
	{
		Ogre theOgre = new Ogre(5, 5, theOgreMovement2, 1);
		
		theOgre.ogreStepsLever();
		assertEquals('$', theOgre.getc());
		
		theOgre.ogreDoesntStepLever();
		assertEquals('O', theOgre.getc());
		
		
		int DownCounter = 0;
		int UpCounter = 0;
		int RightCounter = 0;
		int LeftCounter = 0;
		for(int i = 0; i < 1000; i++)
		{
			String theCurrentMovement = theOgre.getCurrentMovement();
			if(theCurrentMovement == "left")
				LeftCounter++;
			else if(theCurrentMovement == "right")
				RightCounter++;
			else if(theCurrentMovement == "up")
				UpCounter++;
			else if(theCurrentMovement == "down")
				DownCounter++;
		}
		
		boolean isDown = false;
		boolean isUp = false;
		boolean isRight = false;
		boolean isLeft = false;
		
		if(DownCounter < 300 && DownCounter > 200)
		{
			isDown = true;
		}
		if(UpCounter < 300 && UpCounter > 200)
		{
			isUp = true;
		}
		if(RightCounter < 300 && RightCounter > 200)
		{
			isRight = true;
		}
		if(LeftCounter < 300 && LeftCounter > 200)
		{
			isLeft = true;
		}
		
		
		assertTrue(isDown);
		assertTrue(isUp);
		assertTrue(isRight);
		assertTrue(isLeft);
	}
	
	
	@Test
	public void testClub()
	{
		Ogre theOgre = new Ogre(5, 5, theOgreMovement2, 1);
		
		Club theClub = new Club(5, 5, theOgreMovement2, 1);
		
		theClub.clubStepsLever();
		assertEquals('$', theClub.getc());
		
		theClub.clubDoesntStepLever();
		assertEquals('*', theClub.getc());
	}
}
