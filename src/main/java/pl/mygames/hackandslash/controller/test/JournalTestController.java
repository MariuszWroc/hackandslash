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
import pl.mygames.hackandslash.model.Journal;
import pl.mygames.hackandslash.service.IJournalService;

@Controller
public class JournalTestController {
    private static final Logger logger = LoggerFactory.getLogger(JournalTestController.class);
	@Autowired
    private IJournalService journalService;
    
	  @RequestMapping(value = {"/journals"}, method = RequestMethod.GET)
	    public String getJournals(ModelMap model) {
	        List<Journal> journals = findJournals();
	        Journal one_journal = findJournal(ProjectConstants.TEST_ID.getValue());
	    	model.addAttribute("journals", journals);
	    	model.addAttribute("one_journal", one_journal);
	        return "test/journals";
	    }
	    
	    /*
	     * This method will list all existing journals.
	     */
		private List<Journal> findJournals() {
			List<Journal> journals;
			if(journalService.findAll().isEmpty()) {
	        	logger.info("Journals list is empty");
	        	journals = new ArrayList<>();
	        } else {
	        	journals = journalService.findAll();
	        }
			return journals;
		}
		
	    /*
	     * This method will return one equipment.
	     */
		private Journal findJournal(Integer id) {
			Journal journal;
			List<Journal> journals = journalService.findByQuery(id);
			if (journals.isEmpty()){
	    		logger.info("Journals list is empty");
	    		journal = new Journal();
	    	} else {
	    		journal = journals.iterator().next();
	    		if (journals.size() > 1) {
	    			logger.info("Method findJournal(Integer id) returned more then one result");
	    		}
	    	}
			return journal;
		}
}
