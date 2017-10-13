package com.quapt.myf4h.product.rest.resources;

import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quapt.myf4h.product.core.utill.MailServices;
import com.quapt.myf4h.product.domain.Status;
import com.quapt.myf4h.product.repository.StatusRepository;

@RestController
@RequestMapping("/api/status")
public class StatusResource {

	@Inject
	private StatusRepository statusRepository;
	
	@Autowired
	public JavaMailSender  javaMailSender;


	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Status> query() {

		List<Status> userStatus = statusRepository.findAll();
		return userStatus;
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status addItem(@RequestBody Status status) {
		/*String host = "smtp.gmail.com";
        String from = "user";
        String pass = "Quapt@123";
	    Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
	    
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("like2eatinfo@gmail.com");
        mailMessage.setTo("testing77@mailinator.com");
        mailMessage.setSubject("Welcome...!!!");
        mailMessage.setText("Hello " +"Mailinator" +"\n Your registration is successfull");
        javaMailSender.send(mailMessage);        
        
		try {
			Session session = Session.getDefaultInstance(props, new MailServices(from, pass));
	        MimeMessage message = new MimeMessage(session);
	        Address fromAddress = new InternetAddress(from);
	        Address toAddress;
			toAddress = new InternetAddress("testing77@mailinator.com");
			message.setFrom(fromAddress);
	        message.setRecipient(Message.RecipientType.TO, toAddress);

	        message.setSubject("Testing JavaMail");
	        message.setText("Welcome to JavaMail");
	        Transport transport = session.getTransport("smtp");
	        transport.connect(host, from, pass);
	        message.saveChanges();
	        Transport.send(message);
	        transport.close();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

        
		
		return statusRepository.save(status);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Status updateStatus(@RequestBody Status updatedStatus, @PathVariable Integer id) {
		return statusRepository.save(updatedStatus);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteItem(@PathVariable Long id) {
		Status status = statusRepository.findOne((Long)id);
		statusRepository.delete(status);
	}
}
