package pl.mygames.hackandslash.service;

import java.util.List;
import pl.mygames.hackandslash.model.Equipment;

public interface IEquipmentService {
    void add(Equipment equipment);
    void delete(Equipment equipment);
    void update(Equipment equipment);
    Equipment findById(Integer id);
    List<Equipment> findAll();
    List<Equipment> findByQuery(Integer id);
}
