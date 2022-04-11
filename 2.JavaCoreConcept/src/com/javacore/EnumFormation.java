package com.javacore;


enum EnumDirection {
	EAST(0), NORTH(90), SOUTH(270), WEST(180);

	private int angle;

	static {
		System.out.println("Static Block");
	}

	// Not executed urs one. Java internally created and executed. It dont provide
	// control to us.
	EnumDirection() {
		System.out.println("Default Constructor");
	}

	EnumDirection(int angle) {
		this.angle = angle;
	}

	public int getAngle() {
		return angle;
	}
}

class Direction {
	private String direction;
	private int angle;

	public Direction(String direction, int angle) {
		this.direction = direction;
		this.angle = angle;
	}

	public static Direction EAST = new Direction("EAST", 0);
	public static Direction NORTH = new Direction("NORTH", 90);
	public static Direction SOUTH = new Direction("SOUTH", 270);
	public static Direction WEST = new Direction("WEST", 180);

	public int getAngle() {
		return angle;
	}

	@Override
	public String toString() {
		return "Direction [direction=" + direction + ", angle=" + angle + "]";
	}

}

public class EnumFormation {

	public static void main(String[] args) {
		System.out.println(Direction.EAST);
		System.out.println(Direction.NORTH);
		System.out.println(Direction.SOUTH);
		System.out.println(Direction.WEST);

		System.out.println(EnumDirection.EAST.ordinal());
		System.out.println(EnumDirection.NORTH);
		System.out.println(EnumDirection.SOUTH);
		System.out.println(EnumDirection.WEST);
	}

}
