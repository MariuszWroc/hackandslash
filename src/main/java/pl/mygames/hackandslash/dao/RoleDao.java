package pl.mygames.hackandslash.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.model.GameRole;

@Repository
public interface RoleDao extends CrudRepository<GameRole, Integer>{

}
