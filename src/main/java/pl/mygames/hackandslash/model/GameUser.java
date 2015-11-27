/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

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
    @NamedQuery(name = "GameUser.findByActivated", query = "SELECT g FROM GameUser g WHERE g.activated = :activated")})
public class GameUser extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 45)
    private String firstname;
    @Size(max = 45)
    private String lastname;
    private Integer age;
    private Integer gender;
    @NotBlank
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String login;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    @Size(min = 3, max = 45)
    private String password;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    @Email
    private String email;
    @Basic(optional = false)
    @Column(nullable = false)
    private Boolean activated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameUser", fetch = FetchType.LAZY)
    private List<Hero> heroList;
    @JoinColumn(name = "GameRole_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GameRole gameRole;

    public GameUser() {
    }

    public GameUser(Integer id, Integer age, String firstname, String lastname, 
                    String login, String password) {
        this.id = id;
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
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

    public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
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
    
    public String getEmail() {
		return email;
	}
    
    public void setEmail(String email) {
		this.email = email;
	}
}
