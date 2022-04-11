package com.deepu.designpattern;

interface Hotel {
	public Menus getMenus();
}

class NonVegRestaurant implements Hotel {
	public Menus getMenus() {
		NonVegMenu nv = new NonVegMenu();
		return nv;
	}
}

class VegRestaurant implements Hotel {
	public Menus getMenus() {
		VegMenu v = new VegMenu();
		return v;
	}
}

class VegNonBothRestaurant implements Hotel {
	public Menus getMenus() {
		Both b = new Both();
		return b;
	}
}

interface Menus {
	void showMenu();
}

class NonVegMenu implements Menus {

	@Override
	public void showMenu() {
		System.out.println("NonVegMenu");

	}
}

class VegMenu implements Menus {

	@Override
	public void showMenu() {
		System.out.println("VegMenu");

	}
}

class Both implements Menus {

	@Override
	public void showMenu() {
		System.out.println("Both");

	}
}

class HotelKeeper {
	public VegMenu getVegMenu() {
		VegRestaurant v = new VegRestaurant();
		VegMenu vegMenu = (VegMenu) v.getMenus();
		return vegMenu;
	}

	public NonVegMenu getNonVegMenu() {
		NonVegRestaurant v = new NonVegRestaurant();
		NonVegMenu NonvegMenu = (NonVegMenu) v.getMenus();
		return NonvegMenu;
	}

	public Both getVegNonMenu() {
		VegNonBothRestaurant v = new VegNonBothRestaurant();
		Both bothMenu = (Both) v.getMenus();
		return bothMenu;
	}
}

public class FacadeDesignPattern {
	public static void main(String[] args) {
		HotelKeeper keeper = new HotelKeeper();

		VegMenu v = keeper.getVegMenu();
		v.showMenu();
		NonVegMenu nv = keeper.getNonVegMenu();
		nv.showMenu();
		Both both = keeper.getVegNonMenu();
		both.showMenu();

	}
}
