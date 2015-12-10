package pl.mygames.hackandslash.controller.admin;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.LoginDTO;
import pl.mygames.hackandslash.service.IUserService;

@Controller
@Deprecated
public class LoginAdminController {
    private static final Logger logger = LoggerFactory.getLogger(EquipmentAdminController.class);
    @Autowired
    IUserService userService;
    
	@RequestMapping(value = "/loginTest", method = RequestMethod.GET)
	public String getUsers(ModelMap model) {
		model.addAttribute("admin", new LoginDTO());
		logger.info("Login view");
	    return "/login";
	}

	@RequestMapping(value = {"/loginTest/submit"}, method = RequestMethod.POST)
	public String addUser(@ModelAttribute("admin") @Valid LoginDTO admin, BindingResult result) {
		if (!result.hasErrors()) {
			if (userService.isLoginSuccess(admin)) {
				logger.info("Login success");
				return "redirect:/success";
			} else {
				logger.info("Login failed. Wrong password or login.");
				return "redirect:/failed";
			}
			
		} else {
			logger.info("Validation failed. " + result.getFieldError());
			return "/login";
		} 
	}

}
