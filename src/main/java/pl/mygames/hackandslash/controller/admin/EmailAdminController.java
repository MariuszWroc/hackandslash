package pl.mygames.hackandslash.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.web.EmailDTO;
import pl.mygames.hackandslash.service.impl.EmailSenderService;

@Controller
@RequestMapping(value = "/admin")
public class EmailAdminController {
    private static final Logger logger = LoggerFactory.getLogger(EmailAdminController.class);
	
    @Autowired	
    private EmailSenderService mailSender;
    
	@RequestMapping(value = "/email", method = RequestMethod.GET)
    public String getEmail(ModelMap model) {
    	model.addAttribute("email", new EmailDTO());
        return "admin/procedures/sendEmail";
    }
	
    @RequestMapping(value = "/email/send", method = RequestMethod.POST)  
    public String sendEmail(@ModelAttribute("email") EmailDTO email, BindingResult result) {
		if (!result.hasErrors()) {
    		mailSender.sendMail(email);
            logger.info("Email with subject = " + email.getSubject() + " from addres " + email.getSender() + " to "+ email.getReceiver() + " send");
            return "redirect:/admin/email"; 
		} else {
			logger.info("Validation failed. " + result.getFieldError());
			return "admin/procedures/sendEmail";
		}
 
    } 
 
    
}
