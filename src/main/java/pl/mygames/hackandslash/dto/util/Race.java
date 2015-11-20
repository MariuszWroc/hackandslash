package pl.mygames.hackandslash.dto.util;

public enum Race {
	Animal(0, "Zwierzę"),
	Human(1, "Człowiek"),
	Elf(2, "Elf"),
	Ork(3, "Ork"),
	Dwarf(4, "Krasnolud"),
	Halflings(5, "Niziołek"),
	Gnome(6, "Gnome"),
	Kobold(7, "Kobold"),
	Ogre(8, "Ogr"),
	Gnoll(9, "Gnolle");
	
	
	private final int id;
	private final String name;

	private Race(int value, String name) {
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
