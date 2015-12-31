/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import pl.mygames.hackandslash.dto.util.general.GenderEnum;

/**
 *
 * @author Jaca
 */
public final class GenderDTO {
    private final int id;
    private final String name;

    public GenderDTO(GenderEnum gender) {
            this.id = gender.getId();
            this.name = gender.getName();
    }

    public int getId() {
            return id;
    }

    public String getName() {
            return name;
    }
}
