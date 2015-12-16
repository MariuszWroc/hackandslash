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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.*;
import pl.mygames.hackandslash.dto.util.user.UserProfession;
import pl.mygames.hackandslash.dto.util.user.UserRace;
import pl.mygames.hackandslash.service.IHeroService;
import pl.mygames.hackandslash.service.IUserService;

@RestController
@Scope("session")
@RequestMapping(value = { "/user" })
public class HeroController extends UserCommon {
	private static final Logger logger = LoggerFactory.getLogger(HeroController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private IHeroService heroService;

	@RequestMapping(value = "/actualHero", method = RequestMethod.GET)
	public @ResponseBody HeroDTO getHeroByActualUser(ModelMap model) {
		if (getActualLoggedUser().isEnabled()) {
			String login = getActualLoggedUser().getUsername();
			logger.info("Hero with user login = " + login + " loaded");
			return heroService.getHeroByUser(login);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/hero/{login}", method = RequestMethod.GET)
	public @ResponseBody UserDTO getHeroByUserLogin(@PathVariable("login") String login, ModelMap model) {
		if (authenticateUser(login)) {
			logger.info("Hero with user login = " + login + " loaded");
			return userService.getUserDTO(login);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/hero/details", method = RequestMethod.GET)
	public @ResponseBody HeroDTO getHero() {
		return null;
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
