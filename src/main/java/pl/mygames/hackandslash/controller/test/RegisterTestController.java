package pl.mygames.hackandslash.controller.test;



import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.mygames.hackandslash.dto.util.Gender;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IUserService;

@Controller
public class RegisterTestController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterTestController.class); 
	
	@Autowired
    private IUserService userService;
	
    @RequestMapping(value = "/registerTest", method = RequestMethod.GET)
    public String viewRegistration(ModelMap model) {
    	model.addAttribute("user", new GameUser());
    	model.addAttribute("genderEnum", Gender.values());
    	logger.info("register view"); 
        return "test/procedures/registerTest";
    }
    
    @RequestMapping(value = "/registerTest/add", method = RequestMethod.POST)  
    public String addUser(@ModelAttribute("user") @Valid GameUser user, BindingResult result) {
		if (!result.hasErrors()) {
            userService.add(user);
			logger.info("User with id = " + user.getId() + ", added");
		} else {
			logger.info("Validation failed. Error in field " + result.getFieldError());
			return "test/procedures/registerTest";
		}
		
        return "redirect:/registerTest";  
    }
    // method for angular it returns the arrayList of errors list is empty when no errors occoured
    @RequestMapping(value = "/registerTest/addAngu", method = RequestMethod.POST)  
    public @ResponseBody List<FieldError> addUserAngular(@RequestBody @Valid GameUser user, BindingResult result) {
		if (!result.hasErrors()) {
                        userService.add(user);
			logger.info("User with id = " + user.getId() + ", added");
		} else {
			logger.info("Validation failed. Error in field " + result.getFieldError());
			return result.getFieldErrors();
		}
		
        return new ArrayList<>();  
    }
}
