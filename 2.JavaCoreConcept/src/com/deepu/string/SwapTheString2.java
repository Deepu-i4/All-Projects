package com.deepu.string;

public class SwapTheString2 {
	public static void main(String[] args) {
		String s1 = "Ram";
		String s2 = "Mishra";
		System.out.println("Before swaping");
		System.out.println("s1 " + s1);
		System.out.println("s2 " + s2);

		int s1L = s1.length();
		int s2L = s2.length();
		char ch1[] = new char[s1L + s2L + 2];
		char ch2[] = new char[s2L + s1L + 2];
		for (int i = 0; i < s1.length(); i++) {
			ch1[i] = s1.charAt(i);
		}
		for (int j = 0; j < s2.length(); j++) {
			ch2[j] = s2.charAt(j);
		}
		for (int i = s1L, j = 0; i < (s1L + s2L); j++, i++) {
			ch1[i] = ch2[j];
		}
		char ch = ' ';
		ch1[(s1L + s2L) + 1] = ch;

		for (int i = s2L, j = 0; i < (s1L + s2L); i++, j++) {
			ch2[i] = ch1[j];
		}
		ch2[(s1L + s2L) + 1] = ch;

		for (int i = 0; i < s1L; i++) {
			for (int j = 0; j < (s1L + s2L); j++) {
				ch1[j] = ch1[j + 1];
			}
		}
		for (int i = 0; i < s2L; i++) {
			for (int j = 0; j < (s1L + s2L); j++) {
				ch2[j] = ch2[j + 1];
			}
		}
		s1 = new String(ch1);
		s2 = new String(ch2);

		System.out.println("After swaping");
		System.out.println("s1 " + s1);
		System.out.println("s2 " + s2);
	}
}
