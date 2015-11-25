package pl.mygames.hackandslash.dto.util.user;

public enum UserProfession {
	Mage(1, "Mag", 150),
	Warrior(2, "Wojownik", 100),
	Hunter(3, "Łowca", 120),
	Thief(4, "Złodziej", 140);
	
	
	private final int id;
	private final int money;
	private final String name;

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
