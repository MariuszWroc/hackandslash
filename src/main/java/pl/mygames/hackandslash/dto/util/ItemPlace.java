package pl.mygames.hackandslash.dto.util;

public enum ItemPlace {
	RightHand(1, "Prawa ręka"),
	LeftHand(2, "Lewa ręka"),
	Head(3, "Głowa"),
	Body(4, "Tułów"),
	Feet(5, "Stopy"),
	Hands(6, "Ręce"),
	LeftFinger(7, "Lewy palec"),
	RightFinger(8, "Prawy palec");
	
	private final int value;
	private final String name;

	private ItemPlace(int value, String name) {
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
