package pl.mygames.hackandslash.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class HeroProfessionDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @NotNull
    private Integer profession;
    @NotNull
    private Integer strength;
    @NotNull
    private Integer dexterity;
    @NotNull
    private Integer constitution;
    @NotNull
    private Integer intelligence;
    @NotNull
    private Integer charisma;
    

    public Integer getProfession() {
        return profession;
    }

    public void setProfession(Integer profession) {
        this.profession = profession;
    }

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}
    
}
