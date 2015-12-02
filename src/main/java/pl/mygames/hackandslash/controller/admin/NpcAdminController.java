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
import pl.mygames.hackandslash.model.Npc;
import pl.mygames.hackandslash.service.INpcService;

@Controller
public class NpcAdminController {
    private static final Logger logger = LoggerFactory.getLogger(NpcAdminController.class);
	@Autowired
    private INpcService npcService;
	private Integer keyValue;
	
	@RequestMapping(value = {"/npcs"}, method = RequestMethod.GET)
    public String getNpcs(ModelMap model) {
        List<Npc> npcs = findNpcs();
        keyValue = Autoincrementation.getValue(npcs.size());
    	model.addAttribute("npcs", npcs);
    	model.addAttribute("one_npc", new Npc());
        return "test/npcs";
    }
	
    @RequestMapping(value = "/npcs/add", method = RequestMethod.POST)  
    public String addNpc(@ModelAttribute("one_npc")Npc npc, @RequestParam String action) {
        if ((npc.getId() == null) && (action.equals("Add"))) {
        	npc.setId(keyValue);
        	npcService.add(npc);
	        logger.info("Npc with id = " + keyValue + ", added");
        } else if (action.equals("Edit")){
        	npcService.update(npc);
	        logger.info("Npc with id = " + npc.getId() + ", updated");
        } 
        return "redirect:/npcs";  
    } 
    
    @RequestMapping(value = "/npcs/remove/{id}")
    public String removeNpc(@PathVariable("id") Integer id){
        npcService.delete(id);
        logger.info("Npc with id = " + id + ", deleted");
        return "redirect:/npcs";
    }
    
    @RequestMapping(value = "/npcs/edit/{id}")
    public String editNpc(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("npcs", findNpcs());
        model.addAttribute("one_npc", findNpc(id));
        logger.info("Npc with id = " + id + ", edited");
        return "test/npcs";
    }
    
    /*
     * This method will list all existing npcs.
     */
	private List<Npc> findNpcs() {
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
