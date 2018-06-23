package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReceiverMessageControllerTest
{
	
	private ReceiverController controller;
	
	@ Before
	public void setUp() throws Exception
	{
		controller = new ReceiverController();
	}

	@ Test
	public void testReceiver_caseValidMessage()
	{
		
		controller.run();
		fail("Not yet implemented");
	}

}
