package com.features.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Deepu Verma Use Case :- Remove duplicate from list.
 */
public class ImperativeVsDeclarative2 {

	public static void main(String[] args) {
		List<Integer> integerList = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9);

		/**
		 * Imperative Approach
		 */

		List<Integer> uniqueList = new ArrayList<Integer>();
		for (Integer integer : integerList) {
			if (!uniqueList.contains(integer)) {
				uniqueList.add(integer);
			}
		}
		System.out.println("Unique List using Imperative Approach " + uniqueList);

		/**
		 * Declarative Approach
		 */
		List<Integer> uniqueList1 = integerList.stream().distinct().collect(Collectors.toList());
		System.out.println("Unique List using Declarative Approach " + uniqueList1);
	}
}
