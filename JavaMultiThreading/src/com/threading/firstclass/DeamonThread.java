package com.threading.firstclass;

/**
 * 
 * Daemon threads are the ones which does not prevent the JVM from exiting the
 * application once it finishes. Daemon threads are handy for performing
 * background tasks such as garbage collection or collecting application
 * statistics etc. Note that the Java Virtual Machine exits when the only
 * threads running are all daemon threads.Example -In the below example at the
 * end of the while loop grp will point to system thread group. And enumerate
 * method lists the threads in that group and copies the references to the given
 * array. It also returns the number of threads copied. And later I am printing
 * the thread name along with the boolean value checking if it is a daemon
 * thread or not, using the method isDaemon().
 *
 */
public class DeamonThread {

	public static void main(String[] args) {
		Thread th = Thread.currentThread();
		ThreadGroup threadGroup = th.getThreadGroup();
		while (threadGroup.getParent() != null) {
			threadGroup = threadGroup.getParent();
		}
		Thread[] threadList = new Thread[10];
		int n = threadGroup.enumerate(threadList);

		for (int i = 0; i < n; i++) {
			System.out.println("Thread Name : -" + threadList[i].getName() + " ||  isDaemon " + threadList[i].isDaemon());

		}
	}

}
