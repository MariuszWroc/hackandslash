package pl.mygames.hackandslash.service.impl;

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
	
	@Autowired
	private UserDao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(GameUser user) {
		dao.add(user);
	}

	@Transactional(readOnly = false)
        @Secured("ROLE_ADMIN")
	@Override
	public void delete(GameUser user) {
		dao.delete(user);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(GameUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameUser findById(Integer id) {
		return dao.findById(id);
	}
    

}
