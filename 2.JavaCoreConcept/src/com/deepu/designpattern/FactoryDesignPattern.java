package com.deepu.designpattern;

interface Notification12 {
	void notifyUser();
}

class SMSNotification implements Notification12 {

	@Override
	public void notifyUser() {
		System.out.println("Sending an SMS notification");
	}
}

class EmailNotification implements Notification12 {

	@Override
	public void notifyUser() {
		System.out.println("Sending an e-mail notification");
	}
}

class PushNotification implements Notification12 {

	@Override
	public void notifyUser() {
		System.out.println("Sending a push notification");
	}
}

class NotificationFactory {
	public Notification12 createNotification(String channel) {
		if (channel == null || channel.isEmpty())
			return null;
		if ("SMS".equals(channel)) {
			return new SMSNotification();
		} else if ("EMAIL".equals(channel)) {
			return new EmailNotification();
		} else if ("PUSH".equals(channel)) {
			return new PushNotification();
		}
		return null;
	}
}

public class FactoryDesignPattern {
	public static void main(String[] args) {
		NotificationFactory notificationFactory = new NotificationFactory();
		Notification12 notification = notificationFactory.createNotification("SMS");
		notification.notifyUser();
	}
}
