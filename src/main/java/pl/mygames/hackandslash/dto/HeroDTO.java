/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import pl.mygames.hackandslash.dto.util.general.Dice;
import pl.mygames.hackandslash.service.impl.logic.Rules;


/**
 *
 * @author mariusz
 */
public class HeroDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Boolean activated;
    @NotBlank
    private String firstname;
    private String lastname;
    @NotNull
    private Integer gender;
    @NotNull
    private Integer age;
    @NotNull
    private Integer race;
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
    private Integer baseHP;
    private Integer experience;
    private Integer startingPoints;

    public HeroDTO() {
		this.startingPoints = Rules.diceRoller(Dice.DICE3D6.getNumberOfDiceThrow(), Dice.DICE3D6.getSideNumber());
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

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

	public Integer getBaseHP() {
		return baseHP;
	}

	public void setBaseHP(Integer baseHP) {
		this.baseHP = baseHP;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getStartingPoints() {
		return startingPoints;
	}

	public void setStartingPoints(Integer startingPoints) {
		this.startingPoints = startingPoints;
	}
	
}
