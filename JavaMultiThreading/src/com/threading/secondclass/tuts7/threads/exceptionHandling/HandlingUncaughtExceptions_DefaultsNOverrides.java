package com.threading.secondclass.tuts7.threads.exceptionHandling;

import java.lang.Thread.UncaughtExceptionHandler;

import com.threading.secondclass.common.ExceptionLeakingTask;
import com.threading.secondclass.common.ThreadExceptionHandler;
import com.threading.secondclass.common.ThreadExceptionNotifier;

public class HandlingUncaughtExceptions_DefaultsNOverrides {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");

		UncaughtExceptionHandler specialHandler = new ThreadExceptionNotifier();

		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("THE_DEFAULT_ONE"));

		Thread t1 = new Thread(new ExceptionLeakingTask(), "MyThread-1");

		Thread t2 = new Thread(new ExceptionLeakingTask(), "MyThread-2");
		t2.setUncaughtExceptionHandler(specialHandler);

		Thread t3 = new Thread(new ExceptionLeakingTask(), "MyThread-3");

		Thread t4 = new Thread(new ExceptionLeakingTask(), "MyThread-4");
		t4.setUncaughtExceptionHandler(specialHandler);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
