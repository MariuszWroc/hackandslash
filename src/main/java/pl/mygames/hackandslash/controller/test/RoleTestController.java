package pl.mygames.hackandslash.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.mygames.hackandslash.controller.util.ProjectConstants;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.service.IRoleService;

@Controller
public class RoleTestController {
    private static final Logger logger = LoggerFactory.getLogger(RoleTestController.class);
	@Autowired
    private IRoleService roleService;
    
	@RequestMapping(value = {"/roles"}, method = RequestMethod.GET)
    public String getRoles(ModelMap model) {
        List<GameRole> roles = findRolesInService();
        GameRole one_role = findRoleInService();
        model.addAttribute("roles", roles);
        model.addAttribute("one_role", one_role);
        return "test/roles";
    }

    /*
     * This method will get all existing roles.
     */
	private List<GameRole> findRolesInService() {
		List<GameRole> roles;
        if(roleService.findAll().isEmpty()) {
        	logger.info("Roles list is empty");
        	roles = new ArrayList<>();
        } else {
        	roles = roleService.findAll();
        	
        }
		return roles;
	}
    
    /*
     * This method will return one role.
     */
	private GameRole findRoleInService() {
		GameRole role = null;
		List<GameRole> findByQuery = roleService.findByQuery(ProjectConstants.TEST_ID.getValue());
		if (findByQuery.isEmpty()) {
			logger.info("Roles list is empty");
        	role = new GameRole();
        } else {
        	role = findByQuery.iterator().next(); 
        	if (findByQuery.size() > 1) {
            	logger.info("findByQuery returned more then one result");
        	}
        }
		return role;
	}
}
