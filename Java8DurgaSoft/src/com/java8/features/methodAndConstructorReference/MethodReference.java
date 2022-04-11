package com.java8.features.methodAndConstructorReference;

public class MethodReference {

	public static void m1() {
		for (int i = 0; i < 6; i++) {
			System.out.println("Method Reference by our class");
		}
	}

	public static void main(String[] args) {
		// refer our implementation instead of run method implementation
		Runnable r = MethodReference::m1;
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 6; i++) {
			System.out.println("Main Thread");
		}
	}
}
