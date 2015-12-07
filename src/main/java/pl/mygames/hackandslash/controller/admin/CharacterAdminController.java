package pl.mygames.hackandslash.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.controller.util.Autoincrementation;
import pl.mygames.hackandslash.model.GameCharacter;
import pl.mygames.hackandslash.service.ICharacterService;

@Controller
@RequestMapping(value = {"/admin"})
public class CharacterAdminController {
    private static final Logger logger = LoggerFactory.getLogger(CharacterAdminController.class);
	@Autowired
    private ICharacterService characterService;
	private Integer keyValue;
    
	@RequestMapping(value = {"/characters"}, method = RequestMethod.GET)
    public String getCharacters(ModelMap model) {
        List<GameCharacter> characters = findCharacters();
        keyValue = Autoincrementation.getValue(characters.size());
       	model.addAttribute("characters", characters);
       	model.addAttribute("one_character", new GameCharacter());
        return "admin/characters";
    }
	
    @RequestMapping(value = "/characters/add", method = RequestMethod.POST)  
    public String addCharacter(@ModelAttribute("one_character")GameCharacter character, @RequestParam String action) {
        if (character.getId() == null) {
        	character.setId(keyValue);
        	characterService.add(character);
            logger.info("Character with id = " + keyValue + ", added");
        } else if (action.equals("Edit")){
        	characterService.update(character);
            logger.info("Character with id = " + character.getId() + ", updated");
        } 
        return "redirect:/characters";  
    } 
    
    @RequestMapping(value = "/characters/remove/{id}")
    public String removeCharacter(@PathVariable("id") Integer id){      
        characterService.delete(id);
        logger.info("Character with id = " + id + ", deleted");
        return "redirect:/characters";
    }
    
    @RequestMapping(value = "/characters/edit/{id}")
    public String editCharacter(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("characters", findCharacters());
        model.addAttribute("one_character", findCharacter(id));
        logger.info("Character with id = " + id + ", edited");
        return "admin/characters";
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
