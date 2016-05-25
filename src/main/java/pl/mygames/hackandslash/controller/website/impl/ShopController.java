package pl.mygames.hackandslash.controller.website.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ShopController extends UserCommon{
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Autowired
	private CharacterController CharacterController;
	
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public ResponseEntity<Object> getEquipment(ModelMap model) {
		if (getActualLoggedUser().isEnabled()) {
			String login = getActualLoggedUser().getUsername();
			Object object = null;
			logger.info("object ");
			if (object != null) {
				return new ResponseEntity<Object>(object, HttpStatus.OK);
			}

			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
	}
}
