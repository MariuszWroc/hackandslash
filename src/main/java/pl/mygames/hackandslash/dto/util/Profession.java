package pl.mygames.hackandslash.dto.util;

public enum Profession {
	Other(0),
	Mage(1),
	Warrior(2),
	Hunter(3),
	Thief(4);
	
	
	private int value;

	private Profession(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
