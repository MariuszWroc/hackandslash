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
import pl.mygames.hackandslash.model.Equipment;
import pl.mygames.hackandslash.model.Hero;
import pl.mygames.hackandslash.service.IEquipmentService;

@Controller
public class EquipmentTestController {
    private static final Logger logger = LoggerFactory.getLogger(EquipmentTestController.class);
	@Autowired	
    private IEquipmentService equipmentService;
	private Integer keyValue;
	
	@RequestMapping(value = {"/equipments"}, method = RequestMethod.GET)
    public String getEquipments(ModelMap model) {
    	List<Equipment> equipments = findEquipments();
    	keyValue = Autoincrementation.getValue(equipments.size());
		model.addAttribute("equipments", equipments);
		model.addAttribute("one_equipment", new Equipment());
        return "test/equipments";
    }
	
    @RequestMapping(value = "/equipments/add", method = RequestMethod.POST)  
    public String addEquipment(@ModelAttribute("one_equipment")Equipment equipment) {
        if (equipment.getId() == null) {
        	equipment.setId(keyValue);
        	equipmentService.add(equipment);
            logger.info("Equipment with id = " + keyValue + ", added");
        } else {
        	equipmentService.update(equipment);
            logger.info("Equipment with id = " + equipment.getId() + ", updated");
        } 
        return "redirect:/equipments";  
    } 
    
    @RequestMapping(value = "/equipments/remove/{id}")
    public String removeEquipment(@PathVariable("id") Integer id){
        equipmentService.delete(id);
        logger.info("Equipment with id = " + id + ", deleted");
        return "redirect:/equipments";
    }
    
    @RequestMapping(value = "/equipments/edit/{id}")
    public String editEquipment(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("equipments", findEquipments());
        model.addAttribute("one_equipment", findEquipment(id));
        logger.info("Equipment with id = " + id + ", edited");
        return "test/equipments";
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
		List<Equipment> equipments = equipmentService.findById(id);
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
