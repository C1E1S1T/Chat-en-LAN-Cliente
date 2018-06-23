package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Window extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8517559897405623414L;
	private JPanel contentPane;

	public Window(String title)
	{
		super(title);
		setIconImage(Toolkit.getDefaultToolkit()
		               .getImage(Window.class.getResource("/views/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 376);
		setLocationRelativeTo(null);
		contentPane = new ContentPane();
		contentPane.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		setContentPane(contentPane);
	}

}
