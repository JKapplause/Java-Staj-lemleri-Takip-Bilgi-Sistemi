package com.ismailekin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ismailekin.stajtakip.HomeController;

@Service
public class MailService {

		@Autowired
		private JavaMailSender mailSender;
		
		public void registerMail(String mail, String key) {
			
			SimpleMailMessage email = new SimpleMailMessage();
			email.setFrom("ismailekin648@gmail.com");
			email.setTo(mail);
			email.setSubject("Uyeligi Tamamla");
			email.setText("Uyeligi tamamlamak icin asagýdaki linke týklayýnýz.\n\n"
					+HomeController.url+"/reg/"+key);
			
			mailSender.send(email);
		}
}
