package controllers;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import models.Data;

public class SendMessageControllerTest
{
	
	@ Rule
	public ExpectedException exception = ExpectedException.none();

	private MockSocket server;
	private SendController writer;

	@ Before
	public void setUp() throws Exception
	{
		server = new MockSocket();
		writer = new SendController(server);
	}

	@ Test
	public void testSend_caseValidTextAndValidDestiny()
	               throws IOException, ClassNotFoundException
	{
		Data expected = new Data("Hola", "localhost");
		writer.send(expected);
		Object actual = deserialize(server.getStream().toByteArray());
		assertTrue(expected.equals(actual));
	}

	@ Test
	public void testSend_caseNotValidTextAndValidDestiny()
	               throws IOException, ClassNotFoundException
	{
		Data expected = new Data("", "localhost");
		writer.send(expected);
		Object actual = deserialize(server.getStream().toByteArray());
		assertTrue(expected.equals(actual));
	}

	@ Test
	public void testSend_caseValidTextAndNotValidDestiny() throws UnknownHostException
	{
		exception.expect(UnknownHostException.class);
		new Data("Hola", "otro");
	}

	private Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException
	{
		ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
		ObjectInputStream objecteStream = new ObjectInputStream(stream);
		return objecteStream.readObject();
	}

}
