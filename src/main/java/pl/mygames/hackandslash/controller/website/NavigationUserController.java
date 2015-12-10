package pl.mygames.hackandslash.controller.website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class NavigationUserController {
	
	@RequestMapping(value = "/hero", method = RequestMethod.GET)
	public String getHero() {
		return "user/hero";
	}
	
	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String getUserProfil() {
		return "user/profil";
	}
}

