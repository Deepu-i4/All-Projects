package com.threading.firstclass;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.threading.firstclass.utils.PatternFinder;

public class PatternSearch {

	public static void main(String[] args) throws Exception {

		String pattern = "public";
		File dir = new File("./src/sample");
		File[] listFiles = dir.listFiles();

		PatternFinder finder = new PatternFinder();

		// serial processing.
		// serialProcessing(pattern, listFiles, finder);

		// parellel processing
		parallelProcessing(pattern, listFiles, finder);
	}

	private static void serialProcessing(String pattern, File[] listFiles, PatternFinder finder) {
		long startTime = System.currentTimeMillis();
		for (File file : listFiles) {
			List<Integer> lineNumber = finder.findPattern(file, pattern);

			if (!lineNumber.isEmpty()) {
				System.out.println(pattern + " : found " + lineNumber + " in " + file.getName());
			}
		}
		System.out.println("Time taken serial processing :- " + (System.currentTimeMillis() - startTime));
	}

	private static void parallelProcessing(String pattern, File[] listFiles, PatternFinder finder) throws Exception {

		// Fixed thread pool of size 3.
		ExecutorService executor = Executors.newFixedThreadPool(3);
		// Map to store the Future object against each
		// file search request, later once the result is obtained
		// the Future object will be
		// replaced with the search result.
		Map<String, Object> resultMap = new HashMap<String, Object>();
		long startTime1 = System.currentTimeMillis();
		for (File file : listFiles) {
			// Submit a Callable task for the file.
			Future<List<Integer>> future = executor.submit(new Callable<List<Integer>>() {
				@Override
				public List<Integer> call() throws Exception {
					List<Integer> lineNumbers = finder.findPattern(file, pattern);
					return lineNumbers;
				}
			});

			// Save the future object in the map for
			// fetching the result.
			resultMap.put(file.getName(), future);
		}
		// Wait for the requests to complete.
		waitForAll(resultMap);

		for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
			System.out.println(pattern + " : found at " + entry.getValue() + " in " + entry.getKey());
		}
		System.out.println("Time taken parellel processing :- " + (System.currentTimeMillis() - startTime1));
	}

	private static void waitForAll(Map<String, Object> resultMap) throws Exception {
		Set<String> keys = resultMap.keySet();
		for (String key : keys) {
			Future<List<Integer>> future = (Future<List<Integer>>) resultMap.get(key);
			while (!future.isDone()) {
				// Passing the CPU to other
				// threads so that they can
				// complete the operation.
				// With out this we are simply
				// keeping the CPU in loop and
				// wasting its time.
				Thread.yield(); // idle
				
			}
			// Replace the future object with the obtained result.
			resultMap.put(key, future.get());
		}
	}

}
