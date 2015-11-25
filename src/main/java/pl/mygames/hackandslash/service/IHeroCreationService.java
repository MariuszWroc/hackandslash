package pl.mygames.hackandslash.service;


import pl.mygames.hackandslash.dto.HeroDTO;

public interface IHeroCreationService {

	void add(HeroDTO heroDTO);

	Integer generateId();

}