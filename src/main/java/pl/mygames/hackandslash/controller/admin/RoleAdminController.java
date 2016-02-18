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
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.service.IRoleService;

@Controller
@RequestMapping(value = {"/admin"})
public class RoleAdminController {
    private static final Logger logger = LoggerFactory.getLogger(RoleAdminController.class);
	@Autowired
    private IRoleService roleService;
	private Integer keyValue;
    
	@RequestMapping(value = {"/roles"}, method = RequestMethod.GET)
    public String getRoles(ModelMap model) {
        List<GameRole> roles = findRoles();
        keyValue = Autoincrementation.getValue(roles.size());
        model.addAttribute("roles", roles);
        model.addAttribute("one_role", new GameRole());
        return "admin/roles";
    }

    @RequestMapping(value = "/roles/add", method = RequestMethod.POST)  
    public String addRole(@ModelAttribute("one_role")GameRole role, @RequestParam String action) {
        if ((action.equals("Add")) && (action.equals("Add"))) {
        	role.setId(keyValue);
            roleService.add(role);
            logger.info("Place with id = " + keyValue + ", added");
        } else if (action.equals("Edit")) {
            roleService.update(role);
            logger.info("Place with id = " + keyValue + ", updated");
        } 
        return "redirect:/admin/roles";  
    } 
    
    @RequestMapping(value = "/roles/remove/{id}")
    public String removeRole(@PathVariable("id") Integer id){
        roleService.delete(id);
        logger.info("Place with id = " + id + ", deleted");
        return "redirect:/admin/roles";
    }
    
    @RequestMapping(value = "/roles/edit/{id}")
    public String editRole(@PathVariable("id") Integer id, ModelMap model){
        model.addAttribute("roles", findRoles());
        model.addAttribute("one_role", findRole(id));
        logger.info("Place with id = " + id + ", edited");
        return "admin/roles";
    }
    
    /*
     * This method will get all existing roles.
     */
	public List<GameRole> findRoles() {
		return roleService.findAll();
	}
    
    /*
     * This method will return one role.
     */
	private GameRole findRole(Integer id) {
		return roleService.findById(id);
	}
}
