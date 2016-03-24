package pl.mygames.hackandslash.controller.website.impl.routing;

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
        
        @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String getShop() {
		return "user/shop";
	}
        
        @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/equipment", method = RequestMethod.GET)
	public String getEquipment() {
		return "user/equipment";
	}
        
        @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/journal", method = RequestMethod.GET)
	public String getJournal() {
		return "user/journal";
	}
        
        @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value = "/combat", method = RequestMethod.GET)
	public String getCombat() {
		return "user/combat";
	}
}

