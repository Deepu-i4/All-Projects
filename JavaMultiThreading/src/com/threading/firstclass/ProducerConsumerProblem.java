package com.threading.firstclass;

import java.util.ArrayList;
import java.util.List;

/**
 * Here we have a class MessageQueue which acts as a buffer between producer
 * thread and the consumer thread. And the buffer is bounded, so we can set the
 * limit during object creation.
 * 
 * isFull() returns true if messages size reaches the limit.
 * 
 * isEmpty() return true if messages size is equal to zero.
 * 
 * enqueue() - Here it is invoked only by ProducerThread; it adds (at the end)
 * the message to the messages array if it is not full, if full it calls the
 * wait() over the queue object (this) till the consumer consumes the message
 * and notifies it. Also once it adds the message to the queue, it calls the
 * notify() in order to end the consumer's wait() if any.
 * 
 * dequeue() - Here it is invoked only by ConsumerThread; it removes the first
 * element and returns it. If the queue is empty it calls the wait() over the
 * queue object till the producer produces the message. Once it consumes the
 * message it calls the notify() to end the producer's wait() if any.
 * 
 * main() initiates these operations, by creating the MessageQueue object and
 * passing it to both the producer and consumer threads.
 * 
 * @author Deepu Verma
 *
 */

class MessageQueue {

	List<String> messages;
	int limit;

	public MessageQueue(int limit) {
		messages = new ArrayList<String>();
		this.limit = limit;
	}

	public boolean isFull() {
		return messages.size() == limit;
	}

	public boolean isEmpty() {
		return messages.size() == 0;
	}

	public synchronized void enqueue(String msg) {

		while (isFull()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		messages.add(msg);
		this.notify();
	}

	public synchronized String dequeue() {

		while (isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String message = messages.remove(0);
		this.notify();
		return message;
	}

}

class ProducerThread extends Thread {
	MessageQueue queue;

	public ProducerThread(MessageQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			String msg = "Hello-" + i;
			queue.enqueue(msg);
			System.out.println("Produced - " + msg);
		}
	}
}

class ConsumerThread extends Thread {
	MessageQueue queue;

	public ConsumerThread(MessageQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			String message = queue.dequeue();
			System.out.println("Consumed - " + message);
		}
	}
}

public class ProducerConsumerProblem {
	public static void main(String[] args) throws InterruptedException {
		MessageQueue queue = new MessageQueue(1);
		new ProducerThread(queue).start();
		new ConsumerThread(queue).start();
	}
}
