package pl.mygames.hackandslash.dto;

import java.io.Serializable;
import java.util.List;

import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.util.constant.AttackUI;

public class CombatDTO implements Serializable{
    private static final long serialVersionUID = 1L;
	private Hero yourCharacter;
	private List<Hero> enemies;
	private AttackUI attackMenu;

    public Hero getYourCharacter() {
        return yourCharacter;
    }

    public void setYourCharacter(Hero yourCharacter) {
        this.yourCharacter = yourCharacter;
    }

    public List<Hero> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Hero> enemies) {
        this.enemies = enemies;
    }

    public AttackUI getAttackMenu() {
        return attackMenu;
    }

    public void setAttackMenu(AttackUI attackMenu) {
        this.attackMenu = attackMenu;
    }

    @Override
    public String toString() {
        return "CombatDTO{" + "yourCharacter=" + yourCharacter + ", enemies=" + enemies + ", attackMenu=" + attackMenu + '}';
    }
	
}
