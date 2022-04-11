package com.collections.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo extends Thread {

	//static ArrayList<String> list = new ArrayList<String>();
	static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

	public static void main(String[] args) {

		list.add("John");
		list.add("Rohn");
		list.add("Harry");
		list.add("Potter");

		CopyOnWriteArrayListDemo classObject = new CopyOnWriteArrayListDemo();
		classObject.start();

		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			String name = (String) itr.next();
			if (name.equals("Harry")) {
				// itr.remove();
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(list);

	}

	public void run() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.add("Ganesh");
	}
}
