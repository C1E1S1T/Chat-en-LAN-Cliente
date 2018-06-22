package app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest
{

	@ Test
	void testCalculateArea()
	{
		Square square = new Square(2);
		int actual = square.calculateArea();
		int expected = 4;
		assertEquals(expected,actual);
	}

}
