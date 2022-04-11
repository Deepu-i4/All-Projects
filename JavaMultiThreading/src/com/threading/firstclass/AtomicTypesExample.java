package com.threading.firstclass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

//to see the problem
class SharedService {

	static boolean initialized = false;

	public void init() {

		if (initialized) {
			System.out.println("already initialized");
			return;
		}
		// added to see initialization twice
		Thread.yield();
		initialized = true;
		System.out.println("initializing....");
	}

	public void service() {
		init();
		System.out.println("perform some task");
	}

}

//first Solution
class SharedService1 {

	static boolean initialized = false;
	Object mutex = new Object();

	public void init() {
		synchronized (mutex) {
			if (initialized) {
				System.out.println("already initialized");
				return;
			}
			// added to see initialization twice
			Thread.yield();
			initialized = true;
			System.out.println("initializing....");
		}

	}

	public void service() {
		init();
		System.out.println("perform some task");
	}

}

//AtomicType Solution
class SharedService2 {

	static AtomicBoolean initialized = new AtomicBoolean(false);

	public void init() {
		if (!initialized.compareAndSet(false, true)) {
			System.out.println("already initialized");
			return;
		}
		Thread.yield();
		System.out.println("initializing....");

	}

	public void service() {
		init();
		System.out.println("perform some task");
	}

}

public class AtomicTypesExample {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(3);

		SharedService service = new SharedService();
		running(executor, service);
		System.out.println("***********************************");
		SharedService1 service1 = new SharedService1();
		System.out.println("***********************************");
		running(executor, service1);
		SharedService2 service2 = new SharedService2();
		System.out.println("***********************************");
		running(executor, service2);
		executor.shutdown();
		// atomicExample();

	}

	private static void running(ExecutorService executor, SharedService service) {
		for (int i = 1; i <= 3; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					service.service();
				}
			});
		}
	}

	private static void running(ExecutorService executor, SharedService1 service) {
		for (int i = 1; i <= 3; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					service.service();
				}
			});
		}
	}

	private static void running(ExecutorService executor, SharedService2 service) {
		for (int i = 1; i <= 3; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					service.service();
				}
			});
		}
	}

	private static void atomicExample() {
		AtomicInteger value = new AtomicInteger(10);
		boolean status = value.compareAndSet(10, 11);
		// boolean status = value.compareAndSet(20, 11);
		if (status == true) {
			System.out.println("Value was set");
		} else {
			System.out.println("Value was not set");
		}
	}

}
