

public class Guard extends Character
{
	public class Character
	{
		
		public int x = 8;
		public int y = 8;
	
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

}

