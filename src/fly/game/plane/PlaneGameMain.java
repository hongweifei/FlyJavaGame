package fly.game.plane;

import fly.window.Window;

public class PlaneGameMain
{
	public static Window window;
	public static PlaneGame game;
	
	public static void main(String[] args)
	{
		window = new Window("PlaneFight",600,800);
		window.SetVisible(true);
		
		game = new PlaneGame(window);
		game.GameInit();
		game.Start();
	}

}











