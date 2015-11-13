package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.controller.test.TestController;
import pl.mygames.hackandslash.dao.RoleDao;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.service.IRoleService;

@Service
@Transactional(readOnly = true)
public class RoleService implements IRoleService {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    
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
    @Override
    public void update(GameRole role) {
    	dao.update(role);
    }

    @Override
    public GameRole findById(Integer id) {
        return dao.findById(id);
    }
    
    @Override
    public List<GameRole> findByQuery(Integer id) {
        String query = "FROM GameRole R WHERE R.id = " + id;
        
        return dao.findByQuery(query);
    }

    @Override
    public List<GameRole> findAll() {
        return dao.findAll();
    }

}
