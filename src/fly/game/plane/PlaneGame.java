package fly.game.plane;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import fly.graphics.FlyRenderer2D;
import fly.graphics.RenderEvent;



public class PlaneGame
{
	
	protected fly.graphics.FlyScene game_scene;
	
	public fly.game.plane.Player player = new fly.game.plane.Player(0,0,60,80);
	public ArrayList<fly.game.plane.Bullet> player_bullet = new ArrayList<fly.game.plane.Bullet>();
	public ArrayList<fly.game.plane.Enemy> enemy = new ArrayList<fly.game.plane.Enemy>();
	public ArrayList<fly.game.plane.Bullet> enemy_bullet = new ArrayList<fly.game.plane.Bullet>();
	
	private final short image_player = 0;
	private final short image_enemy = 1;
	private final short image_bullet = 2;
	
	private int point = 0;
	
	
	
	public PlaneGame() {this(null);}

	public PlaneGame(fly.window.Window window)
	{
		this.game_scene = new fly.graphics.FlyScene(window);
	}
	
	public void GameInit()
	{
		
		this.game_scene.SetMouseListener(new fly.window.listener.FlyMouseListener(){

			@Override public void mouseClicked(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e)
			{
				if(e.getButton() == MouseEvent.BUTTON3)
					player_bullet.add(
						new fly.game.plane.Bullet(
								player.GetX() + player.w / 2 - 50 / 2,
								player.GetY() - player.GetHeight(),
								50,
								100,
								20
						)
					);
			}
			
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseDragged(MouseEvent e) {mouseMoved(e);}

			@Override public void mouseMoved(MouseEvent e)
			{
				PlaneGame.this.player.SetX(e.getX() - player.GetWidth() / 2);
				PlaneGame.this.player.SetY(e.getY() - player.GetHeight() / 2);
			}

			@Override public void mouseWheelMoved(MouseWheelEvent e) {}
			
		});
		
	}
	
	
	public void Start()
	{
		this.game_scene.SetRenderEvent(new RenderEvent() {

			@Override public void Init(FlyRenderer2D renderer)
			{
				renderer.AddImage("assets/plane/player.png");
				renderer.AddImage("assets/plane/enemy1.png");
				renderer.AddImage("assets/bullet/bullet1.png");
			}
			
			@Override public void Render(FlyRenderer2D renderer)
			{
				int i = 0;
				
				player.updata();
				
				for(i = 0;i < enemy.size();i++)
				{
					enemy.get(i).dy += enemy.get(i).GetSpeed();
					enemy.get(i).updata();
					renderer.DrawImage(image_enemy,
							enemy.get(i).GetX(),
							enemy.get(i).GetY(),
							enemy.get(i).GetWidth(),
							enemy.get(i).GetHeight());
					
					
					for(int j = 0;j < player_bullet.size();j++)
					{
						boolean collision = 
								player_bullet.get(j).GetCollision(enemy.get(i).GetX(), 
								enemy.get(i).GetX() + enemy.get(i).GetWidth(), 
								enemy.get(i).GetY(), 
								enemy.get(i).GetY() + enemy.get(i).GetHeight());
						
						if(collision)
						{
							enemy.get(i).SetState(Plane.State.DEAD, true);
							player_bullet.remove(j);
							PlaneGame.this.point++;
						}
					}
					
					
					if(enemy.get(i).GetY() > game_scene.getHeight())
						enemy.get(i).SetState(Plane.State.DEAD, true);
					
					
				}
				
				
				/**敌机销毁*/
				for(i = 0;i < enemy.size();i++)
				{
					if(enemy.get(i).GetState(Plane.State.DEAD))
					{
						enemy.remove(i);
					}
				}
				
				
				for(i = 0;i < player_bullet.size();i++)
				{
					player_bullet.get(i).dy -= player_bullet.get(i).GetSpeed();
					player_bullet.get(i).updata();
					renderer.DrawImage(image_bullet,
							player_bullet.get(i).GetX(),
							player_bullet.get(i).GetY(),
							player_bullet.get(i).GetWidth(),
							player_bullet.get(i).GetHeight());
					
					/**子弹销毁*/
					if(player_bullet.get(i) != null && 
						player_bullet.get(i).GetY() + player_bullet.get(i).GetHeight() < 0)
					{
						player_bullet.remove(i);
					}
				}
				
				renderer.DrawImage(image_player,player.GetX(), player.GetY(), player.GetWidth(), player.GetHeight());
				
				renderer.DrawText("Points:" + point, 0, game_scene.getHeight());
				
				
				/**敌机刷新*/
				if(enemy.size() < game_scene.getWidth() / 200)
				{
					int x = (int) (Math.random() * game_scene.getWidth());
					enemy.add(new fly.game.plane.Enemy(x,-100,60,80));
				}
				
				
				try {Thread.sleep(1000/60);}
				catch (InterruptedException e) {e.printStackTrace();}
			}
		},true);
		
		
		
	}
	
	
	public void AddEnemy(fly.game.plane.Enemy e) {this.enemy.add(e);}

	
	
	
	
	
	
}





















