package taxinearuTesting;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.Log;

public class Dummy {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		final String username = "anjali.smartsensesolutions@gmail.com";
		final String password = "smartAnjali";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-anjali.smartsensesolutions@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("krishnanjali3492@gmail.com"));
			message.setSubject("Testing Subject");
			 Multipart multipart = new MimeMultipart();
		        
		        MimeBodyPart textPart = new MimeBodyPart();
		        String textContent = "Please find the Attachment.";
		        textPart.setText(textContent);
		        multipart.addBodyPart(textPart);
		        
		        MimeBodyPart attachementPart = new MimeBodyPart();
		        attachementPart.attachFile(new File("/home/smart/workspace/taxinearTesting/src/main/resources/Taxinearu.xlsx"));
		        multipart.addBodyPart(attachementPart);

		        message.setContent(multipart);
		        Transport.send(message);
			System.out.println("Sending");

			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
