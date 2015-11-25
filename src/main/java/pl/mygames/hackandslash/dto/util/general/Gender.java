package pl.mygames.hackandslash.dto.util.general;

public enum Gender {
	MALE(1, "Mężczyzna"),
	FEMALE(2, "Kobieta");
	
	private final int id;
	private final String name;

	private Gender(int id, String name) {
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
