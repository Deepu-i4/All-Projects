package com.features.threading;

class Task extends Thread {
	public void run() {
		doTask();
	}

	private void doTask() {
		for (int i = 0; i < 1000; i++) {
			System.out.print("T");
		}
	}
}

public class ThreadExample {
	public static void main(String args[]) {
		Task task = new Task();
		task.start();
		for (int i = 0; i < 1000; i++) {
			System.out.print("M");
		}
	}
}
