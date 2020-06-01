package fly.text;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TextReader
{
	@SuppressWarnings({ "deprecation", "resource" })
	public static ArrayList<String> ReadTXT(String path) throws IOException
	{
		DataInputStream reader = new DataInputStream(new FileInputStream (path));
		
		ArrayList<String> text = new ArrayList<String>();
		for(String str = reader.readLine();str != null;str = reader.readLine())
		{
			text.add(str);
		}
		
		return text;
	}
}








