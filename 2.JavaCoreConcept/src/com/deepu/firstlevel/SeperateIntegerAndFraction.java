package com.deepu.firstlevel;

import java.util.Scanner;

public class SeperateIntegerAndFraction {

	public static void main(String[] args) {
		System.out.println("Enter fractional no.");
		Scanner sc = new Scanner(System.in);
		double d = sc.nextDouble();

		int IntergerPart = (int) d;
		int integerLength = count(IntergerPart);
		System.out.println("int len : " + integerLength);

		int fullnum = Rational(d);
		int fullLength = count(fullnum);
		System.out.println("full number length : " + fullLength);

		int decimalLength = DecimalPartLength(fullLength, integerLength);
		System.out.println("Deci len: " + decimalLength);
		int deciZero = (int) Math.pow(10, decimalLength);
		System.out.println(deciZero);

		int deciPart = (int) (deciZero * d - deciZero * IntergerPart);

		System.out.println("IntergerPart :  " + IntergerPart + "\t" + "DecimalPart : " + deciPart);

	}

	public static int DecimalPartLength(int fl, int il) {
		int deciL = fl - il;
		return deciL;
	}

	public static int Rational(double d) {
		String s = String.valueOf(d);
		int digitsDec = s.length() - 1 - s.indexOf('.');

		for (int i = 0; i < digitsDec; i++) {
			d *= 10;
		}
		return ((int) d);
	}

	public static int count(int c) {
		int count = 0;
		while (c != 0) {
			c = c / 10;
			count = count + 1;
		}
		return count;
	}

}
