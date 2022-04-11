package com.collections.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ErasureDemo {

	public static void main(String[] args) {
		//System.out.println(method1(new Integer(10)));
		
		ArrayList li = new ArrayList<String>();
		li.add(10);
		li.add(true);
		System.out.println(li);
	}
	
	public static String method1(Integer x) {
		List<String> a = new LinkedList<String>();
		List b = a;
		b.add(x);
		return a.iterator().next();
	}

}
