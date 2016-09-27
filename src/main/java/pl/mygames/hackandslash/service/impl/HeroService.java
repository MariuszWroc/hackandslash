package pl.mygames.hackandslash.service.impl;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.IHeroDao;
import pl.mygames.hackandslash.dao.impl.HeroDao;
import pl.mygames.hackandslash.dto.user.HeroDTO;
import pl.mygames.hackandslash.util.constant.Dice;
import pl.mygames.hackandslash.logic.rule.CreateHeroRule;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.service.*;

@Service
@Transactional(readOnly = true)
public class HeroService implements IHeroService {
	private static final Logger logger = LoggerFactory.getLogger(HeroService.class);
	
    @Autowired
    private IHeroDao dao;
    
    @Autowired
    private IHeroCreationService heroCreationService;
    
    @Autowired
    private ICharacterService characterService;

    @Transactional(readOnly = false)
    @Override
    public void add(Hero hero) {
    	hero.setActivated(ACTIVATED);
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
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Hero hero) {
    	Integer id = hero.getId();
    	Hero heroEntity = findById(id);
    	
    	heroEntity.setMoney(hero.getMoney());
    	
    	dao.update(hero);
    }
    
    @Transactional(readOnly = false)
    @Override
    public Hero update(HeroDTO dto) {
    	Integer id = dto.getId();
    	List<Hero> heroes = dao.findByQuery("Hero.findById", id);
    	Hero heroEntity = new Hero();
    	if (heroes.iterator().hasNext()) {
    		heroEntity = heroes.iterator().next();
    	}
    	
    	if(dto.getMoney() != null) {
        	heroEntity.setMoney(dto.getMoney());	
    	} else {
    		heroEntity.setMoney(0);
    	}
    	GameCharacter gameCharacter = heroEntity.getGameCharacter();
		gameCharacter.setFirstname(dto.getFirstname());
    	gameCharacter.setLastname(dto.getLastname());
    	gameCharacter.setGender(dto.getGender());
    	gameCharacter.setAge(dto.getAge());
    	gameCharacter.setRace(dto.getRace());
    	gameCharacter.setProfession(dto.getProfession());
    	gameCharacter.setDexterity(dto.getDexterity());
    	gameCharacter.setIntelligence(dto.getIntelligence());
    	
    	dao.update(heroEntity);
    	
    	return heroEntity;
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
    	
    	int diceRoller = CreateHeroRule.diceRoller(Dice.DICE3D6.getNumberOfDiceThrow(), Dice.DICE3D6.getSideNumber());

		HeroDTO heroDTO = new HeroDTO
				.HeroBuilder("firstname", 1, 19, 1, 1, 10, 12, 14, 16)
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
    	int diceRoller = CreateHeroRule.diceRoller(Dice.DICE3D6.getNumberOfDiceThrow(), Dice.DICE3D6.getSideNumber());
    	
    	for (Hero heroEntity : heroesByUserLogin) {
    		logger.info("findAllByUser " + heroEntity.getId() + " " + heroEntity.getMoney());
    		GameCharacter gameCharacter = heroEntity.getGameCharacter();
			HeroDTO dto = new HeroDTO				
    				.HeroBuilder(gameCharacter.getFirstname(), gameCharacter.getGender(), gameCharacter.getAge(), 
    						gameCharacter.getRace(), gameCharacter.getProfession(), gameCharacter.getStrength(), gameCharacter.getDexterity(), 
    						gameCharacter.getConstitution(), gameCharacter.getIntelligence())
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
    public HeroDTO findDTOById(Integer id) {
    	List<Hero> heroes = dao.findByQuery("Hero.findById", id);
    	Hero heroEntity = new Hero();
    	if (heroes.iterator().hasNext()) {
    		heroEntity = heroes.iterator().next();
    	}
    	
    	GameCharacter gameCharacter = heroEntity.getGameCharacter();
		Integer race = gameCharacter.getRace();
		Integer strength = gameCharacter.getStrength();
		Integer age = gameCharacter.getAge();
		String firstname = gameCharacter.getFirstname();
		Integer profession = gameCharacter.getProfession();
		Integer gender = gameCharacter.getGender();
		Integer dexterity = gameCharacter.getDexterity();
		Integer intelligence = gameCharacter.getIntelligence();
		Integer constitution = gameCharacter.getConstitution();
		String lastname = gameCharacter.getLastname();
		Integer baseHP = gameCharacter.getBaseHP();
		Integer experience = gameCharacter.getExperienceOnLevel();
		String login = heroEntity.getGameUser().getLogin();
		HeroDTO dto = new HeroDTO
    			.HeroBuilder(firstname, gender, age, race, profession, strength, 
    					dexterity, constitution, intelligence)
    			.id(heroEntity.getId())
    			.activated(heroEntity.getActivated())
    			.lastname(lastname)
    			.baseHP(baseHP)
    			.experience(experience)
    			.money(heroEntity.getMoney())
    			.login(login)
    			.build();
        return dto;
    }

    @Override
    public Hero findById(Integer id) {
		Hero hero;
		List<Hero> heroes = dao.findByQuery("Hero.findById", id);
		if (heroes.isEmpty()){
    		logger.info("Heroes list is empty");
    		hero = new Hero();
    	} else {
    		hero = heroes.iterator().next();
    		if (heroes.size() > 1) {
    			logger.info("Method findHero(Integer id) returned more then one result");
    		}
    	}
		return hero;
    }
    

    @Override
    public List<Hero> findAll() {
        return dao.findByQuery("Hero.findAll");
    }

    public void setDao(HeroDao dao) {
        this.dao = dao;
    }
}
