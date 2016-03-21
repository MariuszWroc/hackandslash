package pl.mygames.hackandslash.controller.admin;

import pl.mygames.hackandslash.dto.user.HeroDTO;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.*;
import pl.mygames.hackandslash.util.constant.GenderEnum;
import pl.mygames.hackandslash.util.constant.user.UserProfession;
import pl.mygames.hackandslash.util.constant.user.UserRace;
import pl.mygames.hackandslash.logic.rule.CreateHeroRule;
import pl.mygames.hackandslash.service.IHeroCreationService;

@Controller
@RequestMapping(value = {"/admin"})
@SessionAttributes({"hero", "genderEnum", "raceEnum", "professionEnum", "min", "max"})
public class CreateHeroAdminController {
	private static final Logger logger = LoggerFactory.getLogger(CreateHeroAdminController.class); 
	
	@Autowired
	private IHeroCreationService heroCreationService;
	
	@RequestMapping(value = "/heroTest", method = RequestMethod.GET)
	public String showHero(ModelMap model) {
		model.addAttribute("hero", null);
		model.addAttribute("genderEnum", GenderEnum.values());
		model.addAttribute("raceEnum", UserRace.values());
		model.addAttribute("professionEnum", UserProfession.values());

		Map<String, DefaultAttributesDTO> populateDefaultAttributes = CreateHeroRule.populateDefaultAttributes();
		DefaultAttributesDTO raceAttributes = populateDefaultAttributes.get("ELF");
		DefaultAttributesDTO professionAttributes = populateDefaultAttributes.get("MAGE");
		AttributeDTO createMinimumAttributes = CreateHeroRule.createMinimumAttributes(raceAttributes, professionAttributes);
		AttributeDTO createMaximumAttributes = CreateHeroRule.createMaximumAttributes(raceAttributes);
		AttributeDTO createDrawedAttributes = CreateHeroRule.getDrawedAttributes(createMinimumAttributes, createMaximumAttributes);
		
		model.addAttribute("maxCharisma", createMaximumAttributes.getCharisma());
		model.addAttribute("maxDexterity", createMaximumAttributes.getDexterity());
		model.addAttribute("maxConstitution", createMaximumAttributes.getConstitution());
		model.addAttribute("maxIntelligence", createMaximumAttributes.getIntelligence());
		model.addAttribute("maxStrength", createMaximumAttributes.getStrength());
		model.addAttribute("minCharisma", createMinimumAttributes.getCharisma());
		model.addAttribute("minDexterity", createMinimumAttributes.getDexterity());
		model.addAttribute("minConstitution", createMinimumAttributes.getConstitution());
		model.addAttribute("minIntelligence", createMinimumAttributes.getIntelligence());
		model.addAttribute("minStrength", createMinimumAttributes.getStrength());
		model.addAttribute("charisma", createDrawedAttributes.getCharisma());
		model.addAttribute("dexterity", createDrawedAttributes.getDexterity());
		model.addAttribute("constitution", createDrawedAttributes.getConstitution());
		model.addAttribute("intelligence", createDrawedAttributes.getIntelligence());
		model.addAttribute("strength", createDrawedAttributes.getStrength());
		
		logger.info("Hero view");
		return "admin/procedures/heroTest";
	}
	
	@RequestMapping(value="/heroTest/add", method = RequestMethod.POST)
	public String addHero(@ModelAttribute("hero") @Valid HeroDTO hero, BindingResult result) {
		if (!result.hasErrors()) {
			// TODO: testing mock
			String loggedUser = "mczarny";
			heroCreationService.add(hero, loggedUser);
			logger.info("Hero with id " + hero.getId() + " added");
			return "redirect:/characters";
		} else {
			logger.info("Validation failed. " + result.getFieldError());
			return "admin/procedures/heroTest";
		}
	}
}
