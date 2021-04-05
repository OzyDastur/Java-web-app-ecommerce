package com.concordia.crud;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.concordia.email.impl.EmailServiceImpl;
import com.concordia.exception.EmailException;



@SpringBootApplication

public class ProductCrudApplication extends SpringBootServletInitializer {
	
    /**
	 * Logger Object to make Logs
	 */
    private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProductCrudApplication.class);
	}

	public static void main(String[] args) throws EmailException {
    	/**
    	 * Sending the Email with the different parameters
    	 *
    	 * @param senderEmailId The Senders Email Address
    	 * @param receiverEmailId The Receivers Email Address
    	 * @param subject The subject of the email.
    	 * @param message The message content in the body which regular text.
    	 * @throws EmailException
    	 */
        SpringApplication.run(ProductCrudApplication.class, args);  
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		EmailServiceImpl email = (EmailServiceImpl) context.getBean("emailServiceImpl");
		String senderEmailId = "chartrandalex20@gmail.com";
		String receiverEmailId = "chartrandalex20@gmail.com";
		String subject = "Testing";
		String message = "This is a test message.";
		email.sendEmail(senderEmailId, receiverEmailId, subject, message);
		/**
    	 * Logging for the Email Messsage being Successfuly Sent.
    	 */
		LOGGER.log(Level.INFO, "Email has been Sent Successfuly.");
	}

}
