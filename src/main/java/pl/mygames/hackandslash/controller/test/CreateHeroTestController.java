package pl.mygames.hackandslash.controller.test;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.controller.util.GuiEnums;
import pl.mygames.hackandslash.dto.HeroDTO;
import pl.mygames.hackandslash.dto.util.*;
import pl.mygames.hackandslash.dto.util.general.*;
import pl.mygames.hackandslash.dto.util.user.UserProfession;
import pl.mygames.hackandslash.dto.util.user.UserRace;
import pl.mygames.hackandslash.service.IHeroCreationService;
import pl.mygames.hackandslash.service.impl.logic.Rules;

@Controller
@SessionAttributes("genderEnum")
public class CreateHeroTestController {
	private static final Logger logger = LoggerFactory.getLogger(CreateHeroTestController.class); 
	
	@Autowired
	private IHeroCreationService heroCreationService;
	
	@RequestMapping(value = "/heroTest", method = RequestMethod.GET)
	public String showHero(ModelMap model) {
		model.addAttribute("hero", new HeroDTO());
		model.addAttribute("genderEnum", Gender.values());
		model.addAttribute("professionEnum", UserProfession.values());
		model.addAttribute("raceEnum", UserRace.values());
		model.addAttribute("max", GuiEnums.MAX_ATTRIBUTE.getAttribute());
		model.addAttribute("min", GuiEnums.MIN_ATTRIBUTE.getAttribute());
		model.addAttribute("value", GuiEnums.VALUE_ATTRIBUTE.getAttribute());
		logger.info("Hero view");
		return "test/procedures/heroTest";
	}
	
	@RequestMapping(value="/heroTest/add", method = RequestMethod.POST)
	public String addHero(@ModelAttribute("hero") @Valid HeroDTO hero, BindingResult result) {
		if (!result.hasErrors()) {
			heroCreationService.add(hero);
			logger.info("Hero with id " + hero.getId() + " added");
		} else {
			logger.info("Validation failed. Error in field " + result.getFieldError());
		}
		return "redirect:/heroTest";
	}
	
	
}
