package com.features.threading;

//Output may be different in execution
public class YieldTest extends Thread {

	public void run() {
		Thread.yield();
		for (int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		YieldTest yieldTest = new YieldTest();
		yieldTest.start();
		// Thread.yield();
		for (int i = 0; i <= 5; i++) {
			System.out.println("Main Thread " + i);
		}
	}
}
