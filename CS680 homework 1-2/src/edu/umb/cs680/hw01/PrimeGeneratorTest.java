package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {
		
	@Test
	public void OneToTwentyPrimeTest() {
		PrimeGenerator g = new PrimeGenerator(1,20);
		g.generatePrimes();
		Long[] expectedValues = {2L,3L,5L,7L,11L,13L,17L,19L};
		assertArrayEquals(expectedValues, g.getPrimes().toArray());
	}
	
	@Test
	public void NegativeNumberTest() {
		try {
			PrimeGenerator g = new PrimeGenerator(-12,10);
		}
		catch(Exception exp){
			assertEquals("Wrong input values: from=-12 to=10" ,exp.getMessage());
		}		
	}
	
	@Test
	public void ThirtyToFortyEightPrimeTest() {
		PrimeGenerator g = new PrimeGenerator(30,48);
		g.generatePrimes();
		Long[] expectedValues = {31L,37L,41L,43L,47L};
		assertArrayEquals(expectedValues, g.getPrimes().toArray());
	}
	

}
