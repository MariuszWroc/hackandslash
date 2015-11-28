/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import java.io.Serializable;
import pl.mygames.hackandslash.model.GameUser;

/**
 *
 * @author mariusz
 */
public class UserDTO extends LoginDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;
    private Integer gender;
    private String email;
    private Boolean activated;
    
    public UserDTO(){
        super();
    }
    
    public UserDTO(GameUser user){
        super(user);
        id = user.getId();
        firstname = user.getFirstname();
        lastname = user.getLastname();
        age = user.getAge();
        gender = user.getGender();
        email = user.getEmail();
        activated = user.getActivated();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
    
    
}
