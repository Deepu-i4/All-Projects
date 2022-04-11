package com.java8.features.consumer;

import java.util.function.Consumer;

public class ConsumerFunctionalInterfaceCase {

	public static void main(String args[]) {

		Consumer<String> consumer = c -> System.out.println(c);
		consumer.accept("Pushpendra Kumar");
		consumer.accept("Hero");
	}
}
