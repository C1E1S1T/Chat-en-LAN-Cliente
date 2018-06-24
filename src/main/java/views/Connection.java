package views;

import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.PlaceHolder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Connection extends JPanel
{
	
	private static final String TITLE_HOSTNAME = "Nombre del HostName Destino";
	private static final long serialVersionUID = 3443638124303488834L;
	private JTextField txtHostName;


	/**
	 * Create the panel.
	 */
	public Connection()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{259, 0};
		gridBagLayout.rowHeights = new int[]{31, 34, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		txtHostName = new PlaceHolder(TITLE_HOSTNAME);
		GridBagConstraints gbc_txtHostName = new GridBagConstraints();
		gbc_txtHostName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHostName.gridx = 0;
		gbc_txtHostName.gridy = 1;
		add(txtHostName, gbc_txtHostName);
		txtHostName.setColumns(10);
	}

	public JTextField getHostName()
	{
		return txtHostName;
	}


}
