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
    @NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e"),
    @NamedQuery(name = "Equipment.findById", query = "SELECT e FROM Equipment e WHERE e.id = :id")})
public class Equipment extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipment", fetch = FetchType.EAGER)
    private List<Item> itemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipment", fetch = FetchType.EAGER)
    private List<GameCharacter> gameCharacterList;

    public Equipment() {
    }

    public Equipment(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<GameCharacter> getGameCharacterList() {
        return gameCharacterList;
    }

    public void setGameCharacterList(List<GameCharacter> gameCharacterList) {
        this.gameCharacterList = gameCharacterList;
    }
    
}
