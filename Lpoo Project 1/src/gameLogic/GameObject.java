package gameLogic;

public class GameObject 
{

	protected int x,y;
	protected char c;
	
	public GameObject(int x,int y, char c) //construtor de GameObject
	{
		this.x=x;
		this.y=y;
		this.c=c;
		
	}
	
	public int getx()   //metodos/funcoes de GameObject para retornar x,y,c
	{
		return x;
	}	
	public int gety()
	{
		return y;
	}	
	public char getc()
	{
		return c;
	}
	
	
	
}