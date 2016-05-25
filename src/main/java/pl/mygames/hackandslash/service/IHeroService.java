package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.dto.user.HeroDTO;
import pl.mygames.hackandslash.model.Hero;

public interface IHeroService extends IGenericService<Hero, Integer>{
	public static final int ACTIVATED = 1;
	void add(HeroDTO heroDTO, String login);
	HeroDTO getHeroByName(String heroName);
	HeroDTO findByUser(String login);
	List<HeroDTO> findAllByUser(String login);
	HeroDTO findDTOById(Integer id);
	Hero update(HeroDTO hero);
}
