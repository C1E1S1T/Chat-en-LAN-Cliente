package presenters;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import utils.Log;
import views.Connection;
import views.listeners.ConnectionListener;

public class ConnectionPresenter
{

	private Connection connection;

	public ConnectionPresenter(Connection connection)
	{
		this.connection = connection;
	}

	public void present()
	{
		connection.getBtnConnect().addActionListener(new ConnectionListener(this));
	}

	public void connect()
	{
		String hostName = connection.getHostName();
		if (!hostName.equals(""))
		{
			try
			{

				InetAddress destiny = InetAddress.getByName(hostName);
				JOptionPane.showMessageDialog(connection, "Encontrado "+destiny.getHostName(),"Conectado",
				               JOptionPane.INFORMATION_MESSAGE);
			}
			catch (UnknownHostException e)
			{
				Log.handle(e, this);
			}
		}
	}

}
