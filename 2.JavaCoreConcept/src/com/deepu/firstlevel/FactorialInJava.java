package com.deepu.firstlevel;

/* */
public class FactorialInJava {

	public static void main(String args[]) {

		System.out.println("factorial of 5 using recursion in Java is: " + factorialRecursive(5));

		System.out.println("factorial of 6 using iteration in Java is: " + factorialIteration(6));
	}

	public static int factorialRecursive(int number) {
		if (number == 0) {
			return 1;
		}
		return number * factorialRecursive(number - 1);
	}

	public static int factorialIteration(int number) {
		int result = 1;
		while (number != 0) {
			result = result * number;
			number--;
		}
		return result;
	}

}
