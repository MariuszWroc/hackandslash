package pl.mygames.hackandslash.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.service.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
        private IUserService userService;
        
        @Autowired(required = true)
        @Qualifier(value = "userService")
        public void setUserService(IUserService userService) {
            this.userService = userService;
        }
        
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
           
           /*
            * This method will add a user.
            */
           @RequestMapping(value = {"/addUser"}, method = RequestMethod.POST)
           public @ResponseBody void addUser(@RequestBody GameUser user) {    
               userService.add(user);
           }
           
           
           @RequestMapping(value = {"/userList.json"}, method = RequestMethod.GET)
            public @ResponseBody List<GameUser> getUserList() {
                return userService.findAll();
            }
}
