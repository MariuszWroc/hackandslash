package pl.mygames.hackandslash.util.constant;

public enum Behaviour {
	ENEMY(1, "Zły"),
	ALLY(2, "Dobry"),
	NEUTRAL(3, "Neutralny");
	
	private final int id;
	private final String name;

	private Behaviour(int id, String name) {
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
