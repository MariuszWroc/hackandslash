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
import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.service.IHeroService;

@Controller
@RequestMapping(value = {"/admin"})
public class HeroAdminController {
    private static final Logger logger = LoggerFactory.getLogger(HeroAdminController.class);
	@Autowired
    private IHeroService heroService;
	private Integer keyValue;

	@RequestMapping(value = {"/heroes"}, method = RequestMethod.GET)
    public String getHeroes(ModelMap model) {
        List<Hero> heroes = findHeroes();
        keyValue = Autoincrementation.getValue(heroes.size());
    	model.addAttribute("heroes", heroes);
    	model.addAttribute("one_hero", new Hero());
        return "admin/heroes";
    }
	
    @RequestMapping(value = "/heroes/add", method = RequestMethod.POST)  
    public String addHero(@ModelAttribute("one_hero")Hero hero, @RequestParam String action) {
        if ((hero.getId() == null) && (action.equals("Add"))) {
        	hero.setId(keyValue);
        	heroService.add(hero);
            logger.info("Hero with id = " + keyValue + ", added");
        } else if (action.equals("Edit")){
        	heroService.update(hero);
            logger.info("Hero with id = " + hero.getId() + ", updated");
        } 
        return "redirect:/heroes";  
    }  
    
    @RequestMapping(value = "/heroes/remove/{id}")
    public String removeHero(@PathVariable("id") Integer id){
        heroService.delete(id);
        logger.info("Hero with id = " + id + ", deleted");
        return "redirect:/heroes";
    }
    
    @RequestMapping(value = "/heroes/edit/{id}")
    public String editHero(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("heroes", findHeroes());
        model.addAttribute("one_hero", findHero(id));
        logger.info("Hero with id = " + id + ", edited");
        return "admin/heroes";
    }
    
    /*
     * This method will list all existing heroes.
     */
	private List<Hero> findHeroes() {
		List<Hero> heroes;
		if(heroService.findAll().isEmpty()) {
        	logger.info("Heroes list is empty");
        	heroes = new ArrayList<>();
        } else {
        	heroes = heroService.findAll();
        }
		return heroes;
	}
	
    /*
     * This method will return one hero.
     */
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
}
