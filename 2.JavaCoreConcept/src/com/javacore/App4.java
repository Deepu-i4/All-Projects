package com.javacore;

public class App4 {

	 void show() {

	}

	public static void main(String[] args) {
		System.out.println(Hello.a);
	}
}
class Hello extends App4 {
	void show() {

	}

	static {
		System.out.println("static" + Hello.a);
	}

	{
		System.out.println("asdasd");
	}

	static int a = 10;

}