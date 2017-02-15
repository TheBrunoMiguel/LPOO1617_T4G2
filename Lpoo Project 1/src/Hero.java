
public class Hero extends Character
{
	public class Character
	{
		
		public int x = 1;
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
