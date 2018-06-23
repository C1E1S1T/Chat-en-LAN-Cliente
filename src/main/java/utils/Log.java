package utils;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log
{
	public static void handle(Exception exception, Object object)
	{
		Logger logger = LogManager.getLogger(object.getClass().getName());
		String message = exception.getMessage();
		logger.error(message, exception);
		JOptionPane.showMessageDialog(null, exception.toString(), "Un error ha ocurrido", JOptionPane.ERROR_MESSAGE);
	}
}
