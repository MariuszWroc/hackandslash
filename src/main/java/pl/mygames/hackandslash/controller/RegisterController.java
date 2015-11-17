package pl.mygames.hackandslash.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.mygames.hackandslash.dto.RegisterDTO;
import pl.mygames.hackandslash.service.IRegisterService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class); 
	@Autowired
    private IRegisterService registerService;
	
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegistration(ModelMap model) {
    	RegisterDTO register = new RegisterDTO();
    	model.addAttribute("registerDTO", register);
    	logger.info("register view"); 
        return "register";
    }
	
	@RequestMapping(value = "/register/add", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute(value = "registerDTO") RegisterDTO register, BindingResult result) {
		
		if (result.hasErrors()) {
			return "redirect:/failed";
		} else {
			logger.info("User values is : " + register.getLogin() + " " + register.getPassword());
			registerService.add(register);
			return "redirect:/success";
		}
	}
}
