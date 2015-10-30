package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.mygames.hackandslash.dao.UserDao;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IUserService;

@Service
@Transactional(readOnly = true)
public class UserService implements IUserService{
	
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

	@Transactional(readOnly = false)
	@Override
	public void add(GameUser user) {
		userDao.add(user);
	}

	@Transactional(readOnly = false)
        @Secured("ROLE_ADMIN")
	@Override
	public void delete(GameUser user) {
		userDao.delete(user);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(GameUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameUser findById(Integer id) {
		return userDao.findById(id);
	}
    
        @Override
	public List<GameUser> findAll() {
		return userDao.findAll();
	}

}
