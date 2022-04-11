package com.javacore;

// without implementing the clone interface.
// driving without license
class Sound12 {
	int x;

	public Sound12(int x) {
		this.x = x;
	}
}

class SwallowCloning2 {
	int y;
	Sound12 sound;

	public SwallowCloning2(int y, Sound12 sound) {
		this.y = y;
		this.sound = sound;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Sound newSound = new Sound(this.sound.x);
		Bass bass = new Bass(y, newSound);
		return bass;
	}

	public void show() {
		System.out.println(y);
		System.out.println(sound.x);
	}

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
