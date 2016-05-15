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

import pl.mygames.hackandslash.dto.user.EquipmentDTO;

@RestController
@Scope("session")
@RequestMapping(value = {"/game"})
public class EquipmentController extends UserCommon{
	private static final Logger logger = LoggerFactory.getLogger(EquipmentController.class);
	
	@RequestMapping(value = "/equipment", method = RequestMethod.GET)
	public ResponseEntity<EquipmentDTO> getEquipment(ModelMap model) {
		if (getActualLoggedUser().isEnabled()) {
			String login = getActualLoggedUser().getUsername();
			EquipmentDTO equipment = new EquipmentDTO();
			logger.info("journal " + equipment.toString());
			if (equipment != null) {
				return new ResponseEntity<EquipmentDTO>(equipment, HttpStatus.OK);
			}

			return new ResponseEntity<EquipmentDTO>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<EquipmentDTO>(HttpStatus.NO_CONTENT);
		}
	}
}
