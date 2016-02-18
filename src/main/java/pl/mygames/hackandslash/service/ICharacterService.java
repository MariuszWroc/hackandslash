package pl.mygames.hackandslash.service;

import java.util.List;

import pl.mygames.hackandslash.model.GameCharacter;

public interface ICharacterService extends IGenericService<GameCharacter, Integer>{
        List<GameCharacter> findByName(String characterName);
        GameCharacter createCharacter(GameCharacter character);
}
