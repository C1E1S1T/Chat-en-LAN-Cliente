package presenters;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;

import controllers.ReceiverController;
import controllers.SendController;
import models.Data;
import utils.Log;
import views.ContentPane;
import views.listeners.MessageListener;

public class ContentPanePresenter implements Observer
{

	private static final int CLIENT_PORT = 9999;
	private ContentPane contentPane;
	private Data data;
	private ReceiverController receiverController;

	public ContentPanePresenter(ContentPane contentPane)
	{
		this.contentPane = contentPane;
		setReceiverController();
	}

	private void setReceiverController()
	{
		receiverController = new ReceiverController();
		receiverController.subscribe(this);
	}

	public void present()
	{
		contentPane.getMessage().addKeyListener(new MessageListener(this));
		new Thread(receiverController).start();
	}

	public void restart()
	{
		receiverController.closeConnection();
		setReceiverController();
	}

	public void send()
	{
		String message = contentPane.getMessage().getText();
		String hostName = destiny();
		contentPane.getMessage().setText("");
		try
		{
			append(message, InetAddress.getLocalHost().getHostName());
		}
		catch (UnknownHostException e)
		{
			Log.handle(e, this);
		}
		try
		{
			data = new Data(message, hostName);
			Socket socket = new Socket(data.getDestiny().getHostAddress(),CLIENT_PORT);
			SendController controller = new SendController(socket);
			controller.send(data);
		}
		catch (IOException e)
		{
			Log.handle(e, this);
		}
	}

	private String destiny()
	{
		return contentPane.getHostName().getText();
	}

	private void append(String message, String hostName)
	{
		contentPane.append(hostName+" : "+message+"\n");
	}

	@ Override
	public void update(Observable arg0, Object arg1)
	{
		Data data = (Data) arg1;
		append(data.getMessage(), destiny());
	}

	public Data getData()
	{
		return data;
	}

}
