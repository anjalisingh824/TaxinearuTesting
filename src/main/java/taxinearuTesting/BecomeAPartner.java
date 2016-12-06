package taxinearuTesting;

import java.util.concurrent.TimeUnit;

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

public class BecomeAPartner {

	private WebDriver driver;
	boolean check = false;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ExcelUtils.getTableArray(Constant.FILE_FULL_PATH,
		// Constant.SHEET_NAME3);

	}

	@Test()
	public void testTaxinaru() throws Exception {

		// check for the page title
		Assert.assertTrue(Constant.TITLE.contains(driver.getTitle()));
		Thread.sleep(5000);
		Log.info("TITLE IS MATCHED");

		// click on become a partner
		driver.findElement(By.id("partnerRegitration")).click();
		Thread.sleep(2000);

		// click on the save button ,so that we can check for the mandatory
		// fields
		driver.findElement(By.id("savePartner")).click();
		Thread.sleep(2000);

		// get The errors for the mandatory fields

		// firstname error
		String CheckError = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[1]/div/div[1]/label[2]"))
				.getText();
		if (CheckError.contains(Constant.FIRST_NAME)) {
			Log.info("Enter firstName error is present");
		} else {
			Log.error("Enter firstName error is not present");
		}

		Thread.sleep(2000);

		// lastname
		String checkError1 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[1]/div/div[2]/label[2]"))
				.getText();
		if (checkError1.contains(Constant.LAST_NAME)) {
			Log.info("Enter lastName error is present");
		} else {
			Log.error("Enter lastName error is not present");
		}
		Thread.sleep(2000);

		// contact number
		String checkError2 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[2]/div/div[1]/label[3]"))
				.getText();
		if (checkError2.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("Please enter valid uk number error is present");
		} else {
			Log.error("Please enter valid uk number error is not present");
		}
		Thread.sleep(2000);

		// email address error
		String checkError3 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[2]/div/div[2]/label[2]"))
				.getText();
		if (checkError3.contains(Constant.ENTER_EMAIL_ERROR)) {
			Log.info("Enter email address error is present");
		} else {
			Log.error("Enter email address error is not present");
		}
		Thread.sleep(2000);

		// company name
		String checkError4 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[3]/div/div[1]/label[2]"))
				.getText();
		if (checkError4.contains(Constant.COMPANY_NAME)) {
			Log.info("Enter company name is present");
		} else {
			Log.error("Enter company name is not present");
		}

		// area name
		String checkError5 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[3]/div/div[2]/label[2]"))
				.getText();
		if (checkError5.contains(Constant.AREA_NAME)) {
			Log.info("Enter area error is present");
		}

		else {
			Log.info("Enter area error is not present");
		}
		Thread.sleep(2000);

		// address
		String checkError6 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[4]/div/div[1]/label[2]"))
				.getText();
		if (checkError6.contains(Constant.ADDRESS_NAME)) {
			Log.info("Enter valid address error is present");
		} else {
			Log.error("Enter valid address error is not present");
		}
		Thread.sleep(2000);

		// official email address
		String checkError7 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[5]/div/div[1]/label[2]"))
				.getText();
		if (checkError7.contains(Constant.ENTER_EMAIL_ERROR)) {
			Log.info("official email address,error is present");
		} else {
			Log.info("official email address,error is not present");
		}
		Thread.sleep(2000);

		// office contact number
		String checkError8 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[5]/div/div[2]/label[3]"))
				.getText();
		if (checkError8.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("office contact number error is present");
		} else {
			Log.error("office contact number error is not present");
		}
		Thread.sleep(2000);

		// city
		String checkError9 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[6]/div/div[1]/label[2]"))
				.getText();
		if (checkError9.contains(Constant.CITY_NAME)) {
			Log.info("Enter city name error is present");
		} else {
			Log.error("Enter city name error is not present");
		}
		Thread.sleep(2000);

		// dispatch system
		String checkError10 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[6]/div/div[2]/label[2]"))
				.getText();
		if (checkError10.contains(Constant.DISPATCH_L_NAME)) {
			Log.info("Enter dispatch system error is present");
		} else {
			Log.error("Enter dispatch system error is not present");
		}
		Thread.sleep(2000);

		// postal code
		String checkError11 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[7]/div/div[1]/label[2]"))
				.getText();
		if (checkError11.contains(Constant.POSTAL_CODE)) {
			Log.info("Enter postal code error is present");
		} else {
			Log.error("Enter postal code error is not present");
		}
		Thread.sleep(2000);

		// passing validation value 1
		Function.becomeAPartner(driver, 1);

		// get the errors

		// first name error
		String validError = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[1]/div/div[1]/label[2]"))
				.getText();
		if (validError.contains(Constant.NAME_ERROR)) {
			Log.info("First name must be 5-20  digits long ,error is present");
			ExcelUtils.setCellData("PASS", 1, 14, Constant.SHEET_NAME8);

		} else {
			Log.error("First name must be 5-20  digits long ,error is not present");
			ExcelUtils.setCellData("FAIL", 1, 14, Constant.SHEET_NAME8);

		}
		Thread.sleep(2000);

		// lastName error
		String validError1 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[1]/div/div[2]/label[2]"))
				.getText();
		if (validError.contains(Constant.VALID_LASTNAME_ERROR)) {
			Log.info("Last name must be 5-20  digits long ,error is present");
			ExcelUtils.setCellData("PASS", 1, 14, Constant.SHEET_NAME8);

		} else {
			Log.error("Last name must be 5-20  digits long ,error is not present");
			ExcelUtils.setCellData("FAIL", 1, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// email error
		String validError2 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[2]/div/div[2]/label[2]"))
				.getText();
		if (validError2.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
			ExcelUtils.setCellData("PASS", 1, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter valid email address error is not present");
			ExcelUtils.setCellData("FAIL", 1, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 2
		Function.becomeAPartner(driver, 2);

		// getting errors

		// first name error
		String error = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[1]/div/div[1]/label[2]"))
				.getText();
		if (error.contains(Constant.NAME_ERROR)) {
			Log.info("First name must be 5-20  digits long ,error is present");
			ExcelUtils.setCellData("PASS", 2, 14, Constant.SHEET_NAME8);

		} else {
			Log.error("First name must be 5-20  digits long ,error is not present");
			ExcelUtils.setCellData("FAIL", 2, 14, Constant.SHEET_NAME8);

		}
		Thread.sleep(2000);

		// lastName error
		String errors = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[1]/div/div[2]/label[2]"))
				.getText();
		if (error.contains(Constant.VALID_LASTNAME_ERROR)) {
			Log.info("Last name must be 5-20  digits long ,error is present");
			ExcelUtils.setCellData("PASS", 2, 14, Constant.SHEET_NAME8);

		} else {
			Log.error("Last name must be 5-20  digits long ,error is not present");
			ExcelUtils.setCellData("FAIL", 2, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 3
		Function.becomeAPartner(driver, 3);

		// get the errors
		// email error
		String error2 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[2]/div/div[2]/label[2]"))
				.getText();
		if (error2.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
			ExcelUtils.setCellData("PASS", 3, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter valid email address error is not present");
			ExcelUtils.setCellData("FAIL", 3, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// passing validation values 4
		Function.becomeAPartner(driver, 4);

		// get the errors

		// first name error
		String validErr = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[1]/div/div[1]/label[2]"))
				.getText();
		if (validErr.contains(Constant.NAME_ERROR)) {
			Log.info("First name must be 5-20  digits long ,error is present");
		} else {
			Log.error("First name must be 5-20  digits long ,error is not present");
		}
		Thread.sleep(2000);

		// lastName error
		String validErr1 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[1]/div/div[2]/label[2]"))
				.getText();
		if (validErr.contains(Constant.VALID_LASTNAME_ERROR)) {
			Log.info("Last name must be 5-20  digits long ,error is present");
		} else {
			Log.error("Last name must be 5-20  digits long ,error is not present");
		}
		Thread.sleep(2000);

		// email error
		String validErr2 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[2]/div/div[2]/label[2]"))
				.getText();
		if (validErr2.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
		} else {
			Log.error("Enter valid email address error is not present");
		}
		Thread.sleep(2000);

		// valid mobile number error is present
		String validError3 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[2]/div/div[1]/label[3]"))
				.getText();
		if (validError3.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
		} else {
			Log.error("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 5
		Function.becomeAPartner(driver, 5);
		Thread.sleep(1000);

		// catch error as we are passing email ,that we are already registered
		// with customer one
		if (driver.getPageSource().contains(Constant.OLD_EMAIL)) {
			Log.info("Email aready exists error is present");
			ExcelUtils.setCellData("PASS", 5, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Email aready exists error is not present");
			ExcelUtils.setCellData("FAIL", 5, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 6
		Function.becomeAPartner(driver, 6);
		Thread.sleep(1000);

		// catch error as we are passing alternate email ,that we are already
		// registered with customer one
		if (driver.getPageSource().contains(Constant.OLD_EMAIL)) {
			Log.info("Email aready exists error is present");
			ExcelUtils.setCellData("PASS", 6, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Email aready exists error is not present");
			ExcelUtils.setCellData("FAIL", 6, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 7
		Function.becomeAPartner(driver, 7);
		Thread.sleep(1000);
		// catch error as we are passing partner request email ,that we are
		// already
		// registered with customer one,but the request pending from admin side
		if (driver.getPageSource().contains(Constant.OLD_EMAIL)) {
			Log.info("Email aready exists error is present");
			ExcelUtils.setCellData("PASS", 7, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Email aready exists error is not present");
			ExcelUtils.setCellData("FAIL", 7, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 8
		Function.becomeAPartner(driver, 8);
		Thread.sleep(1000);

		// catching error if we will try to pass partner name as same as
		// registered one
		if (driver.getPageSource().contains(Constant.PARTNER_NAME_ERROR)) {
			Log.info("Partner name registered error is present");
			ExcelUtils.setCellData("PASS", 8, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Partner name registered error is not present");
			ExcelUtils.setCellData("FAIL", 8, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 9
		Function.becomeAPartner(driver, 9);
		Thread.sleep(1000);

		// catching error if we will try to pass driver's registered mail
		if (driver.getPageSource().contains(Constant.OLD_EMAIL)) {
			Log.info("Email already exists error is present");
			ExcelUtils.setCellData("PASS", 9, 14, Constant.SHEET_NAME8);
		} else {
			Log.error("Email already exists error is not present");
			ExcelUtils.setCellData("FAIL", 9, 14, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// clearing fields
		driver.navigate().refresh();

		// passing validation value 10
		Function.becomeAPartner(driver, 10);

		// email error
		String errorCh = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[2]/div/div[2]/label[2]"))
				.getText();
		if (errorCh.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address error is present");
		} else {
			Log.error("Enter valid email address error is not present");
		}
		Thread.sleep(2000);

		// valid mobile number error is present
		String errCheck = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div/div[1]/div/form/div/div[2]/div/div[1]/label[3]"))
				.getText();
		if (errCheck.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
		} else {
			Log.error("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);


		// clearing fields
		driver.navigate().refresh();
		
		//passing validation value 11
		Function.becomeAPartner(driver, 11);
		
		
		
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
