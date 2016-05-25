package pl.mygames.hackandslash.service;


import pl.mygames.hackandslash.dto.user.HeroDTO;

public interface IHeroCreationService {
	public static final int NO = 0;
	public static final int YES = 1;
	public static final Integer START_EXPERIENCE = 1;
	Integer generateId();
	void add(HeroDTO heroDTO, String login);
}