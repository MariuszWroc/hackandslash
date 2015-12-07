package pl.mygames.hackandslash.controller.admin;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pl.mygames.hackandslash.controller.util.Autoincrementation;
import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.dto.LoginDTO;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IUserService;

@Controller
@RequestMapping(value = {"/admin"})
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(EquipmentAdminController.class);
    @Autowired
    IUserService userService;
    
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getUsers(ModelMap model) {
		model.addAttribute("user", new LoginDTO());
		logger.info("Login view");
	    return "admin/procedures/login";
	}

	@RequestMapping(value = {"/login/submit"}, method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid LoginDTO user, BindingResult result) {
		System.out.println("kupa");
		if (!result.hasErrors()) {
			if (userService.isLoginSuccess(user)) {
				logger.info("Login success");
				return "redirect:/success";
			} else {
				logger.info("Login failed. Wrong password or login.");
				return "redirect:/failed";
			}
			
		} else {
			logger.info("Validation failed. " + result.getFieldError());
			return "admin/procedures/login";
		} 
	}

}
