package br.com.astner.msmail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import br.com.astner.msmail.entity.Mail;
import br.com.astner.msmail.entity.dto.UserDto;
import br.com.astner.msmail.repository.MailRepository;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;
	
	@Autowired
	public MailRepository mailRepository;
	
	@Override
	public void sendSimpleMessage(UserDto input) {
		try {
			Mail newMail = new Mail();
			newMail.setTo(input.getUsername());
			newMail.setSubject("E-Mail Verification for " + input.getName());
			newMail.setText("Hi, " + input.getName() + " this is just an e-mail verification.");
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(newMail.getTo());
			message.setSubject(newMail.getSubject());
			message.setText(newMail.getText());
			
			mailRepository.save(newMail);
			emailSender.send(message);
			
		}catch(MailException exception) {
			exception.printStackTrace();
		}

	}

}
