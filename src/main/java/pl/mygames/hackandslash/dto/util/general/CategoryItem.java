package pl.mygames.hackandslash.dto.util.general;

public enum CategoryItem {
	SHIELDS(1, "Tarcze"),
	SWORDS(2, "Miecze"),
	BOWS(3, "Łuki"),
	STAFFS(4, "Kije"),
	LIQUIDS(4, "Mikstury");
	
	
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
