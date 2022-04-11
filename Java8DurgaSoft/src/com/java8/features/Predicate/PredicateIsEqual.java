package com.java8.features.Predicate;

import java.util.function.Predicate;

public class PredicateIsEqual {

	public static void main(String[] args) {
		Predicate<String> prd = Predicate.isEqual("Push");
		System.out.println(prd.test("Push"));
		System.out.println(prd.test("Salma"));
	}

}
