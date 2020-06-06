package fly.main;

import java.io.IOException;

import fly.game.plane.PlaneGame;
import fly.window.Window;

public class Main
{
	public static Window window;
	public static PlaneGame game;

	public static void main(String[] args) throws IOException
	{
		window = new Window("PlaneFight",600,800);
		window.SetVisible(true);
		
		game = new PlaneGame(window);
		game.GameInit();
		game.Start();
		
	}

}













