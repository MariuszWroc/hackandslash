package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.CharacterDao;
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
    @Override
    public void update(GameCharacter character) {
        dao.update(character);
    }

    @Override
    public GameCharacter findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<GameCharacter> findAll() {
        return dao.findAll();
    }

}
