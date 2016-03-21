/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto.general;

import java.io.Serializable;
import pl.mygames.hackandslash.model.Place;


/**
 *
 * @author XE050991049
 */
public final class PlaceDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private final Integer id;
    private final Integer latitude;
    private final Integer longitude;
    private final Integer radius;    

    public PlaceDTO() {
        this.id = null;
        this.latitude = null;
        this.longitude = null;
        this.radius = null;
    }

    public PlaceDTO(Place place) {
        this.id = place.getId();
        this.latitude = place. getLatitude();
        this.longitude = place.getLongitude();
        this.radius = place.getRadius();
    }

    public Integer getId() {
        return id;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public Integer getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "PlaceDTO{" + "id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", radius=" + radius + '}';
    }
    
}
