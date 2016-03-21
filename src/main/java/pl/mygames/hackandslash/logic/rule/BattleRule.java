package pl.mygames.hackandslash.logic.rule;

import pl.mygames.hackandslash.util.constant.AttackUI;
import pl.mygames.hackandslash.model.Hero;

public final class BattleRule {
	private final Hero player;
	private final Hero enemy;

	public BattleRule(Hero player, Hero enemy) {
		this.player = player;
		this.enemy = enemy;
	}
	
	public void attack(AttackUI selectedAction) {
		if(selectedAction.ATTACK_BY_HAND.name() != null) {
			
		} else if (selectedAction.USE_ABILITY.name() != null) {
			
		} else if (selectedAction.USE_SPELL.name() != null) {
			
		}
	}
	
	public void defend() {
		
	}
	
	public void escape() {
		
	}
	
	public void useQuickItem(Hero player) {
		player.getGameCharacter().getEquipmentList().iterator().next().getItem();
	}
	
	

	public Hero getPlayer() {
		return player;
	}

	public Hero getEnemy() {
		return enemy;
	}
	
}
