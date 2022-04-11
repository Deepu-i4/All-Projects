package com.java8.features.lambdafunctionalinterface;

interface Left {
	default void m1() {
		System.out.println("Left Method call from Interface");
	}
}

interface Right {
	default void m1() {
		System.out.println("Right Method call from Interface");
	}
}

class MultiInheritance implements Left, Right {

	@Override
	public void m1() {
		Right.super.m1();
	}

}

public class DefaultVsMultiInheritance {

	public static void main(String[] args) {
		MultiInheritance multiInheritance = new MultiInheritance();
		multiInheritance.m1();

	}

}
