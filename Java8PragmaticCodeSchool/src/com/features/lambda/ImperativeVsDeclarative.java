package com.features.lambda;

import java.util.stream.IntStream;

/**
 * 
 * @author Deepu Verma
 *
 */
public class ImperativeVsDeclarative {

	public static void main(String[] args) {

		/**
		 * Imperative Style In multi-Thread it will give unexpected results
		 */
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		System.out.println("Sum using Imperative Style " + sum);

		/**
		 * Declarative Style
		 */
		int sum1 = IntStream.rangeClosed(0, 100).sum();
		System.out.println("Sum using Declarative Style " + sum1);

		/**
		 * Declarative Style taken care of multi thread here.
		 */
		int sum2 = IntStream.rangeClosed(0, 100).parallel().sum();
		System.out.println("Sum using Declarative Style with Thread Safe " + sum2);
	}
}
