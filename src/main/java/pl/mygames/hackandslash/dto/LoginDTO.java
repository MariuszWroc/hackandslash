/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import pl.mygames.hackandslash.model.GameUser;

/**
 *
 * @author mariusz
 */
public class LoginDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    
    
    public LoginDTO(){
        
    }
    
    public LoginDTO(GameUser user){
        login = user.getLogin();
        password = user.getPassword();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
