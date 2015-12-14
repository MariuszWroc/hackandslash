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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
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
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;
    private Integer keyValue;

    /*
     * Mapping users list and one user 
     */
    @RequestMapping(value = "/edit/{login}")
    public String editUser(@PathVariable("login") String login, ModelMap model) {
        model.addAttribute("users", findUsers());
        logger.info("User with login = " + login + ", edited");
        return "/{login}";
    }

    @RequestMapping(value = "/profil/{login}")
    public @ResponseBody
    UserDTO getUserByLogin(@PathVariable("login") String login, ModelMap model) {
        if (authenticateUser(login)) {
            logger.info("User with login = " + login + " loaded");
        	return userService.getUserDTO(login);
        } else {
        	return null;
        }
    }
    
    @RequestMapping(value = "/hero/{login}")
    public @ResponseBody
    UserDTO getHeroByUserLogin(@PathVariable("login") String login, ModelMap model) {
        if (authenticateUser(login)) {
        	logger.info("Hero with user login = " + login + " loaded");
        	return userService.getUserDTO(login);
        } else {
        	return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    private Boolean authenticateUser(HttpServletRequest request, String login) {
    	String loginFromSession = (String) request.getSession().getAttribute("username");
    	if (login.equals(loginFromSession)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    private Boolean authenticateUser(String login) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (auth != null) {
    	    Object principal = auth.getPrincipal();  
    	    if (principal instanceof UserDetails) {
    	    	UserDetails user = (UserDetails) principal;
    	    	logger.info("Username in actual session: " + user.getUsername());
    	    	if (user.getUsername().equals(login)) {
    	    		logger.info("User " + login + " is logged in");
	    	    	return true;
    	    	}
    	    }
    	}
    		return false;
    }
    
    
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
                logger.info("Method findUserInteger id) returned more then one result");
            }
        }
        return user;
    }
}
