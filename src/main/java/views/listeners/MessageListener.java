package views.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class MessageListener implements KeyListener
{

	@ Override
	public void keyPressed(KeyEvent arg0)
	{
		
	}

	@ Override
	public void keyReleased(KeyEvent event)
	{
		if(event.getKeyCode()==KeyEvent.VK_ENTER)
		{
         JOptionPane.showMessageDialog(null, "Has pulsado Enter");
     }
	}

	@ Override
	public void keyTyped(KeyEvent arg0)
	{
	}

}
