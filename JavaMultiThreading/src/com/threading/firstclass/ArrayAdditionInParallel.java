package com.threading.firstclass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumCallable implements Callable<Integer> {

	private int arr[];
	private int start;
	private int end;

	public SumCallable(int arr[], int start, int end) {
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	/*
	 * Calculate the sum of the elements of the given partition i.e. from the given
	 * start index to end index.
	 */
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		Thread.sleep(1000);
		return sum;
	}

}

public class ArrayAdditionInParallel {

	public static void main(String[] args) {
		int[] smallArr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		int[] largeArr = new int[10000000];
		for (int a = 0; a < largeArr.length; a++) {
			largeArr[a] = a + 1;
		}

		parrallelProcessing(largeArr);

		// executorService.submit(new SumCallable());

		// simple processing.
		serialProcessing(largeArr);

	}

	private static void parrallelProcessing(int[] arr) {
		long startTime = System.currentTimeMillis();
		// Size of each block.
		int blockSize = 1000000;

		// Number of blocks
		// If say the value for noOfBlocks is 3.3,
		// we know that there are 4 blocks.
		// Hence took the ceil value i.e. 4.
		int noOfBlocks = (int) Math.ceil((double) arr.length / blockSize);
		System.out.println(noOfBlocks);
		// A fixed thread pool of size 3 to calculate the sum.
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		// Future objects are saved to fetch the results after completion.
		List<Future<Integer>> futureObject = new ArrayList();

		// For each partition.
		int start = 0, end;
		for (int i = 1; i <= noOfBlocks; i++) {
			// Calculate the starting and ending index positions
			// of the i th partition.
			start = (i - 1) * blockSize;
			end = start + blockSize - 1;

			// Check if end crosses the actual array size,
			// if yes take the last
			// element index.
			if (end >= arr.length) {
				end = arr.length - 1;
			}
			Future<Integer> future = executorService.submit(new SumCallable(arr, start, end));
			futureObject.add(future);
		}

		int totalSum = 0;
		for (Future<Integer> future : futureObject) {
			totalSum += getComputeValue(future);
		}
		System.out.println("Final Sum " + totalSum);
		System.out.println("Time taken parellel processing :- " + (System.currentTimeMillis() - startTime));

	}

	private static int getComputeValue(Future<Integer> future) {

		while (!future.isDone()) {
			Thread.yield();
		}
		try {
			return future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return 0;
		}
	}

	private static void serialProcessing(int[] array) {
		long startTime = System.currentTimeMillis();
		int sum = array[0];
		for (int i = 1; i < array.length; i++) {
			sum = sum + array[i];

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Sum :- " + sum);
		System.out.println("Time taken parellel processing :- " + (System.currentTimeMillis() - startTime));
	}

}
