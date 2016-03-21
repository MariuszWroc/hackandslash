package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.dto.user.HeroDTO;
import pl.mygames.hackandslash.model.Equipment;
import pl.mygames.hackandslash.model.Hero;

public interface IHeroService extends IGenericService<Hero, Integer>{
    void add(Hero hero);
    void delete(Hero hero);
    void update(Hero hero);
    Hero findById(Integer id);	
    List<Hero> findAll();
	void delete(Integer id);
	void add(HeroDTO heroDTO, String login);
	HeroDTO getHeroByName(String heroName);
	HeroDTO findByUser(String login);
	List<HeroDTO> findAllByUser(String login);
	HeroDTO findDTOById(Integer id);
	Hero update(HeroDTO hero);
}
