package pl.mygames.hackandslash.dto.util.general;

public enum CategoryItem {
	Shields(1, "Tarcze"),
	Swords(2, "Miecze"),
	Bows(3, "Łuki");
	
	private final int id;
	private final String name;

	private CategoryItem(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
