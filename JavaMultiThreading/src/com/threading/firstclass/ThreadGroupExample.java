package com.threading.firstclass;

/**
 * Internal System Threads and ThreadGroup Thread.currentThread() -
 * 
 * currentThread() is a static method in the class Thread and all the static
 * method in the Thread class normally operate on the thread in which it is
 * being executed. Here Thread.currentThread() returns a reference to the
 * current thread i.e. the main thread.
 * 
 * getThreadGroup() - [Thread class method]
 * 
 * A Thread class method that returns a reference to the ThreadGroup to which
 * the corresponding thread instance belongs.
 * 
 * getParent() - [ThreadGroup class method]
 * 
 * A ThreadGroup class method that returns a reference to the parent thread
 * group if any. If there is no parent then this method returns null.
 * 
 * setMaxPriority(int maxPriority) - [ThreadGroup class method]
 * 
 * Sets the maximum priority for that group so that no thread can exceed this
 * priority with in the group.
 *
 */
class DemoThread1 implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class ThreadGroupExample {

	public static void main(String[] args) {

		ThreadGroup myGroup = new ThreadGroup("MyGroup");
		myGroup.setMaxPriority(4);

		Thread demoThread = new Thread(myGroup, new DemoThread1(), "Demo-Thread");
		demoThread.start();

		Thread mainThread = Thread.currentThread();
		ThreadGroup threadGroup = mainThread.getThreadGroup();
		while (threadGroup.getParent() != null) {
			threadGroup = threadGroup.getParent();
		}
		threadGroup.list();

	}
}
