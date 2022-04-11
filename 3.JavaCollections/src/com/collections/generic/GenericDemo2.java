package com.collections.generic;

import java.util.ArrayList;
import java.util.List;

class Bin<T1, T2> {
	private T1 drySet;
	private T2 wetSet;

	public T1 getDrySet() {
		return drySet;
	}

	public void setDrySet(T1 drySet) {
		this.drySet = drySet;
	}

	public T2 getWetSet() {
		return wetSet;
	}

	public void setWetSet(T2 wetSet) {
		this.wetSet = wetSet;
	}

	@Override
	public String toString() {
		return "Bin [drySet=" + drySet + ", wetSet=" + wetSet + "]";
	}

	
}


class Box<T>{
	
}

class SuperBox<T> extends Box<T>{
	
}
public class GenericDemo2 {

	public static void main(String[] args) {

		// Multiple type argument
		Bin<String, Integer> bin = new Bin();
		bin.setDrySet("dry");
		bin.setWetSet(2432);
		System.out.println(bin);
		
		
		// Sub Typeing
		List<Box<Integer>> li = new ArrayList<>();
		li.add(new Box());
		li.add(new SuperBox()); // allowed
		
		// not allowed
		//List<Number> list = new ArrayList<Integer>();
		
		// not allowed
		//ArrayList<Number> list1 = new ArrayList<Integer>();
		
		// allowed
		List<Integer> list = new ArrayList<Integer>();
		
	}

}
