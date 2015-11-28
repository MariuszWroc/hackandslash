package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.HeroDao;
import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.service.ICharacterService;
import pl.mygames.hackandslash.service.IHeroService;

@Service
@Transactional(readOnly = true)
public class HeroService implements IHeroService {

    @Autowired
    private HeroDao dao;
    
    @Autowired
    private ICharacterService characterService;

    @Transactional(readOnly = false)
    @Override
    public void add(Hero hero) {
        dao.add(hero);
    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Hero hero) {
        dao.delete(hero);
    }
    
    @Transactional(readOnly = false)
//  @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Hero hero) {
	dao.update(hero);
    }
    
    @Override
    public HeroDTO getHeroDTO(String heroName) {
        
        List<GameCharacter> characters = characterService.findByName(heroName);
        return null;
    }

    @Override
    public List<Hero> findById(Integer id) {
        return dao.findByQuery("Hero.findById", id);
    }

    @Override
    public List<Hero> findAll() {
        return dao.findByQuery("Hero.findAll");
    }

    public void setDao(HeroDao dao) {
        this.dao = dao;
    }
}
