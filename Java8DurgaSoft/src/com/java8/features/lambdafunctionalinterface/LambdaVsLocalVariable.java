package com.java8.features.lambdafunctionalinterface;

interface Interf {
	public void m1();
}

class AnonymousLocalVariable {
	int x = 111;

	public void m2() {
		Interf interf = new Interf() {
			 int x = 222; // prior to java 8 any variable declare inside the inner class need to be final only.
			public void m1() {
				int x = 213123; 
				System.out.println(this.x);
				System.out.println(x);
			}
		};
		interf.m1();
	}
}

class LambdaLocalVariable {
	int x = 111;

	public void m2() {
		Interf interf = () -> {
			int x = 222; // treated as local variable only.
			System.out.println(this.x);
			System.out.println(x);
		};
		interf.m1();
	}
}

public class LambdaVsLocalVariable {
	public static void main(String[] args) {
		new AnonymousLocalVariable().m2();
		new LambdaLocalVariable().m2();
	}
}
