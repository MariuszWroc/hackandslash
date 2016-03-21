package pl.mygames.hackandslash.util.constant.general;

public enum GeneralRace {
	HUMAN(1, "Człowiek"),
	ELF(2, "Elf"),
	ORC(3, "Ork"),
	DWARF(4, "Krasnolud"),
	HALFLING(5, "Niziołek"),
	GNOME(6, "Gnome"),
	KOBOLD(7, "Kobold"),
	OGRE(8, "Ogr"),
	GNOLL(9, "Gnolle");
	
	
	private final int id;
	private final String name;

	private GeneralRace(int value, String name) {
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
