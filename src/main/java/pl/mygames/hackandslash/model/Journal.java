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
    @NamedQuery(name = "Journal.findAll", query = "SELECT j FROM Journal j"),
    @NamedQuery(name = "Journal.findById", query = "SELECT j FROM Journal j WHERE j.id = :id")})
public class Journal extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @JoinTable(name = "Journal_has_Quest", joinColumns = {
        @JoinColumn(name = "Journal_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Quest_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Quest> questList;
    @JoinColumn(name = "Hero_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Hero hero;

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

    public List<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(List<Quest> questList) {
        this.questList = questList;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Journal)) {
            return false;
        }
        Journal other = (Journal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Journal[ id=" + id + " ]";
    }
    
}
