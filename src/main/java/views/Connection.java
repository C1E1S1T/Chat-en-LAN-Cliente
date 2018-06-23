package views;

import javax.swing.JPanel;
import javax.swing.JTextField;

import presenters.ConnectionPresenter;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Connection extends JPanel
{
	
	private static final String TITLE_BTN_CONNECT = "Conectar";
	private static final long serialVersionUID = 3443638124303488834L;
	private JTextField txtHostName;
	private JButton btnConnect;


	/**
	 * Create the panel.
	 */
	public Connection()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 259, 186, 166, 0};
		gridBagLayout.rowHeights = new int[]{31, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtHostName = new JTextField();
		GridBagConstraints gbc_txtHostName = new GridBagConstraints();
		gbc_txtHostName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHostName.insets = new Insets(0, 0, 0, 5);
		gbc_txtHostName.gridx = 1;
		gbc_txtHostName.gridy = 1;
		add(txtHostName, gbc_txtHostName);
		txtHostName.setColumns(10);
		
		btnConnect = new JButton(TITLE_BTN_CONNECT);
		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.anchor = GridBagConstraints.EAST;
		gbc_btnConnect.gridx = 3;
		gbc_btnConnect.gridy = 1;
		add(btnConnect, gbc_btnConnect);

		ConnectionPresenter presenter = new ConnectionPresenter(this);
		presenter.present();
	}

	public String getHostName()
	{
		return txtHostName.getText();
	}

	public JButton getBtnConnect()
	{
		return btnConnect;
	}
	
}
