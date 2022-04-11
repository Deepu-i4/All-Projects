package com.deepu.array;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* */
public class RemoveDuplicatesFromArrayList {

	public static void main(String args[]) {
		List<String> sourceList = new ArrayList<String>();
		sourceList.add("kishan");
		sourceList.add("kishan");
		sourceList.add("kishan");
		sourceList.add("deepu");
		sourceList.add("sumit");
		sourceList.add("deepu");

		System.out.println("Before removeDuplicateUsingSet() " + sourceList);
		List<String> clearList = removeDuplicateUsingSet(sourceList);
		System.out.println("After removeDuplicateUsingSet() " + clearList);

		System.out.println("Before removeDuplicateUsingLinkedHashSet() " + sourceList);
		clearList = removeDuplicateUsingLinkedHashSet(sourceList);
		System.out.println("After removeDuplicateUsingLinkedHashSet() " + clearList);

		System.out.println("Before removeDuplicate() " + sourceList);
		clearList = removeDuplicate(sourceList);
		System.out.println("After removeDuplicate() " + clearList);

	}

	public static List<String> removeDuplicateUsingSet(List<String> souceList) {
		Set<String> souceset = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		souceset.addAll(souceList);
		return new ArrayList<String>(souceset);
	}

	public static List<String> removeDuplicateUsingLinkedHashSet(List<String> souceList) {
		return new ArrayList<String>(new LinkedHashSet<String>(souceList));
	}

	public static List<String> removeDuplicate(List<String> sourceList) {
		for (int i = 0; i < sourceList.size(); i++) {
			for (int j = i + 1; j < sourceList.size(); j++) {
				if (sourceList.get(i).equalsIgnoreCase(sourceList.get(j))) {
					sourceList.remove(j);
					j--;
				}
			}

		}
		return sourceList;
	}

}
