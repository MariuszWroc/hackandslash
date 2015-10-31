package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.Hero;

public interface IHeroService {
    void add(Hero hero);
    void delete(Hero hero);
    void update(Hero hero);
    Hero findById(Integer id);	
    List<Hero> findAll();
}
