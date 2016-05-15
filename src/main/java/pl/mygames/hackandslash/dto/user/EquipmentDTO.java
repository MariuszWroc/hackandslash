/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto.user;

import java.io.Serializable;
import java.util.List;
import pl.mygames.hackandslash.dto.general.ItemDTO;
import pl.mygames.hackandslash.model.Equipment;

/**
 *
 * @author mariusz
 */
public class EquipmentDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private ItemDTO leftHand;
    private ItemDTO rightHand;
    private ItemDTO boot;
    private ItemDTO armor;
    private ItemDTO headgear;
    private ItemDTO leftRing;
    private ItemDTO righRring;
    private ItemDTO gloves;
    private List<ItemDTO> quickItems;
    private List<ItemDTO> otherItems;

    public EquipmentDTO() {
    }

    public EquipmentDTO(Equipment equipment) {
        this.id = equipment.getId();
        this.leftHand = null;
        this.rightHand = null;
        this.boot = null;
        this.armor = null;
        this.headgear = null;
        this.leftRing = null;
        this.righRring = null;
        this.gloves = null;
        this.quickItems = null;
        this.otherItems = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public ItemDTO getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(ItemDTO leftHand) {
        this.leftHand = leftHand;
    }

    public ItemDTO getRightHand() {
        return rightHand;
    }

    public void setRightHand(ItemDTO rightHand) {
        this.rightHand = rightHand;
    }

    public ItemDTO getBoot() {
        return boot;
    }

    public void setBoot(ItemDTO boot) {
        this.boot = boot;
    }

    public ItemDTO getArmor() {
        return armor;
    }

    public void setArmor(ItemDTO armor) {
        this.armor = armor;
    }

    public ItemDTO getHeadgear() {
        return headgear;
    }

    public void setHeadgear(ItemDTO headgear) {
        this.headgear = headgear;
    }

    public ItemDTO getLeftRing() {
        return leftRing;
    }

    public void setLeftRing(ItemDTO leftRing) {
        this.leftRing = leftRing;
    }

    public ItemDTO getRighRring() {
        return righRring;
    }

    public void setRighRring(ItemDTO righRring) {
        this.righRring = righRring;
    }

    public ItemDTO getGloves() {
        return gloves;
    }

    public void setGloves(ItemDTO gloves) {
        this.gloves = gloves;
    }

    public List<ItemDTO> getQuickItems() {
        return quickItems;
    }

    public void setQuickItems(List<ItemDTO> quickItems) {
        this.quickItems = quickItems;
    }

    public List<ItemDTO> getOtherItems() {
        return otherItems;
    }

    public void setOtherItems(List<ItemDTO> otherItems) {
        this.otherItems = otherItems;
    }

    @Override
    public String toString() {
        return "BackpackDTO{" + "id=" + id + ", leftHand=" + leftHand + ", rightHand=" + rightHand + ", boot=" + boot + ", armor=" + armor + ", headgear=" + headgear + ", leftRing=" + leftRing + ", righRring=" + righRring + ", gloves=" + gloves + ", quickItems=" + quickItems + ", otherItems=" + otherItems + '}';
    }

}
