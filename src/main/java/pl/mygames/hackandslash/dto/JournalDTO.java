/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import java.io.Serializable;
import java.util.List;

import pl.mygames.hackandslash.model.Quest;
/**
 *
 * @author mariusz
 */
public class JournalDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<Quest> quests;
}
