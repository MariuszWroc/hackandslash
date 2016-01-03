package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.model.Hero;

public interface IHeroService {
    void add(Hero hero);
    void delete(Hero hero);
    void update(Hero hero);
    List<Hero> findById(Integer id);	
    List<Hero> findAll();
	void delete(Integer id);
	void add(HeroDTO heroDTO, String login);
	HeroDTO getHeroByName(String heroName);
	HeroDTO findByUser(String login);
	List<HeroDTO> findAllByUser(String login);
}
