package pl.mygames.hackandslash.dto.util;

public enum ItemPlace {
	RightHand(1);
	
	private int value;

	private ItemPlace(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
