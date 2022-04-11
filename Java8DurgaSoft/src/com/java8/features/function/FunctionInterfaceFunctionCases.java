package com.java8.features.function;

import java.util.function.Function;

public class FunctionInterfaceFunctionCases {

	public static void main(String[] args) {
		function1();
		function2();
		function3();
		function4();
	}

	/**
	 * length of String.
	 */
	private static void function1() {
		Function<String, Integer> function = s -> s.length();
		System.out.println(function.apply("Pushpendra"));
	}

	/**
	 * Square of the number.
	 */
	private static void function2() {
		Function<Integer, Integer> function = s -> s * s;
		System.out.println(function.apply(5));
	}

	/**
	 * Remove the blank space from String
	 */
	private static void function3() {
		Function<String, String> function = s -> s.replaceAll(" ", "");
		System.out.println(function.apply("Pushpendra kumar"));
	}

	/**
	 * Count the number of spaces in String.
	 */
	private static void function4() {
		Function<String, Integer> function = s -> s.length() - s.replaceAll(" ", "").length();
		System.out.println(function.apply("Pushpendra kumar Radhe "));
	}
}
