package pl.mygames.hackandslash.dao;

import java.io.Serializable;

public class AttributeDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int constitution;
    private int charisma;

    
	public AttributeDTO(int strength, int dexterity, int intelligence, int constitution, int charisma) {
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.constitution = constitution;
		this.charisma = charisma;
	}
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
    
    
}
