package taxinearuTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.Function;
import Utils.Log;
import org.testng.Assert;

public class BecomeAPartnerFAdmin {

	private WebDriver driver;
	boolean check = false;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ExcelUtils.getTableArray(Constant.FILE_FULL_PATH,
		// Constant.SHEET_NAME3);

	}

	@Test()
	public void testTaxinaru() throws Exception {

		// check for the page title
		Assert.assertTrue(Constant.LOGIN_TITLE.contains(driver.getTitle()));
		Thread.sleep(5000);
		Log.info("TITLE IS MATCHED");

		// login page validations
		// click on the click button ,so that we can check for the error
		// click on the login button
		driver.findElement(By.id("loginbtn")).click();
		Thread.sleep(1000);

		// get the error
		if (driver.getPageSource().contains(Constant.LOGIN_ADMIN_CHECK)) {
			Log.info("Provide username and password error is present");
		} else {
			Log.error("Provide username and password error is not present");
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		int row = 14;
		// admin login
		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME8));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME8));

		// click on the login button
		driver.findElement(By.id("loginbtn")).click();
		Thread.sleep(2000);

		Log.info("--------------------------------------------");

		// click on the company management menu
		driver.findElement(By.xpath("//html/body/div[2]/ul/li[2]/a/i")).click();
		Thread.sleep(2000);

		// click on company management now
		driver.findElement(By.id("partnerManagementTab")).click();
		Thread.sleep(2000);

		// click on add partner now
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div/div[2]/a")).click();
		Thread.sleep(2000);

		// click on save partner now,to check for the mandatory fields
		driver.findElement(By.id("savePartner")).click();
		Thread.sleep(2000);

		// get the errors
		// company name
		String checkError = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[1]/div/label"))
				.getText();
		if (checkError.contains(Constant.ADMIN_PARTNER_C_NAME)) {
			Log.info("Enter Company Name error is present");
		} else {
			Log.error("Enter Company Name error is not present");
		}
		Thread.sleep(2000);

		// contact number
		String checkError1 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[3]/div/label[2]"))
				.getText();
		if (checkError1.contains(Constant.CHECK_CONTACT_NOERR)) {
			Log.info("Enter contact number error is present");
		} else {
			Log.error("Enter contact number error is not present");
		}
		Thread.sleep(2000);

		// email address
		String checkError2 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[5]/div/label"))
				.getText();
		if (driver.getPageSource().contains(Constant.ENTER_EMAIL_ERROR)) {
			Log.info("Enter email address error is present");
		} else {
			Log.error("Enter email address error is not present");
		}
		Thread.sleep(2000);

		// address
		String checkError3 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[7]/div/label"))
				.getText();
		if (driver.getPageSource().contains(Constant.ADMIN_P_ADRS)) {
			Log.info("Enter Address error is present");
		} else {
			Log.error("Enter Address error is not present");
		}
		Thread.sleep(2000);

		// area
		String checkError4 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[10]/div/label"))
				.getText();
		if (driver.getPageSource().contains(Constant.ADMIN_P_AREA)) {
			Log.info("Enter Area error is present");
		} else {
			Log.error("Enter Area error is not present");
		}
		Thread.sleep(2000);

		// city
		String checkError5 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[12]/div/label"))
				.getText();
		if (driver.getPageSource().contains(Constant.ADMIN_P_CITY)) {
			Log.info("Enter city error is present");
		} else {
			Log.error("Enter city error is not present");
		}
		Thread.sleep(2000);

		// postal code
		String checkError6 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[13]/div/label"))
				.getText();
		if (driver.getPageSource().contains(Constant.ADMIN_POSTAL_CODE)) {
			Log.info("Enter postal code error is present");

		} else {
			Log.error("Enter postal code error is not present");
		}
		Thread.sleep(2000);

		// dispatch system
		String checkError7 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[16]/div/label"))
				.getText();
		if (driver.getPageSource().contains(Constant.DISPATCH_L_NAME)) {
			Log.info("Enter dispatch system error is present");
		} else {
			Log.error("Enter dispatch system error is not present");
		}
		Thread.sleep(2000);

		// contact person name error
		String checkError8 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[18]/div/label"))
				.getText();
		if (driver.getPageSource().contains(Constant.CONTACT_P_NAME)) {
			Log.info("Enter contact person name error is present");
		} else {
			Log.error("Enter contact person name error is not present");
		}
		Thread.sleep(2000);

		// contact person email address
		String checkError9 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[19]/div/label"))
				.getText();
		if (driver.getPageSource().contains(Constant.CONTACT_P_EMAIL_A)) {
			Log.info("Enter contact person email address is present");
		} else {
			Log.error("Enter contact person email address is not present");
		}
		Thread.sleep(2000);

		// contact person mobile number
		String checkError10 = driver
				.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[21]/div/label[2]")).getText();
		if (checkError10.contains(Constant.CONTACT_P_MOBILE_NUMBER)) {
			Log.info("Enter contact person mobile number is present");
		} else {
			Log.error("Enter contact person mobile number is not present");
		}
		Thread.sleep(2000);
		Log.info("------------------------------------------------------");

		// passing validation values 1
		Function.adminBecomeAP(driver, 16);

		// get the errors

		// for partner name
		String getErrors = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[1]/div/label"))
				.getText();
		if (getErrors.contains(Constant.PARTNER_NAME_ERROR_ADMIN)) {
			Log.info("Partner name must be between 5 to 20 digits long,error is present");
			ExcelUtils.setCellData("PASS", 16, 14, Constant.SHEET_NAME8);

		} else {
			Log.info("Partner name must be between 5 to 20 digits long,error is not present");
			ExcelUtils.setCellData("FAIL", 16, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// for valid email address
		String getError1 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[5]/div/label"))
				.getText();
		if (getError1.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
			ExcelUtils.setCellData("PASS", 16, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter valid email address error is not present");
			ExcelUtils.setCellData("FAIL", 16, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// for contact mobile number
		String getError2 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[21]/div/label[2]"))
				.getText();
		if (getError2.contains(Constant.CONTACT_P_MOBILE_NUMBER)) {
			Log.info("Enter contact person mobile number is present");
		} else {
			Log.error("Enter contact person mobile number is not present");
		}
		Thread.sleep(2000);

		// contact person name error
		String getError3 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[18]/div/label"))
				.getText();
		if (getError3.contains(Constant.NAME_ERROR)) {
			Log.info("Name must be between 5-20 digits long ,error is present");
			ExcelUtils.setCellData("PASS", 16, 14, Constant.SHEET_NAME8);
		} else {
			Log.info("Name must be between 5-20 digits long ,error is not present");
			ExcelUtils.setCellData("FAIL", 16, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);
		Log.info("-----------------------------------------------");

		// clearing fields
		driver.findElement(By.id("partnerName")).clear();

		driver.findElement(By.id("contactNo")).clear();

		driver.findElement(By.id("emailId")).clear();

		driver.findElement(By.id("address")).clear();

		driver.findElement(By.id("address2")).clear();

		driver.findElement(By.id("area")).clear();

		driver.findElement(By.id("locality")).clear();

		driver.findElement(By.id("postal_code")).clear();

		driver.findElement(By.id("dispatchSystem")).clear();

		driver.findElement(By.id("contactPersonName")).clear();

		driver.findElement(By.id("contactPersonEmailId")).clear();

		driver.findElement(By.id("contactPersonMobileNo")).clear();

		Thread.sleep(2000);

		// passing validation value 2
		Function.adminBecomeAP(driver, 17);

		// get the errors
		// for valid email address
		String getErr = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[5]/div/label"))
				.getText();
		if (getErr.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
			ExcelUtils.setCellData("PASS", 17, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter valid email address error is not present");
			ExcelUtils.setCellData("FAIL", 17, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// for mobile number
		String getErr1 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[21]/div/label[2]"))
				.getText();
		if (getErr1.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("Please enter valid UK contact number error is present");
			ExcelUtils.setCellData("PASS", 17, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Please enter valid UK contact number error is not present");
			ExcelUtils.setCellData("FAIL", 17, 14, Constant.SHEET_NAME8);

		}
		Thread.sleep(2000);
		Log.info("----------------------------------------------------");

		// clearing fields
		driver.findElement(By.id("partnerName")).clear();

		driver.findElement(By.id("contactNo")).clear();

		driver.findElement(By.id("emailId")).clear();

		driver.findElement(By.id("address")).clear();

		driver.findElement(By.id("address2")).clear();

		driver.findElement(By.id("area")).clear();

		driver.findElement(By.id("locality")).clear();

		driver.findElement(By.id("postal_code")).clear();

		driver.findElement(By.id("dispatchSystem")).clear();

		driver.findElement(By.id("contactPersonName")).clear();

		driver.findElement(By.id("contactPersonEmailId")).clear();

		driver.findElement(By.id("contactPersonMobileNo")).clear();

		Thread.sleep(2000);

		// passing validation value 3
		Function.adminBecomeAP(driver, 18);

		// get the errors
		// for valid email address
		String getErr2 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[5]/div/label"))
				.getText();
		if (getErr2.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
			ExcelUtils.setCellData("PASS", 18, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter valid email address error is not present");
			ExcelUtils.setCellData("FAIL", 18, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// for mobile number
		String getErr3 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[21]/div/label[2]"))
				.getText();
		if (getErr3.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("Please enter valid UK contact number error is present");
			ExcelUtils.setCellData("PASS", 18, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Please enter valid UK contact number error is not present");
			ExcelUtils.setCellData("FAIL", 18, 14, Constant.SHEET_NAME8);

		}
		Thread.sleep(2000);
		Log.info("--------------------------------------------------");

		// clearing fields
		driver.findElement(By.id("partnerName")).clear();

		driver.findElement(By.id("contactNo")).clear();

		driver.findElement(By.id("emailId")).clear();

		driver.findElement(By.id("address")).clear();

		driver.findElement(By.id("address2")).clear();

		driver.findElement(By.id("area")).clear();

		driver.findElement(By.id("locality")).clear();

		driver.findElement(By.id("postal_code")).clear();

		driver.findElement(By.id("dispatchSystem")).clear();

		driver.findElement(By.id("contactPersonName")).clear();

		driver.findElement(By.id("contactPersonEmailId")).clear();

		driver.findElement(By.id("contactPersonMobileNo")).clear();

		Thread.sleep(2000);

		// passing validation value 4
		Function.adminBecomeAP(driver, 19);

		// get errors

		// for valid email address
		String getErr4 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[5]/div/label"))
				.getText();
		if (getErr4.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
			ExcelUtils.setCellData("PASS", 19, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter valid email address error is not present");
			ExcelUtils.setCellData("FAIL", 19, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// for mobile number
		String getErr5 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[21]/div/label[2]"))
				.getText();
		if (getErr5.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("Please enter valid UK contact number error is present");
			ExcelUtils.setCellData("PASS", 19, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Please enter valid UK contact number error is not present");
			ExcelUtils.setCellData("FAIL", 19, 14, Constant.SHEET_NAME8);

		}
		Thread.sleep(2000);
		Log.info("------------------------------------------------");

		// clearing fields
		driver.findElement(By.id("partnerName")).clear();

		driver.findElement(By.id("contactNo")).clear();

		driver.findElement(By.id("emailId")).clear();

		driver.findElement(By.id("address")).clear();

		driver.findElement(By.id("address2")).clear();

		driver.findElement(By.id("area")).clear();

		driver.findElement(By.id("locality")).clear();

		driver.findElement(By.id("postal_code")).clear();

		driver.findElement(By.id("dispatchSystem")).clear();

		driver.findElement(By.id("contactPersonName")).clear();

		driver.findElement(By.id("contactPersonEmailId")).clear();

		driver.findElement(By.id("contactPersonMobileNo")).clear();

		Thread.sleep(2000);

		// passing validation value 5
		Function.adminBecomeAP(driver, 20);

		// get the errors
		// company name
		String checkEr = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[1]/div/label"))
				.getText();
		if (checkEr.contains(Constant.ADMIN_PARTNER_C_NAME)) {
			Log.info("Enter Company Name error is present");
			ExcelUtils.setCellData("PASS", 20, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter Company Name error is not present");
			ExcelUtils.setCellData("FAIL", 20, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// contact number
		String checkEr1 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[3]/div/label[2]"))
				.getText();
		if (checkEr1.contains(Constant.CHECK_CONTACT_NOERR)) {
			Log.info("Enter contact number error is present");
			ExcelUtils.setCellData("PASS", 20, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter contact number error is not present");
			ExcelUtils.setCellData("FAIL", 20, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// for valid email address
		String getErr7 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[5]/div/label"))
				.getText();
		if (getErr7.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
			ExcelUtils.setCellData("PASS", 20, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter valid email address error is not present");
			ExcelUtils.setCellData("FAIL", 20, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// contact person name error
		String checkEr8 = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[18]/div/label"))
				.getText();
		if (driver.getPageSource().contains(Constant.CONTACT_P_NAME)) {
			Log.info("Enter contact person name error is present");
			ExcelUtils.setCellData("PASS", 20, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter contact person name error is not present");
			ExcelUtils.setCellData("FAIL", 20, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// for contact mobile number
		String getEr = driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[21]/div/label[2]"))
				.getText();
		if (getEr.contains(Constant.CONTACT_P_MOBILE_NUMBER)) {
			Log.info("Enter contact person mobile number is present");
			ExcelUtils.setCellData("PASS", 20, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter contact person mobile number is not present");
			ExcelUtils.setCellData("FAIL", 20, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);
		Log.info("---------------------------------------------------");

		// clearing fields
		driver.findElement(By.id("partnerName")).clear();

		driver.findElement(By.id("contactNo")).clear();

		driver.findElement(By.id("emailId")).clear();

		driver.findElement(By.id("address")).clear();

		driver.findElement(By.id("address2")).clear();

		driver.findElement(By.id("area")).clear();

		driver.findElement(By.id("locality")).clear();

		driver.findElement(By.id("postal_code")).clear();

		driver.findElement(By.id("dispatchSystem")).clear();

		driver.findElement(By.id("contactPersonName")).clear();

		driver.findElement(By.id("contactPersonEmailId")).clear();

		driver.findElement(By.id("contactPersonMobileNo")).clear();

		Thread.sleep(2000);

		// passing validation value 6
		Function.adminBecomeAP(driver, 21);
		Thread.sleep(1000);

		// get Errors
		if (driver.getPageSource().contains(Constant.EMAIL_ADMIN_EXIST_E)) {
			Log.info("Email address already registered error is present");
			ExcelUtils.setCellData("PASS", 21, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Email address already registered error is not present");
			ExcelUtils.setCellData("FAIL", 21, 14, Constant.SHEET_NAME8);

		}
		Thread.sleep(2000);
		Log.info("---------------------------------------------------");

		// clearing fields
		driver.findElement(By.id("partnerName")).clear();

		driver.findElement(By.id("contactNo")).clear();

		driver.findElement(By.id("emailId")).clear();

		driver.findElement(By.id("address")).clear();

		driver.findElement(By.id("address2")).clear();

		driver.findElement(By.id("area")).clear();

		driver.findElement(By.id("locality")).clear();

		driver.findElement(By.id("postal_code")).clear();

		driver.findElement(By.id("dispatchSystem")).clear();

		driver.findElement(By.id("contactPersonName")).clear();

		driver.findElement(By.id("contactPersonEmailId")).clear();

		driver.findElement(By.id("contactPersonMobileNo")).clear();

		Thread.sleep(2000);

		// passing validation value 7
		Function.adminBecomeAP(driver, 22);
		Thread.sleep(1000);

		// error get
		if (driver.getPageSource().contains(Constant.OLD_EMAIL)) {
			Log.info("Email already exists,enter a new one error is present");
			ExcelUtils.setCellData("PASS", 22, 14, Constant.SHEET_NAME8);
		} else {
			Log.info("Email already exists,enter a new one error is not present");
			ExcelUtils.setCellData("FAIL", 22, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);
		Log.info("-------------------------------------------------");

		// clearing fields
		driver.findElement(By.id("partnerName")).clear();

		driver.findElement(By.id("contactNo")).clear();

		driver.findElement(By.id("emailId")).clear();

		driver.findElement(By.id("address")).clear();

		driver.findElement(By.id("address2")).clear();

		driver.findElement(By.id("area")).clear();

		driver.findElement(By.id("locality")).clear();

		driver.findElement(By.id("postal_code")).clear();

		driver.findElement(By.id("dispatchSystem")).clear();

		driver.findElement(By.id("contactPersonName")).clear();

		driver.findElement(By.id("contactPersonEmailId")).clear();

		driver.findElement(By.id("contactPersonMobileNo")).clear();

		Thread.sleep(2000);

		// passing validation value 8
		Function.adminBecomeAP(driver, 23);
		Thread.sleep(1000);

		// get Errors
		if (driver.getPageSource().contains(Constant.ADMIN_COMPANYN_EXIST)) {
			Log.info("Partner name exists error is present");
			ExcelUtils.setCellData("PASS", 23, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Partner name exists error is not present");
			ExcelUtils.setCellData("FAIL", 23, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------");

		// passing validation value 9
		Function.adminBecomeAP(driver, 24);
		Thread.sleep(1000);

		// get errors
		if (driver.getPageSource().contains(Constant.ADMIN_EMAIL_EXIST)) {
			Log.info("Enter email id already exists error is present");
			ExcelUtils.setCellData("PASS", 24, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter email id already exist error is not present");
			ExcelUtils.setCellData("FAIL", 24, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);
		Log.info("-------------------------------------------------");

		// passing false to true
		check = true;

	}

	@AfterMethod
	public void sendingReports() throws Exception {
		Log.info("AFTER METHOD");
		Function.sendingReports(driver, check);
	}
	
	 @AfterTest
	 public void closeBrowser() {
	 driver.quit();
	 }

}
