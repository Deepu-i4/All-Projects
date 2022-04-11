package com.threading.secondclass.tuts1.executors.running;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.threading.secondclass.common.LoopTaskA;

public class UsingSingleThreadExecutor {

	public static void main(String[] args) {
		System.out.println("Main thread starts here...");

		ExecutorService execService = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 3; i++) {
			execService.execute(new LoopTaskA());
		}

		execService.shutdown();

		System.out.println("Main thread ends here...");
	}
}