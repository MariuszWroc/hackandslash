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
import pl.mygames.hackandslash.model.Equipment;
import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.service.IEquipmentService;

@Controller
public class EquipmentTestController {
    private static final Logger logger = LoggerFactory.getLogger(EquipmentTestController.class);
	@Autowired	
    private IEquipmentService equipmentService;
	
	@RequestMapping(value = {"/equipments"}, method = RequestMethod.GET)
    public String getEquipments(ModelMap model) {
    	List<Equipment> equipments = findEquipments();
    	Equipment one_equipment = findEquipment(ProjectConstants.TEST_ID.getValue());
		model.addAttribute("equipments", equipments);
		model.addAttribute("one_equipment", one_equipment);
        return "test/equipments";
    }
	
    @RequestMapping(value = "/equipments/add", method = RequestMethod.POST)  
    public String addEquipment(@ModelAttribute("one_equipment")Equipment equipment) {
        if (equipment.getId() == 0) {
        	equipmentService.add(equipment);
        } else {
        	equipmentService.update(equipment);
        } 
        return "redirect:/equipments";  
    } 
    
    /*
     * This method will list all existing equipments.
     */
	private List<Equipment> findEquipments() {
		List<Equipment> equipments;
		if (equipmentService.findAll().isEmpty()){
    		logger.info("Equipments list is empty");
    		equipments = new ArrayList<>();
    	} else {
    		equipments = equipmentService.findAll();

    	}
		return equipments;
	}
	
    /*
     * This method will return one equipment.
     */
	private Equipment findEquipment(Integer id) {
		Equipment equipment;
		List<Equipment> equipments = equipmentService.findByQuery(id);
		if (equipments.isEmpty()){
    		logger.info("Equipments list is empty");
    		equipment = new Equipment();
    	} else {
    		equipment = equipments.iterator().next();
    		if (equipments.size() > 1) {
    			logger.info("Method findEquipment(Integer id) returned more then one result");
    		}
    	}
		return equipment;
	}
}
