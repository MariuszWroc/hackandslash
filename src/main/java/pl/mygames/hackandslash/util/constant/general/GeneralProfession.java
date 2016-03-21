package pl.mygames.hackandslash.util.constant.general;

import pl.mygames.hackandslash.service.util.RandomValue;

public enum GeneralProfession {
	VILLAGER(0, "Wieśniak", RandomValue.randomInteger(0, 10)),
	MAGE(1, "Mag", RandomValue.randomInteger(0, 70)),
	WARRIOR(2, "Wojownik", RandomValue.randomInteger(0, 100)),
	HUNTER(3, "Łowca", RandomValue.randomInteger(0, 90)),
	THIEF(4, "Złodziej", RandomValue.randomInteger(0, 80));
	
	
	private final int id;
	private final int money;
	private final String name;

	private GeneralProfession(int id, String name, int money) {
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
