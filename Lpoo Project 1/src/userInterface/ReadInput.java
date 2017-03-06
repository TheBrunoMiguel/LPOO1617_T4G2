package userInterface;
import java.util.Scanner;


public class ReadInput {

	public ReadInput() {
		
	}

	
	public static char read()
	{
		Scanner sc = new Scanner(System.in);
		
		return sc.next().charAt(0);
	
	}
}
