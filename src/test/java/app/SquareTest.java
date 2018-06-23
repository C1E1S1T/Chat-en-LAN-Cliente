package app;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Square;

public class SquareTest
{

	@ Test
	public void test()
	{
		Square square = new Square(4);
		int actual = square.calculateArea();
		int expected = 16;
		assertEquals(expected,actual);
	}

}
