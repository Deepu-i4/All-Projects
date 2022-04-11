package com.java8.features.methodAndConstructorReference;

interface Interf {
	public Sample getSample();
}

class Sample {
	public Sample() {
		System.out.println("Sample class Constructor");
	}
}

public class ConstructorReference {

	public static void main(String[] args) {
		Interf inter = Sample::new;
		Sample sample = inter.getSample();
		System.out.println(sample);
	}
}
