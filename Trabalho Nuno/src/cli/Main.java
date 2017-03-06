package cli;

import logic.Game;

public class Main {
	
	
	public static void main(String[] args) 
	{
		
		Game game=new Game(); //chamar construtor de game
		//game.printMap();->pode estar dentro do game	//1a iteraçao, imprimir game
		game.play();		//chamar game para iniciar

	}

}
