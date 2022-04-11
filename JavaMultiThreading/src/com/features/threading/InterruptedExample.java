package com.features.threading;

public class InterruptedExample extends Thread {

	public InterruptedExample(String string) {
		super(string);
	}

	public void run() {
		System.out.println("A:- " + Thread.interrupted()); // true--> false
		// System.out.println("isInterrupted "+Thread.currentThread().isInterrupted());
		// System.out.println("isInterrupted "+Thread.currentThread().isInterrupted());
		try {
			for (int i = 0; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
				Thread.sleep(1000);
				System.out.println("C:- " + Thread.interrupted());
			}
		} catch (InterruptedException e) {
			System.out.println("Thread Interrupted " + e);
		}
	}

	public static void main(String[] args) {
		InterruptedExample interruptExample = new InterruptedExample("Aish");
		interruptExample.start();
		interruptExample.interrupt();
	}
}
