package pl.mygames.hackandslash.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.impl.HeroDao;
import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.dto.util.general.StartingPoint;
import pl.mygames.hackandslash.dto.util.user.UserProfession;
import pl.mygames.hackandslash.model.*;
import pl.mygames.hackandslash.service.*;

@Service
@Transactional(readOnly = true)
public class HeroCreationService implements IHeroCreationService {
	private static final int NO = 0;
	private static final int YES = 1;
	private static final Integer START_EXPERIENCE = 1;

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
    	Integer idPlace = StartingPoint.CITY.getId();
		List<Place> place = placeService.findById(idPlace);
		List<GameUser> user = userService.findByLogin(login);
		hero.setId(null);
		hero.setActivated(YES);
		hero.setMoney(chooseMoney());
		if (place.iterator().hasNext()) {
			hero.setPlace(place.iterator().next());			
		}

		if (user.iterator().hasNext()) {
			hero.setGameUser(user.iterator().next());			
		}
		addCharacter(character, heroDTO);
		hero.setGameCharacter(character);
		
    	dao.add(hero);
    	
    	addBasicEquipment(character);
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
		character.setId(null);
		character.setAge(heroDTO.getAge());
		character.setBaseHP(calculateHP(heroDTO.getConstitution()));
		character.setCharisma(heroDTO.getCharisma());
		character.setStrength(heroDTO.getStrength());
		character.setStrength(heroDTO.getIntelligence());
		character.setBaseHP(heroDTO.getBaseHP());
		character.setConstitution(heroDTO.getConstitution());
		character.setDexterity(heroDTO.getDexterity());
		character.setExperience(START_EXPERIENCE);
		character.setFirstname(heroDTO.getFirstname());
		character.setLastname(heroDTO.getLastname());
		character.setRace(heroDTO.getRace());
		character.setGender(heroDTO.getGender());
		character.setProfession(heroDTO.getProfession());
		characterService.add(character);
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
		if (constitution>0) {
			//TODO: Logic for create baseHP for constitution
		}
		return baseHP;
	}

	private int chooseMoney() {
		return UserProfession.WARRIOR.getMoney();
	}

}
