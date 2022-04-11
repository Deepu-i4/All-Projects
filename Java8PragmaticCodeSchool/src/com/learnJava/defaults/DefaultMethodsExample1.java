package com.learnJava.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodsExample1 {

	public static void main(String[] args) {

		List<String> stringList = Arrays.asList("Adam", "Jenny", "Alex", "Eric", "Mike");
		
		/**
		 * Before java 8
		 */
		Collections.sort(stringList);

		System.out.println("Before java 8 Sorted list : " + stringList);
		
		/**
		 * After java 8
		 */
		stringList.sort(Comparator.naturalOrder());

		System.out.println(" After java 8 Sorted list : " + stringList);

		stringList.sort(Comparator.reverseOrder());

		System.out.println("Reverse Sorted list : " + stringList);

	}
}
