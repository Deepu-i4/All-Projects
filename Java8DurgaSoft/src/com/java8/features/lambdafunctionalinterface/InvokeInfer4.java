package com.java8.features.lambdafunctionalinterface;

@FunctionalInterface
interface Infer4 {
	public int square(int x);
}

public class InvokeInfer4 {

	public static void main(String[] args) {
		Infer4 infer4 = x -> x * x;
		System.out.println(infer4.square(4));
		System.out.println(infer4.square(5));
		System.out.println(infer4.square(6));
	}
}
