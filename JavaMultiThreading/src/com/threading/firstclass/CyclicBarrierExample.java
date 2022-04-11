package com.threading.firstclass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class A extends Thread {
	CyclicBarrier barrier;

	public A(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	public void run() {
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("A begins....");
	}
}

class B extends Thread {
	CyclicBarrier barrier;

	public B(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	public void run() {
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("B begins....");
	}
}

public class CyclicBarrierExample {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(2);
		new A(barrier).start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new B(barrier).start();
	}

}
