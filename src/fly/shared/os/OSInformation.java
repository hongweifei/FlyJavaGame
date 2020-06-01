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
}










