package views;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

public class ContentPane extends JPanel
{
	private static final long serialVersionUID = -2911959680092849500L;
	private Connection connection;
	private Chat chat;
	private Message message;

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

	public JTextField getMessage()
	{
		return message.getField();
	}

	public JTextField  getHostName()
	{
		return connection.getHostName();
	}

	public JTextArea getChat()
	{
		return chat.getChat();
	}

	public void append(String line)
	{
		chat.getChat().append(line);
	}

}
