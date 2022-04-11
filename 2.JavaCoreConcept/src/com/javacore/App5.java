package com.javacore;

public class App5 extends Horse{

	 void show(Animal Animal) {
		 System.out.println("Animal");
	}
	 
	 void show(Horse Horse) {
		 System.out.println("Horse");
	}

	public static void main(String[] args) {
		Animal animal = new Horse();
		new App5().show(animal);
		
		Horse Horse = new App5();
		Horse.show(Horse);
	}
}
class Animal{}

class Horse extends Animal{
	 void show(Horse Horse) {
		 System.out.println("Horse FF");
	}
	 
}

interface Inter1{
	 int show(int a);
}
interface Inter2{
	 void show(String str);
}

class HHH{}

class DDD extends HHH implements Inter1,Inter2 {

	public int show(int a) {
		return a;
		
	}
	public void show(String str) {
		
	}	
}

