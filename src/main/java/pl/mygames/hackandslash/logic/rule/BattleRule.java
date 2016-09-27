package pl.mygames.hackandslash.logic.rule;

import static pl.mygames.hackandslash.util.constant.AttackUI.*;

import java.util.List;

import pl.mygames.hackandslash.model.Equipment;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.model.Hero;

public final class BattleRule {
	private final Hero player;
	private final Hero enemy;

	public BattleRule(Hero player, Hero enemy) {
		this.player = player;
		this.enemy = enemy;
	}
	
	public void attack(String commend) {
		if(ATTACK_BY_HAND.name().equals(commend)) {
			
		} else if (USE_ABILITY.name().equals(commend)) {
			
		} else if (USE_SPELL.name().equals(commend)) {
			
		}
	}
	
	public void defend() {
		
	}
	
	public void escape() {
		
	}
	
	public void useQuickItem(Hero player) {
		GameCharacter gameCharacter = player.getGameCharacter();
		List<Equipment> equipmentList = gameCharacter.getEquipmentList();
		if (equipmentList.iterator().hasNext()) {
			equipmentList.iterator().next().getItem();			
		}
	}
	
	

	public Hero getPlayer() {
		return player;
	}

	public Hero getEnemy() {
		return enemy;
	}
	
}
