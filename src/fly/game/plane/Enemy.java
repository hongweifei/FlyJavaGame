package fly.game.plane;

public class Enemy extends Plane
{
	
	
	public Enemy()
	{
		this(0,0,0,0);
	}

	public Enemy(int w,int h)
	{
		this(0,0,w,h);
	}
	
	public Enemy(int x,int y,int w,int h)
	{
		super(x,y,w,h);
		this.type = Plane.Type.TYPE_ENEMY;
	}
	
}





























