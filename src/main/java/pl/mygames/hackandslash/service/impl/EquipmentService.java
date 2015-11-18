package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.EquipmentDao;
import pl.mygames.hackandslash.model.Equipment;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.service.IEquipmentService;

@Service
@Transactional(readOnly = true)
public class EquipmentService implements IEquipmentService {

    @Autowired
    private EquipmentDao dao;

    @Transactional(readOnly = false)
    @Override
    public void add(Equipment equipment) {
        dao.add(equipment);
    }

    @Transactional(readOnly = false)
//    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Equipment equipment) {
        dao.delete(equipment);
    }
    
    @Transactional(readOnly = false)
//  @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Equipment equipment) {
        dao.update(equipment);
    }

    @Override
    public List<Equipment> findById(Integer id) {
        return dao.findByQuery("Equipment.findById", id);
    }

    @Override
    public List<Equipment> findAll() {
        return dao.findByQuery("Equipment.findAll");
    }

    public void setDao(EquipmentDao dao) {
        this.dao = dao;
    }
}
