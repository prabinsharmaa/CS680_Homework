package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTest {

	private String[] carToStringArray(Car c) {
		String[] CarInfo = { c.getMake(), c.getModel(), Integer.toString(c.getYear()) };
		return CarInfo;
	}

	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = { "Ford", "Maverick", "2012" };
		Car actual = new Car("Ford", "Maverick", 2012);
		assertArrayEquals(expected, carToStringArray(actual));
	}

	@Test
	public void verifyNotEqualCarWithMakeModelYear() {
		String[] expected = { "Tesla", "Model X", "2018" };
		Car actual = new Car("Honda", "Accord", 2021);
		assertNotEquals(expected, carToStringArray(actual));
	}

}
