package pl.mygames.hackandslash.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.HeroDao;
import pl.mygames.hackandslash.dto.*;
import pl.mygames.hackandslash.dto.util.Profession;
import pl.mygames.hackandslash.dto.util.StartingPoint;
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
	public void add(HeroDTO heroDTO) {
    	Hero hero = new Hero();
		GameCharacter character = new GameCharacter();
    	String login = "mczarny";
    	Integer idPlace = StartingPoint.CITY.getId();
		List<Place> place = placeService.findById(idPlace);
		List<GameUser> user = userService.findByLogin(login);
		hero.setId(heroDTO.getId());
		hero.setActivated(YES);			
		hero.setMoney(chooseMoney());
		if (place.iterator().hasNext()) {
			hero.setPlace(place.iterator().next());			
		}
		hero.setGameCharacter(character);
		if (user.iterator().hasNext()) {
			hero.setGameUser(user.iterator().next());			
		}
		addCharacter(character, heroDTO);
		
    	dao.add(hero);
	}
	
	private void addCharacter(GameCharacter character, HeroDTO heroDTO) {
		character.setId(characterService.findAll().size()+1);
		character.setAge(heroDTO.getAge());
		character.setBaseHP(generateHP(heroDTO.getConstitution()));
		character.setCharisma(heroDTO.getCharisma());
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

	private List<Equipment> addEquipment(GameCharacter character) {

		Item sword = null;
		Item potion = null;
		Equipment rightHand = setBasicWeapon(sword, character);
		Equipment backpackplace = setBasicItem(potion, character);
		List<Equipment> equipments = new ArrayList<>();
		equipments.add(rightHand);
		equipments.add(backpackplace);
		
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

	private Integer generateHP(Integer constitution) {
		int baseHP = 1; 
		if (constitution>0) {
			//TODO: Logic for create baseHP for constitution
		}
		return baseHP;
	}

	private int chooseMoney() {
		return Profession.Warrior.getMoney();
	}
}
