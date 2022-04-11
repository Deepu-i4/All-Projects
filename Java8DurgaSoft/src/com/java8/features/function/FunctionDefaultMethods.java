package com.java8.features.function;

import java.util.Scanner;
import java.util.function.Function;

public class FunctionDefaultMethods {

	public static void main(String[] args) {
		staticMethodsCheck();
		staticMethodsCheck1();
		staticMethodsCheck2();
	}

	private static void staticMethodsCheck() {
		Function<String, String> f1 = s -> s.toUpperCase();
		Function<String, String> f2 = s -> s.substring(0, 9);
		System.out.println(f1.andThen(f2).apply("Aiswarya Pushpendra"));
		System.out.println(f1.compose(f2).apply("Aiswarya Pushpendra"));
	}

	private static void staticMethodsCheck1() {
		Function<Integer, Integer> f1 = i -> i + i;
		Function<Integer, Integer> f2 = i -> i * i * i;
		System.out.println(f1.andThen(f2).apply(2));
		System.out.println(f1.compose(f2).apply(2));
	}

	private static void staticMethodsCheck2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Provide Username : - ");
		String username = scanner.next();

		System.out.println("Provide Password : - ");
		String password = scanner.next();

		Function<String, String> f1 = s -> s.toLowerCase();
		Function<String, String> f2 = s -> s.substring(0, 5);

		if (f1.andThen(f2).apply(username).equals("durga") && password.equals("java")) {
			System.out.println("Valid User");
		} else {
			System.out.println("InValid User");
		}
	}

}
