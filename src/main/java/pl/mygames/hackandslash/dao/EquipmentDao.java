package pl.mygames.hackandslash.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.mygames.hackandslash.model.Equipment;

@Repository
public interface EquipmentDao extends CrudRepository<Equipment, Integer>{

}
