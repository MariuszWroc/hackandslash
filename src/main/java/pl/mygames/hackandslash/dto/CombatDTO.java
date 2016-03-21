package pl.mygames.hackandslash.dto;

import pl.mygames.hackandslash.dto.user.BackpackDTO;
import java.io.Serializable;
import java.util.List;

import pl.mygames.hackandslash.model.GameCharacter;

public class CombatDTO implements Serializable{
    private static final long serialVersionUID = 1L;
	private Integer userHeroId;
	private Integer enemyId;
	private Integer attackRoll;
	private GameCharacter userHero;
	private List<GameCharacter> enemies;
	
	private void test() {
		BackpackDTO backpack = new BackpackDTO();
	}
}
