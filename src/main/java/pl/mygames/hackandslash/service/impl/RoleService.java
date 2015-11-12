package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Override
    public void update(GameRole role) {
	dao.update(role);
    }

    @Override
    public GameRole findById(Integer id) {
        return dao.findById(id);
    }
    
    @Override
    public GameRole findByQuery(Integer id) {
        return dao.findAllByCriteria().iterator().next();
    }

    @Override
    public List<GameRole> findAll() {
        return dao.findAll();
    }

}
