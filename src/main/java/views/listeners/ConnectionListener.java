package views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import presenters.ConnectionPresenter;

public class ConnectionListener implements ActionListener
{

	ConnectionPresenter presenter;

	public ConnectionListener(ConnectionPresenter presenter)
	{
		this.presenter = presenter;
	}

	@ Override
	public void actionPerformed(ActionEvent e)
	{
		presenter.connect();
	}

}
