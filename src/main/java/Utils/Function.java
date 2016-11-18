package Utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.noneDSA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Function {

	public static String link = null;
	public static String get;

	public static void sendingReports(WebDriver driver, boolean changeValue) throws Exception {

		// Date date = Calendar.getInstance().getTime();
		// DateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy hh:mm a");
		// String today = formatter.format(date);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		Date date = cal.getTime();
		DateFormat formatter = new SimpleDateFormat("dd/MMM/YYYY hh:mm a");
		String today = formatter.format(date);

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
		if (changeValue) {
			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("from-anjali.smartsensesolutions@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("krishnanjali3492@gmail.com"));
				message.setSubject("SUCCESS REPORT ON " + today);

				// sending attachments
				Multipart multipart = new MimeMultipart();
				MimeBodyPart textPart = new MimeBodyPart();
				String textContent = "Please find the Attachment.";
				textPart.setText(textContent);
				multipart.addBodyPart(textPart);

				MimeBodyPart attachementPart = new MimeBodyPart();
				attachementPart.attachFile(
						new File("/home/smart/workspace/taxinearTesting/src/main/resources/Taxinearu.xlsx"));
				multipart.addBodyPart(attachementPart);

				message.setContent(multipart);
				Transport.send(message);
				Log.info("ATTACHMENT SEND SUCCESSFULLY");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		} else {

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("from-anjali.smartsensesolutions@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("krishnanjali3492@gmail.com"));
				message.setSubject("FAILURE REPORT");
				message.setText("SENDING REPORTS," + "\n\n FAILURE OF TEST CASE ON DATE" + today);
				Transport.send(message);
				Log.info("FAILURE DONE");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void readEmail(WebDriver driver, String conn, String username, String pass, long t) {
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect(conn, username, pass);
			Folder inbox = store.getFolder("INBOX");
			Thread.sleep(t);
			inbox.open(Folder.READ_ONLY);
			Message msg = inbox.getMessage(inbox.getMessageCount());
			Object content = msg.getContent();
			// String link = null;
			// String get;
			if (content instanceof Multipart) {
				Multipart mp = (Multipart) content;
				for (int i = 0; i < mp.getCount(); i++) {
					BodyPart bp = mp.getBodyPart(i);
					if (Pattern.compile(Pattern.quote("text/html"), Pattern.CASE_INSENSITIVE)
							.matcher(bp.getContentType()).find()) {
						String buffer = (String) bp.getContent();
						Pattern p = Pattern.compile("a href=\"([^\"]*)\"", Pattern.DOTALL);
						Matcher m = p.matcher(buffer);
						if (m.find()) {
							// Get all groups for this match
							for (int j = 0; j <= m.groupCount(); j++) {
								String groupStr = m.group();
								link = groupStr;

							}

						}
						break;
					}
				}

			}

			Address[] in = msg.getFrom();
			for (Address address : in) {
				System.out.println("FROM:" + address.toString());
			}
			Multipart mp = (Multipart) msg.getContent();
			BodyPart bp = mp.getBodyPart(0);
			System.out.println("SENT DATE:" + msg.getSentDate());
			System.out.println("SUBJECT:" + msg.getSubject());
			System.out.println("CONTENT:" + bp.getContent());

		}

		catch (Exception mex) {
			mex.printStackTrace();

		}
	}

	/// selecting dropdown
	public static void dropDown(WebDriver driver, int row, int cellno) throws Exception {
		List<WebElement> elementList = driver.findElements(By.tagName("option"));
		System.out.println(elementList.size());
		String str = ExcelUtils.getCellData(row, cellno, Constant.SHEET_NAME2);
		boolean check = false;

		for (int i = 0; i < elementList.size(); i++) {

			if (elementList.get(i).getText().equals(str)) {
				Log.info("entering if condition");
				WebElement elementClick = elementList.get(i);
				Thread.sleep(5000);
				elementClick.click();
				check = true;
				break;
			}

		}
		if (!check) {
			elementList.get(1).click();
		}

	}

	public static void loginPage(WebDriver driver, int row, int cell1, int cell2, String sheetName) throws Exception {
		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(row, cell1, sheetName));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row, cell2, sheetName));
		driver.findElement(By.xpath("//*[@id='btnLogIn']")).click();
		Thread.sleep(5000);
		Log.info("LOGIN DONE");

	}

	public static void profile(WebDriver driver, int type) throws Exception {
		// click on the menu for selecting profile option
		driver.findElement(By.xpath("//*[@id='mm-menu-toggle']")).click();
		Thread.sleep(5000);
		Log.info("MENU CLICKED");

		// click on the profile option
		driver.findElement(By.xpath("//*[@id='btnProfile']/span[2]")).click();
		Thread.sleep(5000);
		Log.info("PROFILE OPTION SELECTED");
        Thread.sleep(2000);
		// click on the change security questions
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[1]/a")).click();
		Thread.sleep(5000);
		if (type == 1) {
			;
			// then click on the submit button ,So that the link will send to
			// the primary mail id
			driver.findElement(By
					.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[1]/form/div/input"))
					.click();
             Thread.sleep(2000);
			// check for the success message sent to the email
			if (driver.getPageSource().contains(Constant.SEQ1_SUCCESSMSG)) {
				Log.info("CHANGE SECURITY QUESTION UPDATE MESSAGE SENT TO THE PRIMARY EMAIL");
			} else {
				Log.error("CHANGE SECURITY QUESTION UPDATE MESSAGE NOT SENT TO THE PRIMARY EMAIL");
			}
			Thread.sleep(5000);
		} else if (type == 2) {
			Thread.sleep(2000);
			// click to select for the alternate email id
			driver.findElement(By
					.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[1]/form/p[2]/label"))
					.click();
			Thread.sleep(5000);
			// then click on the submit button ,So that the link will send to
			// the alternate mail id
			driver.findElement(By
					.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[1]/form/div/input"))
					.click();
			if (driver.getPageSource().contains(Constant.SEQ1_SCSMSG_TO_ALTERNATE)) {
				Log.info("SECURITY CHANGE MESSAGE HAS BEEN SENT TO THE ALTERNATE EMAIL ID");
			} else {
				Log.error("SECURITY CHANGE MESSAGE HAS NOT BEEN SENT TO THE ALTERNATE EMAIL ID");
			}
		}
	}

}
