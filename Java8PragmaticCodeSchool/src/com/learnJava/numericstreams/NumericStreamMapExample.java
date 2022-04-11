package com.learnJava.numericstreams;

import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

public class NumericStreamMapExample {

	public static List<Integer> mapToObj() {

		List<Integer> integerList = IntStream.rangeClosed(1, 5).mapToObj((i) -> {
			return new Integer(i);
		}).collect(toList());

		return integerList;

	}

	public static double mapToDouble() {

		return IntStream.rangeClosed(1, 5) // intStream
				.mapToDouble((i) -> i) // intStream to doubleStream
				.sum();

	}

	public static long mapToLong() {

		return IntStream.rangeClosed(1, 5) // intStream
				.mapToLong((i) -> i) // intStream to longStream
				.sum();

	}

	public static void main(String[] args) {

		System.out.println("mapToObj : " + mapToObj());

		System.out.println("mapToDouble() : " + mapToDouble());

		System.out.println("mapToLong() : " + mapToLong());

	}
}
