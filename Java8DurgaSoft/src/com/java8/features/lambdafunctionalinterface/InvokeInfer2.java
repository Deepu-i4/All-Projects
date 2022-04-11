package com.java8.features.lambdafunctionalinterface;

@FunctionalInterface
interface Infer2 {
	public void add(int a, int b);
}

public class InvokeInfer2 {

	public static void main(String[] args) {
		Infer2 infer2 = (a, b) -> System.out.println("Sum by Lambda exp " + (a + b));
		infer2.add(10, 20);
		infer2.add(100, 200);
		infer2.add(1000, 2000);
	}
}
