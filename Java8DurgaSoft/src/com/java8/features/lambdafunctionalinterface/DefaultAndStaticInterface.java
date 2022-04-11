package com.java8.features.lambdafunctionalinterface;

interface Infer5 {
	default void m1() {
		System.out.println("Default Method call from Interface");
	}
}

class DefaultClass implements Infer5 {

}

class DefaultOveriddenClass implements Infer5 {
	public void m1() {
		System.out.println("DefaultOveriddenClass: Default Method call from Interface");
	}
}

public class DefaultAndStaticInterface {

	public static void main(String[] args) {
		DefaultClass defaultClass = new DefaultClass();
		defaultClass.m1();

		Infer5 infer5 = new DefaultClass();
		infer5.m1();

		DefaultOveriddenClass deOverClass = new DefaultOveriddenClass();
		deOverClass.m1();

		Infer5 infer53 = new DefaultOveriddenClass();
		infer53.m1();

		Infer56.m23();// only you can call from Interface name.

	}
}

interface Infer56 {
	public static void m23() {
		System.out.println("Static Method call from Interface");
	}
}
