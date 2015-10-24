package pl.mygames.hackandslash.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.model.GameCharacter;

@Repository
public interface CharacterDao extends CrudRepository<GameCharacter, Integer>{

}