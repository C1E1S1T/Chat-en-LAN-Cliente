package controllers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import utils.Log;

public class SendController
{

	private OutputStream stream;

	public SendController(Socket server)
	{
		try
		{
			this.stream = server.getOutputStream();
		}
		catch (IOException exception)
		{
			Log.handle(exception, this);
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
				objectStream.writeObject(data);
				objectStream.close();
			}
			catch (IOException e)
			{
				Log.handle(e, this);
			}
		}
	}

}
