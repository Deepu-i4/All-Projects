package com.deepu.firstlevel;

import java.util.HashMap;
import java.util.Map;

/* */
public class Fibonacci {

	public static void main(String[] args) {
		int number = 10;

		for (int i = 1; i <= number; i++) {
			System.out.print(fibonacci(i) + " ");
		}

		System.out.println();
		for (int i = 1; i <= number; i++) {
			System.out.print(fibonacci2(i) + " ");
		}

		// Using Memoritization
		long beginTime = System.currentTimeMillis();
		for (int j = 0; j <= number; j++) {
			System.out.println(j + "  " + improvedFibonacci(j));
		}
		long endTime = System.currentTimeMillis();

		long delta = endTime - beginTime;
		System.out.println("Time taken : -" + delta);

		// Dynamic programing
		for (int j = 0; j <= number; j++) {
			System.out.println(j + "  " + fib(j));
		}
		;

	}

	// Java program for Fibonacci number using recursion.
	// This program uses tail recursion to calculate Fibonacci number for a given
	// number
	public static int fibonacci(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		return fibonacci(number - 1) + fibonacci(number - 2);
	}

	// Java program to calculate Fibonacci number using loop or Iteration.
	public static int fibonacci2(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		int fibo1 = 1, fibo2 = 1, fibonacci = 1;
		for (int i = 3; i <= number; i++) {
			// Fibonacci number is sum of previous two Fibonacci number
			fibonacci = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibonacci;
		}
		return fibonacci;
	}

	// So I've got a simple optimisation idea. To put previous values in a HashMap
	// and instead of re-computing them each time, to simply take them back from the
	// HashMap
	// if they exist. If they don't exist, we then put them in the HashMap.

	private static Map<Long, Long> previousValuesHolder;
	static {
		previousValuesHolder = new HashMap<Long, Long>();
	}

	public static long improvedFibonacci(long number) {
		if (number == 0 || number == 1) {
			return number;
		}
		try {
			// do not calculate anymore, just return it
			return previousValuesHolder.get(number);
		} catch (NullPointerException np) {
			// has to be calculated once, then save it
			// calculation part
			long value = improvedFibonacci(number - 1) + improvedFibonacci(number - 2);
			// saving part
			previousValuesHolder.put(number, value);
			return value;
		}
	}

	// Dynamic programing
	static int fib(int n) {
		/* Declare an array to store Fibonacci numbers. */
		int f[] = new int[n + 2]; // 1 extra to handle case, n = 0
		int i;

		/* 0th and 1st number of the series are 0 and 1 */
		f[0] = 0;
		f[1] = 1;

		for (i = 2; i <= n; i++) {
			/* Add the previous 2 numbers in the series and store it */
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

	// more ways check here.
	// https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

}