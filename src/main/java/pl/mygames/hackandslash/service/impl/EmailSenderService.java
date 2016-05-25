package pl.mygames.hackandslash.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.*;
import org.springframework.stereotype.Service;

import pl.mygames.hackandslash.dto.web.EmailDTO;

@Service
public class EmailSenderService {
	private static final Logger logger = LoggerFactory.getLogger(EmailSenderService.class); 
	
	@Autowired
	private MailSender sender;
        
    public void sendMail(EmailDTO emailDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(emailDTO.getSender());
		message.setTo(emailDTO.getReceiver());
		message.setSubject(emailDTO.getSubject());
		message.setText(emailDTO.getBody());

		sendMessage(message);
		
		logger.info("Sent message successfully....");
    }

	private void sendMessage(SimpleMailMessage message) {
		try {
			logger.info("Email with subject = " + message.getSubject() + " from addres " + message.getFrom() + " to "+ message.getTo() + " was send");
			sender.send(message);
		} catch (MailException e) {
			logger.error(e.getMessage(), e);
		}
	}
    
	public void setMailSender(MailSender mailSender) {
		this.sender = mailSender;
	}
}
