package pl.mygames.hackandslash.util.constant.user;

public enum UserRace {
	HUMAN(1, "Człowiek", new int [] {
			UserProfession.MAGE.getId(), UserProfession.WARRIOR.getId(), UserProfession.HUNTER.getId() , UserProfession.THIEF.getId()},
			3, 3, 3, 3, 3, 18, 18, 18, 18, 18),
	ELF(2, "Elf", new int [] {
			UserProfession.MAGE.getId(), UserProfession.WARRIOR.getId(), UserProfession.HUNTER.getId(), UserProfession.THIEF.getId()},
			3, 7, 6, 8, 8, 18, 19, 17, 18, 18),
	DWARF(3, "Krasnolud", new int [] {
			UserProfession.WARRIOR.getId(), UserProfession.HUNTER.getId(), UserProfession.THIEF.getId()},
			8, 3, 12, 3, 1, 18, 17, 19, 18, 16),
	HALFLING(4, "Niziołek", new int [] {
			UserProfession.WARRIOR.getId(), UserProfession.HUNTER.getId(), UserProfession.THIEF.getId()},
			6, 8, 10, 6, 3, 17, 19, 18, 18, 18);
	
	private final int id;
	private final String name;
	private final int [] professionAccess;
	private final int minStrength;
	private final int minDexterity;
	private final int minConstitution;
	private final int minIntelligence;
	private final int minCharisma;
	private final int maxStrength;
	private final int maxDexterity;
	private final int maxConstitution;
	private final int maxIntelligence;
	private final int maxCharisma;

	private UserRace(int id, String name, int [] professionAccess, int minStrength, int minDexterity, int minConstitution, int minIntelligence,
			int minCharisma, int maxStrength, int maxDexterity, int maxConstitution, int maxIntelligence,
			int maxCharisma) {
		this.id = id;
		this.name = name;
		this.professionAccess = professionAccess;
		this.minStrength = minStrength;
		this.minDexterity = minDexterity;
		this.minConstitution = minConstitution;
		this.minIntelligence = minIntelligence;
		this.minCharisma = minCharisma;
		this.maxStrength = maxStrength;
		this.maxDexterity = maxDexterity;
		this.maxConstitution = maxConstitution;
		this.maxIntelligence = maxIntelligence;
		this.maxCharisma = maxCharisma;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMinCharisma() {
		return minCharisma;
	}
	
	public int getMinDexterity() {
		return minDexterity;
	}
	
	public int getMinIntelligence() {
		return minIntelligence;
	}
	
	public int getMinStrength() {
		return minStrength;
	}
	
	public int getMinConstitution() {
		return minConstitution;
	}

	public int getMaxStrength() {
		return maxStrength;
	}

	public int getMaxDexterity() {
		return maxDexterity;
	}

	public int getMaxConstitution() {
		return maxConstitution;
	}

	public int getMaxIntelligence() {
		return maxIntelligence;
	}

	public int getMaxCharisma() {
		return maxCharisma;
	}
	
	public int[] getProfessionAccess() {
		return professionAccess;
	}
}
