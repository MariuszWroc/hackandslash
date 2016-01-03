/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.controller.website;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.*;
import pl.mygames.hackandslash.dto.util.user.UserProfession;
import pl.mygames.hackandslash.dto.util.user.UserRace;
import pl.mygames.hackandslash.model.GameUser;
import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.service.IHeroService;
import pl.mygames.hackandslash.service.IUserService;

@RestController
@Scope("session")
@RequestMapping(value = { "/user" })
public class HeroController extends UserCommon {
	private static final Logger logger = LoggerFactory.getLogger(HeroController.class);

	@Autowired
	private IHeroService heroService;

	@RequestMapping(value = "/actualHero", method = RequestMethod.GET)
	public ResponseEntity<HeroDTO> getHeroByActualUser(ModelMap model) {
		if (getActualLoggedUser().isEnabled()) {
			String login = getActualLoggedUser().getUsername();
			logger.info("Hero with user login = " + login + " loaded");
			HeroDTO heroLoaded = heroService.findByUser(login);
			return new ResponseEntity<HeroDTO>(heroLoaded, HttpStatus.OK);
		} else {
			return new ResponseEntity<HeroDTO>(HttpStatus.NO_CONTENT);
		}
	}
	
    @RequestMapping(value = "/hero/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<HeroDTO>> listAllUsers() {
    	String login = getActualLoggedUser().getUsername();
        List<HeroDTO> heroes = heroService.findAllByUser(login);
        logger.info("Heroes list with user login = " + login + " loaded");
        if(heroes.isEmpty()){
            return new ResponseEntity<List<HeroDTO>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<HeroDTO>>(heroes, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/hero/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Hero> updateHero(@PathVariable("id") Integer id, @RequestBody Hero hero, BindingResult result) {
    	logger.info("Updating hero " + id);
        
        if (hero == null) {
        	logger.info("Hero with id " + id + " not found");
            return new ResponseEntity<Hero>(HttpStatus.NOT_FOUND);
        } else {
            copyHero(hero, hero);
            heroService.update(hero);
            return new ResponseEntity<Hero>(hero, HttpStatus.OK);
        }
    }

	@RequestMapping(value = "/hero/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Hero> deleteHero(@PathVariable("id") Integer id) {
    	logger.info("Fetching & Deleting hero with id " + id);
  
    	Hero currentUser = findHero(id);
        if (currentUser == null) {
        	logger.info("Unable to delete. Hero with id " + id + " not found");
            return new ResponseEntity<Hero>(HttpStatus.NOT_FOUND);
        } else {
        	heroService.delete(id);
            return new ResponseEntity<Hero>(HttpStatus.NO_CONTENT);
        }

    }
    
    private void copyHero(Hero heroBefore, Hero heroAfter) {
		// TODO Auto-generated method stub
		
	}
    
//	@RequestMapping(value = "/hero/{login}", method = RequestMethod.GET)
//	public @ResponseBody UserDTO getHeroByUserLogin(@PathVariable("login") String login, ModelMap model) {
//		if (authenticateUser(login)) {
//			logger.info("Hero with user login = " + login + " loaded");
//			return userService.getUserDTO(login);
//		} else {
//			return null;
//		}
//	}
//
//	@RequestMapping(value = "/hero/details", method = RequestMethod.GET)
//	public @ResponseBody HeroDTO getHero() {
//		return null;
//	}
    
    private Hero findHero(Integer id) {
		Hero hero;
		List<Hero> heroes = heroService.findById(id);
		if (heroes.isEmpty()){
    		logger.info("Heroes list is empty");
    		hero = new Hero();
    	} else {
    		hero = heroes.iterator().next();
    		if (heroes.size() > 1) {
    			logger.info("Method findHero(Integer id) returned more then one result");
    		}
    	}
		return hero;
	}

	@RequestMapping(value = "/hero/raceList", method = RequestMethod.GET)
	public @ResponseBody List<RaceDTO> getRaces() {
		List<RaceDTO> list = new ArrayList<RaceDTO>();
		for (UserRace u : UserRace.values()) {
			list.add(new RaceDTO(u));
		}
		return list;
	}

	@RequestMapping(value = "/hero/professionsList", method = RequestMethod.GET)
	public @ResponseBody List<ProfessionDTO> getProfessions() {
		List<ProfessionDTO> list = new ArrayList<ProfessionDTO>();
		for (UserProfession u : UserProfession.values()) {
			list.add(new ProfessionDTO(u));
		}
		return list;
	}
}
