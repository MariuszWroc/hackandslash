/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.dto;

import java.io.Serializable;
import java.util.List;
import pl.mygames.hackandslash.model.GameUser;


/**
 *
 * @author mariusz
 */
@Deprecated
public class RegisterDTO extends UserDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer activated;
    private Integer roleId;
    private List<Integer> heroesIds;
    
    public RegisterDTO(){
        super();
    }
    
    public RegisterDTO(GameUser user){
        super(user);
        activated = 0;
        roleId = 0;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getHeroesIds() {
        return heroesIds;
    }

    public void setHeroesIds(List<Integer> heroesIds) {
        this.heroesIds = heroesIds;
    }
     
}
