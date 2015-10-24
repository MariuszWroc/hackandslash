package pl.mygames.hackandslash.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.model.GameUser;

@Repository
public interface UserDao extends CrudRepository<GameUser, Integer>{

}
