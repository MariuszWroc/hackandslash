package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.ICharacterDao;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.service.ICharacterService;

@Service
@Transactional(readOnly = true)
public class CharacterService implements ICharacterService {
	private static final Logger logger = LoggerFactory.getLogger(CharacterService.class);
	
    @Autowired
    private ICharacterDao dao;

    @Transactional(readOnly = false)
    @Override
    public GameCharacter createCharacter(GameCharacter character) {
        add(character);
        
        return character;
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
    @Secured("ROLE_ADMIN")
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
    public GameCharacter findById(Integer id) {
    	GameCharacter character;
		List<GameCharacter> characters = dao.findByQuery("GameCharacter.findById", id);
		if (characters.isEmpty()){
    		logger.info("Equipments list is empty");
    		character = new GameCharacter();
    	} else {
    		character = characters.iterator().next();
    		if (characters.size() > 1) {
    			logger.info("Method findEquipment(Integer id) returned more then one result");
    		}
    	}
        return character;
    }

    @Override
    public List<GameCharacter> findAll() {
        return dao.findByQuery("GameCharacter.findAll");
    }
    
    @Override
    public List<GameCharacter> findByName(String characterName) {
        return dao.findByQuery("GameCharacter.findByFirstname", "firstname", characterName);
    }
    
    public void setDao(ICharacterDao dao) {
		this.dao = dao;
	}
}
