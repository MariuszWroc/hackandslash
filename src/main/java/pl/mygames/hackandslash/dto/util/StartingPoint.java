package pl.mygames.hackandslash.dto.util;

public enum StartingPoint {
	CITY(1, "Miasto - Stolica");
	
	private final int value;
	private final String name;

	private StartingPoint(int value, String name) {
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
