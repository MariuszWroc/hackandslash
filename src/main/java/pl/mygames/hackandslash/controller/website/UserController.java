/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.controller.website;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.UserDTO;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IUserService;

/**
 *
 * @author Jaca
 */
@RestController
@Scope("session")
@RequestMapping(value = {"/user"})
public class UserController extends UserCommon{

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/actualProfil", method = RequestMethod.GET)
    public @ResponseBody UserDTO getUser(ModelMap model) {
        if (getActualLoggedUser().isEnabled()) {
        	String login = getActualLoggedUser().getUsername();
            logger.info("User with login = " + login + " loaded");
        	return userService.getUserDTO(login);
        } else {
        	return null;
        }
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logoutUser(@ModelAttribute(value = "endpoint") String endpoint, ModelMap model) {
        logger.info("User logout" + endpoint);
        getActualLogoutUser();
        return "/";
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<GameUser> updateUser(@PathVariable("id") Integer id, @RequestBody GameUser user, BindingResult result) {
    	logger.info("Updating User " + id);
        GameUser currentUser = findUser(id);
        
        if (currentUser == null) {
        	logger.info("User with id " + id + " not found");
            return new ResponseEntity<GameUser>(HttpStatus.NOT_FOUND);
        } else {
            copyUser(user, currentUser);
            userService.update(currentUser);
            return new ResponseEntity<GameUser>(currentUser, HttpStatus.OK);
        }

    }

	private void copyUser(GameUser user, GameUser currentUser) {
		currentUser.setLogin(user.getLogin());
        currentUser.setEmail(user.getEmail());
        currentUser.setFirstname(user.getFirstname());
        currentUser.setLastname(user.getLastname());
        currentUser.setPassword(user.getPassword());
        currentUser.setAge(user.getAge());
        currentUser.setGender(user.getGender());
	}

//    @RequestMapping(value = "/profil/{login}", method = RequestMethod.GET)
//    public @ResponseBody
//    UserDTO getUserByLogin(@PathVariable("login") String login, ModelMap model) {
//        if (authenticateUser(login)) {
//            logger.info("User with login = " + login + " loaded");
//        	return userService.getUserDTO(login);
//        } else {
//        	return null;
//        }
//    }
    

      
    
    /*
     * This method will list all existing users.
     */
    private List<GameUser> findUsers() {
        List<GameUser> users;
        if (userService.findAll().isEmpty()) {
            logger.info("Users list is empty");
            users = new ArrayList<>();
        } else {
            users = userService.findAll();
        }
        return users;
    }

    /*
     * This method will return one user.
     */
    private GameUser findUser(Integer id) {
        GameUser user;
        List<GameUser> users = userService.findById(id);
        if (users.isEmpty()) {
            logger.info("Users list is empty");
            user = new GameUser();
        } else {
            user = users.iterator().next();
            if (users.size() > 1) {
                logger.info("Method findUser returned more then one result");
            }
        }
        return user;
    }
}
