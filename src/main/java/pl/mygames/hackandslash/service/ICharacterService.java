package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.GameCharacter;

public interface ICharacterService {
    void add(GameCharacter character);
    void delete(GameCharacter character);
    void update(GameCharacter character);
    List<GameCharacter> findById(Integer id);
    List<GameCharacter> findAll();
	void delete(Integer id);
}
