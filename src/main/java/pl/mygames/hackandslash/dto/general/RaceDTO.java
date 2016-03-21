/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto.general;

import java.io.Serializable;
import pl.mygames.hackandslash.util.constant.user.UserRace;

/**
 *
 * @author Jaca
 */
public final class RaceDTO implements Serializable{
        private static final long serialVersionUID = 1L;
	private final int id;
	private final String name;
	private final int [] professionAccessArray;
	private final int minStrength;
	private final int minDexterity;
	private final int minConstitution;
	private final int minIntelligence;
	private final int minCharisma;
	private final int maxStrength;
	private final int maxDexterity;
	private final int maxConstitution;
	private final int maxIntelligence;
	private final int maxCharisma;

    public RaceDTO() {
        this.id = 0;
        this.name = null;
        this.professionAccessArray = null;
        this.minStrength = 0;
        this.minDexterity = 0;
        this.minConstitution = 0;
        this.minIntelligence = 0;
        this.minCharisma = 0;
        this.maxStrength = 0;
        this.maxDexterity = 0;
        this.maxConstitution = 0;
        this.maxIntelligence = 0;
        this.maxCharisma = 0;
    }
        
        

	public RaceDTO(UserRace race) {
		this.id = race.getId();
		this.name = race.getName();
		this.professionAccessArray = race.getProfessionAccess();
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
	
	public int[] getProfessionAccessArray() {
		return professionAccessArray;
	}

    @Override
    public String toString() {
        return "RaceDTO{" + "id=" + id + ", name=" + name + ", professionAccessArray=" + professionAccessArray + ", minStrength=" + minStrength + ", minDexterity=" + minDexterity + ", minConstitution=" + minConstitution + ", minIntelligence=" + minIntelligence + ", minCharisma=" + minCharisma + ", maxStrength=" + maxStrength + ", maxDexterity=" + maxDexterity + ", maxConstitution=" + maxConstitution + ", maxIntelligence=" + maxIntelligence + ", maxCharisma=" + maxCharisma + '}';
    }
        
}
