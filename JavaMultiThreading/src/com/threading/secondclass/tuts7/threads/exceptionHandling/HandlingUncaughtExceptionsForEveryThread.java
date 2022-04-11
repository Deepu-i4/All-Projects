package com.threading.secondclass.tuts7.threads.exceptionHandling;

import com.threading.secondclass.common.ExceptionLeakingTask;
import com.threading.secondclass.common.ThreadExceptionHandler;

public class HandlingUncaughtExceptionsForEveryThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");

		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));
		// try {
		new Thread(new ExceptionLeakingTask(), "MyThread-1").start();
		new Thread(new ExceptionLeakingTask(), "MyThread-2").start();
		new Thread(new ExceptionLeakingTask(), "MyThread-3").start();
		new Thread(new ExceptionLeakingTask(), "MyThread-4").start();
		/*
		 * } catch (RuntimeException e) { System.out.println(currentThreadName +
		 * " main exits here"); }
		 */
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
