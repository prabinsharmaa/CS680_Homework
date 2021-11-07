package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class CalculatorTest {

	@Test
	public void multiply2And4() {
		Calculator cal = new Calculator() ;
		float expected = 8f;
		float actual = cal.multiply(2, 4);
		assertEquals(expected,actual);
	}	
	
	@Test
	public void divide8By4() {
		Calculator cal = new Calculator();
		float expected = 2f;
		float actual = cal.divide(8, 4);
		assertEquals(expected,actual);
	}
	
	@Test
	public void divideByZeroTest() {
		Calculator cal = new Calculator();
		try {
			float ans = cal.divide(5,0);
		}
		catch(Exception exp) {
			assertEquals("division by zero",exp.getMessage());
		}
	}

}
