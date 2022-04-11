package com.deepu.firstlevel;

import java.util.Scanner;

public class NumToWord {
	private static String[] unitdo = { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight",
			" Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen",
			" Eighteen", " Nineteen" };
	private static String[] tens = { "", "Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy",
			" Eighty", " Ninety" };
	private static String[] digit = { "", " Hundred", " Thousand", " Lakh", " Crore" };

	public static void main(String[] args) {
		int len, quo = 0, rem = 0;
		String l = "";
		String s = "";

		System.out.println("Enter the number : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num <= 0) {
			System.out.println("Zero or Negative number not for conversion");
		}

		while (num > 0) {
			len = count(num);
			switch (len) {
			case 8:
				quo = num / 10000000;
				rem = num % 10000000;
				l = TwoDigit(quo);
				s = s + l + digit[4];
				num = rem;
				break;
			case 7:
			case 6:
				quo = num / 100000;
				rem = num % 100000;
				l = TwoDigit(quo);
				s = s + l + digit[3];
				num = rem;
				break;
			case 5:
			case 4:
				quo = num / 1000;
				rem = num % 1000;
				l = TwoDigit(quo);
				s = s + l + digit[2];
				num = rem;
				break;
			case 3:
				if (len == 3)
					rem = num;
				l = ThreeDigit(rem);
				s = s + l;
				num = 0;
				break;
			case 2:
				l = TwoDigit(num);
				s = s + l;
				num = 0;
				break;
			case 1:
				s = s + unitdo[num];
				num = 0;
				break;
			default:
				num = 0;
				System.out.println("Exceeding Crore....No conversion");
				System.exit(1);
			}
			if (num == 0)
				System.out.println(s);
		}
	}

	public static String TwoDigit(int num) {
		int nrem, nquo; // if //else
		String ltr = ""; // 23 //17
		nquo = num / 10; // 2 //1
		nrem = num % 10; // 3 //7
		if (num > 19) {
			ltr = ltr + tens[nquo] + unitdo[nrem];
		} else {
			ltr = ltr + unitdo[num];
		}
		return ltr;
	}

	public static String ThreeDigit(int num) {
		int nrem, nquo; // if //else
		String ltr = ""; // 300 //323
		nquo = num / 100; // 3 //3
		nrem = num % 100; // 0 //23
		if (nrem == 0) {
			ltr = ltr + unitdo[nquo] + digit[1];
		} else {
			ltr = ltr + unitdo[nquo] + digit[1] + " and" + TwoDigit(nrem);
		}
		return ltr;
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