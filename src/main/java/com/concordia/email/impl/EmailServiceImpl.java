package com.concordia.email.impl;

/**
 * Imports
 *
 */
import com.concordia.exception.EmailException;
import com.condordia.email.EmailService;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
/**
 * END
 *
 */
import org.springframework.stereotype.Service;

/** Email Service Implementation
 * @author Alexis
 *
 */
@Service
public class EmailServiceImpl implements EmailService {
	
	/**
	 * API Object used to send emails
	 *
	 */
	private MailSender mailSender;
	/**
	 * END
	 *
	 */
		
	/**
	 * Instanciates the mailsender Object
	 *
	 */
	public void setMailSender(MailSender mailSender) {
	        this.mailSender = mailSender;
	}
	/**
	 * END
	 *
	 */

	/**
	 * Method for actually sending the email
	 *
	 */  
	@Override
	public void sendEmail(String emailAddressFrom, String emailAddressTo, String subject, String messageContent)
	/**
	 * Email Exception + The Implementation of the Email Service 
	 *
	 * @param emailAddressFrom The addressFrom
	 * @param emailAddressTo The addressTo
	 * @param subject The subject of the email.
	 * @param message The message content in the body which regular text.
	 * @throws EmailException
	 */
		throws EmailException {
		if (mailSender == null) {
		return;
		}
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(emailAddressFrom);
		simpleMailMessage.setTo(emailAddressTo);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(messageContent);
		mailSender.send(simpleMailMessage);
	}
	/**
	 * END
	 *
	 */
}