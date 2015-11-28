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
    @NamedQuery(name = "Hero.findAll", query = "SELECT h FROM Hero h"),
    @NamedQuery(name = "Hero.findById", query = "SELECT h FROM Hero h WHERE h.id = :id"),
    @NamedQuery(name = "Hero.findByActivated", query = "SELECT h FROM Hero h WHERE h.activated = :activated")})
public class Hero extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer activated;
    @JoinColumn(name = "GameCharacter_id", referencedColumnName = "id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    private GameCharacter gameCharacter;
    @JoinColumn(name = "GameUser_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GameUser gameUser;
    @JoinColumn(name = "Place_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Place place;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hero", fetch = FetchType.LAZY)
    private List<Journal> journalList;
    private Integer money;

    public Hero() {
    }

    public Hero(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public GameUser getGameUser() {
        return gameUser;
    }

    public void setGameUser(GameUser gameUser) {
        this.gameUser = gameUser;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<Journal> getJournalList() {
        return journalList;
    }

    public void setJournalList(List<Journal> journalList) {
        this.journalList = journalList;
    }

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}
    
}
