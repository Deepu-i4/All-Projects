package com.threading.secondclass.tuts8.executors.joining;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.threading.secondclass.common.LoopTaskI;
import com.threading.secondclass.common.NamedThreadsFactory;

public class JoiningExecutorTasks {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");

		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadsFactory());

		CountDownLatch doneSignal = new CountDownLatch(2);

		// case1
		execService.execute(new LoopTaskI(doneSignal));
		execService.execute(new LoopTaskI(doneSignal));
		execService.execute(new LoopTaskI(doneSignal));
		execService.execute(new LoopTaskI(doneSignal));

		// case2
		/*
		 * execService.execute(new LoopTaskI(null)); execService.execute(new
		 * LoopTaskI(doneSignal)); execService.execute(new LoopTaskI(doneSignal));
		 * execService.execute(new LoopTaskI(null));
		 */

		execService.shutdown();

		try {
			doneSignal.await();
			System.out.println("[" + currentThreadName + "] " + currentThreadName + " GOT THE SIGNAL TO CONTINUE ...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
