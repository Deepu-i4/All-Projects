package com.learnJava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

	public static Optional<Integer> limit(List<Integer> integers) {
		return integers.stream().limit(2).reduce((a, b) -> a + b);

	}

	public static Optional<Integer> skip(List<Integer> integers) {
		return integers.stream().skip(3).reduce((a, b) -> a + b);
	}

	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(6, 7, 8, 9, 10);

		Optional<Integer> limitResult = limit(integers);
		if (limitResult.isPresent()) {
			System.out.println("The limit result is : " + limitResult.get());
		} else {
			System.out.println("No value present");
		}

		Optional<Integer> skipResult = skip(integers);
		if (skipResult.isPresent()) {
			System.out.println("The limit result is : " + skipResult.get());
		} else {
			System.out.println("No value present");
		}

	}
}
