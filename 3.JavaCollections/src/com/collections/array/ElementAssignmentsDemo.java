package com.collections.array;

public class ElementAssignmentsDemo {

	public static void main(String[] args) {

		// Primitive array: holding boolean, byte, char, short, long, int, float, double
		int[] x = new int[3];
		// adding char in int array, it can be promoted to int
		x[0] = 'a';
		System.out.println(x[0]);
		byte b = 2;
		x[1] = b;

		// Object array

		Object[] objArray = new Object[5];
		objArray[0] = new Object();
		objArray[1] = new String(); // String is sub-class of Object

		// Abstract class type arrays

		Number[] numArray = new Number[3]; // can not hold the number class object, because Number is an abstract class
		numArray[0] = new Integer(1); // can store sub-class objects like Integer,Byte
		numArray[1] = new Byte("2");

		// Interface type arrays

		Runnable[] r = new Runnable[5]; // can hold only those class objects which are implementing this interface
		r[0] = new Thread();
		System.out.println(r[1]);

	}
}
