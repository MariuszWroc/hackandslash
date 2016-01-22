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
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findByCategory", query = "SELECT i FROM Item i WHERE i.category = :category"),
    @NamedQuery(name = "Item.findByWage", query = "SELECT i FROM Item i WHERE i.wage = :wage"),
    @NamedQuery(name = "Item.findByAmount", query = "SELECT i FROM Item i WHERE i.amount = :amount")})
public class Item extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String name;
    private Integer category;
    private Integer wage;
    private Integer attack;
    private Integer defend;
    private Integer magic;
    private Integer addHealth;
    private Integer addStrength;
    private Integer addDexterity;
    private Integer addConstitution;
    private Integer addIntelligence;
    private Integer addCharisma;
    private Integer amount;
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<Equipment> equipmentList;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefend() {
        return defend;
    }

    public void setDefend(Integer defend) {
        this.defend = defend;
    }

    public Integer getMagic() {
        return magic;
    }

    public void setMagic(Integer magic) {
        this.magic = magic;
    }

    public Integer getAddHealth() {
        return addHealth;
    }

    public void setAddHealth(Integer addHealth) {
        this.addHealth = addHealth;
    }

    public Integer getAddStrength() {
        return addStrength;
    }

    public void setAddStrength(Integer addStrength) {
        this.addStrength = addStrength;
    }

    public Integer getAddDexterity() {
        return addDexterity;
    }

    public void setAddDexterity(Integer addDexterity) {
        this.addDexterity = addDexterity;
    }

    public Integer getAddConstitution() {
        return addConstitution;
    }

    public void setAddConstitution(Integer addConstitution) {
        this.addConstitution = addConstitution;
    }

    public Integer getAddIntelligence() {
        return addIntelligence;
    }

    public void setAddIntelligence(Integer addIntelligence) {
        this.addIntelligence = addIntelligence;
    }

    public Integer getAddCharisma() {
        return addCharisma;
    }

    public void setAddCharisma(Integer addCharisma) {
        this.addCharisma = addCharisma;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

	public List<Equipment> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<Equipment> equipmentList) {
		this.equipmentList = equipmentList;
	}
  
}
