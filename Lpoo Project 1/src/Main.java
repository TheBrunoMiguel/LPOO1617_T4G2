import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Dungeon!\n\n");
		Map map1 = new Map();
		Hero hero1 = new Hero();
		Guard guard1 = new Guard();
		boolean GameOver = false;
		
		while (GameOver = false)
		{
			map1.showMap();
			System.out.println("\n\n What's your move (A for left, S for down, W for up, D for right, and N for not moving) : ");
			Scanner reader = new Scanner(System.in);
			char TheMove = reader.next(".").charAt(0);
		
			switch(TheMove)
			{
			case 'W': 
			{
				
				if (map1[hero1.y-1][hero.x] == 'G')
				{
					//nao sei bem como testar isto, devido ao update constante do guarda
				}
				
				else if(map1[hero1.y-1][hero1.x] != 'X')
				{
					hero1.MoveW();
				}
			}
			break;
			case 'A':
			{
				if(map1[hero1.y][hero1.x-1] == 'k')
				{
					map1[5][0] = 'S';
					map1[6][0] = 'S';
					map1[8][7] = 'K';
					hero1.MoveA();
				}
				else if (map1[hero1.y][hero.x-1] == 'S')
				{
					GameOver = true;
					System.out.println("You Won!\n");
				}
				else if (map1[hero1.y][hero.x-1] == 'G')
				{
					//nao sei bem como testar isto, devido ao update constante do guarda
				}
				else if (map1[hero1.y][hero1.x-1] != 'X')
				{
					hero1.MoveA();
				}
			}
			break;
			case 'S':
			{
				
				if (map1[hero1.y+1][hero.x] == 'G')
				{
					//nao sei bem como testar isto, devido ao update constante do guarda
				}
				
				else if(map1[hero1.y+1][hero1.x] != 'X')
				{
					hero1.MoveS();
				}
			}
			break;
			case 'D': 
			{
				if (map1[hero1.y][hero.x+1] == 'G')
				{
					//nao sei bem como testar isto, devido ao update constante do guarda
				}
				
				else if(map1[hero1.y][hero1.x+1] != 'X')
				{
					hero1.MoveD();
				}
			}
			break;
			default: 
				break;
			}
		
		}
		if(GameOver == true)
		{
			System.out.println("Game Over!");
		}
	}
}
