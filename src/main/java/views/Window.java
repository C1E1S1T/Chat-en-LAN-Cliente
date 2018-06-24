package views;

import javax.swing.JFrame;
import javax.swing.UIManager;

import presenters.ContentPanePresenter;

import java.awt.Toolkit;

public class Window extends JFrame
{

	private static final String ROUTE_LOGO = "/views/logo.png";
	/**
	 * 
	 */
	private static final long serialVersionUID = -8517559897405623414L;
	private ContentPane contentPane;

	public Window(String title)
	{
		super(title);
		setIconImage(Toolkit.getDefaultToolkit()
		               .getImage(Window.class.getResource(ROUTE_LOGO)));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 376);
		setLocationRelativeTo(null);
		contentPane = new ContentPane();
		contentPane.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		setContentPane(contentPane);

		new ContentPanePresenter(contentPane).present();

	}

}
