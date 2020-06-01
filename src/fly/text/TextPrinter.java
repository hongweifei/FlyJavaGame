package fly.text;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TextPrinter
{
	@SuppressWarnings({ "deprecation", "resource" })
	public static void PrintTXT(String path) throws IOException
	{
		DataInputStream reader = new DataInputStream(new FileInputStream (path));
		
		String text = reader.readLine();
		while(text != null)
		{
			System.out.println(text);
			text = reader.readLine();
		}
	}

	public static void PrintANS(String path) throws IOException
	{
		TextPrinter.PrintTXT(path);
	}
	
	public static void PrintText(ArrayList<String> text)
	{
		for(int i = 0;i < text.size();i++)
			System.out.println(text.get(i));
	}
}











