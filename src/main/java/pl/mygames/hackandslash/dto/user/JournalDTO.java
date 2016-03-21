/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto.user;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author mariusz
 */
public class JournalDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private List<UserQuestDTO> quests;

    public JournalDTO() {
    }

    public JournalDTO(Integer id, List<UserQuestDTO> quests) {
        this.id = id;
        this.quests = quests;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
	public List<UserQuestDTO> getQuests() {
		return quests;
	}
	public void setQuests(List<UserQuestDTO> quests) {
		this.quests = quests;
	}

    @Override
    public String toString() {
        return "JournalDTO{" + "id=" + id + ", quests=" + quests + '}';
    }
        
}
