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
import pl.mygames.hackandslash.model.JournalPage;
import pl.mygames.hackandslash.service.IJournalService;

@Controller
@RequestMapping(value = {"/admin"})
public class JournalAdminController {
    private static final Logger logger = LoggerFactory.getLogger(JournalAdminController.class);
	@Autowired
    private IJournalService journalService;
	private Integer keyValue;
    
	  @RequestMapping(value = {"/journals"}, method = RequestMethod.GET)
	    public String getJournals(ModelMap model) {
	        List<JournalPage> journals = findJournals();
	        keyValue = Autoincrementation.getValue(journals.size());
	    	model.addAttribute("journals", journals);
	    	model.addAttribute("one_journal", new JournalPage());
	        return "admin/journals";
	    }
	  
	    @RequestMapping(value = "/journals/add", method = RequestMethod.POST)  
	    public String addJournal(@ModelAttribute("one_journal")JournalPage journal, @RequestParam String action) {
	        if ((journal.getId() == null) && (action.equals("Add"))) {
	        	journal.setId(keyValue);
	        	journalService.add(journal);
	            logger.info("Journal with id = " + keyValue + ", added");
	        } else if (action.equals("Edit")){
	        	journalService.update(journal);
	            logger.info("Journal with id = " + journal.getId() + ", updated");
	        } 
	        return "redirect:/admin/journals";  
	    }
	    
	    @RequestMapping(value = "/journals/remove/{id}")
	    public String removeJournal(@PathVariable("id") Integer id){
	        journalService.delete(id);
	        logger.info("Journal with id = " + id + ", deleted");
	        return "redirect:/admin/journals";
	    }
	    
	    @RequestMapping(value = "/journals/edit/{id}")
	    public String editJournal(@PathVariable("id") Integer id, ModelMap model){
	        model.addAttribute("journals", findJournals());
	        model.addAttribute("one_journal", findJournal(id));
	        logger.info("Journal with id = " + id + ", edited");
	        return "admin/journals";
	    }
	    
	    /*
	     * This method will list all existing journals.
	     */
		private List<JournalPage> findJournals() {
			List<JournalPage> journals;
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
		private JournalPage findJournal(Integer id) {
			return journalService.findById(id);
		}
}
