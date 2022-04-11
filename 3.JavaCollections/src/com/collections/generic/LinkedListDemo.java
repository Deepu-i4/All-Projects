package com.collections.generic;

public class LinkedListDemo {

	public static void main(String[] args) {
		DataNode<Integer> node2 = new DataNode<Integer>(20, null);
		DataNode<Integer> node1 = new DataNode<Integer>(20, node2);
		
		System.out.println(node1.toString());
		
		DataNode<Double> node22 = new DataNode<Double>(20.9, null);
		DataNode<Double> node11 = new DataNode<Double>(20.7, node22);
		
		//Error now
		//DataNode<Double> node111 = new DataNode<Double>(20.7, node2);
		DataNode<Number> node1112 = new DataNode<>(Double.valueOf(20.7), null);
		
		//Error now
		DataNode<Integer> node111 = new DataNode<Integer>(20, node1112);

	}

}
