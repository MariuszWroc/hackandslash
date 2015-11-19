package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.controller.test.TestController;
import pl.mygames.hackandslash.controller.util.Autoincrementation;
import pl.mygames.hackandslash.dao.RoleDao;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.service.IRoleService;

@Service
@Transactional(readOnly = true)
public class RoleService implements IRoleService {
    
    @Autowired
    private RoleDao dao;

    public void setDao(RoleDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = false)
    @Override
    public void add(GameRole role) {
        dao.add(role);
    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(GameRole role) {
        dao.delete(role);
    }
    
    @Transactional(readOnly = false)
//  @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(GameRole role) {
    	dao.update(role);
    }

    @Override
    public List<GameRole> findById(Integer id) {
        return dao.findByQuery("GameRole.findById", id);
    }

    @Override
    public List<GameRole> findAll() {
        return dao.findByQuery("GameRole.findAll");
    }

}
