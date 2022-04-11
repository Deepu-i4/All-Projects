package com.collections.generic;

import java.util.ArrayList;

public class Behaviour {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("push");
		list.add("string");
		callNonGeneric(list);
		System.out.println(list);
	}

	private static void callNonGeneric(ArrayList list) {
		list.add(10);
		list.add(true);
	}

}
