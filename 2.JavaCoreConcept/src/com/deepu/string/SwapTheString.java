package com.deepu.string;

public class SwapTheString {
	public static void main(String[] args) {
		String s1 = "Ram";
		String s2 = "Mishra";
		System.out.println("before s1 " + s1);
		System.out.println("before s2 " + s2);
		int s1L = s1.length();
		int s2L = s2.length();
		System.out.println("---------------------------");
		s1 = s1 + s2;
		s2 = s1 + s2;
		s1 = s1.substring(s1L, s1.length());
		System.out.println("After swaping s1 " + s1);
		s2 = s2.substring(0, s1L);
		System.out.println("After swaping s2 " + s2);

	}
}
