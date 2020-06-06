package fly.game.plane;

public class Bullet
{
	
	public static class Way
	{
		public static final short UP = 0;
		public static final short DOWN = 1;
		public static final short LEFT = 2;
		public static final short RIGHT = 3;
	}
	
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	
	public int dx = 0;
	public int dy = 0;
	
	protected int speed = 5;
	protected short way = Bullet.Way.UP;//< Bullet.Way.*
	
	
	public Bullet()
	{
		this(0,0,0,0);
	}
	
	public Bullet(int w,int h)
	{
		this(0,0,w,h);
	}
	
	public Bullet(int x,int y,int w,int h)
	{
		this(x,y,w,h,5);
	}
	
	public Bullet(int x,int y,int w,int h,int speed)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.speed = speed;
	}
	
	
	public void SetX(int x) {this.x = x;}
	public void SetY(int y) {this.y = y;}
	public int GetX() {return this.x;}
	public int GetY() {return this.y;}
	
	
	public void SetWidth(int w) {this.w = w;}
	public void SetHeight(int h) {this.h = h;}
	public int GetWidth() {return this.w;}
	public int GetHeight() {return this.h;}
	
	
	public boolean GetCollision(int left,int right,int top,int bottom)
	{
		/*java swing 使用*/
		if(this.x <= right && this.x >= left &&
			((this.y >= top && this.y <= bottom) ||
			(this.y + this.h >= top && this.y + this.h <= bottom)))
			return true;
		
		if(this.x + this.w >= left && this.x + this.w <= right &&
			((this.y >= top && this.y <= bottom) ||
			(this.y + this.h >= top && this.y + this.h <= bottom)))
			return true;
		
		
		/*libgdx 使用
		if(this.x <= right && this.x >= left &&
			((this.y <= top && this.y >= bottom) ||
			(this.y + this.h <= top && this.y + this.h >= bottom)))
			return true;
			
		if(this.x + this.w >= left && this.x + this.w <= right &&
			((this.y <= top && this.y >= bottom) ||
			(this.y + this.h <= top && this.y + this.h >= bottom)))
			return true;
		*/
		
		return false;
	}
	public int GetSpeed() {return this.speed;}
	
	/**
	 * 
	 * @param way Bullet.Way.*
	 */
	public void SetWay(short way) {this.way = way;}
	public short GetWay() {return this.way;}
	
	
	public void updata()
	{
		/*java swing
		switch(this.way)
		{
		case Bullet.Way.UP:
			this.y -= this.speed;
			break;
		case Bullet.Way.DOWN:
			this.y += this.speed;
			break;
		case Bullet.Way.LEFT:
			this.x -= this.speed;
			break;
		case Bullet.Way.RIGHT:
			this.x += this.speed;
			break;
		}
		*/
		
		this.x += this.dx;
		this.y += this.dy;
		this.dx = 0;
		this.dy = 0;
	}
}











































