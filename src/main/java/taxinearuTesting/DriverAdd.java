package taxinearuTesting;

import java.util.concurrent.TimeUnit;

import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.Function;
import Utils.Log;

public class DriverAdd {

	private WebDriver driver;
	boolean check = false;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.PARTNER_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test()
	public void testTaxinaru() throws Exception {

		// check for the title
		Assert.assertTrue(Constant.LOGIN_PARTNER_TITLE.contains(driver.getTitle()));
		Thread.sleep(5000);
		Log.info("LOGIN PAGE TITLE MATCHED");

		// login partner
		int row = 1;
		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME7));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME7));

		// click on the submit button
		driver.findElement(By.xpath("//html/body/div[1]/div/div[3]/form/div[7]/input")).click();
		Thread.sleep(5000);

		// click on the driver menu
		driver.findElement(By.xpath("//html/body/div[2]/ul/li[3]/a/i")).click();
		Thread.sleep(2000);

		// now click on the driver ,so that we can add the driver
		driver.findElement(By.id("driverDetailsTab")).click();
		Thread.sleep(2000);

		// click on the add driver button in the right hand side above corner
		driver.findElement(By.id("driverDetailsTableBtn")).click();
		Thread.sleep(2000);

		// click on the add button to check for the mandatory fields
		driver.findElement(By.id("driverDetailsBtn")).click();
		Thread.sleep(2000);

		// get the mandatory errors
		// first name error
		String error1 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[1]/div/label"))
				.getText();
		if (error1.contains(Constant.FIRST_NAME)) {
			Log.info("Enter first name,error is present");
		} else {
			Log.error("Enter first name,error is not present");
		}
		Thread.sleep(2000);

		// last name error
		String error2 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[3]/div/label"))
				.getText();
		if (error2.contains(Constant.LAST_NAME)) {
			Log.info("Enter last name,error is present");
		} else {
			Log.error("Enter last name,error is not present");
		}
		Thread.sleep(2000);

		// email address
		String error3 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[5]/div/label"))
				.getText();
		if (error3.contains(Constant.ENTER_EMAIL_ERROR)) {
			Log.info("Enter email address error is present");
		} else {
			Log.error("Enter emai address error is present");
		}
		Thread.sleep(2000);

		// contact number
		String error4 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[7]/div/label[2]"))
				.getText();
		if (error4.contains(Constant.P_CONTACT_ERROR)) {
			Log.info("Enter Uk contact number ,error is present");
		} else {
			Log.error("Enter Uk contact number error is not present");
		}

		Thread.sleep(2000);

		// password error
		String error5 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[10]/div/label"))
				.getText();
		if (error5.contains(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is present");
		} else {
			Log.error(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is not present");
		}

		Thread.sleep(2000);

		// vehicle registration error
		String error6 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[16]/div/label"))
				.getText();
		if (error6.contains(Constant.P_VEHICLE_REG_ERROR)) {
			Log.info("Enter vehicle registration ,error is present");
		} else {
			Log.error("Enter vehicle registration ,error is not present");
		}
		Thread.sleep(2000);

		// vehicle color
		String error7 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[18]/div/label"))
				.getText();
		if (error7.contains(Constant.P_VEHICLE_COLOR)) {
			Log.info("Enter valid vehicle error is present");
		} else {
			Log.error("Enter valid vehicle error is not present");
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------");

		// passing validation value 1
		Function.driverAdd(driver, 3);

		// get the errors
		// email error
		String error8 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[5]/div/label"))
				.getText();
		if (error8.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
			ExcelUtils.setCellData("PASS", 3, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter valid email address error is present");
			ExcelUtils.setCellData("FAIL", 3, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// contact number error
		String error9 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[7]/div/label[2]"))
				.getText();
		if (error9.contains(Constant.P_CONTACT_ERROR)) {
			Log.info("Enter valid UK contact number  error is present");
			ExcelUtils.setCellData("PASS", 3, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter valid UK contact number  error is not present");
			ExcelUtils.setCellData("FAIL", 3, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// password error
		String error10 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[10]/div/label"))
				.getText();
		if (error10.contains(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is present");
			ExcelUtils.setCellData("PASS", 3, 12, Constant.SHEET_NAME7);
		} else {
			Log.error(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is not present");
			ExcelUtils.setCellData("FAIL", 3, 12, Constant.SHEET_NAME7);
		}

		Thread.sleep(2000);

		// vehicle color
		String error11 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[18]/div/label"))
				.getText();
		if (error11.contains(Constant.P_VEHICLE_COLOR)) {
			Log.info("Enter valid vehicle error is present");
			ExcelUtils.setCellData("PASS", 3, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter valid vehicle error is not present");
			ExcelUtils.setCellData("FAIL", 3, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------");

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing validation value 2
		Function.driverAdd(driver, 4);

		// get the errors
		// firstname
		String error12 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[1]/div/label"))
				.getText();
		if (error12.contains(Constant.LENGTH_FIRSTNAME)) {
			Log.info("First name must be 2 to 20 characters long,error is present");
			ExcelUtils.setCellData("PASS", 4, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("First name must be 2 to 20 characters long,error is not present");
			ExcelUtils.setCellData("FAIL", 4, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// lastname
		String error13 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[3]/div/label"))
				.getText();
		if (error13.contains(Constant.LENGTH_LASTNAME)) {
			Log.info("Last name must be 2 to 20 characters long,error is present");
			ExcelUtils.setCellData("PASS", 4, 12, Constant.SHEET_NAME7);
		} else {
			Log.info("Last name must be 2 to 20 characters long,error is not present");
			ExcelUtils.setCellData("FAIL", 4, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// email error
		String error14 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[5]/div/label"))
				.getText();
		if (error14.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
			ExcelUtils.setCellData("PASS", 4, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter valid email address error is present");
			ExcelUtils.setCellData("FAIL", 4, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// contact number error
		String error15 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[7]/div/label[2]"))
				.getText();
		if (error15.contains(Constant.P_CONTACT_ERROR)) {
			Log.info("Enter valid UK contact number  error is present");
			ExcelUtils.setCellData("PASS", 4, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter valid UK contact number  error is not present");
			ExcelUtils.setCellData("FAIL", 4, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// password error
		String error16 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[10]/div/label"))
				.getText();
		if (error16.contains(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is present");
			ExcelUtils.setCellData("PASS", 4, 12, Constant.SHEET_NAME7);
		} else {
			Log.error(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is not present");
			ExcelUtils.setCellData("FAIL", 4, 12, Constant.SHEET_NAME7);
		}

		Thread.sleep(2000);

		// vehicle registration error
		String error17 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[16]/div/label"))
				.getText();
		if (error17.contains(Constant.P_VALID_REG_NO)) {
			Log.info("Vehical registration number should be 1 to 7 characters,error is present");
			ExcelUtils.setCellData("PASS", 4, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Vehical registration number should be 1 to 7 characters,error is not present");
			ExcelUtils.setCellData("FAIL", 4, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// vehicle color
		String error18 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[18]/div/label"))
				.getText();
		if (error18.contains(Constant.P_VEHICLE_COLOR)) {
			Log.info("Enter valid vehicle error is present");
			ExcelUtils.setCellData("PASS", 4, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter valid vehicle error is not present");
			ExcelUtils.setCellData("FAIL", 4, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------");

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing validation value 3
		Function.driverAdd(driver, 5);

		// get the errors

		// contact number error
		String error19 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[7]/div/label[2]"))
				.getText();
		if (error19.contains(Constant.P_CONTACT_ERROR)) {
			Log.info("Enter valid UK contact number  error is present");
			ExcelUtils.setCellData("PASS", 5, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter valid UK contact number  error is not present");
			ExcelUtils.setCellData("FAIL", 5, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// password error
		String error20 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[10]/div/label"))
				.getText();
		if (error20.contains(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is present");
			ExcelUtils.setCellData("PASS", 5, 12, Constant.SHEET_NAME7);
		} else {
			Log.error(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is not present");
			ExcelUtils.setCellData("FAIL", 5, 12, Constant.SHEET_NAME7);
		}

		Thread.sleep(2000);

		// vehicle color
		String error21 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[18]/div/label"))
				.getText();
		if (error21.contains(Constant.P_VEHICLE_COLOR)) {
			Log.info("Enter valid vehicle error is present");
			ExcelUtils.setCellData("PASS", 5, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter valid vehicle error is not present");
			ExcelUtils.setCellData("FAIL", 5, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------");

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing validation value 4
		Function.driverAdd(driver, 6);

		// get the errors
		// contact number error
		String error22 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[7]/div/label[2]"))
				.getText();
		if (error22.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("Please enter valid UK contact number.,error is present");
			ExcelUtils.setCellData("PASS", 6, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Please enter valid UK contact number.,error is not present");
			ExcelUtils.setCellData("FAIL", 6, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// password error
		String error23 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[10]/div/label"))
				.getText();
		if (error23.contains(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is present");
			ExcelUtils.setCellData("PASS", 6, 12, Constant.SHEET_NAME7);
		} else {
			Log.error(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is not present");
			ExcelUtils.setCellData("FAIL", 6, 12, Constant.SHEET_NAME7);
		}

		Thread.sleep(2000);

		Log.info("---------------------------------------------------");

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing validation value 5
		Function.driverAdd(driver, 7);

		// get the errors
		// first name error
		String error24 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[1]/div/label"))
				.getText();
		if (error24.contains(Constant.FIRST_NAME)) {
			Log.info("Enter first name,error is present");
			ExcelUtils.setCellData("PASS", 7, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter first name,error is not present");
			ExcelUtils.setCellData("FAIL", 7, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// last name error
		String error25 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[3]/div/label"))
				.getText();
		if (error25.contains(Constant.LAST_NAME)) {
			Log.info("Enter last name,error is present");
			ExcelUtils.setCellData("PASS", 7, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter last name,error is not present");
			ExcelUtils.setCellData("FAIL", 7, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// password error
		String error26 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[10]/div/label"))
				.getText();
		if (error26.contains(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is present");
			ExcelUtils.setCellData("PASS", 7, 12, Constant.SHEET_NAME7);
		} else {
			Log.error(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is not present");
			ExcelUtils.setCellData("FAIL", 7, 12, Constant.SHEET_NAME7);
		}

		Thread.sleep(2000);

		// vehicle color
		String error27 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[18]/div/label"))
				.getText();
		if (error27.contains(Constant.P_VEHICLE_COLOR)) {
			Log.info("Enter valid vehicle error is present");
			ExcelUtils.setCellData("PASS", 7, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter valid vehicle error is not present");
			ExcelUtils.setCellData("FAIL", 7, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------");

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing validation value 6
		Function.driverAdd(driver, 8);

		// get the errors
		// email error
		String error28 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[5]/div/label"))
				.getText();
		if (error28.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
			ExcelUtils.setCellData("PASS", 8, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Enter valid email address error is present");
			ExcelUtils.setCellData("FAIL", 8, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);
		// contact number error
		String error29 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[7]/div/label[2]"))
				.getText();
		if (error29.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("Please enter valid UK contact number.,error is present");
			ExcelUtils.setCellData("PASS", 8, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Please enter valid UK contact number.,error is not present");
			ExcelUtils.setCellData("FAIL", 8, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		// password error
		String error30 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[10]/div/label"))
				.getText();
		if (error30.contains(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is present");
			ExcelUtils.setCellData("PASS", 8, 12, Constant.SHEET_NAME7);
		} else {
			Log.error(
					"Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?),error is not present");
			ExcelUtils.setCellData("FAIL", 8, 12, Constant.SHEET_NAME7);
		}

		Thread.sleep(2000);

		Log.info("---------------------------------------------------");

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing validation value 7
		Function.driverAdd(driver, 9);
		Thread.sleep(1000);

		// get the errors
		if (driver.getPageSource().contains(Constant.OLD_EMAIL)) {
			Log.info("The email address you have entered already exists, please enter a new email.,error is present");
			ExcelUtils.setCellData("PASS", 9, 12, Constant.SHEET_NAME7);
		} else {
			Log.error(
					"The email address you have entered already exists, please enter a new email.,error is not present");
			ExcelUtils.setCellData("FAIL", 9, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------------");

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing validation value 8
		Function.driverAdd(driver, 10);
		Thread.sleep(1000);

		// get the errors
		if (driver.getPageSource().contains(Constant.OLD_EMAIL)) {
			Log.info("The email address you have entered already exists, please enter a new email.,error is present");
			ExcelUtils.setCellData("PASS", 10, 12, Constant.SHEET_NAME7);
		} else {
			Log.error(
					"The email address you have entered already exists, please enter a new email.,error is not present");
			ExcelUtils.setCellData("FAIL", 10, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------------");

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing validation value 9
		Function.driverAdd(driver, 11);
		Thread.sleep(1000);

		// get the errors
		if (driver.getPageSource().contains(Constant.P_VEHICLE_REG_ALREADY_EXIST_E)) {
			Log.info(
					"Vehicle with same registration number Exists.Please try with new registration number.,error is present");
			ExcelUtils.setCellData("PASS", 11, 12, Constant.SHEET_NAME7);
		} else {
			Log.error(
					"Vehicle with same registration number Exists.Please try with new registration number.,error is not present");
			ExcelUtils.setCellData("FAIL", 11, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(1000);

		Log.info("-----------------------------------------------------------");

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing validation value 10
		Function.driverAdd(driver, 12);
		Thread.sleep(1000);

		// get the errors
		if (driver.getPageSource().contains(Constant.OLD_EMAIL)) {
			Log.info("The email address you have entered already exists, please enter a new email.,error is present");
			ExcelUtils.setCellData("PASS", 12, 12, Constant.SHEET_NAME7);
		} else {
			Log.error(
					"The email address you have entered already exists, please enter a new email.,error is not present");
			ExcelUtils.setCellData("FAIL", 12, 12, Constant.SHEET_NAME7);
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------------");

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing validation value 11
		Function.driverAdd(driver, 13);
		Thread.sleep(2000);

		// get the errors
		if (driver.getPageSource().contains(Constant.P_DRIVER_NAME_EXIST)) {
			Log.info("Driver with same first name and last name already registered.,error is present");
			ExcelUtils.setCellData("PASS", 13, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Driver with same first name and last name already registered.,error is not present");
			ExcelUtils.setCellData("FAIL", 13, 12, Constant.SHEET_NAME7);
		}

		Thread.sleep(2000);

		Log.info("---------------------------------------------------------");

		// clearing fields
		// // firstname
		// driver.findElement(By.id("firstName")).clear();
		//
		// // lastname
		// driver.findElement(By.id("lastName")).clear();
		//
		// // email
		// driver.findElement(By.id("emailId")).clear();
		//
		// // contact number
		// driver.findElement(By.id("mobileNumber")).clear();
		//
		// // password
		// driver.findElement(By.id("password")).clear();
		//
		// // vehicle registration
		// driver.findElement(By.id("registrationNumber")).clear();
		//
		// // vehicle color
		// driver.findElement(By.id("color")).clear();
		//
		// Thread.sleep(2000);

		// passing confirm values
		// Function.driverAdd(driver, 14);
		// Thread.sleep(1000);
		// // editing values
		// if (driver.getPageSource().contains(Constant.DRIVER_UPDATED_SCS_MSG))
		// {
		// Log.info("Driver added successfully,message is present");
		// ExcelUtils.setCellData("PASS", 14, 12, Constant.SHEET_NAME7);
		// } else {
		// Log.error("Driver added successfully,message is not present");
		// ExcelUtils.setCellData("FAIL", 14, 12, Constant.SHEET_NAME7);
		// }
		// Thread.sleep(2000);

		// click on the cancel button,so that we can edit the values
		driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div[2]/form/div[20]/input[2]")).click();
		Thread.sleep(2000);

		// click on the edit button
		driver.findElement(
				By.xpath("//html/body/div[3]/div[3]/div/div[4]/div[2]/div/div[3]/div[2]/div/div[5]/div[9]/div/i"))
				.click();
		Thread.sleep(2000);

		// clearing fields
		// firstname
		driver.findElement(By.id("firstName")).clear();

		// lastname
		driver.findElement(By.id("lastName")).clear();

		// email
		driver.findElement(By.id("emailId")).clear();

		// contact number
		driver.findElement(By.id("mobileNumber")).clear();

		// password
		driver.findElement(By.id("password")).clear();

		// vehicle registration
		driver.findElement(By.id("registrationNumber")).clear();

		// vehicle color
		driver.findElement(By.id("color")).clear();

		Thread.sleep(2000);

		// passing values for editing
		Function.driverAdd(driver, 15);

		// get update success message
		if (driver.getPageSource().contains(Constant.DRIVER_EDIT_SCS_MSG)) {
			Log.info("Driver information updated successfully,message is present");
			ExcelUtils.setCellData("PASS", 15, 12, Constant.SHEET_NAME7);
		} else {
			Log.error("Driver information updated successfully,message is not present");
			ExcelUtils.setCellData("FAIL", 15, 12, Constant.SHEET_NAME7);
		}

		Thread.sleep(5000);

		Log.info("------------------------------------------------------------");

		// passing false to true
		check = true;

	}

	@AfterMethod
	public void sendingReports() throws Exception {
		Log.info("AFTER METHOD");
		Function.sendingReports(driver, check);
	}

	// @AfterTest
	// public void closeBrowser() {
	// driver.quit();
	// }

}
