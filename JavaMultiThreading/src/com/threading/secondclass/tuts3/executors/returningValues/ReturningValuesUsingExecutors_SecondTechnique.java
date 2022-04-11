package com.threading.secondclass.tuts3.executors.returningValues;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.threading.secondclass.common.CalculationTaskB;
import com.threading.secondclass.common.LoopTaskA;
import com.threading.secondclass.common.NamedThreadsFactory;
import com.threading.secondclass.common.TaskResult;

public class ReturningValuesUsingExecutors_SecondTechnique {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");

		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadsFactory());

		CompletionService<TaskResult<String, Integer>> completionService = new ExecutorCompletionService<TaskResult<String, Integer>>(
				execService);

		completionService.submit(new CalculationTaskB(2, 3, 2000));
		completionService.submit(new CalculationTaskB(3, 4, 1000));
		completionService.submit(new CalculationTaskB(4, 5, 500));

		completionService.submit(new LoopTaskA(), new TaskResult<String, Integer>("LoopTaskA-1", 999));

		execService.shutdown();

		for (int i = 0; i < 4; i++) {
			try {
				System.out.println(completionService.take().get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
