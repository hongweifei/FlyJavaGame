package fly.game.plane;

public class Plane
{
	
	public static class Type
	{
		public static final short TYPE_NONE = 0;
		public static final short TYPE_PLAYER = 1;
		public static final short TYPE_ENEMY = 2;
	}
	
	public static class State
	{
		public static final short MOVE = 0;
		public static final short DEAD = 1;
		public static final short VISIBLE = 2;
	}
	
	protected short type = Plane.Type.TYPE_NONE;
	protected int x,y;
	protected int w,h;
	
	public int dx = 0;
	public int dy = 0;
	
	protected int speed = 5;
	
	protected boolean move = false;//< 移动
	protected boolean dead = false;//< 死亡
	protected boolean visible = true;//< 可视
	
	
	public Plane()
	{
		this(0,0,0,0);
	}
	
	public Plane(int w,int h)
	{
		this(0,0,w,h);
	}
	
	public Plane(int x,int y,int w,int h)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	/**
	 * 
	 * @param state_type Plane.State.*
	 * @param state true or false
	 */
	public void SetState(short state_type,boolean state)
	{
		switch(state_type)
		{
		case Plane.State.MOVE:
			this.move = state;
			break;
		case Plane.State.DEAD:
			this.dead = state;
			break;
		case Plane.State.VISIBLE:
			this.visible = state;
			break;
		}
	}
	
	/**
	 * 
	 * @param state_type Plane.State.*
	 * @return
	 */
	public boolean GetState(short state_type)
	{
		switch(state_type)
		{
		case Plane.State.MOVE:
			return this.move;
		case Plane.State.DEAD:
			return this.dead;
		case Plane.State.VISIBLE:
			return this.visible;
		}
		
		return false;
	}
	
	
	public void SetX(int x) {this.x = x;}
	public void SetY(int y) {this.y = y;}
	public int GetX() {return this.x;}
	public int GetY() {return this.y;}
	
	public void SetWidth(int w) {this.w = w;}
	public void SetHeight(int h) {this.h = h;}
	public int GetWidth() {return this.w;}
	public int GetHeight() {return this.h;}
	
	public void SetSpeed(int speed) {this.speed = speed;}
	public int GetSpeed() {return this.speed;}
	
	
	public void updata()
	{
		if(this.dx != 0 || this.dy != 0)
			this.move = true;
		else
			this.move = false;
		
		
		this.x += this.dx;
		this.y += this.dy;
		this.dx = 0;
		this.dy = 0;
	}
}

























