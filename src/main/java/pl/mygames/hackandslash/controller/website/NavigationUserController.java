package pl.mygames.hackandslash.controller.website;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class NavigationUserController {
	
	@Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/hero", method = RequestMethod.GET)
	public String getHero() {
		return "user/hero";
	}
	
	@Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String getUserProfil() {
		return "user/profil";
	}
	
	@Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String getPlayGame() {
		return "user/game";
	}
}

