package com.features.threading;

public class InterruptExample extends Thread {

	public void run() {
		try {
			for (int i = 0; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread Interrupted " + e);
		}
	}

	public static void main(String[] args) {
		InterruptExample interruptExample = new InterruptExample();
		interruptExample.start();
		interruptExample.interrupt();
	}
}
