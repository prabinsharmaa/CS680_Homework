package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	public void multiply5By2() {
		Calculator cut = new Calculator();
		float expected = 10;
		float actual = cut.multiply(5,2);
		assertTrue(cut instanceof Calculator);
		assertEquals(expected, actual);
	}
	@Test
	public void divide4By2(){
		Calculator cut = new Calculator();
		float expected = 2f;
		float actual = cut.divide(4,2);
		assertEquals(expected, actual);
	}
	@Test
	public void divide6By0withTryCatch(){
		Calculator cut = new Calculator();
		try{
			cut.divide(6, 0);
			fail("Division by zero");
		}
		catch(IllegalArgumentException ex){
			assertEquals("division by zero", ex.getMessage());
		}
	}
}
