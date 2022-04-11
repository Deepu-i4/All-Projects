package com.deepu.string;

public class ReverseString {

	public static void main(String args[]) {

		// quick easy to reverse String in Java - Use StringBuffer
		String word = "HelloWorld";
		String reverse = new StringBuffer(word).reverse().toString();
		System.out.printf(" original String : %s , reversed String %s  %n", word, reverse);

		word = "Band";
		reverse = reverse(word);
		System.out.printf(" original String : %s , reversed String %s %n", word, reverse);

		word = "Push";
		reverse = reverseRecursive(word);
		System.out.printf(" original String : %s , reversed String %s %n", word, reverse);

	}

	// best
	public static String reverseRecursive(String source) {
		if ((null == source) || (source.length() < 1)) {
			return source;
		}
		return reverseRecursive(source.substring(1)) + source.charAt(0);
	}

	public static String reverse2(String source) {
		char ch[] = source.toCharArray();
		String reverse = "";
		for (int i = ch.length - 1; i >= 0; i--) {
			reverse = reverse + ch[i];
		}
		return reverse;
	}

	public static String reverse(String source) {
		if (source == null || source.isEmpty()) {
			return source;
		}
		String reverse = "";
		for (int i = source.length() - 1; i >= 0; i--) {
			reverse = reverse + source.charAt(i);
		}

		return reverse;
	}

}
