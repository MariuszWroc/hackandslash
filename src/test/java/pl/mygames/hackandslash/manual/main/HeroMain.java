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
		HeroDTO heroDTO = null;
		String login = "mczarny";
//		creationService.add(heroDTO, login);
		
		logger.info("OK");
	}

}
