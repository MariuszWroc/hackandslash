/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mygames.hackandslash.dao.RoleDao;
import pl.mygames.hackandslash.dao.UserDao;
import pl.mygames.hackandslash.dto.RegisterDTO;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.model.GameUser;

/**
 *
 * @author mariusz
 */

@Service
@Transactional(readOnly = true)
public class RegisterService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private RoleDao roleDao;
    
    @Transactional(readOnly = false)
    public void add(RegisterDTO registerDTO) {
        GameUser user = new GameUser();
        GameRole role = roleDao.findById(registerDTO.getRoleId());
        user.setGameRole(role);
        user.setId(registerDTO.getId());
        user.setAge(registerDTO.getAge());
        user.setFirstname(registerDTO.getFirstname());
        user.setLastname(registerDTO.getLastname());
        user.setGender(registerDTO.getGender());
        user.setLogin(registerDTO.getLogin());
        user.setPassword(registerDTO.getPassword());
        user.setActivated(0);
        user.setHeroList(null);
        user.setGameRole(role);
        
        userDao.add(user);
    }

    @Transactional(readOnly = false)
    @Secured("ROLE_ADMIN")
    public void delete(GameUser user) {
    }

    @Transactional(readOnly = false)
    public void update(GameUser user) {
    }

    public GameUser findById(Integer id) {
        return null;
    }

    public List<GameUser> findAll() {
        return null;
    }
}
