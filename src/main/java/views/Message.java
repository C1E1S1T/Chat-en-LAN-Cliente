package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import utils.PlaceHolder;

import java.awt.GridBagConstraints;

public class Message extends JPanel
{

	private static final long serialVersionUID = 1371226834358089169L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Message()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		textField = new PlaceHolder("Escriba aqui su mensaje");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
	}

	public JTextField getField()
	{
		return textField;
	}

}
