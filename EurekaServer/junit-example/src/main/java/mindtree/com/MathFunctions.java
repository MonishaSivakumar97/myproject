package mindtree.com;

public class MathFunctions {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		return a / b;
	}

	public double findCircleArea(double radius) {
		return Math.PI * radius * radius;
	}

	public int findfactorial(int n) {
		int result = 1;
		if (n >= 0) {
			for (int i = n; i > 0; i--) {
				result = result * i;
			}
			return result;
		} else {
			return -1;
		}
	}
}
