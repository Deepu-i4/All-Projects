package com.javacore;

class Outer {
	int a = 11;

	class Inner {
		int a = 22;

		void show() {
			int a = 33;
			System.out.println(a);
			System.out.println(this.a);
			System.out.println(Inner.this.a);
			System.out.println(Outer.this.a);
		}
	}

	void show() {
		System.out.println(new Inner().a);
	}

	static class StaInner {
		int a = 22;

		void show() {
			int a = 33;
			System.out.println(a);
			System.out.println(this.a);
		}
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inOb = outer.new Inner();
		inOb.show();
		outer.show();
		Outer1 outer1 = new Outer1();
		outer1.show();
		Outer1.Inner onner1 = new Outer1.Inner();
		onner1.show();

		new Outer2().m1();

		Hello1 hello = new Hello1();
		hello.m1();
		hello.p.sleeping();

		// 2 nd way
		new Person() {
			public void sleeping() {
				System.out.println("sdfsd sleeping");
			}

			public void reading() {
				System.out.println("asdasd reading");
			}
		}.reading();

		Anynomous ai = new Anynomous() {
		};
		Anynomous as = new Anynomous() {
		};
		System.out.println("Anynomous ref " + (ai == as));
		// System.out.println(new Anynomous() {} == new Anynomous() {});
	}

}

// static class
class Outer1 {
	static int a = 34;

	static void show() {
		System.out.println(a);
		// Inner.show();
	}

	static class Inner {
		static int a = 22;

		void show() {
			int a = 33;
			System.out.println(a);
		}
	}
}

// Local Inner class.
class Outer2 {
	void m1() {
		// int d=100;
		final int d = 100;
		class Inner {
			void show() {
				System.out.println("d:- " + d);
			}
		}
		new Inner().show();
	}
}

// Anonymous class

abstract class Person {
	public abstract void sleeping();
}

class Hello1 {
	Person p = new Person() {
		public void sleeping() {
			System.out.println("sleeping");
			reading();
		}

		public void reading() {
			System.out.println("reading");
		}
	};

	void m1() {
		p.sleeping();
		// p.reading();
	}
}

class Anynomous {
}
