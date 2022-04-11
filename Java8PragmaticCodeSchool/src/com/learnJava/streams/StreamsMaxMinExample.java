package com.learnJava.streams;

import java.util.*;

public class StreamsMaxMinExample {

	/**
	 * Avoid to use the default in case of finding min and max of Integer Array.
	 * 
	 * @param integerList
	 * @return
	 */
	public static Integer maxValue(List<Integer> integerList) {
		return integerList.stream().reduce(0, (a, b) -> (a > b) ? a : b);
		// 6,7,8,9,10
		// a variable holds the max value for each element in the iteration
	}

	public static Optional<Integer> maxValue1(List<Integer> integerList) {
		return integerList.stream().reduce((a, b) -> (a > b) ? a : b);
	}

	public static Optional<Integer> maxValue2(List<Integer> integerList) {
		return integerList.stream().reduce(Integer::max);
	}

	public static Optional<Integer> maxValue3(List<Integer> integerList) {
		return integerList.stream().max((a, b) -> a.compareTo(b));
	}

	// Minimum values:-
	public static Optional<Integer> minValue1(List<Integer> integerList) {
		return integerList.stream().reduce((a, b) -> (a < b) ? a : b);
	}

	public static Optional<Integer> minValue2(List<Integer> integerList) {
		return integerList.stream().reduce(Integer::min);
	}

	public static Optional<Integer> minValue3(List<Integer> integerList) {
		return integerList.stream().min((a, b) -> a.compareTo(b));
	}

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<Integer>();
		Integer maxValue = maxValue(integers);
		System.out.println("Max Value is : " + maxValue);

		List<Integer> integers1 = Arrays.asList(6, 7, 8, 9, 10);
		Optional<Integer> maxValue1 = maxValue1(integers1);
		if (maxValue1.isPresent()) {
			System.out.println("Max Value is maxValue1 : " + maxValue1.get());
		} else {
			System.out.println("Input list is empty : ");
		}

		Optional<Integer> maxValue2 = maxValue2(integers1);
		if (maxValue2.isPresent()) {
			System.out.println("Max Value is maxValue2 : " + maxValue2.get());
		} else {
			System.out.println("Input list is empty : ");
		}

		Optional<Integer> maxValue3 = maxValue3(integers1);
		if (maxValue3.isPresent()) {
			System.out.println("Max Value is maxValue3 : " + maxValue3.get());
		} else {
			System.out.println("Input list is empty : ");
		}

		Optional<Integer> minValue1 = minValue1(integers1);
		if (minValue1.isPresent()) {
			System.out.println("Max Value is minValue1 : " + minValue1.get());
		} else {
			System.out.println("Input list is empty : ");
		}

		Optional<Integer> minValue2 = minValue2(integers1);
		if (minValue2.isPresent()) {
			System.out.println("Max Value is minValue2 : " + minValue2.get());
		} else {
			System.out.println("Input list is empty : ");
		}

		Optional<Integer> minValue3 = minValue3(integers1);
		if (minValue3.isPresent()) {
			System.out.println("Max Value is minValue3 : " + minValue3.get());
		} else {
			System.out.println("Input list is empty : ");
		}

	}
}
