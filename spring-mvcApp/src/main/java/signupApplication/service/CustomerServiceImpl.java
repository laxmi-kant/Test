package signupApplication.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import signupApplication.dao.CustomerDao;
import signupApplication.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	public Boolean forgotPassword(String email, String password) {
		return customerDao.forgotPassword(email, password);
	}

	public Boolean save(Customer cust) {
		boolean trigger = customerDao.save(cust);
		System.out.println(signIn(cust.getEmail(), cust.getPassword()).toString());
		if (trigger) {
			sendEmail(cust.getEmail());
		}
		return true;
	}

	public boolean sendEmail(String email) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("temperorymail25@gmail.com", "lk@123456789y");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("temperorymail25@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Signup Mail");
			message.setText("You got signup successfullyr," + "\n\n Thank You!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	public Customer signIn(String email, String password) {
		return customerDao.signIn(email, password);

	}

}
