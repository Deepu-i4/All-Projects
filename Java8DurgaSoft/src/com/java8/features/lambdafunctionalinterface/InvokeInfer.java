package com.java8.features.lambdafunctionalinterface;

@FunctionalInterface
interface Infer {
	public void m1();
}

 class InvokeInfer1 {

	public static void main(String[] args) {
		Infer infer = () -> System.out.println("Getting called from Implemented functional interface");
		infer.m1();
	}
}

public class InvokeInfer implements Infer{

	@Override
	public void m1() {
		System.out.println("FROM IMpL");
		
	}
	
	public static void main(String[] args) {
		InvokeInfer a = new InvokeInfer();
		a.m1();
	}
	
	
}
