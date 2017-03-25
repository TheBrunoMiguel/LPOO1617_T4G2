package userInterface;
import gameLogic.Game;


public class Main {
	
	
	public static void main(String[] args) 
	{
		
		Game game=new Game(); //chamar construtor de game
		//game.printMap();->pode estar dentro do game	//1a iteraçao, imprimir game
//		game.play();		//chamar game para iniciar
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
