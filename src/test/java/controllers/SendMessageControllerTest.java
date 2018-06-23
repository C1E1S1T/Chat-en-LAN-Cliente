package controllers;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

import models.Data;

public class SendMessageControllerTest
{
	private MockSocket socket;
	private SendController writer;

	@ Before
	public void setUp() throws Exception
	{
		socket = new MockSocket();
		writer = new SendController(socket);
	}

	@ Test
	public void testSend_caseValidTextAndValidDestiny()
	               throws IOException, ClassNotFoundException
	{
		Data expected = new Data("Hola", "localhost");
		writer.send(expected);
		Object actual = deserialize(socket.getStream().toByteArray());
		assertTrue(expected.equals(actual));
	}

	@ Test
	public void testSend_caseNotValidTextAndValidDestiny()
	               throws IOException, ClassNotFoundException
	{
		Data expected = new Data("", "localhost");
		writer.send(expected);
		Object actual = deserialize(socket.getStream().toByteArray());
		assertTrue(expected.equals(actual));
	}

	@ Test (expected = UnknownHostException.class)
	public void testSend_caseValidTextAndNotValidDestiny() throws UnknownHostException
	{
		Data expected = new Data("Hola", "otro");
		writer.send(expected);
	}

	private Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException
	{
		ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
		ObjectInputStream objecteStream = new ObjectInputStream(stream);
		return objecteStream.readObject();
	}

}
