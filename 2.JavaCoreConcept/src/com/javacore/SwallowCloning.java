package com.javacore;

class Sound {
	int x;

	public Sound(int x) {
		this.x = x;
	}
}

class Bass implements Cloneable {
	int y;
	Sound sound;

	public Bass(int y, Sound sound) {
		this.y = y;
		this.sound = sound;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		if (this instanceof Cloneable) {
			Sound newSound = new Sound(this.sound.x);
			Bass bass = new Bass(y, newSound);
			return bass;
		} else {
			throw new CloneNotSupportedException();
		}
	}

	public void show() {
		System.out.println(y);
		System.out.println(sound.x);
	}

}

public class SwallowCloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		Sound sound = new Sound(10);
		Bass bass = new Bass(20, sound);
		bass.show();
		Bass newBass = (Bass) bass.clone();
		newBass.show();
		System.out.println("------------");
		newBass.y = 40;
		newBass.sound.x = 20;
		newBass.show();
		bass.show();

	}

}
