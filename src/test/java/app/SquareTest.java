package app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest
{

	@ Test
	void test()
	{
		int actual = new Square(2).calculateArea();
		int expected = 4;
		assertEquals(expected,actual);
	}

}
