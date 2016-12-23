package Utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	public static void dropDown(WebDriver driver, int row, int cellno, String sheetName) throws Exception {
		List<WebElement> elementList = driver.findElements(By.tagName("option"));
		System.out.println(elementList.size());
		String str = ExcelUtils.getCellData(row, cellno, sheetName);
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
		Thread.sleep(2000);
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
		Thread.sleep(5000);
		// click on the change security questions
		driver.findElement(By.xpath("//*[@id='changeSecurity']")).click();
		Thread.sleep(1000);
		if (type == 1) {

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

			// click to select for the alternate email id
			driver.findElement(By
					.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[1]/form/p[2]/label"))
					.click();
			Thread.sleep(2000);
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

	public static void changeEmail(WebDriver driver, int row, int cell1, int cell2, int type) throws Exception {

		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row, cell1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row, cell2, Constant.SHEET_NAME1));

		// using the tab so that it will go to the confirm button for click
		driver.findElement(By.id("confEmail")).sendKeys(Keys.TAB);

		// using enter command ,so it should be clickable
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		// check for the errors present
		if (type == Constant.VALID_EMAIL_ERROR) {
			String error = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]")).getText();
			if (error.contains(Constant.CHECK_EMAIL_ERROR)) {
				Log.info("ENTER VALID EMAIL ADDRESS PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME1);
			} else {
				Log.error("ENTER VALID EMAIL ADDRESS NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME1);
			}

			String confirmEmailError2 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]"))
					.getText();
			if (confirmEmailError2.contains(Constant.CHECK_EMAIL_ERROR1)) {
				Log.info("ENTER CONFIRM EMAIL ERROR PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME1);
			} else {
				Log.error("ENTER CONFIRM EMAIL ERROR IS NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME1);
			}

		} else if (type == Constant.MISMATCH_ERROR) {

			// check for the errors present
			String emailMismatchError = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label"))
					.getText();
			if (emailMismatchError.contains(Constant.EMAIL_MISMATCH_ERROR)) {
				Log.info("EMAIL AND CONFIRM EMAIL SHOULD BE SAME ERROR PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME1);
			}

			else {

				Log.error("EMAIL AND CONFIRM EMAIL SHOULD BE SAME ERROR PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME1);
			}

		} else if (type == Constant.EXIST_EMAIL_ERR) {

			if (driver.getPageSource().contains(Constant.EMAIL_EXIST_ERROR))

			{
				Log.info("EMAIL ALREAY EXIST ERROR PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME1);
			} else {
				Log.error("EMAIL ALREADY EXIST ERROR NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME1);
			}
		} else if (type == Constant.EMAIL_AND_AEMAIL_NTSM) {
			if (driver.getPageSource().contains(Constant.EMAIL_AND_ALTEMAIL_NOTSAME)) {
				Log.info("EMAIL AND ALTERNATE EMAIL CANNOT BE SAME ERROR IS PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME1);
			} else {

				Log.error("EMAIL AND ALTERNATE EMAIL CANNOT BE SAME ERROR IS NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME1);
			}
		}

		else if (type == Constant.EMAIL_SCSMSG) {

			if (driver.getPageSource().contains(Constant.EMAIL_CHANGESCSMSG))

			{
				Log.info("EMAIL UPDATE SUCCESS MESSAGE PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME1);
			} else {
				Log.error("EMAIL UPDATE SUCCESS MESSAGE NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME1);
			}

		}
	}

	public static void changePasswordAlternate(WebDriver driver, int row, int cell1, int cell2, int type)
			throws Exception {
		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row, cell1, Constant.SHEET_NAME));
		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row, cell2, Constant.SHEET_NAME));

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();
		Thread.sleep(2000);
		if (type == Constant.CHANGEPWD_ERRORMSG_BYALTERNATE) {

			if (driver.getPageSource().contains(Constant.CHANGEPASSWORDE_MSG)) {
				Log.info("PASS");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME);
			} else {
				Log.error("FAIL");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME);
			}
		} else if (type == Constant.PASSWORD_MISMATCHE) {

			if (driver.getPageSource().contains(Constant.PASSWORD_MISMATCH_ERROR)) {
				Log.info("PASS");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME);
			} else {
				Log.error("FAIL");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME);
			}
		} else if (type == Constant.PWD_UPDATE_MSG) {
			if (driver.getPageSource().contains(Constant.PASSWORD_CHANGED_SUCCESSMSG)) {
				Log.info("PASS");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME);
			} else {
				Log.error("FAIL");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME);
			}
		}
	}

	public static void changeAlternateEmail(WebDriver driver, int row, int cell1, int cell2, int type, String sheetName)
			throws Exception {
		driver.findElement(By.id("alternate")).sendKeys(ExcelUtils.getCellData(row, cell1, sheetName));
		driver.findElement(By.id("confAltEmail")).sendKeys(ExcelUtils.getCellData(row, cell2, sheetName));
		driver.findElement(By.id("confAltEmail")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		if (type == Constant.VALID_EMAIL_ERROR) {

			String alternateEmailError = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]"))
					.getText();
			if (alternateEmailError.contains(Constant.CHECK_EMAIL_ERROR)) {
				Log.info("ENTER VALID EMAIL ADDRESS ERROR PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME3);
			}

			else {
				Log.error("ENTER VALID EMAIL ADDRESS ERROR IS NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME3);

			}

			String confirmAlternateEmailError = driver
					.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]")).getText();

			if (confirmAlternateEmailError.contains(Constant.CHECK_EMAIL_ERROR1)) {
				Log.info("ENTER CONFIRM VALID EMAIL ADDRESS ERROR PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME3);
			}

			else {
				Log.error("ENTER CONFIRM VALID EMAIL ADDRESS ERROR IS NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME3);

			}
		} else if (type == Constant.MISMATCH_ERROR) {
			String emailNotSameError = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label"))
					.getText();
			if (emailNotSameError.contains(Constant.EMAIL_MISMATCH_ERROR)) {
				Log.info("NEW AND CONFIRM EMAIL SHOULD BE SAME ERROR PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME3);
			} else {
				Log.error("NEW AND CONFIRM EMAIL SHOULD BE SAME ERROR IS NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME3);
			}
		} else if (type == Constant.ALTERNATE_EMAIL_NOTSAMERROR) {

			if (driver.getPageSource().contains(Constant.CHANGE_ALTERNATE_EMAILERROR)) {
				Log.info("EMAIL AND ALTERNATE EMAIL SHOULD NOT BE PRESENT ERROR IS PRESENT ");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME3);
			} else {
				Log.info("EMAIL AND ALTERNATE EMAIL SHOULD NOT BE PRESENT ERROR IS NOT PRESENT ");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME3);
			}
		} else if (type == Constant.SCS_MSG_ALTERNATE) {

			if (driver.getPageSource().contains(Constant.ALTERNATE_EMAIL_UPDATESCSMSG)) {
				Log.info("PASS");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME3);
			} else {
				Log.info("FAIL");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME3);
			}
		}

	}

	public static void changeAlternateBySecurity(WebDriver driver, int row, int cell1, int cell2, int type)
			throws Exception

	{
		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(row, cell1, Constant.SHEET_NAME3));
		driver.findElement(By.id("txtConfirmEmailId"))
				.sendKeys(ExcelUtils.getCellData(row, cell2, Constant.SHEET_NAME3));

		Thread.sleep(5000);
		// click on the submit button
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/form[2]/div/div/div[4]/input")).click();

		if (type == Constant.VALID_EMAIL_BYSECURITY_ERRROR) {
			String checkError = driver
					.findElement(By
							.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/form[2]/div/div/div[2]/div[2]/label"))
					.getText();
			if (checkError.contains(Constant.CHECK_EMAIL_ERROR)) {
				Log.info("ENTER VALID EMAIL ADDRESS ERROR PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME3);

			} else {
				Log.info("ENTER VALID EMAIL ADDRESS ERROR IS NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME3);
			}
		} else if (type == Constant.ALTERNATE_EMAIL_NOTSAME_BYSECURITY) {
			String checkError1 = driver
					.findElement(By
							.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/form[2]/div/div/div[3]/div[2]/label"))
					.getText();
			if (checkError1.contains(Constant.EMAIL_MISMATCH_CHECK)) {
				Log.info("EMAIL AND CONFIRM EMAIL ADDRESS ERROR IS PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME3);
			} else {
				Log.info("EMAIL AND CONFIRM EMAIL ADDRESS ERROR IS NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME3);
			}

		} else if (type == Constant.MISMATCH_BYSECURITY_ERROR) {
			if (driver.getPageSource().contains(Constant.ALTERNATE_EMAIL_UPDATERROR)) {
				Log.info("PRIMARY AND ALTERNATE EMAIL SHOULD NOT BE SAME ERROR PRESENT");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME3);

			} else {
				Log.error("PRIMARY AND ALTERNATE EMAIL SHOULD NOT BE SAME ERROR IS NOT PRESENT");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME3);
			}
		}

		else if (type == Constant.SCS_MSG_BY_SECURITY) {

			if (driver.getPageSource().contains(Constant.ALTERNATE_EMAIL_SCSMSG)) {
				Log.info("ALTERNATIVE EMAIL UPDATE SUCCESSFULLY");
				ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME3);
			} else {
				Log.error("ALTERNATIVE EMAIL NOT UPDATED SUCCESSFULLY");
				ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME3);
			}
		}

	}

	public static void signUp(WebDriver driver, int row) throws Exception {

		// passing value for firstName
		driver.findElement(By.id("firstName")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME4));
		// passing value for second name
		driver.findElement(By.id("lastName")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME4));
		// passing value for contact number
		driver.findElement(By.id("contactNo")).sendKeys(ExcelUtils.getCellData(row, 3, Constant.SHEET_NAME4));
		// passing value for email address
		driver.findElement(By.id("emailId")).sendKeys(ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME4));
		// passing value for password
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row, 5, Constant.SHEET_NAME4));
		// passing value for con pass
		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row, 6, Constant.SHEET_NAME4));
		// passing value for alternate email
		driver.findElement(By.id("altEmailId")).sendKeys(ExcelUtils.getCellData(row, 7, Constant.SHEET_NAME4));
		// selecting security question
		Function.dropDown(driver, row, 8, Constant.SHEET_NAME4);

		// passing value for security question 1
		driver.findElement(By.id("ans1")).sendKeys(ExcelUtils.getCellData(row, 9, Constant.SHEET_NAME4));

		// selecting security question 2
		Function.dropDown(driver, row, 10, Constant.SHEET_NAME4);

		// passing value for security question 2
		driver.findElement(By.id("ans2")).sendKeys(ExcelUtils.getCellData(row, 11, Constant.SHEET_NAME4));

		// click on the check box
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[11]/div/div/input")).click();

		Thread.sleep(2000);

		// click on the submit button ,so that we can check the errors
		driver.findElement(By.id("btnUsrSignUp")).click();

	}

	public static void becomeAPartner(WebDriver driver, int row) throws Exception {

		// first name
		driver.findElement(By.id("contactPersonFName")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME5));
		// last name
		driver.findElement(By.id("contactPersonLName")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME5));

		// contact number
		driver.findElement(By.id("contactNo")).sendKeys(ExcelUtils.getCellData(row, 3, Constant.SHEET_NAME5));

		// email address
		driver.findElement(By.id("emailId")).sendKeys(ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME5));

		// company name
		driver.findElement(By.id("partnerName")).sendKeys(ExcelUtils.getCellData(row, 5, Constant.SHEET_NAME5));

		// area
		driver.findElement(By.id("area")).sendKeys(ExcelUtils.getCellData(row, 6, Constant.SHEET_NAME5));

		// address
		driver.findElement(By.id("address")).sendKeys(ExcelUtils.getCellData(row, 7, Constant.SHEET_NAME5));

		// office email
		driver.findElement(By.id("contactPersonEmailId"))
				.sendKeys(ExcelUtils.getCellData(row, 8, Constant.SHEET_NAME5));

		// office contact number
		driver.findElement(By.id("contactPersonMobileNo"))
				.sendKeys(ExcelUtils.getCellData(row, 9, Constant.SHEET_NAME5));

		// city
		driver.findElement(By.id("locality")).sendKeys(ExcelUtils.getCellData(row, 10, Constant.SHEET_NAME5));

		// dispatch location
		driver.findElement(By.id("dispatchSystem")).sendKeys(ExcelUtils.getCellData(row, 11, Constant.SHEET_NAME5));

		// postal code
		driver.findElement(By.id("postal_code")).sendKeys(ExcelUtils.getCellData(row, 12, Constant.SHEET_NAME5));

		// uploading file
		driver.findElement(By.id("contactPersonLogo")).sendKeys(ExcelUtils.getCellData(row, 13, Constant.SHEET_NAME5));

		Thread.sleep(2000);
		// click on the submit button
		driver.findElement(By.id("savePartner")).click();

	}

	public static void adminBecomeAP(WebDriver driver, int row) throws Exception {

		driver.findElement(By.id("partnerName")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME5));

		driver.findElement(By.id("contactNo")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME5));

		driver.findElement(By.id("emailId")).sendKeys(ExcelUtils.getCellData(row, 3, Constant.SHEET_NAME5));

		driver.findElement(By.id("address")).sendKeys(ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME5));

		driver.findElement(By.id("address2")).sendKeys(ExcelUtils.getCellData(row, 5, Constant.SHEET_NAME5));

		driver.findElement(By.id("area")).sendKeys(ExcelUtils.getCellData(row, 6, Constant.SHEET_NAME5));

		driver.findElement(By.id("locality")).sendKeys(ExcelUtils.getCellData(row, 7, Constant.SHEET_NAME5));

		driver.findElement(By.id("postal_code")).sendKeys(ExcelUtils.getCellData(row, 8, Constant.SHEET_NAME5));

		driver.findElement(By.id("dispatchSystem")).sendKeys(ExcelUtils.getCellData(row, 9, Constant.SHEET_NAME5));

		driver.findElement(By.id("contactPersonName")).sendKeys(ExcelUtils.getCellData(row, 10, Constant.SHEET_NAME5));

		driver.findElement(By.id("contactPersonEmailId"))
				.sendKeys(ExcelUtils.getCellData(row, 11, Constant.SHEET_NAME5));

		driver.findElement(By.id("contactPersonMobileNo"))
				.sendKeys(ExcelUtils.getCellData(row, 12, Constant.SHEET_NAME5));

		driver.findElement(By.id("contactPersonLogo")).sendKeys(ExcelUtils.getCellData(row, 13, Constant.SHEET_NAME5));
		Thread.sleep(5000);

		driver.findElement(By.id("savePartner")).click();

	}

	public static void vehicleAdd(WebDriver driver, int row) throws Exception {
		driver.findElement(By.id("vehicleType")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME5));

		driver.findElement(By.id("maxPeopleAllowed")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME5));

		driver.findElement(By.id("minRate")).sendKeys(ExcelUtils.getCellData(row, 3, Constant.SHEET_NAME5));

		driver.findElement(By.id("maxRate")).sendKeys(ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME5));

		// click on the save button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='saveTaxiType']")).click();

	}

	public static void EventBooking(WebDriver driver, int row) throws Exception {
		// firstname
		driver.findElement(By.id("firstname")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME2));

		// lastname
		driver.findElement(By.id("lastname")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME2));

		// event date
		driver.findElement(By.id("eventdate")).click();
		Thread.sleep(2000);
		List<WebElement> element = driver.findElements(By.tagName("td"));
		String getFExcel = ExcelUtils.getCellData(row, 3, Constant.SHEET_NAME2);
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().contains(getFExcel)) {
				WebElement elementClick = element.get(i);
				Thread.sleep(2000);
				elementClick.click();
				Thread.sleep(2000);
				break;
			}

		}

		driver.findElement(By.id("eventdate")).sendKeys(Keys.TAB);

		// // for selecting radio button
		// driver.findElement(By.id("rdoReturn")).click();
		// Thread.sleep(2000);

		// pickup area
		driver.findElement(By.id("pickuparea")).sendKeys(ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME2));

		// drop area
		driver.findElement(By.id("droparea")).sendKeys(ExcelUtils.getCellData(row, 5, Constant.SHEET_NAME2));

		// people
		Function.dropDown(driver, row, 6, Constant.SHEET_NAME2);

		// contact number
		driver.findElement(By.id("phoneno")).sendKeys(ExcelUtils.getCellData(row, 7, Constant.SHEET_NAME2));

		// email address
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row, 8, Constant.SHEET_NAME2));

		// luggage
		Function.dropDown(driver, row, 9, Constant.SHEET_NAME2);

		// click on the submit
		driver.findElement(By.xpath("//*[@id='saveEventBooking']")).click();
		Thread.sleep(2000);

	}

	public static void contactUs(WebDriver driver, int row) throws Exception {
		// name
		driver.findElement(By.id("name")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME2));

		// contact no
		driver.findElement(By.id("mobileNo")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME2));

		// email
		driver.findElement(By.id("emailId")).sendKeys(ExcelUtils.getCellData(row, 3, Constant.SHEET_NAME2));

		// subject
		driver.findElement(By.id("subject")).sendKeys(ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME2));

		// message
		driver.findElement(By.id("message")).sendKeys(ExcelUtils.getCellData(row, 5, Constant.SHEET_NAME2));

		// click on send
		driver.findElement(By.id("sendContactInfo")).click();
		Thread.sleep(2000);

	}

	public static void bookTaxi(WebDriver driver, int row) throws Exception {

		// pick up

		WebElement element = driver.findElement(By.id("areafrom_0"));
		element.sendKeys("we");

		WebElement name = driver.findElement(By.className("pac-item"));
		List<WebElement> storeTag = name.findElements(By.tagName("span"));
		String str = ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME6);
		for (int i = 0; i < storeTag.size(); i++) {
			if (storeTag.get(i).getText().equalsIgnoreCase(str)) {
				System.out.println(storeTag.get(i).getText());
				storeTag.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}

		Thread.sleep(5000);
		driver.findElement(By.id("areafrom_0")).sendKeys(Keys.TAB);

		// drop
		try {
			WebElement element1 = driver.findElement(By.id("areato_0"));
			element1.sendKeys("harl");

			WebElement name1 = driver.findElement(By.className("pac-item"));
			List<WebElement> storeTag1 = name1.findElements(By.tagName("span"));
			String str1 = ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME6);
			for (int i = 0; i < storeTag1.size(); i++) {
				if (storeTag1.get(i).getText().equalsIgnoreCase(str1)) {
					System.out.println(storeTag1.get(i).getText());
					Thread.sleep(2000);
					storeTag1.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

		Thread.sleep(5000);

		// click on the plus button for adding more area
		driver.findElement(By.id("addMoreArea")).click();
		Thread.sleep(2000);

		// via
		try {
			WebElement element2 = driver.findElement(By.id("areato_1"));
			element2.sendKeys("br");

			WebElement name2 = driver.findElement(By.className("pac-item"));
			List<WebElement> storeTag2 = name2.findElements(By.tagName("span"));
			String str2 = ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME6);
			for (int i = 0; i < storeTag2.size(); i++) {
				if (storeTag2.get(i).getText().equalsIgnoreCase(str2)) {
					System.out.println(storeTag2.get(i).getText());
					Thread.sleep(5000);
					storeTag2.get(i).click();
					Thread.sleep(2000);
					break;
				}

			}
		} catch (Exception e) {
			e.getMessage();
		}

		Thread.sleep(5000);

		// click on now
		driver.findElement(By.id("now")).click();
		Thread.sleep(2000);

		// select the luggage
		Function.dropDown(driver, row, 5, Constant.SHEET_NAME6);

		// select the people
		Function.dropDown(driver, row, 6, Constant.SHEET_NAME6);

		// click on the search
		driver.findElement(By.id("searchPartnerTaxi")).click();
		Thread.sleep(1000);

	}

}
