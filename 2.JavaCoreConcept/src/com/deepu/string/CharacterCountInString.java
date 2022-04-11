package com.deepu.string;

import java.util.HashMap;

public class CharacterCountInString {

	public static void main(String[] args) {
		String str = "jjujjuuddd";
		System.out.println(findDuplicateCount(str));
		System.out.println(findDuplicateCountUsingHashMap(str));
	}

	// best
	static HashMap<Character, Integer> findDuplicateCountUsingHashMap(String str) {
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for (Character character : str.toCharArray()) {
			if (charCountMap.containsKey(character)) {
				charCountMap.put(character, charCountMap.get(character) + 1);
			} else {
				charCountMap.put(character, 1);
			}
		}
		return charCountMap;
	}

	// O(n2)
	private static HashMap<Character, Integer> findDuplicateCount(String str) {
		HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
		int count;
		char[] strArray = str.toCharArray();
		for (int i = 0; i < strArray.length; i++) {
			count = 0;
			for (int j = 0; j < strArray.length; j++) {
				if (strArray[i] == strArray[j]) {
					count++;
				}
			}
			charCount.put(strArray[i], count);
		}
		return charCount;
	}

	static int i, j, k, c = 0, w;

	static char m; // we can only define static for variables and fns not for arrays

	static void frequencycount(String s) {
		// first store in character array
		char[] z = new char[s.length()];
		for (w = 0; w < s.length(); w++)
			z[w] = s.charAt(w);

		for (i = 0; i < w; i++) {
			char ch = z[i];
			for (j = i + 1; j < w; j++) {
				if (z[j] == ch) {
					for (k = j; k < (w - 1); k++)
						z[k] = z[k + 1];
					w--;
					j = i;
				}
			}
		}
		int[] t = new int[w];
		for (i = 0; i < w; i++) {
			for (j = 0, c = 0; j < s.length(); j++) {
				if (z[i] == s.charAt(j))
					c++;
			}
			t[i] = c;
			System.out.print(z[i] + "=" + c + ",");
		}
	}
}