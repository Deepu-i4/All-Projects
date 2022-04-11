package com.threading.firstclass;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.threading.firstclass.utils.IOUtils;

/**
 * Transforming serial code to parallel code using Threads.. Serial Mode - In
 * the below example we are making a direct call to copyFile and it is executed
 * in serial order i.e. first Copy a.txt to c.txt is executed and then once it
 * is done, the next copy i.e. b.txt to d.txt will be initiated.. Parallel Mode
 * The two copy operations above are initiated through two different threads,
 * which enables us to perform the operation in parallel. For this we defined a
 * CopyTask which is a Runnable task, you should pass the source and the
 * destination to the constructor which are then used to perform the copy
 * operation once the task execution begins.
 */
class CopyTask implements Runnable {

	String sourceFile;
	String destFile;

	public CopyTask(String sourceFile, String destFile) {
		super();
		this.sourceFile = sourceFile;
		this.destFile = destFile;
	}

	@Override
	public void run() {
		try {
			IOUtils.copyFile(sourceFile, destFile);
			System.out.println("Copied from :- " + sourceFile + " to :- " + destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

public class FileCopyMain {

	public static void main(String[] args) throws IOException {
		String sourceFile1 = "a.txt";
		String sourceFile2 = "b.txt";

		String destFile1 = "c.txt";
		String destFile2 = "d.txt";

		// Need to do below task parellel
		// IOUtils.copyFile(sourceFile1, destFile1);
		// IOUtils.copyFile(sourceFile2, destFile2);

		Thread t1 = new Thread(new CopyTask(sourceFile1, destFile1));
		t1.start();
		Thread t2 = new Thread(new CopyTask(sourceFile2, destFile2));
		t2.start();
		System.out.println("Done");

		// 100 files--->10 threads.

		// Creating thread pool and reusing the thread.
		/**
		 * ExecutorService - In the previous example we executed the copyTask using
		 * separate threads, but there is a critical point to consider here, Thread
		 * creation is a costly activity as it includes creating a separate execution
		 * context, stack etc.. Hence we should refrain from creating too many threads.
		 * And also creating a thread for each task is not a good idea, instead we can
		 * create a pool of threads and effectively utilise them in executing all the
		 * task. This could be achieved using ExecutorService in Java. Use the execute
		 * method of the ExecutorService to submit a Runnable task, if a thread is
		 * available in the pool then it assigns this task to the thread otherwise the
		 * task is added to the blocking queue and is kept till a thread is available.
		 * 
		 * Creating a ThreadPool - Below statement creates a thread pool of size 5.
		 * ExecutorService executor = Executors.newFixedThreadPool(5); Submitting a
		 * Runnable task - We can submit a task for execution using the execute method.
		 * executor.execute( runnableTaskInstance ); e.g. executor.execute(new
		 * CopyTask(sourceFile1, destFile1));
		 */
		ExecutorService exService = Executors.newFixedThreadPool(5);
		exService.execute(new CopyTask(sourceFile1, destFile1));
		exService.execute(new CopyTask(sourceFile2, destFile2));

	}
}
