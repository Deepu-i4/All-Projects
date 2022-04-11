package com.javacore;
class Rectangle {
	int height;
	int width;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int area() {
		return width * height;

	}

}

class Square extends Rectangle {


	public void setHeight(int height) {
		this.height = height;
		this.width = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
		this.height = width;
	}


}

public class LiskovSubstitutionPrinciple {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(10);
		rectangle.setWidth(5);
		System.out.println(rectangle.area());
		
		Rectangle rectangle1 = new Square();
		rectangle1.setHeight(10);
		rectangle1.setWidth(5);
		System.out.println(rectangle1.area());
		

	}

}
