package com.features.threading;

//Output may be different in execution
public class PriorityTest extends Thread {

	public PriorityTest(String string) {
		super(string);
	}

	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		System.out.println("Child Thread Priority " + Thread.currentThread().getPriority());
	}

	public static void main(String[] args) {
		System.out.println("Main Thread Priority " + Thread.currentThread().getPriority());

		PriorityTest yieldTest = new PriorityTest("Smart Programming");
		yieldTest.start();
		//yieldTest.setPriority(10);
		for (int i = 0; i <= 5; i++) {
			System.out.println("Main Thread " + i);
		}
	}
}
