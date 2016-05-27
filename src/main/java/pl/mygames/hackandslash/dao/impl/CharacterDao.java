package pl.mygames.hackandslash.dao.impl;

import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.dao.ICharacterDao;
import pl.mygames.hackandslash.model.GameCharacter;

@Repository
public final class CharacterDao extends GenericExtendedDao<GameCharacter, Integer> implements ICharacterDao {

}