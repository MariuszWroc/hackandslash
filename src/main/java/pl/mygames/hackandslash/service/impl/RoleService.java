package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.IRoleDao;
import pl.mygames.hackandslash.dao.impl.RoleDao;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.service.IRoleService;

@Service
@Transactional(readOnly = true)
public class RoleService implements IRoleService {
	private static final Logger logger = LoggerFactory.getLogger(RoleService.class);
	
    @Autowired
    private IRoleDao dao;

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
    @Secured("ROLE_ADMIN")
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
    public GameRole findById(Integer id) {
    	GameRole role;
		List<GameRole> roles = dao.findByQuery("GameRole.findById", id);
		if (roles.isEmpty()){
    		logger.info("Role list is empty");
    		role = new GameRole();
    	} else {
    		role = roles.iterator().next();
    		if (roles.size() > 1) {
    			logger.info("Method findById(Integer id) returned more then one result");
    		}
    	}
        return role;
    }

    @Override
    public List<GameRole> findAll() {
        return dao.findByQuery("GameRole.findAll");
    }

    public void setDao(RoleDao dao) {
        this.dao = dao;
    }
}
