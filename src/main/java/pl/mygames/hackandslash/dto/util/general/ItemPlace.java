package pl.mygames.hackandslash.dto.util.general;

public enum ItemPlace {
	RightHand(1, "Prawa ręka"),
	LeftHand(2, "Lewa ręka"),
	Head(3, "Głowa"),
	Body(4, "Tułów"),
	Feet(5, "Stopy"),
	Hands(6, "Ręce"),
	LeftFinger(7, "Lewy palec"),
	RightFinger(8, "Prawy palec");
	
	private final int id;
	private final String name;

	private ItemPlace(int value, String name) {
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
