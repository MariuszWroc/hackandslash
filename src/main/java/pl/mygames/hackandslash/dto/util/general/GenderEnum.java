package pl.mygames.hackandslash.dto.util.general;

public enum GenderEnum {
	DEFAULT(0, ""),
	MALE(1, "Mężczyzna"),
	FEMALE(2, "Kobieta");
	
	private final int id;
	private final String name;

	private GenderEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
