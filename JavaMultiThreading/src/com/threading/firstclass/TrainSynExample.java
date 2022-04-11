package com.threading.firstclass;

import java.util.HashMap;
import java.util.Map;

/**
 * If you are finding the result 50, this is because both the threads saw the
 * available tickets are 100 and both of them subtracted 50
 * 
 * i.e. t1 saw available = 100 and
 * 
 * available -= 50 => 50
 * 
 * also t2 saw available = 100 (because before t1 updates the available count,
 * control switched over to other thread. ) and
 * 
 * available -= 50 => 50
 * 
 * Both the threads updated the available count as 50. Hence you saw 50.
 * 
 * Solution :-
 * 
 * Though control is passed to other thread because t1 is in the middle of the
 * update operation, we can not allow t2 to proceed with the update i.e. we need
 * to block the threads from simultaneously performing updates over the same
 * object. This can be achieved through synchronized methods/blocks or you can
 * use locks.
 * 
 * Change the above reserveTickets method and make it synchronized
 * 
 * 
 * This will block t2 from performing the operation while t1 is in progress or
 * may be the other way around.
 * 
 * You can also use the synchronized block or locks for this as well. Obtain the
 * writeLock before proceeding with update.
 * 
 * @author Deepu Verma
 *
 */
public class TrainSynExample {

	public static void main(String[] args) throws InterruptedException {

		TicketReservationSystem reservationSystem = new TicketReservationSystem();
		String trainName = "a";
		int ticketCount = 50;

		// These two threads are trying to book 50 tickets for train "a".
		// After the operation expected available tickets are 0.
		Thread t1 = new Thread(new TicketBookingTask(reservationSystem, trainName, ticketCount));

		Thread t2 = new Thread(new TicketBookingTask(reservationSystem, trainName, ticketCount));

		t1.start();
		t2.start();

		// Wait for both the threads to complete.
		t1.join();
		t2.join();

		// Expected result is 0, but you might find 50.
		System.out.println("Available tickets for train - " + trainName + " are "
				+ reservationSystem.getAvailableTickets(trainName));

	}
}

/*
 * Class that is responsible for reserving/booking tickets.
 */
class TicketReservationSystem {

	Map<String, Integer> reservationInfo = new HashMap<String, Integer>();

	public TicketReservationSystem() {
		init();
	}

	private void init() {
		reservationInfo.put("a", 100);
		reservationInfo.put("b", 100);
	}

	/*
	 * Reserves the tickets for the given train, if there are sufficient tickets
	 * available.
	 */
	public void reserveTickets(String trainName, int ticketCount) {
		Integer available = reservationInfo.get(trainName);

		if (available == null) {
			System.out.println("Invalid train name " + trainName);
			return;
		}

		if (available < ticketCount) {
			System.out.println("Could not reserve, requested seats not available");
			return;
		}

		// For demo purpose.
		// Intentionally passed on control to other thread
		// before updating available tickets.
		// This is to demonstrate that what if control is switched here..
		Thread.yield();

		// Reduce the available ticket count.
		available -= ticketCount;

		// Update the Map.
		reservationInfo.put(trainName, available);
	}

	/*
	 * Returns available tickets associated with the given trainName.
	 */
	public Integer getAvailableTickets(String trainName) {
		return reservationInfo.get(trainName);
	}
}

/*
 * A Runnable task class that enables parallel ticket booking.
 */
class TicketBookingTask implements Runnable {

	private TicketReservationSystem reservationSystem;
	private String trainName;
	private int ticketCount;

	public TicketBookingTask(TicketReservationSystem reservationSystem, String trainName, int ticketCount) {
		this.reservationSystem = reservationSystem;
		this.trainName = trainName;
		this.ticketCount = ticketCount;
	}

	@Override
	public void run() {
		reservationSystem.reserveTickets(trainName, ticketCount);
	}

}
