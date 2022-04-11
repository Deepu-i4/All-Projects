package com.features.threading;

//Example to use interrupted method instead of stop method:- 
//here we requesting another thread5 to stop working for the time thread6 finish our job
class Thread5 extends Thread {

	public void run() {
		boolean isInterrupted = Thread.currentThread().isInterrupted();
		System.out.println(getName() + " isInterrupt " + isInterrupted);
		try {
			for (int i = 0; i <= 5; i++) {
				System.out.println(getName() + " " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread Interrupted " + e);
		}
	}

}

class Thread6 extends Thread {
	Thread5 t5;

	public Thread6(String s2, Thread5 t5) {
		super(s2);
		this.t5 = t5;
		start();
	}

	public void run() {
		//t5.stop();
		System.out.println("Starting working with" + " " + getName());
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(getName() + " " + i);
			} catch (InterruptedException e) {
			}
		}
		System.out.println(getName() + " Dead");
	}
}

public class InterruptedExceptionExample {
	public static void main(String[] args) {
		Thread5 t5 = new Thread5();
		t5.start();
		//t5.interrupt();
		new Thread6("Thread 6", t5);
	}
}
