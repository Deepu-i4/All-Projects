package com.deepu.string;

import java.util.Map;
import java.util.Set;

public class PrintDuplicateCharInString {

	public static void main(String[] args) {
		printDuplicateCharactersUsingHashMap("Programming");
	}

	public static void printDuplicateCharactersUsingHashMap(String source) {
		Map<Character, Integer> sourceMap = CharacterCountInString.findDuplicateCountUsingHashMap(source);
		Set<Character> keys = sourceMap.keySet();
		for (Character ch : keys) {
			if (sourceMap.get(ch) > 1) {
				System.out.println(ch + "\t" + sourceMap.get(ch));
			}
		}
	}

}
