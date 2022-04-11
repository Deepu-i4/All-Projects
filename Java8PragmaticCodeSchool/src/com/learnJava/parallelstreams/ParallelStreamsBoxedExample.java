package com.learnJava.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamsBoxedExample {

	public static int sequentialSum(List<Integer> integerList) {
		long start = System.currentTimeMillis();
		int sum = integerList.stream().reduce(0, (x, y) -> x + y);
		long duration = System.currentTimeMillis() - start;
		System.out.println("Duration in sequential stream : " + duration);
		return sum;
	}

	public static int parallelSum(List<Integer> integerList) {
		long start = System.currentTimeMillis();
		int sum = integerList.parallelStream().reduce(0, (x, y) -> x + y);
		// performs the unboxing from Integer to int.
		long duration = System.currentTimeMillis() - start;
		System.out.println("Duration in parallel stream : " + duration);
		return sum;
	}

	public static void main(String[] args) {
		List<Integer> integerList = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());
		System.out.println(sequentialSum(integerList));
		System.out.println(parallelSum(integerList));
	}
}
