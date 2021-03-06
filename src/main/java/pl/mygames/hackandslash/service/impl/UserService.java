package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.IUserDao;
import pl.mygames.hackandslash.dao.impl.UserDao;
import pl.mygames.hackandslash.dto.web.LoginDTO;
import pl.mygames.hackandslash.dto.user.UserDTO;
import pl.mygames.hackandslash.util.constant.Rolename;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IRoleService;
import pl.mygames.hackandslash.service.IUserService;

@Service
@Transactional(readOnly = true)
public class UserService implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
    @Autowired
    private IUserDao dao;
    
    @Autowired
    private IRoleService roleService;

    @Transactional(readOnly = false)
    @Override
    public Boolean isAdd(GameUser user) {
        	user.setId(generateId());
        	user.setActivated(Boolean.TRUE);
        	setDefaultRole(user);
            dao.add(user);
            return true;
    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(GameUser user) {
        dao.delete(user);
    }
    
    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    @Override
    public void delete(Integer id) {
    	dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(GameUser user) {
//    	setDefaultRole(user);
    	dao.update(user);
    }
	
    @Override
	public Integer generateId() {
		return dao.generateId();
	}
        
    @Override
    public UserDTO getUserDTO(String login) {
        List<GameUser> gameUsers = findByLogin(login);
        if(gameUsers.iterator().hasNext()) {
           return new UserDTO(gameUsers.iterator().next());
        } else {
           return new UserDTO(); 
        }
    }
	
    @Override
    public List<GameUser> findByLogin(String login) {
        return dao.findByQuery("GameUser.findByLogin", "login", login);
    }
    
    @Override
    public List<GameUser> findByPassword(String password) {
        return dao.findByQuery("GameUser.findByPassword", "password", password);
    }
    
    @Override
    public List<GameUser> findByEmail(String email) {
        return dao.findByQuery("GameUser.findByEmail", "email", email);
    }


    @Override
    public GameUser findById(Integer id) {
    	GameUser user;
		List<GameUser> users = dao.findByQuery("GameCharacter.findById", id);
		if (users.isEmpty()){
    		logger.info("Equipments list is empty");
    		user = new GameUser();
    	} else {
    		user = users.iterator().next();
    		if (users.size() > 1) {
    			logger.info("Method findEquipment(Integer id) returned more then one result");
    		}
    	}
        return user;
    }

    @Override
    public List<GameUser> findAll() {
        return dao.findByQuery("GameUser.findAll");
    }
    
    @Override
    public Boolean isLoginSuccess(LoginDTO loginDTO) {
    	boolean userExist = isUserExist(loginDTO.getUsername());
    	boolean passwordCorrect = isPasswordCorrect(loginDTO.getPassword());
    	if((userExist) && (passwordCorrect)) {
        	logger.info("login success");
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    
    @Override
	public Boolean isRegisterUserValid(String login, String email) {
    	if ((!isUserExist(login)) && (!isEmailExist(email))) {
    		return true;
    	} else {
    		return false;
    	}
    }

	private void setDefaultRole(GameUser user) {
		Integer idRole = Rolename.USER.getId();
        user.setGameRole(roleService.findById(idRole));	
	}
	
	private Boolean isUserExist(String login) {
    	if (findByLogin(login).isEmpty()) {
    		return false;
    	} else {
        	logger.info("user exist");
    		return true;
    	}
    }
	
	private Boolean isEmailExist(String email) {
    	if (findByEmail(email).isEmpty()) {
    		return false;
    	} else {
        	logger.info("email exist");
    		return true;
    	}
    }
    
    private Boolean isPasswordCorrect(String password) {
    	if (findByPassword(password).isEmpty()) {
    		return false;
    	} else {
    		logger.info("password is corrrect");
    		return true;
    	}
    }

	@Override
	@Transactional(readOnly = false)
	public void add(GameUser user) {
    	user.setActivated(Boolean.TRUE);
    	setDefaultRole(user);
        dao.add(user);
        logger.info("Add user in service");
	}

    public void setUserDao(UserDao dao) {
        this.dao = dao;
    }
}
