package pl.mygames.hackandslash.dto.util.user;

public enum UserProfession {
	MAGE(1, "Mag", 150),
	WARRIOR(2, "Wojownik", 100),
	HUNTER(3, "Łowca", 120),
	THIEF(4, "Złodziej", 140);
	
	
	private final int id;
	private final String name;
	private final int money;

	private UserProfession(int id, String name, int money) {
		this.id = id;
		this.name = name;
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
}

