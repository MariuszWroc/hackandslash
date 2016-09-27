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
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p"),
    @NamedQuery(name = "Place.findById", query = "SELECT p FROM Place p WHERE p.id = :id"),
    @NamedQuery(name = "Place.findByLatitude", query = "SELECT p FROM Place p WHERE p.latitude = :latitude"),
    @NamedQuery(name = "Place.findByLongitude", query = "SELECT p FROM Place p WHERE p.longitude = :longitude")})
public class Place extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String latitude;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String longitude;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private Integer radius;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place", fetch = FetchType.LAZY)
    private List<Hero> heroList;

    public Place() {
    }

    public Place(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
    
}
