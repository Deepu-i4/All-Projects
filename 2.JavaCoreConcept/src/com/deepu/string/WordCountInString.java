package com.deepu.string;

import java.util.HashMap;
import java.util.Set;

public class WordCountInString {

	public static void main(String[] args) {
		String sentence = "Radhika is Radhika";
		String[] words = sentence.split(" ");
		HashMap<String, Integer> wordDuplicateCount = new HashMap<String, Integer>();
		for (String word : words) {
			if (wordDuplicateCount.containsKey(word)) {
				wordDuplicateCount.put(word, wordDuplicateCount.get(word) + 1);
			} else {
				wordDuplicateCount.put(word, 1);
			}
		}
		Set<String> keySet = wordDuplicateCount.keySet();
		for (String str : keySet) {
			if (wordDuplicateCount.get(str) > 1) {
				System.out.println(str + " count is " + wordDuplicateCount.get(str));
			}
		}

	}
}
