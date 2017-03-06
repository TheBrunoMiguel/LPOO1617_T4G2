package gameLogic;
public class Guard extends Character
{
	public int numberOfPersonalities;  // 1 -> Rookie,  2 -> Drunken,  3 -> Suspicious
	
	public Guard(int theNumberOfPersonalities)
	{
		x = 1;
		y = 8;
		numberOfPersonalities = theNumberOfPersonalities;
	}
}

