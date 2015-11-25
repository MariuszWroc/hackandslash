package pl.mygames.hackandslash.dto.util.general;

public enum Behaviour {
	Enemy(1, "Zły"),
	Ally(2, "Dobry"),
	Neutral(3, "Neutralny");
	
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
