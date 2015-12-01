package pl.mygames.hackandslash.service;


import pl.mygames.hackandslash.dto.HeroDTO;

public interface IHeroCreationService {
	Integer generateId();
	void add(HeroDTO heroDTO, String login);
}