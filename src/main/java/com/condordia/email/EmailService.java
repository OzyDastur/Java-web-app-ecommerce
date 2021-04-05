package com.condordia.email;

import com.concordia.exception.EmailException;

/**
 * @author Alexis
 *
 */
public interface EmailService {
	
	/**
	 * Send email through 
	 *
	 * @param emailAddressFrom The addressFrom
	 * @param emailAddressTo The addressTo
	 * @param subject The subject of the email.
	 * @param message The message content in the body which regular text.
	 * @throws EmailException
	 */
	void sendEmail(String emailAddressFrom, String emailAddressTo, String subject, String messageContent) throws EmailException;

}