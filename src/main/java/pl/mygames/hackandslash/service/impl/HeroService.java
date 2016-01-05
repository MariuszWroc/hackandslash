package pl.mygames.hackandslash.service.impl;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.impl.HeroDao;
import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.dto.util.general.Dice;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.service.*;
import pl.mygames.hackandslash.service.impl.logic.Rules;

@Service
@Transactional(readOnly = true)
public class HeroService implements IHeroService {
	private static final Logger logger = LoggerFactory.getLogger(HeroService.class);
	
    @Autowired
    private HeroDao dao;
    
    @Autowired
    private IHeroCreationService heroCreationService;
    
    @Autowired
    private ICharacterService characterService;

    @Transactional(readOnly = false)
    @Override
    public void add(Hero hero) {
        dao.add(hero);
    }
    
    @Transactional(readOnly = false)
    @Override
    public void add(HeroDTO heroDTO, String login) {
    	heroCreationService.add(heroDTO, login);
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
    public HeroDTO findByUser(String login) {
    	Hero heroEntity = null;
    	
    	List<Hero> heroByUserLogin = dao.getHeroByParam("login", login);
    	for (Hero hero : heroByUserLogin) {
    		logger.info("heroByUserLogin " + hero.getId() + " " + hero.getMoney() + " " + hero.getGameUser().getLogin()); 
		}
    	
    	if (heroByUserLogin.iterator().hasNext()) {
    		heroEntity = heroByUserLogin.iterator().next();
    	}
//    	
//        List<GameCharacter> characters = new ArrayList<>();
//        GameCharacter character = null;
//        if (!characters.isEmpty()) {
//        	character = characters.iterator().next();
//        }
    	
    	int diceRoller = Rules.diceRoller(Dice.DICE3D6.getNumberOfDiceThrow(), Dice.DICE3D6.getSideNumber());

		HeroDTO heroDTO = new HeroDTO
				.HeroBuilder("firstname", 1, 19, 1, 1, 10, 12, 14, 16, 14)
					.id(heroEntity.getId())
					.activated(heroEntity.getActivated())
					.startingPoints(diceRoller)
					.build();
        
        return heroDTO;
    }
    
    @Override
    public HeroDTO getHeroByName(String heroName) {
        List<GameCharacter> characters = characterService.findByName(heroName);
        GameCharacter character = null;
        HeroDTO heroDTO = null;
        return null;
    }
    
    @Override    
    public List<HeroDTO> findAllByUser(String login) {
    	List<Hero> heroesByUserLogin = dao.getHeroByParam("login", login);
    	List<HeroDTO> heroesDTOs = new ArrayList<HeroDTO>();
    	int diceRoller = Rules.diceRoller(Dice.DICE3D6.getNumberOfDiceThrow(), Dice.DICE3D6.getSideNumber());
    	
    	for (Hero heroEntity : heroesByUserLogin) {
    		logger.info("findAllByUser " + heroEntity.getId() + " " + heroEntity.getMoney());
    		GameCharacter gameCharacter = heroEntity.getGameCharacter();
			HeroDTO dto = new HeroDTO				
    				.HeroBuilder(gameCharacter.getFirstname(), gameCharacter.getGender(), gameCharacter.getAge(), 
    						gameCharacter.getRace(), gameCharacter.getProfession(), gameCharacter.getStrength(), gameCharacter.getDexterity(), 
    						gameCharacter.getConstitution(), gameCharacter.getIntelligence(), gameCharacter.getCharisma())
					.id(heroEntity.getId())
					.activated(heroEntity.getActivated())
					.startingPoints(diceRoller)
					.baseHP(diceRoller)
					.build();
    		heroesDTOs.add(dto);
    	}
		return heroesDTOs;
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
