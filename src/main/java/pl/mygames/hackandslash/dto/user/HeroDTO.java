/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


/**
 *
 * @author mariusz
 */
public class HeroDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private final Integer id;
    private final String login;
    private final Integer activated;
    @NotBlank
    private final String firstname;
    private final String lastname;
    @NotNull
    private final Integer gender;
    @NotNull
    private final Integer age;
    @NotNull
    private final Integer race;
    @NotNull
    private final Integer profession;
    @NotNull
    private final Integer strength;
    @NotNull
    private final Integer dexterity;
    @NotNull
    private final Integer constitution;
    @NotNull
    private final Integer intelligence;
    @NotNull
    private final Integer charisma;
    private final Integer baseHP;
    private final Integer experience;
    private final Integer startingPoints;
    private final Integer money;

	private HeroDTO(HeroBuilder builder) {
			this.id = builder.id;
			this.login = builder.login;
			this.activated = builder.activated;
			this.firstname = builder.firstname;
			this.lastname = builder.lastname;
			this.gender = builder.gender;
			this.age = builder.age;
			this.race = builder.race;
			this.profession = builder.profession;
			this.strength = builder.strength;
			this.dexterity = builder.dexterity;
			this.constitution = builder.constitution;
			this.intelligence = builder.intelligence;
			this.charisma = builder.charisma;
			this.baseHP = builder.baseHP;
			this.experience = builder.experience;
			this.startingPoints = builder.startingPoints;
			this.money = builder.money;
		}

	public HeroDTO() {
		this.id = null;
		this.login = null;
		this.activated = null;
		this.firstname = null;
		this.lastname = null;
		this.gender = null;
		this.age = null;
		this.race = null;
		this.profession = null;
		this.strength = null;
		this.dexterity = null;
		this.constitution = null;
		this.intelligence = null;
		this.charisma = null;
		this.baseHP = null;
		this.experience = null;
		this.startingPoints = null;
		this.money = null;
	}

	public Integer getId() {
        return id;
    }
	
	public String getLogin() {
        return login;
    }

    public Integer getActivated() {
        return activated;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getRace() {
        return race;
    }

    public Integer getProfession() {
        return profession;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public Integer getCharisma() {
        return charisma;
    }

	public Integer getBaseHP() {
		return baseHP;
	}

	public Integer getExperience() {
		return experience;
	}

	public Integer getStartingPoints() {
		return startingPoints;
	}
	
	public Integer getMoney() {
		return money;
	}
	
	public static class HeroBuilder {
	    private Integer id;
	    private String login;
	    private Integer activated;
	    @NotBlank
	    private final String firstname;
	    private String lastname;
	    @NotNull
	    private final Integer gender;
	    @NotNull
	    private final Integer age;
	    @NotNull
	    private final Integer race;
	    @NotNull
	    private final Integer profession;
	    @NotNull
	    private final Integer strength;
	    @NotNull
	    private final Integer dexterity;
	    @NotNull
	    private final Integer constitution;
	    @NotNull
	    private final Integer intelligence;
	    @NotNull
	    private final Integer charisma;
	    private Integer baseHP;
	    private Integer experience;
	    private Integer startingPoints;
	    private Integer money;
	    
	    
	    
		public HeroBuilder(String firstname, Integer gender,
				Integer age, Integer race, Integer profession, Integer strength, Integer dexterity,
				Integer constitution, Integer intelligence, Integer charisma) {
			this.firstname = firstname;
			this.gender = gender;
			this.age = age;
			this.race = race;
			this.profession = profession;
			this.strength = strength;
			this.dexterity = dexterity;
			this.constitution = constitution;
			this.intelligence = intelligence;
			this.charisma = charisma;
		}
		
		public HeroBuilder id(Integer id) {
			this.id = id;
			return this;
		}
		
		public HeroBuilder login(String login) {
			this.login = login;
			return this;
		}

		public HeroBuilder activated(Integer activated) {
			this.activated = activated;
			return this;
		}

		public HeroBuilder lastname(String lastname) {
			this.lastname = lastname;
			return this;
		}
		
		public HeroBuilder baseHP(Integer baseHP) {
			this.baseHP = baseHP;
			return this;
		}
		
		public HeroBuilder experience(Integer experience) {
			this.experience = experience;
			return this;
		}
		
		public HeroBuilder startingPoints(Integer startingPoints) {
			this.startingPoints = startingPoints;
			return this;
		}
		
		public HeroBuilder money(Integer money) {
			this.money = money;
			return this;
		}

		public HeroDTO build() {
			return new HeroDTO(this);
		}
		
		@Override
		public String toString() {
	        return String.format("%s, id: %d [hero: %s %s, with exp: %s]", getClass().getSimpleName(), id, firstname, lastname, experience);
		}
	}
}
