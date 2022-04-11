package com.deepu.string;

import java.util.ArrayList;
import java.util.List;

public class StringPalindrome {

	public static void main(String[] args) {
		ArrayList<E>
		simpleway("madam");

		// Second way evaluated in half looping only. Best Approach.
		usingPointer("madam");

		// Third way using recursive method.
		usingRecursion("madam");
	}

	private static void simpleway(String original) {
		String reverse = "";
		for (int i = original.length() - 1; i >= 0; i--) {
			reverse = reverse + original.charAt(i);
		}
		String str = original.equals(reverse) ? " is a palindrome." : " isn't a palindrome.";
		System.out.println(original + str);
	}

	private static void usingPointer(String inputString) {
		int begin = 0;
		int end = inputString.length() - 1;
		while (begin < end) {
			if (inputString.charAt(begin) == inputString.charAt(end)) {
				begin++;
				end--;
			}
		}
		if (begin == end) {
			System.out.println(inputString + " is Palindrome");
		} else {
			System.out.println(inputString + " is not Palindrome");
		}
	}

	// not used
	private static void oldUsingPointer(String inputString) {
		int length = inputString.length();
		int i, begin, end, middle;
		begin = 0;
		end = length - 1;
		middle = (begin + end) / 2;

		for (i = begin; i <= middle; i++) {
			if (inputString.charAt(begin) == inputString.charAt(end)) {
				begin++;
				end--;
			} else {
				break;
			}
		}
		if (i == middle + 1) {
			System.out.println(" Palindrome");
		} else {
			System.out.println(" Not a palindrome");
		}
	}

	private static void usingRecursion(String inputStr) {
		String outputString = inputStr.equals(reverse(inputStr)) ? inputStr + " is a palindrome."
				: inputStr + " isn't a palindrome.";
		System.out.println(outputString);
	}

	public static String reverse(String inputStr) {
		if ((null == inputStr) || (inputStr.length() < 1)) {
			return inputStr;
		}
		return reverse(inputStr.substring(1)) + inputStr.charAt(0);
	}

}
