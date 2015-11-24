package pl.mygames.hackandslash.service;

import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dto.HeroDTO;

public interface IHeroCreationService {

	void add(HeroDTO heroDTO);

}