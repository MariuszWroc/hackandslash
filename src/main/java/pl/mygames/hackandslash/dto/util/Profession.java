package pl.mygames.hackandslash.dto.util;

public enum Profession {
	Mage(1),
	Warrior(2);
	
	private int value;

	private Profession(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
