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

import pl.mygames.hackandslash.dto.user.JournalDTO;

@RestController
@Scope("session")
@RequestMapping(value = {"/game"})
public class JournalController extends UserCommon{
	private static final Logger logger = LoggerFactory.getLogger(JournalController.class);
	
	@Autowired
	private HeroController heroController;
	
	@RequestMapping(value = "/journal", method = RequestMethod.GET)
	public ResponseEntity<JournalDTO> getJournal(ModelMap model) {
		if (getActualLoggedUser().isEnabled()) {
			String login = getActualLoggedUser().getUsername();
			JournalDTO journal = new JournalDTO();
			logger.info("journal " + journal.toString());
			if (journal != null) {
				return new ResponseEntity<JournalDTO>(journal, HttpStatus.OK);
			}

			return new ResponseEntity<JournalDTO>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<JournalDTO>(HttpStatus.NO_CONTENT);
		}
	}
}
