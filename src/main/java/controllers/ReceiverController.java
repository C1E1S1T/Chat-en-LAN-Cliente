package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import models.Data;

public class ReceiverController extends Controller implements Runnable
{
	private static final int PORT_TO_LISTEN = 9999;
	private Data data;
	private List<Observer> observers;

	public ReceiverController()
	{
		observers = new ArrayList<>();
	}

	@ Override
	public void run()
	{
		ServerSocket serverSocket = null;
		try
		{
			serverSocket = new ServerSocket(PORT_TO_LISTEN);
		}
		catch (IOException e1)
		{
			handle(e1);
		}
		while (true)
		{
			try
			{
				Socket socketReceived = serverSocket.accept();
				ObjectInputStream stream = (ObjectInputStream) socketReceived
				               .getInputStream();
				data = (Data) stream.readObject();
				serverSocket.close();
				this.notifyObservers(data);
			}
			catch (IOException|ClassNotFoundException e)
			{
				handle(e);
			}
		}
	}

	public void subscribe(Observer observer)
	{
		observers.add(observer);
	}

	public void delete(Observer observer)
	{
		observers.remove(observer);
	}

	private void notifyObservers(Data data)
	{
		for (Observer observer : this.observers)
		{
			observer.update(null, data);
		}
	}

}
