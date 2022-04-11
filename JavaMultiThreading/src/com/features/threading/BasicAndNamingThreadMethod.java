package com.features.threading;

public class BasicAndNamingThreadMethod extends Thread {

	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("Pushpendra Main");
		System.out.println(Thread.currentThread().getName());
		// System.out.println(10 / 0); //Exception in thread "Pushpendra Main"
		// java.lang.ArithmeticException: / by zero
		System.out.println(Thread.currentThread().isAlive());

		BasicAndNamingThreadMethod bnTm = new BasicAndNamingThreadMethod();
		bnTm.setName("Smart Programming");
		bnTm.start();
		System.out.println(bnTm.isAlive());

	}
}
