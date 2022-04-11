package com.java8.features.lambdafunctionalinterface;

public class ThreadDemoRunnable {

	public static void main(String[] args) {
		
		Runnable runnable = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Child thread");
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main thread");
		}

		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Child 2 thread");
			}
		});
		thread1.start();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Child 3 thread");
			}
		}).start();
	}
}
