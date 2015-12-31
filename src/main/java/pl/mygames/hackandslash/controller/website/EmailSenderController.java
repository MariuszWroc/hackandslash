package pl.mygames.hackandslash.controller.website;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.EmailDTO;
import pl.mygames.hackandslash.service.impl.EmailSenderService;

@RestController
public class EmailSenderController {
	 private static final Logger logger = LoggerFactory.getLogger(EmailSenderController.class);
		
	    @Autowired	
	    private EmailSenderService mailSender;
		
	    @RequestMapping(value = "/email/send", method = RequestMethod.POST)  
	    public String sendEmail(@ModelAttribute("emailDetail") EmailDTO email, BindingResult result) {
			if (!result.hasErrors()) {
	    		mailSender.sendMail(email);
	            logger.info("Email with subject = " + email.getSubject() + " from addres " + email.getSender() + " to "+ email.getReceiver() + " was send");
	            return "redirect:/admin/email"; 
			} else {
				logger.info("Validation failed. " + result.getFieldError());
				return "admin/procedures/sendEmail";
			}
	    } 
}
