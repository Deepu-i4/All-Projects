package com.collections.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {

		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
		map.put(0, "Basics");
		map.put(1, "Strong");
		map.put(0, "Tech");
		System.out.println("ConcurrentHashMap:-" + map);
		// map.remove(1);

		// Methods of Concurrent Map

		// V putIfAbsent(K key, V value);
		map.putIfAbsent(0, "Hello");
		System.out.println("putIfAbsent:-" + map);

		// boolean remove(Object key, Object value);
		// necessary key is associate with value then only it will be removed.
		map.remove(1, "Strong");
		System.out.println("remove:-" + map);

		// boolean replace(K key, V oldValue, V newValue);
		map.replace(0, "Wrong", "Know");
		System.out.println("replace:- " + map);

		// V replace(K key, V value);
		// java 1.8 version
		map.replace(0, "BasicsStrong");
		// return the old value and replace with new value.
		// System.out.println(map.replace(0,"BasicsStrong"));
		System.out.println("replace" + map);
		// System.out.println(map.replace(3,"BasicsStrong"));

	}
}
