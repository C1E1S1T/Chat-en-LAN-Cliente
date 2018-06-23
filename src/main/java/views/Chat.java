package views;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;

public class Chat extends JPanel
{

	private static final long serialVersionUID = 1291756469887143336L;

	/**
	 * Create the panel.
	 */
	public Chat()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		add(editorPane);

	}

}
