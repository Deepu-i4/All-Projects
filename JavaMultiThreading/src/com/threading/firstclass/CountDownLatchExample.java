package com.threading.firstclass;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class UserMigrateTask implements Runnable {

	@Override
	public void run() {
		System.out.println("first run :- " + Thread.currentThread());
		int recordCount = 220;
		int batchSize = 100;
		int nPages = (int) Math.ceil((double) recordCount / batchSize);

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CountDownLatch latch = new CountDownLatch(nPages);

		for (int i = 1; i <= nPages; i++) {
			final int pageNo = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println("inside run :- " + Thread.currentThread());
					System.out.println("Migrating page - " + pageNo);
					latch.countDown();
				}
			});

		}
		executorService.shutdown();
		boolean success = false;
		try {
			// latch.await();
			success = latch.await(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (success) {
			System.out.println("User data migration completed");
		} else {
			System.out.println("Time out while User data migration to completed");
		}
	}

}

public class CountDownLatchExample {

	public static void main(String args[]) {
		new Thread(new UserMigrateTask()).start();
	}
}
