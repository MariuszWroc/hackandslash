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
public class UserService implements IUserService {
    
    @Autowired
    private UserDao dao;

    public void setUserDao(UserDao dao) {
        this.dao = dao;
    }

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
	dao.update(user);
    }

    @Override
    public GameUser findById(Integer id) {
        return dao.findById(id);
    }
    
    @Override
    public List<GameUser> findByQuery(Integer id) {
        String query = "FROM GameUser U WHERE U.id = " + id;
        
        return dao.findByQuery(query);
    }

    @Override
    public List<GameUser> findAll() {
        return dao.findAll();
    }

}
