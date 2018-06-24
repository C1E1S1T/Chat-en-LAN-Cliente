package views.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import presenters.ContentPanePresenter;

public class MessageListener implements KeyListener
{

	private ContentPanePresenter present;

	public MessageListener(ContentPanePresenter presenter)
	{
		this.present=presenter;
	}
	
	@ Override
	public void keyPressed(KeyEvent arg0)
	{
		
	}

	@ Override
	public void keyReleased(KeyEvent event)
	{
		if(event.getKeyCode()==KeyEvent.VK_ENTER)
		{
         present.send();
     }
	}

	@ Override
	public void keyTyped(KeyEvent arg0)
	{
	}

}
