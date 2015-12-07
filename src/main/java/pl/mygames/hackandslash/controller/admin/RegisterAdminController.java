package pl.mygames.hackandslash.controller.admin;



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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.mygames.hackandslash.dto.util.general.Gender;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IUserService;

@Controller
@SessionAttributes("genderEnum")
@RequestMapping(value = {"/admin"})
public class RegisterAdminController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterAdminController.class); 
	
	@Autowired
    private IUserService userService;
	
    @RequestMapping(value = "/registerTest", method = RequestMethod.GET)
    public String viewRegistration(ModelMap model) {
    	model.addAttribute("user", new GameUser());
    	model.addAttribute("genderEnum", Gender.values());
    	logger.info("register view"); 
        return "admin/procedures/registerTest";
    }
    
    @RequestMapping(value = "/registerTest/add", method = RequestMethod.POST)  
    public String addUser(@ModelAttribute("user") @Valid GameUser user, BindingResult result, RedirectAttributes redirectAttributes) {
            if (!result.hasErrors() ) {
                Boolean savingSuccess = userService.add(user);
                if (savingSuccess) {
                            logger.info("User with id = " + user.getId() + ", added");
                } else {

                    redirectAttributes.addFlashAttribute("loginExist","Login name is used by someone elsey.");
                }

            } else {
            	redirectAttributes.addFlashAttribute("loginExist","Login name is used by someone elsey.");
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
