package com.learnJava.defaults;

import java.util.List;

/**
 * 
 * @author Deepu Verma
 *
 */
public interface Multiplier {

	int multiply(List<Integer> integerList);

	default int size(List<Integer> integerList) {
		System.out.println("Inside interface");
		return integerList.size();
	}

	static boolean isEmpty(List<Integer> integerList) {

		return integerList != null && integerList.size() == 0;
	}
};
