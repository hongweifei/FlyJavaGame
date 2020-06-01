package fly.main;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import fly.shared.os.OSInformation;
import fly.window.Window;

public class Main
{
	Window window;

	public static void main(String[] args) throws IOException
	{
		System.out.println("Hello");

		System.out.println("\033[92;1mabc中文\033[0m");
		System.out.println("\033[92;4mabc中文\033[0m");
		System.out.println("\033[92;7mabc中文\033[0m");
		
		DataInputStream reader = new DataInputStream(new FileInputStream ("E:/man.txt"));
		
		
		//TextPrinter.PrintTXT("E:/man.txt");
		
		
		System.out.println("\n\n\n\n\n");
		
		
		for(int ch = reader.read();ch != -1;ch = reader.read())
		{
			
			if(ch == '°')
				System.out.print("\033[47m" + (char)ch + "\033[0m");
			else if(ch == 'ß')
				System.out.print("\033[46m" + (char)ch + "\033[0m");
			else if(ch == '²')
				System.out.print("\033[45m" + (char)ch + "\033[0m");
			else if(ch == 'Ý')
				System.out.print("\033[44m" + (char)ch + "\033[0m");
			else if(ch == '±')
				System.out.print("\033[43m" + (char)ch + "\033[0m");
			else if(ch == 'Ü')
				System.out.print("\033[42m" + (char)ch + "\033[0m");
			else if(ch == 'Û')
				System.out.print("\033[41m" + (char)ch + "\033[0m");
			else if(ch == 'Þ' || ch == ' ')
				System.out.print("\033[40m" + (char)ch + "\033[0m");
			else
				System.out.print((char)ch);
		}
		
		
		
		
		reader.close();
		System.out.println("\n\n\n\n\n");
		
		System.out.println(OSInformation.GetOSName());
		
	}

}













