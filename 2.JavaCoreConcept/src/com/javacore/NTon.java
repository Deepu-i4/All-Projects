package com.javacore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NTon {
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 2; i++) {
			System.out.println(Hello23.getHello());
		}

		for (int i = 0; i < 8; i++) {
			System.out.println(MutipleObject.getHello());
		}
	}
}

class Hello23 {
	private static Hello23 h1 = new Hello23();
	private static Hello23 h2 = new Hello23();

	private Hello23() {
	}

	public static Hello23 getHello() {
		if (Math.random() > 0.5) {
			return h1;
		} else
			return h2;
	}
}

class MutipleObject {
	private static MutipleObject nton;
	private static int count = 0;
	private static List<MutipleObject> list = new ArrayList();

	private MutipleObject() {
	}

	public static MutipleObject getHello() throws Exception {
		MutipleObject mutipleObject = null;
		if (count < 5) {
			mutipleObject = new MutipleObject();
			count++;
			list.add(mutipleObject);
		} else {
			Random rand = new Random();
			int max = 4;
			int min = 0;
			int randomNum = rand.nextInt((max - min) + 1) + min;
			return list.get(randomNum);
		}
		return mutipleObject;
	}
}
