package pl.mygames.hackandslash.manual.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.service.impl.HeroCreationService;

public class HeroMain {
	private static final Logger logger = LoggerFactory.getLogger(HeroMain.class);
	
	public static void testAddHero() {
		logger.info("Testing add Hero");
		HeroCreationService creationService = new HeroCreationService();
		HeroDTO heroDTO = new HeroDTO();
		heroDTO.setAge(26);
		heroDTO.setGender(1);
		heroDTO.setFirstname("Mario");
		heroDTO.setRace(1);
		heroDTO.setProfession(2);
		heroDTO.setStrength(16);
		heroDTO.setDexterity(12);
		heroDTO.setConstitution(14);
		heroDTO.setIntelligence(10);
		heroDTO.setCharisma(8);
		String login = "mczarny";
//		creationService.add(heroDTO, login);
		
		logger.info("OK");
	}

}
