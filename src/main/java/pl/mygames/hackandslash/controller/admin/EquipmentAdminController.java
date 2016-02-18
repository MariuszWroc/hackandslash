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
import pl.mygames.hackandslash.model.Equipment;
import pl.mygames.hackandslash.service.IEquipmentService;

@Controller
@RequestMapping(value = {"/admin"})
public class EquipmentAdminController {
    private static final Logger logger = LoggerFactory.getLogger(EquipmentAdminController.class);
	@Autowired	
    private IEquipmentService equipmentService;
	private Integer keyValue;
	
	@RequestMapping(value = {"/equipments"}, method = RequestMethod.GET)
    public String getEquipments(ModelMap model) {
    	List<Equipment> equipments = findEquipments();
    	keyValue = Autoincrementation.getValue(equipments.size());
		model.addAttribute("equipments", equipments);
		model.addAttribute("one_equipment", new Equipment());
        return "admin/equipments";
    }
	
    @RequestMapping(value = "/equipments/add", method = RequestMethod.POST)  
    public String addEquipment(@ModelAttribute("one_equipment")Equipment equipment, @RequestParam String action) {
        if (equipment.getId() == null) {
        	equipment.setId(keyValue);
        	equipmentService.add(equipment);
            logger.info("Equipment with id = " + keyValue + ", added");
        } else if (action.equals("Edit")){
        	equipmentService.update(equipment);
            logger.info("Equipment with id = " + equipment.getId() + ", updated");
        } 
        return "redirect:/admin/equipments";  
    } 
    
    @RequestMapping(value = "/equipments/remove/{id}")
    public String removeEquipment(@PathVariable("id") Integer id){
        equipmentService.delete(id);
        logger.info("Equipment with id = " + id + ", deleted");
        return "redirect:/admin/equipments";
    }
    
    @RequestMapping(value = "/equipments/edit/{id}")
    public String editEquipment(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("equipments", findEquipments());
        model.addAttribute("one_equipment", findEquipment(id));
        logger.info("Equipment with id = " + id + ", edited");
        return "admin/equipments";
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
		return equipmentService.findById(id);
	}
}
