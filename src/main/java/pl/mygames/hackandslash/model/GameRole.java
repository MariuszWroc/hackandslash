/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author mariusz
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "GameRole.findAll", query = "SELECT g FROM GameRole g"),
    @NamedQuery(name = "GameRole.findById", query = "SELECT g FROM GameRole g WHERE g.id = :id"),
    @NamedQuery(name = "GameRole.findByRolename", query = "SELECT g FROM GameRole g WHERE g.rolename = :rolename")})
public class GameRole extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Size(max = 45)
    private String rolename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameRole", fetch = FetchType.EAGER)
    private List<GameUser> gameUserList;

    public GameRole() {
    }

    public GameRole(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<GameUser> getGameUserList() {
        return gameUserList;
    }

    public void setGameUserList(List<GameUser> gameUserList) {
        this.gameUserList = gameUserList;
    } 
}
