package com.java8.features.lambdafunctionalinterface;

@FunctionalInterface
interface Infer3 {
	public int getLength(String str);
}

public class InvokeInfer3 {

	public static void main(String[] args) {
		Infer3 infer3 = s -> s.length();
		System.out.println(infer3.getLength("Hello"));
		System.out.println(infer3.getLength("Dance"));
		System.out.println(infer3.getLength("Excuse"));
	}
}
