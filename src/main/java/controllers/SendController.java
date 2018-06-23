package controllers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SendController
{

	private OutputStream stream;

	public SendController(Socket server)
	{
		try
		{
			this.stream = server.getOutputStream();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void send(Object data)
	{
		if (data!=null)
		{
			ObjectOutputStream objectStream = null;
			try
			{
				objectStream = new ObjectOutputStream(stream);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			try
			{
				objectStream.writeObject(data);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			try
			{
				objectStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
