package pl.mygames.hackandslash.dto.util;

public enum CategoryItem {
	Shields(1, "Tarcze"),
	Swords(2, "Miecze"),
	Bows(3, "Łuki");
	
	private final int value;
	private final String name;

	private CategoryItem(int value, String name) {
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
