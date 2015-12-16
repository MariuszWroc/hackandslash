package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.impl.NpcDao;
import pl.mygames.hackandslash.model.Npc;
import pl.mygames.hackandslash.service.INpcService;

@Service
@Transactional(readOnly = true)
public class NpcService implements INpcService {

    @Autowired
    private NpcDao dao;

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
//  @Secured("ROLE_ADMIN")
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
    public List<Npc> findById(Integer id) {
        return dao.findByQuery("Npc.findById", id);
    }

    @Override
    public List<Npc> findAll() {
        return dao.findByQuery("Npc.findAll");
    }

    public void setDao(NpcDao dao) {
        this.dao = dao;
    }
}
