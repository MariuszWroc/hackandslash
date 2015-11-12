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
    private IRegisterService registerService;
    
	@Autowired(required = true)
    @Qualifier(value = "registerService")
	public void setRegisterService(IRegisterService registerService) {
		this.registerService = registerService;
	}
	
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
    	RegisterDTO register = new RegisterDTO();
    	model.put("registerForm", register);
    	logger.info("register view"); 
        return "register";
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute(value = "registerForm") RegisterDTO register, BindingResult result) {

		if (result.hasErrors()) {
			return "register";
		} else {
			logger.info("User values is : " + register.getLogin() + " " + register.getPassword());
			registerService.add(register);
			return "success";
		}
	}
}
