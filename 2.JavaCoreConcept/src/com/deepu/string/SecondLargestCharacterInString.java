package com.deepu.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SecondLargestCharacterInString {

	public static void main(String[] args) {
		HashMap<Character, Integer> charCountMap = findDuplicateCountUsingHashMap("jjjjuuddd");
		myway(charCountMap);

		System.out.println(getSecondMostFreq("geeksforgeeks"));

	}

	private static void myway(HashMap<Character, Integer> charCountMap) {
		Set<Character> keySet = charCountMap.keySet();
		int largest = 0;
		int secondLargest = 0;
		for (Character ch : keySet) {
			if (charCountMap.get(ch) > largest) {
				secondLargest = largest;
				largest = charCountMap.get(ch);
			} else if (charCountMap.get(ch) > secondLargest) {
				secondLargest = charCountMap.get(ch);
			}
		}
		System.out.println("SecondLargest character is " + getKeyFromValue(charCountMap, secondLargest)
				+ " and occurence " + secondLargest);
	}

	private static HashMap<Character, Integer> findDuplicateCountUsingHashMap(String str) {
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

	public static Object getKeyFromValue(Map hm, Object value) {
		for (Object o : hm.keySet()) {
			if (hm.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}

	// optimum way
	public static char getSecondMostFreq(String str) {
		final int NO_OF_CHARS = 256;

		// count number of occurrences of every
		// character.
		int[] count = new int[NO_OF_CHARS];
		int i;
		for (i = 0; i < str.length(); i++)
			(count[str.charAt(i)])++;
		
		for (int j = 0; j < count.length; j++) {
			System.out.println(j);
		}
		

		// Traverse through the count[] and find
		// second highest element.
		int first = 0, second = 0;
		for (i = 0; i < NO_OF_CHARS; i++) {
			/*
			 * If current element is smaller than first then update both first and second
			 */
			if (count[i] > count[first]) {
				second = first;
				first = i;
			}

			/*
			 * If count[i] is in between first and second then update second
			 */
			else if (count[i] > count[second] && count[i] != count[first])
				second = i;
		}

		return (char) second;
	}
}
