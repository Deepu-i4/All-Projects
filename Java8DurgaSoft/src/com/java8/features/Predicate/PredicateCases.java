package com.java8.features.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class PredicateCases {

	public static void main(String[] args) {
		predicate1();
		predicate2();
		predicate3();
		predicate4();
		predicate5();
		predicate6();
	}

	/**
	 * check on number.
	 */
	private static void predicate1() {
		Predicate<Integer> p = i -> i > 10;
		System.out.println(p.test(100));
		System.out.println(p.test(7));
	}

	/**
	 * check string length
	 */
	private static void predicate2() {
		Predicate<String> p = s -> s.length() > 3;
		System.out.println("-----------");
		System.out.println(p.test("Pushpendra"));
		System.out.println(p.test("Hi"));
	}

	/**
	 * Check empty Collection.
	 */
	private static void predicate3() {
		Predicate<Collection> p = c -> c.isEmpty();
		System.out.println("-----------");
		System.out.println(p.test(new ArrayList()));
		System.out.println(p.test(Arrays.asList("Dave", "Jessie", "Alex", "Dan")));
	}

	/**
	 * Predicate Joining
	 */
	private static void predicate4() {
		int[] x = { 0, 5, 10, 15, 20, 25, 30 };
		Predicate<Integer> p1 = i -> i > 10;
		Predicate<Integer> p2 = i -> i % 2 == 0;
		System.out.println("-----------");
		System.out.println("The Numbers Greater Than 10:");
		checkPredicate(p1, x);
		System.out.println("The Even Numbers Are:");
		checkPredicate(p2, x);
		System.out.println("The Numbers Not Greater Than 10:");
		checkPredicate(p1.negate(), x);
		System.out.println("The Numbers Greater Than 10 And Even Are");
		checkPredicate(p1.and(p2), x);
		System.out.println("The Numbers Greater Than 10 OR Even");
		checkPredicate(p1.or(p2), x);
	}

	private static void checkPredicate(Predicate<Integer> predicate, int[] x) {
		for (int i : x) {
			if (predicate.test(i)) {
				System.out.println(i);
			}
		}
	}

	/**
	 * Names starts with K
	 */
	private static void predicate5() {
		String[] names = { "Sunny", "Kajal", "Mallika", "Katrina", "Kajol" };
		Predicate<String> startsWithK = s -> s.charAt(0) == 'K';
		System.out.println("-----------");
		for (String name : names) {
			if (startsWithK.test(name))
				System.out.println(name);
		}
	}

	/**
	 * remove null and empty.
	 */
	private static void predicate6() {
		String[] names = { "Sunny", "", "", null, "Kajal", null, "Mallika", "Katrina", "Kajol" };
		Predicate<String> pred = s -> s != null && s.length() != 0;
		System.out.println("-----------");
		List<String> list = new ArrayList();
		for (String name : names) {
			if (pred.test(name))
				list.add(name);
		}
		System.out.println("Proper List without null and empty " + list);
	}
}
