package pl.mygames.hackandslash.controller.website;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pl.mygames.hackandslash.controller.admin.EquipmentAdminController;
import pl.mygames.hackandslash.controller.util.Autoincrementation;
import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IUserService;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(EquipmentAdminController.class);
    @Autowired
    IUserService userService;
    
	@RequestMapping(value = "/logintest", method = RequestMethod.GET)
	public String getUsers(ModelMap model) {
		model.addAttribute("user", new GameUser());
		logger.info("Login view");
	    return "test/login";
	}

	@RequestMapping(value = {"/loginTestProcessing"}, method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid GameUser user, BindingResult result) {
		if (!result.hasErrors()) {
			if (userService.findByLogin(user.getLogin()).isEmpty()) {
				userService.add(user);
				logger.info("No user login found in database.");
			} else {
				logger.info("Login was used by someone else.");
			}
			return "redirect:/success";
		} else {
			logger.info("Validation failed. " + result.getFieldError());
			return "test/login";
		} 
	}
	
	@RequestMapping("/userTest")
	public String geUserPage() {
		return "user";
	}

	@RequestMapping("/adminTest")
	public String geAdminPage() {
		return "admin";
	}

	@RequestMapping("403page")
	public String ge403denied() {
		return "redirect:login?denied";
	}

}
