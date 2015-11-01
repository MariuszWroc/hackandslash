/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author mariusz
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Quest.findAll", query = "SELECT q FROM Quest q"),
    @NamedQuery(name = "Quest.findById", query = "SELECT q FROM Quest q WHERE q.id = :id"),
    @NamedQuery(name = "Quest.findByDescription", query = "SELECT q FROM Quest q WHERE q.description = :description"),
    @NamedQuery(name = "Quest.findByTarget", query = "SELECT q FROM Quest q WHERE q.target = :target"),
    @NamedQuery(name = "Quest.findByStartDate", query = "SELECT q FROM Quest q WHERE q.startDate = :startDate")})
public class Quest extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Size(max = 45)
    private String description;
    @Size(max = 45)
    private String target;
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    private Date startDate;
    @ManyToMany(mappedBy = "questList", fetch = FetchType.LAZY)
    private List<Journal> journalList;

    public Quest() {
    }

    public Quest(Integer id) {
        this.id = id;
    }
    
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Journal> getJournalList() {
        return journalList;
    }

    public void setJournalList(List<Journal> journalList) {
        this.journalList = journalList;
    }
}
