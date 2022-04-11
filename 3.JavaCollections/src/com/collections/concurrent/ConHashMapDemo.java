package com.collections.concurrent;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConHashMapDemo extends Thread {

	static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();

	public static void main(String[] args) {
		ConHashMapDemo tChild = new ConHashMapDemo();
		map.put(1, "John");
		map.put(2, "Rohn");
		map.put(3, "Tom");
		map.put(4, "Shiva");
		tChild.start();

		Set<Entry<Integer, String>> entrySet = map.entrySet();

		Iterator<Entry<Integer, String>> itr = entrySet.iterator();

		while (itr.hasNext()) {
			Entry<Integer, String> entry = itr.next();
			System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(5, "Ganesha");

	}
}
