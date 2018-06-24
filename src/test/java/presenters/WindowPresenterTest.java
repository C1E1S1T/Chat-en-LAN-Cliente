package presenters;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

import models.Data;
import views.ContentPane;

public class WindowPresenterTest
{
	ContentPanePresenter presenter;
	ContentPane contentPane;
	
	@ Before
	public void setUp() throws Exception
	{
		contentPane = new ContentPane();
		presenter = new ContentPanePresenter(contentPane);
	}

	@ Test
	public void testMessage_expectedData() throws UnknownHostException
	{
		String message = "Hola";
		String hostName = "localhost";
		contentPane.getMessage().setText(message);
		contentPane.getHostName().setText(hostName);
		presenter.send();
		Data actual = presenter.getData();
		Data expected = new Data(message, hostName);
		assertTrue(expected.equals(actual));
	}

	@ Test
	public void testMessage_expectedDrawChat() throws UnknownHostException
	{
		String message = "Hola";
		String hostName = "THINK-CEST";
		contentPane.getMessage().setText(message);
		contentPane.getHostName().setText(hostName);
		presenter.send();
		String actual = contentPane.getChat().getText();
		String expected = hostName + " : " + message + "\n";
		assertEquals(expected,actual);
	}
	
}
