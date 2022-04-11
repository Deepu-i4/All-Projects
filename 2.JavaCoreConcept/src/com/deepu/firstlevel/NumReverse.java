package com.deepu.firstlevel;

public class NumReverse {

	public static void main(String[] args) {
		int n = 123;
		int count = 0;
		int c = n;
		// this loop is to count the inter value places
		while (c != 0) {
			c = c / 10;
			count++;
		}

		int r = 0;
		int ch[] = new int[count];

		for (int i = 0; i < count; i++) {
			r = r * 10;
			r = r + n % 10;
			n = n / 10;
			ch[i] = r;
		}
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]);
		}
	}
}
