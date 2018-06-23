package controllers;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class MockSocket extends Socket
{

	ByteArrayOutputStream stream;
	PrintStream outputStream;

	public MockSocket()
	{
		stream = new ByteArrayOutputStream();
		outputStream = new PrintStream(stream);
	}

	@ Override
	public OutputStream getOutputStream()
	{
		return outputStream;
	}

	public ByteArrayOutputStream getStream()
	{
		return stream;
	}

}
