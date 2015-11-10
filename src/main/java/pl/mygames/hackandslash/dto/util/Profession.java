package pl.mygames.hackandslash.dto.util;

public enum Profession {
	Other(0, "Inna"),
	Mage(1, "Mag"),
	Warrior(2, "Wojownik"),
	Hunter(3, "Łowca"),
	Thief(4, "Złodziej");
	
	
	private int value;
	private String name;

	private Profession(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
}
