package com.features.threading;

class MedicalThread extends Thread {

	public void run() {
		try {
			System.out.println("Medical Test Started");
			Thread.sleep(1000);
			System.out.println("Medical Test Done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class TestDrive extends Thread {

	public void run() {
		try {
			System.out.println("TestDrive Test Started");
			Thread.sleep(1000);
			System.out.println("TestDrive Test Done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class OfficerSign extends Thread {

	public void run() {
		try {
			System.out.println("OfficerSign Test Started");
			Thread.sleep(1000);
			System.out.println("OfficerSign Test Done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class JoinTest extends Thread {

	public static void main(String[] args) throws InterruptedException {

		MedicalThread mt = new MedicalThread();
		mt.start();
		mt.join();

		TestDrive td = new TestDrive();
		td.start();
		td.join();

		OfficerSign os = new OfficerSign();
		os.start();

	}
}
