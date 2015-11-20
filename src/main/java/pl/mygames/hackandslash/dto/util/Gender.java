package pl.mygames.hackandslash.dto.util;

public enum Gender {
	Male(1, "Mężczyzna"),
	Female(2, "Kobieta");
	
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
