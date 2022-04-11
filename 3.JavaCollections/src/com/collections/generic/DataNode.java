package com.collections.generic;

public class DataNode<E> {
	private E data;
	//private DataNode<E> next;
	private DataNode<? extends Number> next;

	/*
	 * public DataNode(E data, DataNode<E> next) { super(); this.data = data;
	 * this.next = next; }
	 */
	
	public DataNode(E data, DataNode<? extends Number> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/*
	 * public DataNode<E> getNext() { return next; }
	 */
	
	public DataNode<?> getNext() {
		return next;
	}

	public void setNext(DataNode<? extends Number> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "DataNode [data=" + data + ", next=" + next + "]";
	}

}
