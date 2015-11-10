package pl.mygames.hackandslash.dto.util;

public enum Behaviour {
	Enemy(1, "Zły"),
	Ally(2, "Dobry"),
	Neutral(3, "Neutralny");
	
	private int value;
	private String name;

	private Behaviour(int value, String name) {
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
