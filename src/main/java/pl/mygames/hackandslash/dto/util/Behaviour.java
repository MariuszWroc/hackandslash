package pl.mygames.hackandslash.dto.util;

public enum Behaviour {
	Enemy(1),
	Ally(2),
	Neutral(3);
	
	private int value;

	private Behaviour(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
