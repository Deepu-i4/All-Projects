package com.collections.generic;

/*class Data {
	private Object data;

	public Data(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "data is :- " + data;
	}
}*/

class Data<T> {
	private T data;

	public Data(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "data is :- " + data;
	}
}

public class GenericDemo {

	public static void main(String[] args) {
		//classCastException();
		//compileTimeError();
		
		IData<String> d3 = new EData<>("Generic interface");
		System.out.println(d3.toString());

	}

	private static void classCastException() {
		Data data1 = new Data("THIS IS DATA");
		System.out.println(data1.getData());
		Data data2 = new Data(10);
		int i = (int) data1.getData();
		System.out.println(i);
	}
	
	private static void compileTimeError() {
		Data<String> data1 = new Data<>("THIS IS DATA");
		System.out.println(data1.getData());
		Data<Integer> data2 = new Data(10);
		//int i = (int) data1.getData();
		//System.out.println(i);
	}

}
