package com.learnJava.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableExample {

	public static Optional<String> ofNullable() {
		return Optional.ofNullable("Hello");
		// return Optional.ofNullable(null);
	}

	public static Optional<String> of() {
		return Optional.ofNullable("Hello");
		// return Optional.of(null);
	}

	public static Optional<String> empty() {
		return Optional.empty();
	}

	public static void main(String[] args) {
		System.out.println("ofNullable :- " + ofNullable().isPresent());
		System.out.println("ofNullable :- " + ofNullable().get());

		// It will the error in case of passing the invalid or null string.
		System.out.println("of :- " + of());
		System.out.println("empty :" + empty());
	}
}
