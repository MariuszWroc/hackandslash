package pl.mygames.hackandslash.controller.website.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("session")
@RequestMapping(value = {"/game"})
public class CombatController extends UserCommon{
	private static final Logger logger = LoggerFactory.getLogger(CombatController.class);
	
	@RequestMapping(value = "/combat", method = RequestMethod.GET)
	public ResponseEntity<Object> getEquipment(ModelMap model) {
		if (getActualLoggedUser().isEnabled()) {
			String login = getActualLoggedUser().getUsername();
			Object combat = null;
			logger.info("combat ");
			if (combat != null) {
				return new ResponseEntity<Object>(combat, HttpStatus.OK);
			}

			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
	}
}
