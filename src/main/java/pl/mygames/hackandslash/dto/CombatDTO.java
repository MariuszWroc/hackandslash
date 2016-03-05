package pl.mygames.hackandslash.dto;

import java.util.List;

import pl.mygames.hackandslash.dto.util.general.ItemPlace;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.model.Item;

public class CombatDTO {
	private Integer userHeroId;
	private Integer enemyId;
	private Integer attackRoll;
	private GameCharacter userHero;
	private List<GameCharacter> enemies;
	
	private void test() {
		BackpackDTO backpack = new BackpackDTO();
	}
}
