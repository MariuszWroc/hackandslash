/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mygames.hackandslash.dao.*;
import pl.mygames.hackandslash.dao.impl.UserDao;
import pl.mygames.hackandslash.dto.RegisterDTO;
import pl.mygames.hackandslash.dto.util.general.Rolename;
import pl.mygames.hackandslash.model.*;
import pl.mygames.hackandslash.service.IRegisterService;
import pl.mygames.hackandslash.service.IRoleService;

/**
 *
 * @author mariusz
 */

@Deprecated
@Service
@Transactional(readOnly = true)
public class RegisterService implements IRegisterService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private IRoleService roleService;
    
    /* (non-Javadoc)
	 * @see pl.mygames.hackandslash.service.impl.IRegisterService#add(pl.mygames.hackandslash.dto.RegisterDTO)
	 */
    @Override
	@Transactional(readOnly = false)
    public void add(RegisterDTO registerDTO) {
        GameUser user = new GameUser();
        Integer idRole = Rolename.USER.getId();
		List<GameRole> findById = roleService.findById(idRole);
//        GameRole role = roleDao.findById(registerDTO.getRoleId());
        user.setId(registerDTO.getId());
        user.setAge(registerDTO.getAge());
        user.setFirstname(registerDTO.getFirstname());
        user.setLastname(registerDTO.getLastname());
        user.setGender(registerDTO.getGender());
        user.setLogin(registerDTO.getLogin());
        user.setPassword(registerDTO.getPassword());
        user.setActivated(Boolean.FALSE);
        user.setHeroList(null);
        if(findById.iterator().hasNext()) {
            user.setGameRole(findById.iterator().next());	
        }
        
        userDao.add(user);
    }

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    
    
}
