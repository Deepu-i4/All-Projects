package com.learnJava.functionalInterfaces;

public class FunctionExample1 {

	public String appendDefault(String input) {

		return FunctionExample.addSomeString.apply(input);
	}

	public static void main(String[] args) {
		System.out.println(new FunctionExample1().appendDefault("Pushpendra"));
	}

}
