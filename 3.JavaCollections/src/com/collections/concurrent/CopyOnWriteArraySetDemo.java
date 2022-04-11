package com.collections.concurrent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo  extends Thread {

	//static HashSet<String> set = new HashSet<String>();
	// first constructor
	static CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
	public static void main(String[] args) {
		set.add("Basics");
		set.add("Basics");
		set.add("Strong");
		set.add("Strong");

		// second constructor
		CopyOnWriteArraySet<String> set1 = new CopyOnWriteArraySet<>(set);
		System.out.println(set1);
		
		CopyOnWriteArraySetDemo object = new CopyOnWriteArraySetDemo();
		object.run();
		
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String name = (String) itr.next();
			if (name.equals("Strong")) {
				// itr.remove();
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(set);

	}
	
	public void run() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		set.add("Ganesh");
	}
}
