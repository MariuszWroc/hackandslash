package pl.mygames.hackandslash.dto.util;

public enum Race {
	Human(1),
	Elf(2);
	
	private int value;

	private Race(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
