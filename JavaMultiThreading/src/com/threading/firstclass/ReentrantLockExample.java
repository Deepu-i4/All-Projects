package com.threading.firstclass;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReentrantLock {

	private int x;

	// ReadWriteLock object for requesting the lock.
	ReadWriteLock rw_lock = new ReentrantReadWriteLock();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void incr() {

		// Request the write lock as the
		// operation is intended to modify the data.

		Lock lock = rw_lock.writeLock();
		lock.lock();

		try {

			int y = getX();
			y++;

			// Just for simulation
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}

			setX(y);

		} finally {
			// Unlock
			lock.unlock();
		}
	}

}

class MyThread1 extends Thread {

	ReentrantLock obj;

	public MyThread1(ReentrantLock obj) {
		this.obj = obj;
	}

	public void run() {
		obj.incr();
	}
}

public class ReentrantLockExample {

	public static void main(String[] args) {

		ReentrantLock obj = new ReentrantLock();
		obj.setX(10);

		MyThread1 t1 = new MyThread1(obj);
		MyThread1 t2 = new MyThread1(obj);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(obj.getX());
	}
}
