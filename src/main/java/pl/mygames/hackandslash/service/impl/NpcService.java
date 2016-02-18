package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.INpcDao;
import pl.mygames.hackandslash.dao.impl.NpcDao;
import pl.mygames.hackandslash.model.Npc;
import pl.mygames.hackandslash.service.INpcService;

@Service
@Transactional(readOnly = true)
public class NpcService implements INpcService {
	private static final Logger logger = LoggerFactory.getLogger(NpcService.class);
	
    @Autowired
    private INpcDao dao;

    @Transactional(readOnly = false)
    @Override
    public void add(Npc npc) {
        dao.add(npc);
    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Npc npc) {
        dao.delete(npc);
    }
    
    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Npc npc) {
        dao.update(npc);
    }

    @Override
    public Npc findById(Integer id) {
    	Npc npc;
		List<Npc> npcs = dao.findByQuery("GameCharacter.findById", id);
		if (npcs.isEmpty()){
    		logger.info("Equipments list is empty");
    		npc = new Npc();
    	} else {
    		npc = npcs.iterator().next();
    		if (npcs.size() > 1) {
    			logger.info("Method findEquipment(Integer id) returned more then one result");
    		}
    	}
        return npc;
    }

    @Override
    public List<Npc> findAll() {
        return dao.findByQuery("Npc.findAll");
    }

    public void setDao(NpcDao dao) {
        this.dao = dao;
    }
}
