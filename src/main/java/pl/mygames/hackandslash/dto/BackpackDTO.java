/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import pl.mygames.hackandslash.dto.util.general.ItemPlace;
import pl.mygames.hackandslash.model.*;

/**
 *
 * @author mariusz
 */
public class BackpackDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Item leftHand;
    private Item rightHand;
    private Item boot;
    private Item armor;
    private Item headgear;
    private Item leftRing;
    private Item righRring;
    private Item gloves;
    private List<Item> quickItems;
    private List<Item> otherItems;
    private Integer heroId;
    

	public Item getRightHand() {
		return rightHand;
	}
	public void setRightHand(Item rightHand) {
		this.rightHand = rightHand;
	}
	public Item getBoot() {
		return boot;
	}
	public void setBoot(Item boot) {
		this.boot = boot;
	}
	public Item getArmor() {
		return armor;
	}
	public void setArmor(Item armor) {
		this.armor = armor;
	}
	public Item getHeadgear() {
		return headgear;
	}
	public void setHeadgear(Item headgear) {
		this.headgear = headgear;
	}
	public Item getLeftRing() {
		return leftRing;
	}
	public void setLeftRing(Item leftRing) {
		this.leftRing = leftRing;
	}
	public Item getRighRring() {
		return righRring;
	}
	public void setRighRring(Item righRring) {
		this.righRring = righRring;
	}
	public Item getGloves() {
		return gloves;
	}
	public void setGloves(Item gloves) {
		this.gloves = gloves;
	}
	public List<Item> getQuickItems() {
		return quickItems;
	}
	public void setQuickItems(List<Item> quickItems) {
		this.quickItems = quickItems;
	}
	public List<Item> getOtherItems() {
		return otherItems;
	}
	public void setOtherItems(List<Item> otherItems) {
		this.otherItems = otherItems;
	}   
    public Integer getHeroId() {
		return heroId;
	}
    public void setHeroId(Integer heroId) {
		this.heroId = heroId;
	}
	public Item getLeftHand() {
		return leftHand;
	}
	public void setLeftHand(Item leftHand) {
		this.leftHand = leftHand;
	}
    
}
