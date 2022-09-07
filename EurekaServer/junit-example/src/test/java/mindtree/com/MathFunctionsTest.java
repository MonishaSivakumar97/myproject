package mindtree.com;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("When run MathFunctions")
class MathFunctionsTest {
	MathFunctions mathFunctions;

	@BeforeEach
	void init() {
		mathFunctions = new MathFunctions();
	}

	@Test
	@Disabled
	@DisplayName("test method. should not run")
	void testDisabled() {
		fail("This test should be Disabled");
	}

	@Nested
	@DisplayName("Add Method")
	@Tag("Math")
	class AddTest {
		@Test
		@DisplayName("testing method add two number positive")
		void testAddPositive() {
			assertEquals(2, mathFunctions.add(1, 1), "the add methods should add two numbers return positive");
		}

		@Test
		@DisplayName("testing method add two number Negative")
		void testAddNegative() {
			int expected = -2;
			int actual = mathFunctions.add(-1, -1);
			assertEquals(expected, actual, "should return sum" + expected + "but returned" + actual);
		}
	}

	@Test
	@DisplayName("method multiply")
	@Tag("Math")
	void testAddMultiply() {
		// assertEquals(-2, mathFunctions.multiply(-1, -1), "methods should multiply two
		// numbers");
		assertAll(() -> assertEquals(4, mathFunctions.multiply(2, 2)),
				() -> assertEquals(0, mathFunctions.multiply(2, 0)),
				() -> assertEquals(-2, mathFunctions.multiply(2, -1)));
	}

	@Test
	@DisplayName("method factorial")
	void testfindFactorial() {
		assertAll(() -> assertEquals(120, mathFunctions.findfactorial(5)),
				() -> assertEquals(1, mathFunctions.findfactorial(0)),
				() -> assertEquals(-1, mathFunctions.findfactorial(-4)));
	}

	@Test
	@DisplayName("testing method add")
	@Tag("Math")
	void testAdd() {
		int expected = 2;
		int actual = mathFunctions.add(1, 1);
		assertEquals(expected, actual, "the add methods should add two numbers");
	}

	@Test
	void testDivide() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathFunctions.divide(1, 0), "Divide by zero should throw");
	}

	@RepeatedTest(3)

	void testFindCircleArea(RepetitionInfo repetitionInfo) {
		double expected = 314.1592653589793;
		double actual = mathFunctions.findCircleArea(10);
		assertEquals(expected, actual, "Should return circle area");
	}

}
