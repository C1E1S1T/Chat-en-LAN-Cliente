package views;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import java.awt.Font;

public class Chat extends JPanel
{

	private static final long serialVersionUID = 1291756469887143336L;
	private JTextArea pane;

	/**
	 * Create the panel.
	 */
	public Chat()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		pane = new JTextArea();
		pane.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pane.setEditable(false);
		add(pane);

	}

	public JTextArea getChat()
	{
		return pane;
	}

}
