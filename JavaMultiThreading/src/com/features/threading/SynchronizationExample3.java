package com.features.threading;

class BookThreaterSeat1 {
	static int totalSeat = 20;

	synchronized static int bookSeat(int seats) {
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

}

class MyThread1 extends Thread {

	BookThreaterSeat1 bookThreaterSeat;
	int seats;

	public MyThread1(BookThreaterSeat1 bookThreaterSeat, int seats) {
		this.bookThreaterSeat = bookThreaterSeat;
		this.seats = seats;
	}

	public void run() {
		bookThreaterSeat.bookSeat(seats);
	}
}

class MyThread2 extends Thread {

	BookThreaterSeat1 bookThreaterSeat;
	int seats;

	public MyThread2(BookThreaterSeat1 bookThreaterSeat, int seats) {
		this.bookThreaterSeat = bookThreaterSeat;
		this.seats = seats;
	}

	public void run() {
		bookThreaterSeat.bookSeat(seats);
	}
}

public class SynchronizationExample3 {

	public static void main(String[] args) {
		BookThreaterSeat1 bookThreaterSeat1 = new BookThreaterSeat1();
		MyThread1 radhika = new MyThread1(bookThreaterSeat1, 7);
		radhika.start();

		MyThread1 radhe = new MyThread1(bookThreaterSeat1, 6);
		radhe.start();

		BookThreaterSeat1 bookThreaterSeat2 = new BookThreaterSeat1();
		MyThread2 amit = new MyThread2(bookThreaterSeat2, 5);
		amit.start();

		MyThread2 allu = new MyThread2(bookThreaterSeat2, 9);
		allu.start();

	}

}
