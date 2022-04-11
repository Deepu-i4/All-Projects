package com.features.threading;

class Thread1 extends Thread {
	private Shared shared;

	public Thread1(Shared s1, String s2) {
		super(s2);
		this.shared = s1;
		start();
	}

	public void run() {
		System.out.println("Withdraw amount " + shared.withDraw());
	}
}

class Thread2 extends Thread {
	private Shared shared;

	public Thread2(Shared s1, String s2) {
		super(s2);
		this.shared = s1;
		start();
	}

	public void run() {
		shared.submit();
	}
}

class Shared {
	int flag;
	int data = 0;

	public synchronized int withDraw() {
		if (flag == 0) {
			try {
				System.out.println("Wait block No Money");
				wait(); // Thread1 will leave the processor cycle here and lock of the object
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Back wait block");
		return data;
	}

	public synchronized void submit() {
		flag = 1;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		data = 10;
		System.out.println("Amount Submitted");
		notify(); // Thread 2 will notify Thread 1 to take the processor cycle and lock to
					// continue their part.
	}

}

public class WaitNotifyExample {
	public static void main(String[] args) {
		Shared shared = new Shared();
		Thread t1 = new Thread1(shared, "Thread One");
		Thread t2 = new Thread2(shared, "Thread Two");
	}
}
