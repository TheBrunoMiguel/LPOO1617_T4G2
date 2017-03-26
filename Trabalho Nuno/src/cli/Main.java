package cli;

import logic.Game;

public class Main {
	
	
	public static void main(String[] args) 
	{
		
		Game game=new Game(); //chamar construtor de game
		game.printmap(); //primeiro print, 
		while(game.isRunning()){
			char c;
			c=getinput();
			game.update(c);
			}
		game.printEndGameMessage();
		

	}
	
	public static char getinput() {
		char c = ReadInput.read();
		return c;
	}



}


//maps.get(currentmap).printMap(hero);
//while (running) {
//	update();
//}
//printEndGameMessage();