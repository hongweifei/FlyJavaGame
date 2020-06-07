package fly.shared.os;


public class OSInformation
{
	public static String GetOSName()
	{
		return System.getProperty("os.name");
	}

	public static boolean IsWindows()
	{
		String os_name = System.getProperty("os.name");
		if(os_name.startsWith(OSName.Windows.toString()))
			return true;
		return false;
	}
	
	public static boolean IsLinux()
	{
		String os_name = System.getProperty("os.name");
		if(os_name.startsWith(OSName.Linux.toString()))
			return true;
		return false;
	}
	
	public static OSName GetOS()
	{
		String name = System.getProperty("os.name");
		if(name.startsWith(OSName.Windows.toString()))
			return OSName.Windows;
		else if(name.startsWith(OSName.Linux.toString()))
			return OSName.Linux;
		else if(name.startsWith(OSName.Mac_OS.toString()))
			return OSName.Mac_OS;
		else if(name.startsWith(OSName.Mac_OS_X.toString()))
			return OSName.Mac_OS_X;
		
		return OSName.Others;
	}
}










