package com.collections.generic;

import java.util.ArrayList;
import java.util.List;

public class WildCardDemo {
	
	//generic method
	public static <T> void displayData(List<T> list) {
		for(T t:list) {
			System.out.println(t);
		}
	}
	
	// unbounded wildcard
	public static <T> void displayData1(List<?> list) {
		for(Object t:list) {
			System.out.println(t);
		}
	}
	
	//lower wilrd card
	public static <T> void displayData2(List<? super Integer> list) {
		for(Object t:list) {
			System.out.println(t);
		}
	}
	
	//lower wilrd card
	public static <T> void displayData3(List<? super Number> list) {
		for(Object t:list) {
			System.out.println(t);
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(34);
		list.add(24);
		
		displayData(list);
		
		displayData1(list);
		
		displayData2(list);
		
		List<Number> list1 = new ArrayList<>();
		list.add(34);
		list.add(24);
		displayData2(list1); // you can pass Number is super of Integer
		
		//displayData3(list); // Integer is not super type of number thats why error.
	}

}
