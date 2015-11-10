package pl.mygames.hackandslash.dto.util;

public enum Gender {
	Male(1),
	Female(2);
	
	private int value;

	private Gender(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
