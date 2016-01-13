package pl.mygames.hackandslash.dto;

import java.util.List;

import pl.mygames.hackandslash.model.GameCharacter;

public class CombatDTO {
	private Integer userHeroId;
	private Integer enemyId;
	private Integer attackRoll;
	private GameCharacter userHero;
	private List<GameCharacter> enemies;
}
