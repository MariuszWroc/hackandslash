package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.UserDao;
import pl.mygames.hackandslash.dto.util.Rolename;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IRoleService;
import pl.mygames.hackandslash.service.IUserService;

@Service
@Transactional(readOnly = true)
public class UserService implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
    @Autowired
    private UserDao dao;
    
    @Autowired
    private IRoleService roleService;

    public void setUserDao(UserDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = false)
    @Override
    public Boolean add(GameUser user) {
    	if(!isUserExist(user.getLogin())) {
        	user.setId(generateId());
        	user.setActivated(Boolean.TRUE);
        	setDefaultRole(user);
            dao.add(user);
            return true;
    	} else {
    		logger.info("User already exist.");
    		return false;
    	}

    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(GameUser user) {
        dao.delete(user);
    }
    
    @Transactional(readOnly = false)
//  @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(GameUser user) {
    	setDefaultRole(user);
    	dao.update(user);
    }

	private void setDefaultRole(GameUser user) {
		Integer idRole = Rolename.USER.getId();
		List<GameRole> gameRole = roleService.findById(idRole);
        if(gameRole.iterator().hasNext()) {
        	user.setGameRole(gameRole.iterator().next());	
        }
	}
	
    @Override
	public Integer generateId() {
		return dao.generateId();
	}
	
    @Override
    public List<GameUser> findByLogin(String login) {
        return dao.findByQuery("GameUser.findByLogin", "login", login);
    }

    @Override
    public List<GameUser> findById(Integer id) {
        return dao.findByQuery("GameUser.findById", id);
    }

    @Override
    public List<GameUser> findAll() {
        return dao.findByQuery("GameUser.findAll");
    }
    
    private Boolean isUserExist(String login) {
    	if (findByLogin(login).isEmpty()) {
    		return false;
    	} else {
    		return true;
    	}
    }

}
