package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.HeroDao;
import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.dto.util.Profession;
import pl.mygames.hackandslash.dto.util.StartingPoint;
import pl.mygames.hackandslash.model.Equipment;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.model.Place;
import pl.mygames.hackandslash.service.ICharacterService;
import pl.mygames.hackandslash.service.IEquipmentService;
import pl.mygames.hackandslash.service.IPlaceService;
import pl.mygames.hackandslash.service.IUserService;

@Service
@Transactional(readOnly = true)
public class HeroCreationService {
	private static final int activate = 1;

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
	
	@Transactional(readOnly = false)
	public void add(HeroDTO heroDTO) {
    	Hero hero = new Hero();
    	String login = "mczarny";
    	Integer idPlace = StartingPoint.CITY.getValue();
		List<Place> place = placeService.findById(idPlace);
		GameCharacter character = new GameCharacter();
//		Equipment equipments = new Equipment();
		List<GameUser> user = userService.findByLogin(login);
		hero.setActivated(activate);
		hero.setMoney(Profession.Warrior.getMoney());
		if (place.iterator().hasNext()) {
			hero.setPlace(place.iterator().next());			
		}
		hero.setId(10);
		hero.setGameCharacter(character);
		if (user.iterator().hasNext()) {
			hero.setGameUser(user.iterator().next());			
		}

    	dao.add(hero);
	}
}
