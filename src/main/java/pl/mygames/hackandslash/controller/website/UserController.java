/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.controller.website;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    public ResponseEntity<UserDTO> getUser(ModelMap model) {
        if (getActualLoggedUser().isEnabled()) {
        	UserDTO userLoaded = loadActualProfil();
        	return new ResponseEntity<UserDTO>(userLoaded, HttpStatus.OK);
        } else {
        	return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logoutUser(@ModelAttribute(value = "endpoint") String endpoint, ModelMap model) {
        logger.info("User logout" + endpoint);
        getActualLogoutUser();
        return "/";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<List<ObjectError>> updateUser(@PathVariable("id") Integer id, @RequestBody @Valid GameUser currentUser, BindingResult result) {
    	logger.info("Updating User " + id);
        
        if ((!result.hasErrors()) && (userService.isRegisterUserValid(currentUser.getLogin(), currentUser.getEmail()))) {
            userService.update(currentUser);
            logger.info("User with id " + id + " updated, currentUser " + currentUser.getLogin());
            return new ResponseEntity<List<ObjectError>>(result.getAllErrors(),HttpStatus.CREATED);
        } else {
            return new ResponseEntity<List<ObjectError>>(result.getAllErrors(),HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GameUser> deleteUser(@PathVariable("id") Integer id) {
    	logger.info("Fetching & Deleting User with id " + id);
  
        GameUser dbUser = findUser(id);
        if (dbUser == null) {
        	logger.info("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<GameUser>(HttpStatus.NOT_FOUND);
        } else {
            userService.delete(id);
        	logger.info("User with id " + id + " deleted");
            return new ResponseEntity<GameUser>(HttpStatus.NO_CONTENT);
        }

    }
    
	private UserDTO loadActualProfil() {
		String login = getActualLoggedUser().getUsername();
		logger.info("User with login = " + login + " loaded");
		UserDTO userLoaded = userService.getUserDTO(login);
		
		return userLoaded;
	}

	private GameUser copyUser(GameUser userBefore, GameUser userAfter) {
		Integer id = userBefore.getId();
		String login = userBefore.getLogin();
		String email = userBefore.getEmail();
		
		if((id != null) && (login != null) && (email != null)) {
			userAfter.setId(id);
			userAfter.setLogin(login);
	        userAfter.setEmail(email);
	        userAfter.setFirstname(userBefore.getFirstname());
	        userAfter.setLastname(userBefore.getLastname());
	        userAfter.setPassword(userBefore.getPassword());
	        userAfter.setAge(userBefore.getAge());
	        userAfter.setGender(userBefore.getGender());
	        userAfter.setActivated(userBefore.getActivated());
	        userAfter.setGameRole(userBefore.getGameRole());
	        userAfter.setHeroList(userBefore.getHeroList());
		}
        
		logger.info("New user " + userAfter.getId() + " " + userAfter.getGender() + " " + userAfter.getGameRole()  + " " + userAfter.getHeroList());
		
        return userAfter;
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
