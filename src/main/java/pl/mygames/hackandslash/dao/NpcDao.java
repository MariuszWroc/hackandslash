package pl.mygames.hackandslash.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.model.Npc;

@Repository
public interface NpcDao extends CrudRepository<Npc, Integer>{

}