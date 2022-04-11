package com.features.threading;

// Problem 1 :- Another Thread has to resume suspended Thread. which is possible if Thread calling method is not synchronized 
// Problem 2:-  If both method is synchronized then thread will never get change to call resume() for Thread1 and It will be the condition of Deadlock then.
class WithDrawThread extends Thread {
	private Shared1 shared;

	public WithDrawThread(Shared1 s1, String s2) {
		super(s2);
		this.shared = s1;
		start();
	}

	public void run() {
		System.out.println("Withdraw amount " + shared.withDraw(this));
	}

}

class SubmitThread extends Thread {
	private Shared1 shared;
	WithDrawThread withDrawThread;

	public SubmitThread(Shared1 s1, String s2, WithDrawThread withDrawThread) {
		super(s2);
		this.shared = s1;
		this.withDrawThread = withDrawThread;
		start();
	}

	public void run() {
		shared.submit(withDrawThread, this);
	}
}

class Shared1 {
	int flag;
	int data = 0;

	public synchronized int withDraw(WithDrawThread withDrawThread) {
		if (flag == 0) {
			System.out.println("Suspend block No Money " + withDrawThread.getName());
			withDrawThread.suspend(); // Thread1 will leave the processor cycle here and but not the lock of the
										// object
		}
		System.out.println("Back suspend block " + withDrawThread.getName());
		return data;
	}

	public void submit(WithDrawThread withDrawThread, SubmitThread submitThread) {
		// public synchronized void submit(WithDrawThread withDrawThread, SubmitThread
		// submitThread) {
		flag = 1;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		data = 10;
		System.out.println("Amount Submitted " + withDrawThread.getName());
		withDrawThread.resume(); // Another Thread has to resume suspended Thread. This is the Problem
	}

}

public class PromWithSuspendAndResume {
	public static void main(String[] args) {
		Shared1 shared = new Shared1();
		WithDrawThread t3 = new WithDrawThread(shared, "WithDrawThread");
		SubmitThread t4 = new SubmitThread(shared, "SubmitThread", t3);
	}
}
