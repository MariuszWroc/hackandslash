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
    @NamedQuery(name = "GameUser.findAll", query = "SELECT g FROM GameUser g"),
    @NamedQuery(name = "GameUser.findById", query = "SELECT g FROM GameUser g WHERE g.id = :id"),
    @NamedQuery(name = "GameUser.findByFirstname", query = "SELECT g FROM GameUser g WHERE g.firstname = :firstname"),
    @NamedQuery(name = "GameUser.findByLastname", query = "SELECT g FROM GameUser g WHERE g.lastname = :lastname"),
    @NamedQuery(name = "GameUser.findByAge", query = "SELECT g FROM GameUser g WHERE g.age = :age"),
    @NamedQuery(name = "GameUser.findByGender", query = "SELECT g FROM GameUser g WHERE g.gender = :gender"),
    @NamedQuery(name = "GameUser.findByLogin", query = "SELECT g FROM GameUser g WHERE g.login = :login"),
    @NamedQuery(name = "GameUser.findByPassword", query = "SELECT g FROM GameUser g WHERE g.password = :password"),
    @NamedQuery(name = "GameUser.findByActivated", query = "SELECT g FROM GameUser g WHERE g.activated = :activated")})
public class GameUser extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Size(max = 45)
    private String firstname;
    @Size(max = 45)
    private String lastname;
    private Integer age;
    private Integer gender;
    @Size(max = 45)
    private String login;
    @Size(max = 45)
    private String password;
    private Integer activated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameUser", fetch = FetchType.EAGER)
    private List<Hero> heroList;
    @JoinColumn(name = "GameRole_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private GameRole gameRole;

    public GameUser() {
    }

    public GameUser(Integer id) {
        this.id = id;
    }

    @Override
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

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }

    public GameRole getGameRole() {
        return gameRole;
    }

    public void setGameRole(GameRole gameRole) {
        this.gameRole = gameRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameUser)) {
            return false;
        }
        GameUser other = (GameUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.GameUser[ id=" + id + " ]";
    }
    
}
