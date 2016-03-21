package pl.mygames.hackandslash.util.constant;

public enum Rolename {
	ADMIN(1,"ROLE_ADMIN"),
	USER(2,"ROLE_USER");
	
	private final int id;
	private final String name;
	
	private Rolename(int value, String name) {
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
