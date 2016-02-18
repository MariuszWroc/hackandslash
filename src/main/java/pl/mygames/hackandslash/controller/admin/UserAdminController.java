package pl.mygames.hackandslash.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.controller.util.Autoincrementation;
import pl.mygames.hackandslash.dto.UserDTO;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IUserService;

@Controller
@RequestMapping(value = {"/admin"})
public class UserAdminController {
    private static final Logger logger = LoggerFactory.getLogger(UserAdminController.class);
    
	@Autowired
	private IUserService userService;
	private Integer keyValue;
	
	/*
	 * Mapping users list and one user 
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsers(ModelMap model) {
		List<GameUser> users = findUsers();
		keyValue = Autoincrementation.getValue(users.size());
		model.addAttribute("users", users);
		model.addAttribute("one_user", new GameUser());
	    return "admin/users";
	}
	
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)  
    public String addUser(@ModelAttribute("one_user")GameUser user, @RequestParam String action) {
        if ((user.getId() != null) && (action.equals("Add"))) {
        	user.setId(keyValue);
            userService.add(user);
            logger.info("Place with id = " + keyValue + ", added");
        } else if (action.equals("Edit")) {
        	userService.update(user);
            logger.info("Place with id = " + user.getId() + ", updated");
        } 
        
        return "redirect:/admin/users";  
    }  

    @RequestMapping(value = "/users/remove/{id}")
    public String removeUser(@PathVariable("id") Integer id){
        userService.delete(id);
        logger.info("Place with id = " + id + ", deleted");
        return "redirect:/admin/users";
    }
    
    @RequestMapping(value = "/users/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("users", findUsers());
        model.addAttribute("one_user", findUser(id));
        logger.info("Place with id = " + id + ", edited");
        return "admin/users";
    }
    
    @RequestMapping(value = "/users/{login}")
    public @ResponseBody UserDTO getUserByLogin(@PathVariable("login") String login, ModelMap model){
        return userService.getUserDTO(login);
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
		return userService.findById(id);
	}
	
	
}