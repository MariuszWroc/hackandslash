package pl.mygames.hackandslash.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.impl.HeroDao;
import pl.mygames.hackandslash.dto.user.HeroDTO;
import static pl.mygames.hackandslash.util.constant.StartingPoint.START_CITY;
import static pl.mygames.hackandslash.util.constant.user.UserProfession.*;
import pl.mygames.hackandslash.model.*;
import pl.mygames.hackandslash.service.*;

@Service
@Transactional(readOnly = true)
public class HeroCreationService implements IHeroCreationService {
	private static final Logger logger = LoggerFactory.getLogger(HeroCreationService.class);

	@Autowired
	private HeroDao dao;

	@Autowired
	private IEquipmentService equipmentService;
	
	@Autowired
	private IItemService itemService;
	
	@Autowired
	private ICharacterService characterService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IPlaceService placeService;
	
	/* (non-Javadoc)
	 * @see pl.mygames.hackandslash.service.impl.IHeroCreationService#add(pl.mygames.hackandslash.dto.HeroDTO)
	 */
	@Override
	@Transactional(readOnly = false)
	public void add(HeroDTO heroDTO, String login) {
    	Hero hero = new Hero();
		GameCharacter character = new GameCharacter();
		Place place = placeService.findById(START_CITY.getId());
		List<GameUser> user = userService.findByLogin(login);
		
		addCharacter(character, heroDTO);
		addBasicEquipment(character);
		
		hero.setId(null);
		hero.setActivated(YES);
		hero.setMoney(chooseMoney());
		hero.setSpeed(DEFAULT_SPEED);
		hero.setPlace(place);
		
    	dao.add(hero);  	
	}
	
    @Override
	public Integer generateId() {
		return dao.generateId();
	}

	private void setDefaultId(HeroDTO heroDTO, Hero hero) {
		Integer id = heroDTO.getId();
		if (id == null) {
			hero.setId(dao.generateId());
		} else {
			hero.setId(id);
		}
	}
	
	private void addCharacter(GameCharacter character, HeroDTO heroDTO) {
		Integer calculatedHP = calculateHP(heroDTO.getConstitution());
		Integer calculatedAC = calculateAC(heroDTO.getDexterity());
		Integer calculatedLevel = calculateLevel(heroDTO.getProfession());
		character.setId(null);
		character.setAge(heroDTO.getAge());
		character.setStrength(heroDTO.getStrength());
		character.setStrength(heroDTO.getIntelligence());
		character.setConstitution(heroDTO.getConstitution());
		character.setDexterity(heroDTO.getDexterity());
		character.setFirstname(heroDTO.getFirstname());
		character.setLastname(heroDTO.getLastname());
		character.setRace(heroDTO.getRace());
		character.setGender(heroDTO.getGender());
		character.setProfession(heroDTO.getProfession());
		character.setBaseAC(calculatedAC);
		character.setEffectiveAC(calculatedAC);
		character.setBaseHP(calculatedHP);
		character.setCurrentHP(calculatedHP);
		character.setActualLevel(calculatedLevel);
		character.setExperienceOnLevel(START_EXPERIENCE);
		
		characterService.add(character);
	}

	private Integer calculateLevel(Integer profession) {
		int level = 1; 
		if (profession > 0) {
			//TODO: Logic for create level for profession
		}
		return level;
	}

	private Integer calculateAC(Integer dexterity) {
		int baseAC = 10; 
		if (dexterity > 0) {
			//TODO: Logic for create baseAC for dexterity
		}
		return baseAC;
	}

	// TODO: dokończyć
	private List<Equipment> addBasicEquipment(GameCharacter character) {
		Item staff = null;
		Item potion = null;
		
		if (itemService.findByName("Staff").iterator().hasNext()) {
			staff = itemService.findByName("Staff").iterator().next();
		}
		if (itemService.findByName("Potion of healing").iterator().hasNext()) {
			potion = itemService.findByName("Potion of healing").iterator().next();
		}
		
		Equipment staffEquiped = setBasicWeapon(staff, character);
		Equipment potionEquiped = setBasicItem(potion, character);
		
		List<Equipment> equipments = new ArrayList<>();
		equipments.add(staffEquiped);
		equipments.add(potionEquiped);
		
		return equipments;
	}
	
	private Equipment setBasicItem(Item item, GameCharacter character) {
		Equipment potion = new Equipment();
		potion.setId(equipmentService.findAll().size()+1);
		potion.setItem(item);
		potion.setInPlace(NO);
		potion.setGameCharacter(character);
		equipmentService.add(potion);
		
		return potion;
	}

	private Equipment setBasicWeapon(Item item, GameCharacter character) {
		Equipment weapon = new Equipment();
		weapon.setId(equipmentService.findAll().size()+1);
		weapon.setItem(item);
		weapon.setInPlace(NO);
		weapon.setGameCharacter(character);
		equipmentService.add(weapon);
		
		return weapon;
	}

	private Integer calculateHP(Integer constitution) {
		int baseHP = 10; 
		if (constitution > 0) {
			//TODO: Logic for create baseHP for constitution
		}
		return baseHP;
	}

	private int chooseMoney() {
		return WARRIOR.getMoney();
	}

	public void setDao(HeroDao dao) {
		this.dao = dao;
	}
}
