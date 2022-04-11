package com.collections.array;

public class VariableAssignments {

	public static void main(String[] args) {
		int[] x = new int[2];
		int[] a = x; // assigning x to a : No new array is created here
		x[0] = 1;
		System.out.println(x[0]);
		System.out.println(a[0]);
		a[1] = 2;
		System.out.println(x[1]);
		System.out.println(a[1]);

		// ------------------

		int[] b = { 1, 2, 3 };
		int[] c = { 11, 22 };
		b = c;
		c = b; // both b and c will point same array c

		for (int e : b) {
			System.out.println(e);
		}
		System.out.println("_______________");
		for (int e : c) {
			System.out.println(e);
		}

		// -------------------

		String[] s = new String[3];
		Object[] objArr = s;
		// string array can be promoted to object array

		short[] shorts = new short[2]; // [S
		// int[] ints = shorts; //[I

		// short element can be promoted to int, but short array type object can not
		// promoted to int array type.

	}
}
