/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import pl.mygames.hackandslash.dto.util.user.UserRace;

/**
 *
 * @author Jaca
 */
public class RaceDTO {
	private int id;
	private String name;
	private int [] professionAccess;
	private int minStrength;
	private int minDexterity;
	private int minConstitution;
	private int minIntelligence;
	private int minCharisma;
	private int maxStrength;
	private int maxDexterity;
	private int maxConstitution;
	private int maxIntelligence;
	private int maxCharisma;

	public RaceDTO(UserRace race) {
		this.id = race.getId();
		this.name = race.getName();
		this.professionAccess = race.getProfessionAccess();
		this.minStrength = race.getMinStrength();
		this.minDexterity = race.getMinDexterity();
		this.minConstitution = race.getMinConstitution();
		this.minIntelligence = race.getMinIntelligence();
		this.minCharisma = race.getMinCharisma();
		this.maxStrength = race.getMaxStrength();
		this.maxDexterity = race.getMaxDexterity();
		this.maxConstitution = race.getMaxConstitution();
		this.maxIntelligence = race.getMaxIntelligence();
		this.maxCharisma = race.getMaxCharisma();
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMinCharisma() {
		return minCharisma;
	}
	
	public int getMinDexterity() {
		return minDexterity;
	}
	
	public int getMinIntelligence() {
		return minIntelligence;
	}
	
	public int getMinStrength() {
		return minStrength;
	}
	
	public int getMinConstitution() {
		return minConstitution;
	}

	public int getMaxStrength() {
		return maxStrength;
	}

	public int getMaxDexterity() {
		return maxDexterity;
	}

	public int getMaxConstitution() {
		return maxConstitution;
	}

	public int getMaxIntelligence() {
		return maxIntelligence;
	}

	public int getMaxCharisma() {
		return maxCharisma;
	}
	
	public int[] getProfessionAccess() {
		return professionAccess;
	}
}
