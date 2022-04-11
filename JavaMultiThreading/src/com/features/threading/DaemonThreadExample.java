package com.features.threading;

public class DaemonThreadExample extends Thread {

	public DaemonThreadExample(String string) {
		super(string);
	}

	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		System.out.println("Daemon Thread " + Thread.currentThread().isDaemon());
	}

	public static void main(String[] args) {
		// just to check Main Thread or Daemon or not.
		if (Thread.currentThread().isDaemon()) {
			System.out.println("Main Thread is Daemon Thread");
		} else {
			System.out.println("Main Thread is not Daemon Thread");
		}
		DaemonThreadExample daemon = new DaemonThreadExample("Daemon Thread ");
		daemon.setDaemon(true);
		daemon.start();
	}
}
