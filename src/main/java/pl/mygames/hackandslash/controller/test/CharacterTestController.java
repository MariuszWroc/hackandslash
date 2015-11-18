package pl.mygames.hackandslash.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.mygames.hackandslash.controller.util.Autoincrementation;
import pl.mygames.hackandslash.controller.util.ProjectConstants;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.service.ICharacterService;

@Controller
public class CharacterTestController {
    private static final Logger logger = LoggerFactory.getLogger(CharacterTestController.class);
	@Autowired
    private ICharacterService characterService;
	private Integer keyValue;
    
	@RequestMapping(value = {"/characters"}, method = RequestMethod.GET)
    public String getCharacters(ModelMap model) {
        List<GameCharacter> characters = findCharacters();
        keyValue = Autoincrementation.getValue(characters.size());
       	model.addAttribute("characters", characters);
       	model.addAttribute("one_character", new GameCharacter());
        return "test/characters";
    }
	
    @RequestMapping(value = "/characters/add", method = RequestMethod.POST)  
    public String addCharacter(@ModelAttribute("one_character")GameCharacter character) {
        if (character.getId() == null) {
        	character.setId(keyValue);
        	characterService.add(character);
        } else {
        	characterService.update(character);
        } 
        return "redirect:/characters";  
    } 
    
    @RequestMapping(value = "/characters/remove/{id}")
    public String removeCharacter(@PathVariable("id") Integer id){      
        characterService.delete(id);
        return "redirect:/characters";
    }
    
    @RequestMapping(value = "/characters/edit/{id}")
    public String editCharacter(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("characters", findCharacters());
        model.addAttribute("one_character", findCharacter(id));
        return "test/characters";
    }
    
    /*
     * This method will list all existing characters.
     */
	private List<GameCharacter> findCharacters() {
		List<GameCharacter> characters;
		if(characterService.findAll().isEmpty()) {
        	logger.info("Characters list is empty");
        	characters = new ArrayList<>();
        } else {
        	characters = characterService.findAll();
 
        }
		return characters;
	}
	
    /*
     * This method will return one character.
     */
	private GameCharacter findCharacter(Integer id) {
		GameCharacter character;
		List<GameCharacter> characters = characterService.findById(id);
		if (characters.isEmpty()){
    		logger.info("Characters list is empty");
    		character = new GameCharacter();
    	} else {
    		character = characters.iterator().next();
    		if (characters.size() > 1) {
    			logger.info("Method findCharacter(Integer id) returned more then one result");
    		}
    	}
		return character;
	}
}
