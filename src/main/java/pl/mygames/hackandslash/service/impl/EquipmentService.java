package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.EquipmentDao;
import pl.mygames.hackandslash.model.Equipment;
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
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Equipment equipment) {
        dao.delete(equipment);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Equipment equipment) {
        dao.update(equipment);
    }

    @Override
    public Equipment findById(Integer id) {
        return dao.findById(id);
    }
    
    @Override
    public List<Equipment> findByQuery(Integer id) {
        String query = "FROM Equipment E WHERE E.id = " + id;
        
        return dao.findByQuery(query);
    }

    @Override
    public List<Equipment> findAll() {
        return dao.findAll();
    }

    public void setDao(EquipmentDao dao) {
        this.dao = dao;
    }
}
