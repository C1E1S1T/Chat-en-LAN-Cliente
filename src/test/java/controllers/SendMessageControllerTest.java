package controllers;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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
	public void testSend_caseValidTextAnd() throws IOException, ClassNotFoundException
	{
		Data expected = new Data("Hola", "localhost");
		writer.send(expected);
		Object actual = deserialize(socket.getStream().toByteArray());
		assertTrue(expected.equals(actual));
	}

	@ Test
	public void testSend_caseNotValidText() throws IOException, ClassNotFoundException
	{
		Data expected = new Data("", "localhost");
		writer.send(expected);
		Object actual = deserialize(socket.getStream().toByteArray());
		assertTrue(expected.equals(actual));
	}
	
	private static Object deserialize(byte[] bytes)
	               throws IOException, ClassNotFoundException
	{
		ByteArrayInputStream b = new ByteArrayInputStream(bytes);
		ObjectInputStream o = new ObjectInputStream(b);
		return o.readObject();
	}

}
