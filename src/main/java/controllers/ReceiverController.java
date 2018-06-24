package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import models.Data;
import utils.Log;

public class ReceiverController implements Runnable
{
	private static final int PORT_TO_LISTEN = 9999;
	private Data data;
	private List<Observer> observers;
	private boolean isOpenConnection;

	public ReceiverController()
	{
		observers = new ArrayList<>();
		isOpenConnection = true;
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
			Log.handle(e1, this);
		}
		while (isOpenConnection)
		{
			try
			{
				Socket socketReceived = serverSocket.accept();
				ObjectInputStream stream =  new ObjectInputStream(socketReceived.getInputStream());
				data = (Data) stream.readObject();
				this.notifyObservers(data);
			}
			catch (IOException|ClassNotFoundException e)
			{
				Log.handle(e, this);
			}
		}
		try
		{
			serverSocket.close();
		}
		catch (IOException e)
		{
			Log.handle(e, this);
		}
		this.notifyAll();
	}

	public void closeConnection()
	{
		isOpenConnection = false;
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
