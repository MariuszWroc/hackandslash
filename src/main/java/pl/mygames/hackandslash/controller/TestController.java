/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mygames.hackandslash.model.*;
import pl.mygames.hackandslash.service.*;

/**
 *
 * @author mariusz
 */
@Controller
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private IUserService userService;
    private ICharacterService characterService;
    private IEquipmentService equipmentService;
    private IRoleService roleService;
    private IHeroService heroService;
    private IItemService itemService;
    private IJournalService journalService;
    private INpcService npcService;
    private IPlaceService placeService;
    private IQuestService questService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired(required = true)
    @Qualifier(value = "heroService")
    public void setHeroService(IHeroService heroService) {
        this.heroService = heroService;
    }

    @Autowired(required = true)
    @Qualifier(value = "characterService")
    public void setCharacterService(ICharacterService characterService) {
        this.characterService = characterService;
    }

    @Autowired(required = true)
    @Qualifier(value = "equipmentService")
    public void setEquipmentService(IEquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Autowired(required = true)
    @Qualifier(value = "roleService")
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired(required = true)
    @Qualifier(value = "itemService")
    public void setItemService(IItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired(required = true)
    @Qualifier(value = "journalService")
    public void setJournalService(IJournalService journalService) {
        this.journalService = journalService;
    }

    @Autowired(required = true)
    @Qualifier(value = "npcService")
    public void setNpcService(INpcService npcService) {
        this.npcService = npcService;
    }

    @Autowired(required = true)
    @Qualifier(value = "placeService")
    public void setPlaceService(IPlaceService placeService) {
        this.placeService = placeService;
    }

    @Autowired(required = true)
    @Qualifier(value = "questService")
    public void setQuestService(IQuestService questService) {
        this.questService = questService;
    }
    
                /*
            * This method will list all existing users.
            */
           @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
           public String getUsers(ModelMap model) {

               List<GameUser> users = userService.findAll();
               logger.info("getUsers results " + users.iterator().next().getId());
               model.addAttribute("users", users);
               return "test/users";
           }
           
           
                       /*
            * This method will list all existing users.
            */
           @RequestMapping(value = {"/equipments"}, method = RequestMethod.GET)
           public String getEquipments(ModelMap model) {

               List<Equipment> equipments = equipmentService.findAll();
               logger.info("get results " + equipments.iterator().next().getId());
               model.addAttribute("equipments", equipments);
               return "test/equipments";
           }
           
                       /*
            * This method will list all existing users.
            */
           @RequestMapping(value = {"/characters"}, method = RequestMethod.GET)
           public String getCharacters(ModelMap model) {

               List<GameCharacter> characters = characterService.findAll();
               logger.info("get results " + characters.iterator().next().getId());
               model.addAttribute("characters", characters);
               return "test/characters";
           }
           
                       /*
            * This method will list all existing users.
            */
           @RequestMapping(value = {"/roles"}, method = RequestMethod.GET)
           public String getRoles(ModelMap model) {

               List<GameRole> roles = roleService.findAll();
               logger.info("get results " + roles.iterator().next().getId());
               model.addAttribute("roles", roles);
               return "test/roles";
           }
           
                       /*
            * This method will list all existing users.
            */
           @RequestMapping(value = {"/heroes"}, method = RequestMethod.GET)
           public String getHeroes(ModelMap model) {

               List<Hero> heroes = heroService.findAll();
               logger.info("get results " + heroes.iterator().next().getId());
               model.addAttribute("heroes", heroes);
               return "test/heroes";
           }
           
                       /*
            * This method will list all existing users.
            */
           @RequestMapping(value = {"/items"}, method = RequestMethod.GET)
           public String getItems(ModelMap model) {

               List<Item> items = itemService.findAll();
               logger.info("get results " + items.iterator().next().getId());
               model.addAttribute("items", items);
               return "test/items";
           }
           
                       /*
            * This method will list all existing journals.
            */
           @RequestMapping(value = {"/journals"}, method = RequestMethod.GET)
           public String getJournals(ModelMap model) {

               List<Journal> journals = journalService.findAll();
               logger.info("get results " + journals.iterator().next().getId());
               model.addAttribute("journals", journals);
               return "test/journals";
           }
           
                       /*
            * This method will list all existing npcs.
            */
           @RequestMapping(value = {"/npcs"}, method = RequestMethod.GET)
           public String getNpcs(ModelMap model) {

               List<Npc> npcs = npcService.findAll();
               logger.info("get results " + npcs.iterator().next().getId());
               model.addAttribute("npcs", npcs);
               return "test/npcs";
           }
           
                       /*
            * This method will list all existing places.
            */
           @RequestMapping(value = {"/places"}, method = RequestMethod.GET)
           public String getPlaces(ModelMap model) {

               List<Place> places = placeService.findAll();
               logger.info("get results " + places.iterator().next().getId());
               model.addAttribute("places", places);
               return "test/places";
           }
           
                       /*
            * This method will list all existing users.
            */
           @RequestMapping(value = {"/quests"}, method = RequestMethod.GET)
           public String getQuests(ModelMap model) {

               List<Quest> quests = questService.findAll();
               logger.info("get results " + quests.iterator().next().getId());
               model.addAttribute("quests", quests);
               return "test/quests";
           }
           
                       /* This method will list all existing users.
            */
           @RequestMapping(value = {"/tests"}, method = RequestMethod.GET)
           public String getTests() {
               return "test/testlist";
           }
}
