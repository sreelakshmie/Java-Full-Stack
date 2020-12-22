package com.company.vendor.utilities;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilityImplementation implements EmailUtilityInterface {

	
	@Autowired
	JavaMailSender sender;
	
	@Override
	public void sendEmail(String toAddress, String subject, String body) {
		// TODO Auto-generated method stub

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(toAddress);
			helper.setSubject(subject);
			helper.setText(body);
		}catch(MessagingException m)
		{
			System.out.println("Mail Sending Failed");
		}
		sender.send(message);
	}

}
