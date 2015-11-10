package pl.mygames.hackandslash.dto.util;

public enum ItemPlace {
	RightHand(1),
	LeftHand(2),
	Head(3),
	Body(4),
	Feet(5),
	Hands(6),
	LeftFinger(7),
	RightFinger(8);
	
	private int value;

	private ItemPlace(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
