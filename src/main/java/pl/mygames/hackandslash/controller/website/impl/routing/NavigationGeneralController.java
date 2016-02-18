package pl.mygames.hackandslash.controller.website.impl.routing;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigationGeneralController {
	private static final Logger logger = LoggerFactory.getLogger(NavigationGeneralController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
    @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() {
	        return "main/register";
	}
    
    @RequestMapping(value = "/about", method = RequestMethod.GET)
	public String getAboutAuthors() {
	        return "main/about";
	}
            
    @RequestMapping(value = "/screens", method = RequestMethod.GET)
	public String getScreens() {
	        return "main/screens";
	}
    
    @RequestMapping(value = "/authors", method = RequestMethod.GET)
	public String getAuthors() {
	        return "main/authors";
	}
    
	@RequestMapping(value = "/email", method = RequestMethod.GET)
    public String getEmail() {
        return "main/email";
    }
	
	@RequestMapping(value = "/email/success", method = RequestMethod.GET)
    public String getSendEmailSuccess() {
        return "/helper/sendSuccess";
    }
	
	@RequestMapping(value = "/email/failed", method = RequestMethod.GET)
    public String getSendEmailfailed() {
        return "/helper/sendFailed";
    }
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String getLogout() {
        return "logout";
    }
    
    @RequestMapping(value = {"/logout/success"}, method = RequestMethod.GET)
    public String getLogoutSuccess() {
        return "helper/afterLogout";
    }
    
    @RequestMapping(value = {"/failed"}, method = RequestMethod.GET)
    public String getFailed() {
        return "helper/failed";
    }
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }
    
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String getWelcome(){
        return "main/welcome";
    }
    
    @RequestMapping(value = {"/denied"}, method = RequestMethod.GET)
    public String getAccessDenied() {
        return "helper/accessDenied";
    }
    
    @RequestMapping(value = {"/header"}, method = RequestMethod.GET)
    public String getHeaderTemplate() {
        return "template/header";
    }
    
    @RequestMapping(value = {"/left"}, method = RequestMethod.GET)
    public String getContentTemplate() {
        return "template/left";
    }
    
    @RequestMapping(value = {"/footer"}, method = RequestMethod.GET)
    public String getFooterTemplate() {
        return "template/footer";
    }
    
}
