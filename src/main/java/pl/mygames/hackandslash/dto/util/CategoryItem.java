package pl.mygames.hackandslash.dto.util;

public enum CategoryItem {
	Shields(1),
	Swords(2),
	Bows(3);
	
	private int value;

	private CategoryItem(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
