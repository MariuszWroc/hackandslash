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
    private String firstname;
    @Size(max = 45)
    private String lastname;
    @Size(max = 45)
    private String gender;
    @Size(max = 45)
    private String age;
    @Size(max = 45)
    private String race;
    @Size(max = 45)
    private String profession;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer charisma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameCharacter", fetch = FetchType.LAZY)
    private List<Npc> npcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameCharacter", fetch = FetchType.LAZY)
    private List<Hero> heroList;
    @JoinColumn(name = "Equipment_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Equipment equipment;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    
}
