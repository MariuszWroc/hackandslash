package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.IEquipmentDao;
import pl.mygames.hackandslash.dto.user.EquipmentDTO;
import pl.mygames.hackandslash.model.Equipment;
import pl.mygames.hackandslash.service.IEquipmentService;

@Service
@Transactional(readOnly = true)
public class EquipmentService implements IEquipmentService {
	private static final Logger logger = LoggerFactory.getLogger(EquipmentService.class);
	
    @Autowired
    private IEquipmentDao dao;

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
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Equipment equipment) {
        dao.update(equipment);
    }
    
    public void findDTOById(Integer id) {
    	EquipmentDTO backpack = new EquipmentDTO();
    	Equipment equipment = findById(id);
//    	backpack.setHeroId(equipment.getGameCharacter().getHero().getId());
//    	backpack.setArmor(equipment.getItem());
//    	backpack.setBoot(equipment.getItem());
//    	backpack.setGloves(equipment.getItem());
//    	backpack.setHeadgear(equipment.getItem());
//    	backpack.setLeftHand(equipment.getItem());
//    	backpack.setRightHand(equipment.getItem());
//    	backpack.setLeftRing(equipment.getItem());
//    	backpack.setRighRring(equipment.getItem());
    }

    @Override
    public Equipment findById(Integer id) {
    	Equipment equipment;
		List<Equipment> equipments = dao.findByQuery("GameCharacter.findById", id);
		if (equipments.isEmpty()){
    		logger.info("Equipments list is empty");
    		equipment = new Equipment();
    	} else {
    		equipment = equipments.iterator().next();
    		if (equipments.size() > 1) {
    			logger.info("Method findEquipment(Integer id) returned more then one result");
    		}
    	}
        return equipment;
    }

    @Override
    public List<Equipment> findAll() {
        return dao.findByQuery("Equipment.findAll");
    }

    public void setDao(IEquipmentDao dao) {
        this.dao = dao;
    }
}
