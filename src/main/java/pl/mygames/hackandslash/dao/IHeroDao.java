package pl.mygames.hackandslash.dao;

import java.util.List;

import pl.mygames.hackandslash.model.Hero;

public interface IHeroDao {
	List<Hero> getHeroByUserLogin(String login);
}
