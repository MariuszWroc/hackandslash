package pl.mygames.hackandslash.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import pl.mygames.hackandslash.model.Hero;

public interface IHeroDao extends IGenericExtendedDao<Hero, Integer>{
	List<Hero> getHeroByParam(String paramName, String paramValue) throws EmptyResultDataAccessException;
}
