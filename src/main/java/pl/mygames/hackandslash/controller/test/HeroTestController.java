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
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.service.IHeroService;

@Controller
public class HeroTestController {
    private static final Logger logger = LoggerFactory.getLogger(HeroTestController.class);
	@Autowired
    private IHeroService heroService;
	private Integer keyValue;

	@RequestMapping(value = {"/heroes"}, method = RequestMethod.GET)
    public String getHeroes(ModelMap model) {
        List<Hero> heroes = findHeroes();
        keyValue = Autoincrementation.getValue(heroes.size());
    	model.addAttribute("heroes", heroes);
    	model.addAttribute("one_hero", new Hero());
        return "test/heroes";
    }
	
    @RequestMapping(value = "/heroes/add", method = RequestMethod.POST)  
    public String addHero(@ModelAttribute("one_hero")Hero hero) {
        if (hero.getId() == null) {
        	hero.setId(keyValue);
        	heroService.add(hero);
        } else {
        	heroService.update(hero);
        } 
        return "redirect:/heroes";  
    }  
    
    @RequestMapping(value = "/heroes/remove/{id}")
    public String removeHero(@PathVariable("id") Integer id){
        heroService.delete(id);
        return "redirect:/heroes";
    }
    
    @RequestMapping(value = "/heroes/edit/{id}")
    public String editHero(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("heroes", findHeroes());
        model.addAttribute("one_hero", findHero(id));
        return "test/heroes";
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
