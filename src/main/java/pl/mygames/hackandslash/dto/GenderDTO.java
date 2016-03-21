/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import java.io.Serializable;
import pl.mygames.hackandslash.util.constant.GenderEnum;

/**
 *
 * @author Jaca
 */
public final class GenderDTO implements Serializable{
    private static final long serialVersionUID = 1L;
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
