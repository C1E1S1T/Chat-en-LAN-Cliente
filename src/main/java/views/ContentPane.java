package views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;

public class ContentPane extends JPanel
{
	private static final long serialVersionUID = -2911959680092849500L;
	private JPanel connection;
	private JPanel chat;
	private JPanel message;

	/**
	 * Create the panel.
	 */
	public ContentPane()
	{
		chat = new Chat();
		setLayout(new BorderLayout(0, 0));
		this.add(chat, BorderLayout.CENTER);
		connection = new Connection();
		GridBagLayout gridBagLayout = (GridBagLayout) connection.getLayout();
		gridBagLayout.rowHeights = new int[] { 0, 0, 14 };
		add(connection, BorderLayout.NORTH);
		message = new Message();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) message.getLayout();
		gridBagLayout_1.rowHeights = new int[] { 15, 17 };
		add(message, BorderLayout.SOUTH);
	}

}
