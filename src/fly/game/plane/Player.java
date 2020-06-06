package fly.game.plane;

public class Player extends Plane
{
	
	
	public Player()
	{
		this(0,0,0,0);
	}

	public Player(int w,int h)
	{
		this(0,0,w,h);
	}
	
	public Player(int x,int y,int w,int h)
	{
		super(x,y,w,h);
		this.type = Plane.Type.TYPE_PLAYER;
	}

}























