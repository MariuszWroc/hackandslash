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
import org.springframework.web.bind.annotation.RequestParam;

import pl.mygames.hackandslash.controller.util.Autoincrementation;
import pl.mygames.hackandslash.controller.util.ProjectConstants;
import pl.mygames.hackandslash.model.GameRole;
import pl.mygames.hackandslash.model.Journal;
import pl.mygames.hackandslash.service.IJournalService;

@Controller
public class JournalTestController {
    private static final Logger logger = LoggerFactory.getLogger(JournalTestController.class);
	@Autowired
    private IJournalService journalService;
	private Integer keyValue;
    
	  @RequestMapping(value = {"/journals"}, method = RequestMethod.GET)
	    public String getJournals(ModelMap model) {
	        List<Journal> journals = findJournals();
	        keyValue = Autoincrementation.getValue(journals.size());
	    	model.addAttribute("journals", journals);
	    	model.addAttribute("one_journal", new Journal());
	        return "test/journals";
	    }
	  
	    @RequestMapping(value = "/journals/add", method = RequestMethod.POST)  
	    public String addJournal(@ModelAttribute("one_journal")Journal journal, @RequestParam String action) {
	        if ((journal.getId() == null) && (action.equals("Add"))) {
	        	journal.setId(keyValue);
	        	journalService.add(journal);
	            logger.info("Journal with id = " + keyValue + ", added");
	        } else if (action.equals("Edit")){
	        	journalService.update(journal);
	            logger.info("Journal with id = " + journal.getId() + ", updated");
	        } 
	        return "redirect:/journals";  
	    }
	    
	    @RequestMapping(value = "/journals/remove/{id}")
	    public String removeJournal(@PathVariable("id") Integer id){
	        journalService.delete(id);
	        logger.info("Journal with id = " + id + ", deleted");
	        return "redirect:/journals";
	    }
	    
	    @RequestMapping(value = "/journals/edit/{id}")
	    public String editJournal(@PathVariable("id") Integer id, ModelMap model){
	        model.addAttribute("journals", findJournals());
	        model.addAttribute("one_journal", findJournal(id));
	        logger.info("Journal with id = " + id + ", edited");
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
			List<Journal> journals = journalService.findById(id);
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
