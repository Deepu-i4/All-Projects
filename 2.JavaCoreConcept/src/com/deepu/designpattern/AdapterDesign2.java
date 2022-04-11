package com.deepu.designpattern;

//Java implementation of Adapter pattern

interface Movable {
	// returns speed in MPH
	double getSpeed();
}

class BugattiVeyron implements Movable {

	@Override
	public double getSpeed() {
		return 268;
	}
}

interface MovableAdapter {
	// returns speed in KM/H
	double getSpeed();
}

class MovableAdapterImpl implements MovableAdapter {

	private Movable movable;

	public MovableAdapterImpl(Movable movable) {
		super();
		this.movable = movable;
	}

	@Override
	public double getSpeed() {
		return convertMPHtoKMPH(movable.getSpeed());
	}

	private double convertMPHtoKMPH(double mph) {
		return mph * 1.60934;
	}
}

class AdapterDesign2 {
	public static void main(String args[]) {
		Movable movable = new BugattiVeyron();
		System.out.println("BugattiVeyron in USA " + movable.getSpeed() + " MPH");

		// UK speed
		MovableAdapter movableAdapter = new MovableAdapterImpl(movable);
		System.out.println("BugattiVeyron in UK " + movableAdapter.getSpeed() + " KPH");

	}
}
