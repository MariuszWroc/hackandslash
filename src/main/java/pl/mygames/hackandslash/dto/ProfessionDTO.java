/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import pl.mygames.hackandslash.dto.util.user.UserProfession;

/**
 *
 * @author Jaca
 */
public class ProfessionDTO {
    	private int id;
	private String name;
	private int money;

	public ProfessionDTO(UserProfession profesion) {
		this.id = profesion.getId();
		this.name = profesion.getName();
		this.money = profesion.getMoney();
	}

	public int getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
