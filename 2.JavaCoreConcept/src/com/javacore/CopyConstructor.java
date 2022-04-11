package com.javacore;

class Complex {

	int re, im;

	// A normal parameterized constructor
	public Complex(int re, int im) {
		this.re = re;
		this.im = im;
	}

	// copy constructor
	Complex(Complex c) {
		System.out.println("Copy constructor called");
		re = c.re;
		im = c.im;
	}

	public String toString() {
		return "(" + re + " + " + im + ")";
	}
}

public class CopyConstructor {

	public static void main(String[] args) {
		Complex c1 = new Complex(10, 15);
		System.out.println(c1);
		// Following involves a copy constructor call
		Complex c2 = new Complex(c1);
		c2.re = 20;
		c2.im = 30;

		// Note that following doesn't involve a copy constructor call as
		// non-primitive variables are just references.
		Complex c3 = c2;

		System.out.println(c2); // toString() of c2 is called here
	}
}
