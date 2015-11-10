package pl.mygames.hackandslash.dto.util;

public enum Gender {
	Male(1, "Mężczyzna"),
	Female(2, "Kobieta");
	
	private int value;
	private String name;

	private Gender(int value, String name) {
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
