package userInterface;
import java.util.Scanner;
import gameLogic.*;


public class UserInterface 
{
	
	public void showMap(Map TheMap)
	{
		for(int i = 0; i < 10; i++)
		{
			String Each_Line = " ";
			for(int j = 0; j < 10; j++)
			{
				if(TheMap.map[j][i] == '0')
				{
					Each_Line = Each_Line + "  ";
				}
				else
				{
					Each_Line = Each_Line + TheMap.map[j][i] + " ";
				}
			}
			Each_Line = Each_Line + "\n";
			System.out.println(Each_Line);
		}
	}
	
	public void showMap2(Map2 TheMap2)
	{
		for(int i = 0; i < 10; i++)
		{
			String Each_Line = " ";
			for(int j = 0; j < 10; j++)
			{
				if(TheMap2.map2[j][i] == '0')
				{
					Each_Line = Each_Line + "  ";
				}
				else
				{
					Each_Line = Each_Line + TheMap2.map2[j][i] + " ";
				}
			}
			Each_Line = Each_Line + "\n";
			System.out.println(Each_Line);
		}
	}
	
	public String Input()
	{
		System.out.println("\n\n What's your move (A for left, S for down, W for up, D for right, and N for not moving) : ");
		Scanner reader1 = new Scanner(System.in);
		String TheString = reader1.next();
		reader1.close();
		return TheString;
	}
}
