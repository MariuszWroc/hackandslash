package pl.mygames.hackandslash.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.model.Hero;

@Repository
public interface HeroDao extends CrudRepository<Hero, Integer>{

}