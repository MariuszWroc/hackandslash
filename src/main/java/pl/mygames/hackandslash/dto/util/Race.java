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
	
	
	private int value;
	private String name;

	private Race(int value, String name) {
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
