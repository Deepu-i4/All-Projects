package com.features.threading;

//Output may be different in execution
public class SleepTest extends Thread {

	public SleepTest(String string) {
		super(string);
	}

	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SleepTest yieldTest = new SleepTest("Smart Programming");
		yieldTest.start();
		for (int i = 0; i <= 5; i++) {
			//Thread.currentThread().sleep(-100);
			//Thread.currentThread().sleep(1000,-10);
			//Thread.currentThread().sleep(1000,9999999);
			Thread.currentThread().sleep(1000*2,999999);
			System.out.println("Main Thread " + i);
		}
	}
}
