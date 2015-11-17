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
import pl.mygames.hackandslash.model.Npc;
import pl.mygames.hackandslash.service.INpcService;

@Controller
public class NpcTestController {
    private static final Logger logger = LoggerFactory.getLogger(NpcTestController.class);
	@Autowired
    private INpcService npcService;
	
	@RequestMapping(value = {"/npcs"}, method = RequestMethod.GET)
    public String getNpcs(ModelMap model) {
        List<Npc> npcs = findNpcs(model);
        Npc one_npc = findNpc(ProjectConstants.TEST_ID.getValue());
    	model.addAttribute("npcs", npcs);
    	model.addAttribute("one_npc", one_npc);
        return "test/npcs";
    }
	
    @RequestMapping(value = "/npcs/add", method = RequestMethod.POST)  
    public String addNpc(@ModelAttribute("one_npc")Npc npc) {
        if (npc.getId() == 0) {
        	npcService.add(npc);
        } else {
        	npcService.update(npc);
        } 
        return "redirect:/npcs";  
    } 
    
    /*
     * This method will list all existing npcs.
     */
	private List<Npc> findNpcs(ModelMap model) {
		List<Npc> npcs;
		if(npcService.findAll().isEmpty()) {
        	logger.info("Npcs list is empty");
        	npcs = new ArrayList<>();
        } else {
        	npcs = npcService.findAll();
        }
		return npcs;
	}
	
    /*
     * This method will return one npc.
     */
	private Npc findNpc(Integer id) {
		Npc npc;
		List<Npc> npcs = npcService.findById(id);
		if (npcs.isEmpty()){
    		logger.info("Npcs list is empty");
    		npc = new Npc();
    	} else {
    		npc = npcs.iterator().next();
    		if (npcs.size() > 1) {
    			logger.info("Method findNpc(Integer id) returned more then one result");
    		}
    	}
		return npc;
	}
}
