package pl.mygames.hackandslash.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.mygames.hackandslash.controller.util.ProjectConstants;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.model.Quest;
import pl.mygames.hackandslash.service.IQuestService;

@Controller
public class QuestTestController {
    private static final Logger logger = LoggerFactory.getLogger(QuestTestController.class);
	@Autowired
    private IQuestService questService;
    
	@RequestMapping(value = {"/quests"}, method = RequestMethod.GET)
    public String getQuests(ModelMap model) {
    	List<Quest> quests = findQuests(model);
    	Quest one_quest = findQuest(ProjectConstants.TEST_ID.getValue());
    	model.addAttribute("quests", quests);
    	model.addAttribute("one_quest", one_quest);
        return "test/quests";
    }
	
    @RequestMapping(value = "/quests/add", method = RequestMethod.POST)  
    public String addQuest(@ModelAttribute("one_quest")Quest quest) {
        if (quest.getId() == 0) {
        	questService.add(quest);
        } else {
        	questService.update(quest);
        } 
        return "redirect:/quests";  
    } 

    /*
     * This method will list all existing quests.
     */
	private List<Quest> findQuests(ModelMap model) {
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
		Quest quest;
		List<Quest> quests = questService.findByQuery(id);
		if (quests.isEmpty()){
    		logger.info("Quests list is empty");
    		quest = new Quest();
    	} else {
    		quest = quests.iterator().next();
    		if (quests.size() > 1) {
    			logger.info("Method findQuest() returned more then one result");
    		}
    	}
		return quest;
	}
}
