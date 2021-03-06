package com.threading.secondclass.tuts2.executors.naming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.threading.secondclass.common.LoopTaskC;
import com.threading.secondclass.common.NamedThreadsFactory;


public class NamingExecutorThreads {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		ExecutorService execService = Executors.newCachedThreadPool(
				new NamedThreadsFactory());
		
		for (int i = 0; i < 3; i++) {
			execService.execute(new LoopTaskC());
		}
		
		execService.shutdown();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
