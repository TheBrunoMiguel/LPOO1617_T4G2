public class Character
{
	public int x;
	public int y;

	public void MoveW() 
	{
		y = y - 1;
	}

	public void MoveA() 
	{
		x = x - 1;
	}

	public void MoveS() 
	{
		y = y + 1;
	}

	public void MoveD() 
	{
		x = x + 1;
	}
}
