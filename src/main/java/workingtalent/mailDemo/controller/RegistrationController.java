package workingtalent.mailDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import workingtalent.mailDemo.domain.EmailService;

@RestController
public class RegistrationController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/signup")
	public String signup() {
		return "Please sign up for our service.";
	}
	
	@RequestMapping("/signup-success")
	public String signupSuccess() {
		
		//send a notification
		try {
			emailService.sendEmail();
		}
		catch(Exception e) {
			
		}
		
		return "Sending Email....";
	}
}
