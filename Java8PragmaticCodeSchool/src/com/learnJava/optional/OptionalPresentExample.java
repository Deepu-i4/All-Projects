package com.learnJava.optional;

import java.util.Optional;

public class OptionalPresentExample {

	public static void main(String[] args) {
		// Optional<String> stringOptional = Optional.ofNullable(null);
		Optional<String> stringOptional = Optional.ofNullable("Hello");
		System.out.println(stringOptional.isPresent());
		stringOptional.ifPresent(s -> System.out.println("value is : " + s));
	}
}
