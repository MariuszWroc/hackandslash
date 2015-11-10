/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author mariusz
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "GameCharacter.findAll", query = "SELECT g FROM GameCharacter g"),
    @NamedQuery(name = "GameCharacter.findById", query = "SELECT g FROM GameCharacter g WHERE g.id = :id"),
    @NamedQuery(name = "GameCharacter.findByFirstname", query = "SELECT g FROM GameCharacter g WHERE g.firstname = :firstname"),
    @NamedQuery(name = "GameCharacter.findByLastname", query = "SELECT g FROM GameCharacter g WHERE g.lastname = :lastname"),
    @NamedQuery(name = "GameCharacter.findByGender", query = "SELECT g FROM GameCharacter g WHERE g.gender = :gender"),
    @NamedQuery(name = "GameCharacter.findByAge", query = "SELECT g FROM GameCharacter g WHERE g.age = :age"),
    @NamedQuery(name = "GameCharacter.findByRace", query = "SELECT g FROM GameCharacter g WHERE g.race = :race"),
    @NamedQuery(name = "GameCharacter.findByProfession", query = "SELECT g FROM GameCharacter g WHERE g.profession = :profession"),
    @NamedQuery(name = "GameCharacter.findByStrength", query = "SELECT g FROM GameCharacter g WHERE g.strength = :strength"),
    @NamedQuery(name = "GameCharacter.findByDexterity", query = "SELECT g FROM GameCharacter g WHERE g.dexterity = :dexterity"),
    @NamedQuery(name = "GameCharacter.findByConstitution", query = "SELECT g FROM GameCharacter g WHERE g.constitution = :constitution"),
    @NamedQuery(name = "GameCharacter.findByIntelligence", query = "SELECT g FROM GameCharacter g WHERE g.intelligence = :intelligence"),
    @NamedQuery(name = "GameCharacter.findByCharisma", query = "SELECT g FROM GameCharacter g WHERE g.charisma = :charisma")})
public class GameCharacter extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Size(max = 45)
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String firstname;
    @Column(length = 45)
    private String lastname;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer gender;
    private Integer age;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer race;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer profession;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer charisma;
    private Integer baseHP;
    private Integer experience;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameCharacter", fetch = FetchType.LAZY)
    private List<Npc> npcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameCharacter", fetch = FetchType.LAZY)
    private List<Hero> heroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameCharacter", fetch = FetchType.LAZY)
    private List<Equipment> equipmentList;

    public GameCharacter() {
    }

    public GameCharacter(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Npc> getNpcList() {
        return npcList;
    }

    public void setNpcList(List<Npc> npcList) {
        this.npcList = npcList;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }

	public List<Equipment> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<Equipment> equipmentList) {
		this.equipmentList = equipmentList;
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

}
