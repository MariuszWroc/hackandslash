package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.impl.CharacterDao;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.service.ICharacterService;

@Service
@Transactional(readOnly = true)
public class CharacterService implements ICharacterService {

    @Autowired
    private CharacterDao dao;

    public void setDao(CharacterDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = false)
    @Override
    public void add(GameCharacter character) {
        dao.add(character);
    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(GameCharacter character) {
        dao.delete(character);
    }
    
    @Transactional(readOnly = false)
//  @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(GameCharacter character) {
        dao.update(character);
    }
    
    @Override
    public List<GameCharacter> findById(Integer id) {
        return dao.findByQuery("GameCharacter.findById", id);
    }

    @Override
    public List<GameCharacter> findAll() {
        return dao.findByQuery("GameCharacter.findAll");
    }
    
    @Override
    public List<GameCharacter> findByName(String characterName) {
        return dao.findByQuery("GameCharacter.findByFirstname", "firstname", characterName);
    }
}
