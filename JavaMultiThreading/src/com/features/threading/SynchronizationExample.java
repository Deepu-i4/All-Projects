package com.features.threading;

class Temp {
	int x;
	int y;

	public int multiply(int a, int b) {
		x = a;
		y = b;
		return x * y;
	}
}

class Sum {
	int x;
	int y;

	public int sum(int a, int b) {
		x = a;
		y = b;
		int s = 0;
		// synchronizing current class object
		synchronized (this) {
			s = x + y;
		}
		return s;
	}

	public int multiply(int a, int b) {
		Temp temp = new Temp();
		int mul = 0;
		// synchronizing other class object
		// synchronized (temp) {
		mul = temp.multiply(a, b);
		// }
		return mul;
	}
}

public class SynchronizationExample {
	public static void main(String[] args) {
		// getSum();
		getMultiplication();
	}

	private static void getSum() {
		Sum sum = new Sum();
		Runnable r1 = () -> System.out.println("r1:- " + sum.sum(10, 20));
		Runnable r2 = () -> System.out.println("r2:- " + sum.sum(100, 200));
		Runnable r3 = () -> System.out.println("r3:- " + sum.sum(1000, 2000));
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
	}

	private static void getMultiplication() {
		Sum sum = new Sum();
		Runnable r1 = () -> System.out.println("r1:- " + sum.multiply(1000, 20));
		Runnable r2 = () -> System.out.println("r2:- " + sum.multiply(1000, 200));
		Runnable r3 = () -> System.out.println("r3:- " + sum.multiply(1000, 2000));
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
	}
}
