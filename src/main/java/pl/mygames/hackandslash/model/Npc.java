/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.model;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author mariusz
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Npc.findAll", query = "SELECT n FROM Npc n"),
    @NamedQuery(name = "Npc.findById", query = "SELECT n FROM Npc n WHERE n.id = :id"),
    @NamedQuery(name = "Npc.findByBehaviour", query = "SELECT n FROM Npc n WHERE n.behaviour = :behaviour")})
public class Npc extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Size(max = 45)
    private String behaviour;
    @JoinColumn(name = "GameCharacter_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GameCharacter gameCharacter;

    public Npc() {
    }

    public Npc(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }  
}
