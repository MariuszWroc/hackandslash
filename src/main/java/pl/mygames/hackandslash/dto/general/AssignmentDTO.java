/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto.general;

import java.io.Serializable;
import pl.mygames.hackandslash.util.constant.CategoryAssignment;

/**
 *
 * @author XE050991049
 */
public final class AssignmentDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private final Integer id;
    private final String description;
    private final String target;
    private final PlaceDTO place;
    private final CategoryAssignment category;

    public AssignmentDTO() {
        this.id = null;
        this.description = null;
        this.target = null;
        this.place = null;
        this.category = null;
    }
    
    public AssignmentDTO(Integer id, String description, String target, PlaceDTO place, CategoryAssignment category) {
        this.id = id;
        this.description = description;
        this.target = target;
        this.place = place;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTarget() {
        return target;
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public CategoryAssignment getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "AssignmentDTO{" + "id=" + id + ", description=" + description + ", target=" + target + ", place=" + place + ", category=" + category + '}';
    }
    
}
