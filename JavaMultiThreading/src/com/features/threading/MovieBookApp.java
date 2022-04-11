package com.features.threading;

class TotalEarning extends Thread {
	int total = 0;

	public void run() {

		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				total = total + 100;
			}
			this.notify();
		}
	}
}

public class MovieBookApp {
	public static void main(String[] args) {
		TotalEarning totalEarning = new TotalEarning();
		totalEarning.start();
		synchronized (totalEarning) {
			try {
				totalEarning.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Total Earnings: " + totalEarning.total);
	}
}
