package controllers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SendController extends Controller
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
			this.handle(exception);
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
				this.handle(e);
			}
		}
	}

}
