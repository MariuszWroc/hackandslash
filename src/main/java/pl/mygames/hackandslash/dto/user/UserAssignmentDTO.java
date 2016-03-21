/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto.user;

import java.io.Serializable;
import pl.mygames.hackandslash.dto.general.AssignmentDTO;


/**
 *
 * @author XE050991049
 */
public class UserAssignmentDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private boolean passed;
    private AssignmentDTO assignment;

    public UserAssignmentDTO() {
    }
    
    public UserAssignmentDTO(Integer id, boolean passed, AssignmentDTO assignment) {
        this.id = id;
        this.passed = passed;
        this.assignment = assignment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AssignmentDTO getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentDTO assignment) {
        this.assignment = assignment;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    @Override
    public String toString() {
        return "UserAssignmentDTO{" + "id=" + id + ", passed=" + passed + ", assignment=" + assignment + '}';
    }
    
}
