package pl.mygames.hackandslash.dto.util.user;

public enum UserRace {
	Human(1, "Człowiek"),
	Elf(2, "Elf"),
	Dwarf(3, "Krasnolud"),
	Halflings(4, "Niziołek");
	
	
	private final int id;
	private final String name;

	private UserRace(int value, String name) {
		this.id = value;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
