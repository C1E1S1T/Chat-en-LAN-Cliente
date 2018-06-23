package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log
{
	public static void handle(Exception exception, Object object)
	{
		Logger logger = LogManager.getLogger(object.getClass().getName());
		logger.error(exception.getMessage(), exception);
	}
}
