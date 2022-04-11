package com.collections.generic;

import java.util.List;

public class GenericMethod {
	
	/*
	 * private List data;
	 * 
	 * public <T> GenericMethod(List<T> data) { this.data = data; }
	 */

	public <T> String concat(T data) {
		return "Data is :-"+data;
	}
	
	public static void main(String[] args) {
		System.out.println(new GenericMethod().concat("Pushpendra"));
		System.out.println(new GenericMethod().concat(123));
	}
}
