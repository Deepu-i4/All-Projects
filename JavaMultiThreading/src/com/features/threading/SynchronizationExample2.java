package com.features.threading;

class BookThreaterSeat {
	int totalSeat = 10;

	synchronized int bookSeat1(int seats) {
		if (totalSeat >= seats) {
			System.out.println(seats + " seats booked succesfully");
			totalSeat = totalSeat - seats;
			System.out.println("Seats Left " + totalSeat);
		} else {
			System.out.println("Seats can not be booked");
			System.out.println("Seats Left " + totalSeat);
		}
		return seats;
	}

	// synchronized block
	int bookSeat(int seats) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		synchronized (this) {
			if (totalSeat >= seats) {
				System.out.println(seats + " seats booked succesfully");
				totalSeat = totalSeat - seats;
				System.out.println("Seats Left " + totalSeat);
			} else {
				System.out.println("Seats can not be booked");
				System.out.println("Seats Left " + totalSeat);
			}
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		return seats;
	}
}

public class SynchronizationExample2 extends Thread {
	static BookThreaterSeat bookThreaterSeat;
	int seats;

	public void run() {
		bookThreaterSeat.bookSeat(seats);
	}

	public static void main(String[] args) {
		bookThreaterSeat = new BookThreaterSeat();
		SynchronizationExample2 deepak = new SynchronizationExample2();
		deepak.seats = 7;
		deepak.start();

		SynchronizationExample2 amit = new SynchronizationExample2();
		amit.seats = 6;
		amit.start();
	}

}
