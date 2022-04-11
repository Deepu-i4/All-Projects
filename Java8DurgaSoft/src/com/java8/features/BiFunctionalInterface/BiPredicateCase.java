package com.java8.features.BiFunctionalInterface;

import java.util.function.BiPredicate;

public class BiPredicateCase {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> bipred = (a, b) -> (a + b) % 2 == 0;
		System.out.println(bipred.test(10, 20));
		System.out.println(bipred.test(15, 20));
	}

}
