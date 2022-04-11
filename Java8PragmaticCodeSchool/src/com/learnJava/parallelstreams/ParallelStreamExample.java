package com.learnJava.parallelstreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < numberOfTimes; i++) {
			supplier.get();
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static int sumSequentialStream() {
		int total = IntStream.rangeClosed(1, 10000000).sum();
		return total;
	}

	public static int sumParallelStream() {
		int total = IntStream.rangeClosed(1, 1000000)// IntStream
				.parallel() // splits the data in to multiple parts //775057
				.sum();// performs the sum of the individual parts and consolidate the result.
		return total;
	}

	public static void main(String[] args) {
		System.out.println("sumSequentialStream:= " + sumSequentialStream());
		System.out.println("sumParallelStream:= " + sumParallelStream());
		System.out.println(Runtime.getRuntime().availableProcessors());
		long sequentialDuration = checkPerformanceResult(ParallelStreamExample::sumSequentialStream, 20);
		System.out.println("sequentialDuration in MilliSeconds: " + sequentialDuration);
		long parallelDuration = checkPerformanceResult(ParallelStreamExample::sumParallelStream, 20);
		System.out.println("parallelDuration in MilliSeconds: " + parallelDuration);

	}
}
