package com.deepu.firstlevel;

/**
 * Java program to check if number is palindrome or not. A number is called
 * palindrome if number and its reverse is equal This Java program can also be
 * used to reverse a number in Java
 */
public class NumberPalindrome {

	public static void main(String args[]) {

		System.out.println(isPalindrome(121) ? "Number : " + 121 + " is a palindrome"
				: "Number : " + 121 + " is not a palindrome");
	}

	public static boolean isPalindrome(int number) {
		int palindrome = number; // copied number into variable
		int reverse = 0;

		while (palindrome != 0) {
			int remainder = palindrome % 10;
			reverse = reverse * 10 + remainder;
			palindrome = palindrome / 10;
		}
		if (number == reverse) {
			return true;
		}
		return false;
	}

}