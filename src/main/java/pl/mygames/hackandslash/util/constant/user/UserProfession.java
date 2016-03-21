package pl.mygames.hackandslash.util.constant.user;

public enum UserProfession {
	MAGE(1, "Mag", 150, 3, 3, 3, 9, 3),
	WARRIOR(2, "Wojownik", 100, 9, 3, 3, 3, 3),
	HUNTER(3, "Łowca", 120, 13, 13, 14, 3, 3),
	THIEF(4, "Złodziej", 140, 3, 9, 3, 3, 3);
	
	
	private final int id;
	private final String name;
	private final int money;
	private final int minStrength;
	private final int minDexterity;
	private final int minConstitution;
	private final int minIntelligence;
	private final int minCharisma;

	private UserProfession(int id, String name, int money, int minStrength, int minDexterity, int minConstitution,
			int minIntelligence, int minCharisma) {
		this.id = id;
		this.name = name;
		this.money = money;
		this.minStrength = minStrength;
		this.minDexterity = minDexterity;
		this.minConstitution = minConstitution;
		this.minIntelligence = minIntelligence;
		this.minCharisma = minCharisma;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public int getMinStrength() {
		return minStrength;
	}

	public int getMinDexterity() {
		return minDexterity;
	}

	public int getMinConstitution() {
		return minConstitution;
	}

	public int getMinIntelligence() {
		return minIntelligence;
	}

	public int getMinCharisma() {
		return minCharisma;
	}

}

