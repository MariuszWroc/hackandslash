package pl.mygames.hackandslash.dto.util;

public enum Rolename {
	ADMIN(1,"ROLE_ADMIN"),
	USER(2,"ROLE_USER");
	
	private final int value;
	private final String name;
	
	private Rolename(int value, String name) {
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
