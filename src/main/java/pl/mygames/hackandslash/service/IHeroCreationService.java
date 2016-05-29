package pl.mygames.hackandslash.service;


import pl.mygames.hackandslash.dto.user.HeroDTO;

public interface IHeroCreationService {
	public static final int NO = 0;
	public static final int YES = 1;
	public static final Integer START_EXPERIENCE = 1;
	public static final Integer BASIC_ATTACK = 1;
	public static final Integer START_MORALE = 12;
	public static final Integer DEFAULT_FATIGUE = 10;
	public static final Integer DEFAULT_REPUTATION = 12;
	public static final Integer DEFAULT_SPEED = 1;
	Integer generateId();
	void add(HeroDTO heroDTO, String login);
}