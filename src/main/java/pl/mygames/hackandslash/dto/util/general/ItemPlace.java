package pl.mygames.hackandslash.dto.util.general;

public enum ItemPlace {
	RIGHT_HAND(1, "Prawa ręka"),
	LEFT_HAND(2, "Lewa ręka"),
	HEAD(3, "Głowa"),
	BODY(4, "Tułów"),
	FEET(5, "Stopy"),
	HANDS(6, "Ręce"),
	LEFT_FINGER(7, "Lewy palec"),
	RIGHT_FINGER(8, "Prawy palec"),
	QUICK_ITEM_SLOT(9, "Quick item"),
	OTHER(0, "Backpack");
	
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
