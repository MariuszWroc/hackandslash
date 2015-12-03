package pl.mygames.hackandslash.controller.website;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigationController {
	private static final Logger logger = LoggerFactory.getLogger(NavigationController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
    @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() {
	        return "register";
	}
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getUser() {
	        return "user";
	}
    
    @RequestMapping(value = "/hero", method = RequestMethod.GET)
	public String getHero() {
	        return "hero";
	}
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
	        return "login";
	}
    
    @RequestMapping(value = "/createHero", method = RequestMethod.GET)
	public String getCreateHero() {
	        return "createHero";
	}
}
