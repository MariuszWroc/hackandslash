/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import pl.mygames.hackandslash.dto.general.QuestDTO;

/**
 *
 * @author XE050991049
 */
public class UserQuestDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private boolean passed;   
    private Date startDate;
    private QuestDTO quest;
    private List<UserAssignmentDTO> userAssignments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public QuestDTO getQuest() {
        return quest;
    }

    public void setQuest(QuestDTO quest) {
        this.quest = quest;
    }

    public List<UserAssignmentDTO> getUserAssignments() {
        return userAssignments;
    }

    public void setUserAssignments(List<UserAssignmentDTO> userAssignments) {
        this.userAssignments = userAssignments;
    }

    @Override
    public String toString() {
        return "UserQuestDTO{" + "id=" + id + ", passed=" + passed + ", startDate=" + startDate + ", quest=" + quest + ", userAssignments=" + userAssignments + '}';
    }
    
}
