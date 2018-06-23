package app;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import utils.Log;
import views.Window;

public class UI
{

	public void start(String title)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					Window frame = new Window(title);
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					Log.handle(e, this);
				}
			}
		});
	}
	
}
