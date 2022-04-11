package com.collections.generic;

public interface IData<T> {

	public T getData();
	
	public void setData(T data);
	
}

class EData<T> implements IData<T>{
	private T data;

	public EData(T data) {
		this.data = data;
	}

	
	@Override
	public String toString() {
		return "data is :- " + data;
	}


	@Override
	public T getData() {
		return data;
	}


	@Override
	public void setData(T data) {
		this.data = data;
	}
}
