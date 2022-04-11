package com.threading.firstclass;

/**
 * Thread Synchronization Thread synchronization is used to solve concurrency
 * problems that exist in parallel processing. Concurrency problem exist when
 * more than one thread is accessing the same shared resource.
 * 
 * E.g.
 * 
 * 1) More than one transaction is being performed on the same account
 * 
 * 2) Multiple resources are booking tickets for the same train from different
 * locations.
 * 
 * etc.
 * 
 * Synchronization in Java Threads It can be achieved through
 * 
 * 1) Synchronized methods
 * 
 * 2) Synchronized block
 * 
 * 3) Locks discussed later.
 * 
 * synchronized method Consider the class Sample
 * 
 * class Sample { synchronized void f() {...} } Consider Three threads T1, T2,
 * T3 and two objects for Sample they are A,B.
 * 
 * T1 ..........A.f(); locks A and proceeds
 * 
 * T2 ..........B.f(); locks B and proceeds
 * 
 * T3 ..........A.f(); wait till T1 unlocks A.
 * 
 * To run a synchronized method object must be locked.
 * 
 * synchronized block When synchronization is not required for the entire method
 * i.e only certain part of the code must be synchronized then we use
 * synchronized block.
 * 
 * synchronized( object ) { // operations over the object } The above code is
 * executed only after obtaining lock over the object. Thread Safe Code or
 * Re-entrant code:- When a code block is safe from concurrency problems then
 * the code is referred as thread safe or re-entrant.In case of the below
 * operation incr() operation is considered as thread safe or re-entrant.
 * Example - In the below example try removing synchronized keyword before the
 * incr() operation and check the result. You will find inconsistent result. By
 * making the method synchronized, we are forcing the thread to lock the object
 * before performing the incr() operation. Though control is intentionally
 * passed to other thread, other thread won't be able to proceed with the
 * operation as it need to first lock (obj) before proceeding forward.
 * 
 * i.e. lets assume t1 locks obj then t2 should wait till t1 releases the lock,
 * hence object is modified by only one thread at a time and you will see
 * consistent results.
 *
 */
class Sample {

	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	/*
	 * Try removing synchronized.
	 */
	public synchronized void incr() {

		// read the value of x.
		int y = getX();

		// Increment the value
		y++;

		// Just assume if control is switched to
		// some other thread and it too looks at
		// the old value of x and proceeds with
		// modification. Such scenarios lead to
		// in consistent results.
		// To simulate such scenarios lets us just
		// pass the control to some other thread.

		// with sleep this thread will go to blocked state
		// for the given time interval, hence other thread
		// will get a chance.
		try {
			Thread.sleep(1);
		} catch (Exception e) {
		}

		// set x to new value.
		setX(y);
	}
}

class MyThread extends Thread {

	Sample obj;

	public MyThread(Sample obj) {
		this.obj = obj;
	}

	public void run() {
		obj.incr();
	}

}

public class SynchronizationExample {

	public static void main(String[] args) {

		Sample obj = new Sample();
		obj.setX(10);

		// In this case both the threads t1 and t2
		// are sharing the same Sample object obj.
		// Both the threads will try to perform the
		// increment operation simultaneously.

		MyThread t1 = new MyThread(obj);
		MyThread t2 = new MyThread(obj);

		t1.start();
		t2.start();

		// Here main thread called the join operation
		// on t1 and t2. join() operations waits for
		// thread to complete before returning.
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(obj.getX());
	}

}

/**
 * Synchronizing static data operations - Is the below increment() operation
 * thread-safe ?
 * 
 * class Sample {
 * 
 * static int a = 5; int b = 10;
 * 
 * public synchronized void increment( ) { a++; b++; }
 * 
 * // .... } Answer is NO. Because we made it synchronized we may think that it
 * is thread-safe but it is not. And it is because of the static variable a.
 * Lets assume that there are two objects for Sample, in that case both of them
 * will share the same copy of a because it is a class member, where as they get
 * different copies of b, because b is non static i.e. the instance member and
 * each instance will get a separate copy of b.
 * 
 * Assume Thread 1 invoked the increment method over the first object and Thread
 * 2 invoked the increment method over the second object. Because the
 * increment() method is non-static and it is synchronized, object should be
 * locked before getting into the method.
 * 
 * Here Thread1 locks the first object and gets in and also Thread 2 locks the
 * second object and gets in, because both are different objects and hence both
 * the thread acquire locks and they both proceed with the operation.
 *
 *
 * In this case the increment() operation is thread-safe, because for modifying
 * the static member 'a' we are locking the class object, Sample.class returns a
 * reference to class object and synchronized block will acquire lock over the
 * object and then proceed forward with the operation. And for b++ we are
 * locking the current object using the this reference. And hence both the
 * operations are now thread-safe, as we properly locked the corresponding
 * object before modification.
 */

class Sample1 {

	static int a = 5;
	int b = 10;

	public void increment() {
		// lock the Class object before modifying
		// static content.
		synchronized (Sample1.class) {
			a++;
		}

		// lock the object before modifying
		// instance members.
		synchronized (this) {
			b++;
		}
	}
}

/**
 * Create a static method for incrementing a and declare it as synchronized, so
 * that when the thread enters this method it locks the class object. Just
 * remember that whenever you are modifying the static content in a
 * multi-threaded environment you should lock the class object to make your code
 * thread-safe.
 * 
 * @author Deepu Verma
 *
 */
class Sample3 {

	static int a = 5;
	int b = 10;

	// This method is static and hence it locks the Class object.
	public static synchronized void incrementA() {
		a++;
	}

	// This method is non static and hence it locks the object
	// on which it is invoked.
	public synchronized void increment() {
		incrementA();
		b++;
	}

	// ....

}
