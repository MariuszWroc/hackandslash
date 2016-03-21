package pl.mygames.hackandslash.manual.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.mygames.hackandslash.dto.user.HeroDTO;
import pl.mygames.hackandslash.logic.CopyingObjectFactory;
import pl.mygames.hackandslash.model.Hero;

public class FactoryMain {
	private static final Logger logger = LoggerFactory.getLogger(HeroMain.class);
	
	public static void testFactoryHero() {
		logger.info("Testing factory of Hero");
		HeroDTO hero = null;
		Hero heroEntity = new Hero();
		heroEntity.setMoney(100);
		CopyingObjectFactory.makeTransferObject(heroEntity, hero);
	}
}
