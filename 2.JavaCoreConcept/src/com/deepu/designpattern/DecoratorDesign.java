package com.deepu.designpattern;

interface ChristmasTree {
	String decorate();
}

class ChristmasTreeImpl implements ChristmasTree {

	@Override
	public String decorate() {
		return "Christmas tree";
	}
}

abstract class TreeDecorator implements ChristmasTree {
	private ChristmasTree tree;

	public TreeDecorator(ChristmasTree tree) {
		this.tree = tree;
	}

	@Override
	public String decorate() {
		return tree.decorate();
	}
}

class BubbleLights extends TreeDecorator {

	public BubbleLights(ChristmasTree tree) {
		super(tree);
	}

	public String decorate() {
		return super.decorate() + decorateWithBubbleLights();
	}

	private String decorateWithBubbleLights() {
		return " with Bubble Lights";
	}
}

class Garland extends TreeDecorator {

	public Garland(ChristmasTree tree) {
		super(tree);
	}

	public String decorate() {
		return super.decorate() + decorateWithGarland();
	}

	private String decorateWithGarland() {
		return " with Garland ";
	}
}

public class DecoratorDesign {
	public static void main(String... args) {
		ChristmasTree christmasTree = new ChristmasTreeImpl();
		System.out.println(christmasTree.decorate());

		ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
		System.out.println(tree1.decorate());

		ChristmasTree tree2 = new BubbleLights(new Garland(new Garland(new ChristmasTreeImpl())));
		System.out.println(tree2.decorate());

	}

}
