package pl.mygames.hackandslash.util.constant;

public enum StartingPoint {
	CITY(1, "Miasto - Stolica");
	
	private final int id;
	private final String name;

	private StartingPoint(int id, String name) {
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
