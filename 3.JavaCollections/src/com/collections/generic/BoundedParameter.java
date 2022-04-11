package com.collections.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class DataSorter<T extends Number> {
	private List<T> list;

	public DataSorter(List<T> list) {
		this.list = list;
	}

	public void getSortedData() {
		list.sort(null); // deafult sorting
		for (T t : list) {
			System.out.println(t);
		}
	}
}

public class BoundedParameter {
	
	public static <T extends Number> void getSortedData(List<T> list) {
		list.sort(null); // 
		for (T t : list) {
			System.out.println(t);
		}
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(new Integer[] { 2, 56, 23, 732, 4 });
		List<String> slist = Arrays.asList(new String[] { "as", "fd", "add", "d", "sd" });
		List<Double> dlist = Arrays.asList(new Double[] { 4.5, 3.4 ,1.1});
		DataSorter<Integer> sortInteger = new DataSorter(list);
		sortInteger.getSortedData();
		DataSorter<Double> sortDouble = new DataSorter(dlist);
		sortDouble.getSortedData();
		//DataSorter<String> sortString = new DataSorter(slist);
		//sortString.getSortedData();
		
		//Instead of using DataSorter Class use Generic method.
		getSortedData(dlist);
		getSortedData(list);
		
		CBound bound = new CBound();
		getSortedData1(bound);

	}
	
	public static <T extends IBound1 &IBound2> void getSortedData1(T list) {
	}

}


interface IBound1{}
interface IBound2{}
class CBound implements IBound1,IBound2{}