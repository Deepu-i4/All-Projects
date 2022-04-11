package com.deepu.firstlevel;

class A1 {
	static int c = 0;

	public A1() {
		c = c + 1;
	}
}

public class CountObjectNumber {
	public static void main(String[] args) {
		A1 a1 = new A1();
		System.out.println(a1.c);

		A1 a2 = new A1();
		System.out.println(a2.c);
	}
}