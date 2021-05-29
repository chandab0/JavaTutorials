package test.array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import main.array.FindProductExceptSelf;

public class FindProductExceptSelfTest {
	@Test
	public void whenWithoutDivisionInvoked_givenAnMixedArray_returnItsProduct() {
		try {
			int[] input = { -5, 2, 10, 3 };
			int[] expectedResult = { 60, -150, -30, -100 };
			assertArrayEquals(FindProductExceptSelf.withoutDivision(input), expectedResult);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void whenWithoutDivisionInvoked_givenAnAllPoistiveArray_returnItsProduct() {
		try {
			int[] input = { 1, 2, 3, 4 };
			int[] expectedResult = { 24, 12, 8, 6 };
			assertArrayEquals(FindProductExceptSelf.withoutDivision(input), expectedResult);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void whenWithBruteForceInvoked_givenAnMixedArray_returnItsProduct() {
		try {
			int[] input = { -5, 2, 10, 3 };
			int[] expectedResult = { 60, -150, -30, -100 };
			assertArrayEquals(FindProductExceptSelf.withBruteForce(input), expectedResult);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void whenWithBruteForceInvoked_givenAnAllPoistiveArray_returnItsProduct() {
		try {
			int[] input = { 1, 2, 3, 4 };
			int[] expectedResult = { 24, 12, 8, 6 };
			assertArrayEquals(FindProductExceptSelf.withBruteForce(input), expectedResult);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void whenWithDivisionInvoked_givenAnMixedArray_returnItsProduct() {
		try {
			int[] input = { -5, 2, 10, 3 };
			int[] expectedResult = { 60, -150, -30, -100 };
			assertArrayEquals(FindProductExceptSelf.withBruteForce(input), expectedResult);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void whenWithDivisionInvoked_givenAnAllPoistiveArray_returnItsProduct() {
		try {
			int[] input = { 1, 2, 3, 4 };
			int[] expectedResult = { 24, 12, 8, 6 };
			assertArrayEquals(FindProductExceptSelf.withBruteForce(input), expectedResult);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
