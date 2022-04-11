package com.learnJava.parallelstreams;

import java.util.stream.IntStream;

public class SumClient {

	public static void main(String[] args) {
		Sum sum = new Sum();
		IntStream.rangeClosed(1, 10000).parallel().forEach(sum::performSum); // result is : 500500
		System.out.println(sum.getTotal());
		// it is not going to give same result as we are working on mutable object.

		/*
		 * Sum sum1 = new Sum(); long start1 = System.currentTimeMillis();
		 * IntStream.rangeClosed(1, 10000).forEach(sum1::performSum); // result is :
		 * 500500 long end1 = System.currentTimeMillis();
		 * System.out.println("Time Taken :- " + (end1 - start1) + " " +
		 * sum1.getTotal());
		 */
	}
}
