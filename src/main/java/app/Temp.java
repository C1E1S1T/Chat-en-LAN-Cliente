package app;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Temp
{
	
	public static void main(String[] args)
	{
		new Temp().start();
	}
	
	public void start()
	{
		try
		{
			InetAddress adress = InetAddress.getByName("DESKTOP-VVGK202");
			System.out.println(adress.getHostAddress());
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
	}

}
