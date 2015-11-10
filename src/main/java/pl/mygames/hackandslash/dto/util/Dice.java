package pl.mygames.hackandslash.dto.util;

public enum Dice {
	Dice1(1, "1D4"),
	Dice2(2, "1D6"),
	Dice3(3, "1D8");
	
	private int value;
	private String name;

	private Dice(int value, String name) {
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
