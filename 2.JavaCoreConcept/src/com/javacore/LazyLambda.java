package com.javacore;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LazyLambda {

	public static void main(String args[]) {
		// nonLazy();
		lazyLambda();
		lazyLambdaUsingStream();
	}

	private static void lazyLambdaUsingStream() {
		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("Defining the Stream");
		final Stream<Integer> stream = numbers.stream().filter(LazyLambda::compute).filter(LazyLambda::process);
		System.out.println("Not Executed yet");
		int num = stream.findFirst().orElse(0);
		System.out.println(num);

	}

	private static void lazyLambda() {
		final int number = 4;
		Supplier<Boolean> computeResult = () -> compute(number);
		Supplier<Boolean> processResult = () -> process(number);
		if (computeResult.get() && processResult.get()) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

	private static void nonLazy() {
		final int number = 4;
		final boolean computeResult = compute(number);
		final boolean processResult = process(number);
		if (computeResult && processResult) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

	public static boolean compute(final int number) {
		System.out.println("computing number : " + number);
		return number > 5 ? true : false;
	}

	public static boolean process(final int number) {
		System.out.println("processing number : " + number);
		return number % 3 == 0 ? true : false;
	}
}
