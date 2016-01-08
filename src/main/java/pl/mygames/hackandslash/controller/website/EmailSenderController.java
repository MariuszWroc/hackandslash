package pl.mygames.hackandslash.controller.website;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import pl.mygames.hackandslash.dto.EmailDTO;
import pl.mygames.hackandslash.service.impl.EmailSenderService;

@RestController
public class EmailSenderController {
	 private static final Logger logger = LoggerFactory.getLogger(EmailSenderController.class);
		
	    @Autowired	
	    private EmailSenderService mailSender;
		
	    @RequestMapping(value = "/email/send", method = RequestMethod.POST, consumes = { "application/json;charset=UTF-8" })  
	    public ResponseEntity<List<ObjectError>> sendEmail(@RequestBody @Valid EmailDTO email, BindingResult result) {
			if (!result.hasErrors()) {
	    		mailSender.sendMail(email);
	            return new ResponseEntity<List<ObjectError>>(result.getAllErrors(), HttpStatus.OK);
			} else {
				logger.info("Validation failed. " + result.getFieldError());
				return new ResponseEntity<List<ObjectError>>(result.getAllErrors(), HttpStatus.CONFLICT);
			}
	    } 
}
