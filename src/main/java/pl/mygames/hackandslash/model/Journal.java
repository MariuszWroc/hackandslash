/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author mariusz
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Journal.findAll", query = "SELECT j FROM Journal j"),
    @NamedQuery(name = "Journal.findById", query = "SELECT j FROM Journal j WHERE j.id = :id")})
public class Journal extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @JoinColumn(name = "Quest_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Quest quest;
    @JoinColumn(name = "Hero_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Hero hero;
    @Basic(optional = false)
    private Integer passed;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    public Journal() {
    }

    public Journal(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Quest getQuest() {
		return quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

	public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

	public Integer getPassed() {
		return passed;
	}

	public void setPassed(Integer passed) {
		this.passed = passed;
	} 

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
}
