package com.deepu.string;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Counters {

	public static void main(String[] args) {

		if (false) {
			ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
			map.put("as", "asd");
			map.put("pas", "pasd");
			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {

				System.out.println(map.get(it.next()));
				map.put("ras", "gdhd");

			}

			CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<String>();
			al.add("string");
			al.add("string1");
			al.add("string1");

			ListIterator<String> itr = al.listIterator();

			while (itr.hasNext()) {

				System.out.println(itr.next());
				itr.set("sadad");
				itr.add("sds");
			}

		}

		String str = "one two three two three three two";
		String[] sArr = str.split(" ");

		if (false) {
			HashMap<String, MutableInteger> countmap = new HashMap<String, MutableInteger>();
			for (String a : sArr) {
				if (countmap.containsKey(a)) {
					MutableInteger oldValue = countmap.get(a);
					oldValue.setCount(oldValue.getCount() + 1);
				} else {
					countmap.put(a, new MutableInteger(1));
				}
			}
			System.out.println(countmap);

		}
		// efficent one
		if (true) {
			HashMap<String, MutableInteger> countmap = new HashMap<String, MutableInteger>();
			for (String a : sArr) {
				MutableInteger intvalue = new MutableInteger(1);
				MutableInteger oldvalue = countmap.put(a, intvalue);
				if (oldvalue != null) {
					intvalue.setCount(oldvalue.getCount()+1);
				}
			}
			System.out.println(countmap);
		}
		
		if (true) {
			HashMap<String, AtomicInteger> countmap = new HashMap<String, AtomicInteger>();
			for (String a : sArr) {
				AtomicInteger intvalue = new AtomicInteger(1);
				AtomicInteger oldvalue = countmap.put(a, intvalue);
				if (oldvalue != null) {
					intvalue.set(oldvalue.get()+1);
				}
			}
			System.out.println(countmap);
		}
		

		if (true) {
			HashMap<String, int[]> countmap = new HashMap<String, int[]>();
			for (String a : sArr) {
				int[] oldvalue = countmap.put(a, new int[] {1});
				if (oldvalue != null) {
					oldvalue[0]++;
				}
			}
			System.out.println(countmap);
		}
	

	}

}

class MutableInteger {
	private int count;

	public MutableInteger(int count) {
		super();
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return Integer.toString(count);
	}

}
