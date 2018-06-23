package controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller
{

	

	public void handleError(Exception exception)
	{
		Logger logger = LogManager.getLogger(this.getClass().getName());
		logger.error(exception.getMessage(), exception);
	}
	
}
