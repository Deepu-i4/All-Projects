package com.javacore;

//Code to illustrate Phantom reference
import java.lang.ref.*;

class Apple {
	public void x() {
		System.out.println("GeeksforGeeks");
	}
}

public class PhantomReferenceExample {
	public static void main(String[] args) {
		// Strong Reference
		Apple apple = new Apple();
		apple.x();

		// Creating reference queue
		ReferenceQueue<Apple> refQueue = new ReferenceQueue();

		// Creating Phantom Reference to Apple-type object to which 'apple'
		// is also pointing.
		PhantomReference<Apple> phantomRef = null;

		phantomRef = new PhantomReference(apple, refQueue);

		// Now, Apple-type object to which 'apple' was pointing
		// earlier is available for garbage collection.
		// But, this object is kept in 'refQueue' before
		// removing it from the memory.
		apple = null;

		// It always returns null.
		apple = phantomRef.get();

		// It shows NullPointerException.
		apple.x();
	}
}
