package com.threading.firstclass;

import java.util.concurrent.Semaphore;

class PrintThread extends Thread {

	int id;
	Semaphore semaphore;

	public PrintThread(int id, Semaphore semaphore) {
		super();
		this.id = id;
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			semaphore.acquire();
			System.out.println("Printing " + id);
			Thread.sleep(1000);
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

public class SemaphoreExample {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(2);
		for (int i = 1; i <= 6; i++) {
			new PrintThread(i, semaphore).start();
		}
	}

}
