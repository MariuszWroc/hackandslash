package pl.mygames.hackandslash.service;

import pl.mygames.hackandslash.model.Equipment;

public interface IEquipmentService {
    void add(Equipment equipment);
    void delete(Equipment equipment);
    void update(Equipment equipment);
    Equipment findById(Integer id);	
}
