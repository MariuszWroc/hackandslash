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
import pl.mygames.hackandslash.model.Quest;
import pl.mygames.hackandslash.service.IQuestService;

@Controller
@RequestMapping(value = {"/admin"})
public class QuestAdminController {
    private static final Logger logger = LoggerFactory.getLogger(QuestAdminController.class);
	@Autowired
    private IQuestService questService;
	private Integer keyValue;
    
	@RequestMapping(value = {"/quests"}, method = RequestMethod.GET)
    public String getQuests(ModelMap model) {
    	List<Quest> quests = findQuests();
    	keyValue = Autoincrementation.getValue(quests.size());
    	model.addAttribute("quests", quests);
    	model.addAttribute("one_quest", new Quest());
        return "admin/quests";
    }
	
    @RequestMapping(value = "/quests/add", method = RequestMethod.POST)  
    public String addQuest(@ModelAttribute("one_quest")Quest quest, @RequestParam String action) {
        if ((quest.getId() == null) && (action.equals("Add"))) {
        	quest.setId(keyValue);
        	questService.add(quest);
            logger.info("Place with id = " + keyValue + ", added");
        } else if (action.equals("Edit")){
        	questService.update(quest);
            logger.info("Place with id = " + quest.getId() + ", updated");
        } 
        return "redirect:/admin/quests";  
    } 
    
    @RequestMapping(value = "/quests/remove/{id}")
    public String removeQuest(@PathVariable("id") Integer id){
        questService.delete(id);
        logger.info("Place with id = " + id + ", deleted");
        return "redirect:/admin/quests";
    }
    
    @RequestMapping(value = "/quests/edit/{id}")
    public String editQuest(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("quests", findQuests());
        model.addAttribute("one_quest", findQuest(id));
        logger.info("Place with id = " + id + ", edited");
        return "admin/quests";
    }

    /*
     * This method will list all existing quests.
     */
	private List<Quest> findQuests() {
		List<Quest> quests;
		if(questService.findAll().isEmpty()) {
        	logger.info("Quests list is empty");
        	quests = new ArrayList<>();
        } else {
        	quests = questService.findAll();
        }
		
		return quests;
	}
	
    /*
     * This method will return one quest.
     */
	private Quest findQuest(Integer id) {
		return questService.findById(id);
	}
}
