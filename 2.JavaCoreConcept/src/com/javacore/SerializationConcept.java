package com.javacore;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dad implements Serializable {
	int a;
	static int staticVariable = 20;
	// Association.
	Mummy mummy;

	public Dad(int a, Mummy mummy) {
		super();
		this.a = a;
		this.mummy = mummy;
	}

}

class Mummy implements Serializable {
	int a;

	public Mummy(int a) {
		super();
		this.a = a;
	}

}

public class SerializationConcept {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Mummy mummy = new Mummy(24);
		Dad dad = new Dad(12, mummy);
		FileOutputStream fos = new FileOutputStream("momDad.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(dad);
		System.out.println("It is serialized Properly");
		oos.close();
		fos.close();

		// deserilize it
		FileInputStream fis = new FileInputStream("momDad.txt");
		ObjectInputStream ois;
		ois = new ObjectInputStream(fis);
		Dad dad1 = (Dad) ois.readObject();
		System.out.println("Deserialized  :- " + dad1.a + " : " + dad.mummy.a + " : " + dad.staticVariable);
		ois.close();
		fis.close();

		// for Inheritance.
		B b1 = new B(10, 20);
		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);

		// Serializing B's(subclass) object
		FileOutputStream fos1 = new FileOutputStream("abc.ser");
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		oos1.writeObject(b1);
		oos1.close();
		fos1.close();
		System.out.println("Object has been serialized");

		// De-Serializing B's(subclass) object
		FileInputStream fis1 = new FileInputStream("abc.ser");
		ObjectInputStream ois1 = new ObjectInputStream(fis1);
		B b2 = (B) ois1.readObject();
		ois1.close();
		fis1.close();
		System.out.println("Object has been deserialized");

		System.out.println("i = " + b2.i);
		System.out.println("j = " + b2.j);

	}

}

class A implements Serializable {
	int i;

	public A(int i) {
		this.i = i;
	}
}

class B extends A {
	// not to serialize.
	int j;

	public B(int i, int j) {
		super(i);
		this.j = j;
	}

	/**
	 * By implementing writeObject method,we can prevent subclass from serialization
	 * 
	 * @param oos
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream oos) throws IOException {
		// throw new NotSerializableException();
	}

	/**
	 * By implementing readObject method,we can prevent subclass from
	 * de-serialization
	 * 
	 * @param in
	 * @throws IOException
	 */
	private void readObject(ObjectInputStream in) throws IOException {
		// throw new NotSerializableException();
	}
}
