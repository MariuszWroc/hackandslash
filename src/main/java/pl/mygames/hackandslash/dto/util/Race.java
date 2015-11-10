package pl.mygames.hackandslash.dto.util;

public enum Race {
	Animal(0),
	Human(1),
	Elf(2),
	Ork(3),
	Dwarf(4),
	Halflings(5),
	Gnome(6),
	Kobold(7),
	Ogre(8),
	Gnoll(9);
	
	
	private int value;

	private Race(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
