package com.threading.secondclass.common;

public class ExceptionLeakingTask implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
	}

}
