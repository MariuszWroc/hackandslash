package pl.mygames.hackandslash.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.mygames.hackandslash.controller.util.ProjectConstants;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IUserService;

@Controller
public class UserTestController {
    private static final Logger logger = LoggerFactory.getLogger(UserTestController.class);
    
	@Autowired
	private IUserService userService;
	
	/*
	 * Mapping users list and one user 
	 */
	@RequestMapping(value = {"/users"}, method = RequestMethod.GET)
	public String getUsers(ModelMap model) {
		List<GameUser> users = findUsers();
		GameUser one_user = findUser(ProjectConstants.TEST_ID.getValue());
		model.addAttribute("users", users);
		model.addAttribute("one_user", one_user);
	    return "test/users";
	}
	
	/*
	 * This method will list all existing users.
	 */
	private List<GameUser> findUsers() {
		List<GameUser> users;
		if (userService.findAll().isEmpty()){
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
		List<GameUser> users = userService.findByQuery(id);
		if (users.isEmpty()){
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