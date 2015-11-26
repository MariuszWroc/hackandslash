/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import pl.mygames.hackandslash.dto.util.general.Gender;

/**
 *
 * @author Jaca
 */
public class GenderWorkAround {
    private int id;
    private String name;

    public GenderWorkAround(Gender g) {
            this.id = g.getId();
            this.name = g.getName();
    }

    public int getId() {
            return id;
    }

    public String getName() {
            return name;
    }
}
