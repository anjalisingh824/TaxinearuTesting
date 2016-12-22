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

public class ContactUs {

	private WebDriver driver;
	boolean check = false;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test()
	public void testTaxinaru() throws Exception {

		// check for the page title
		Assert.assertTrue(Constant.TITLE.contains(driver.getTitle()));
		Thread.sleep(5000);
		Log.info("TITLE IS MATCHED");

		// click on contact us
		driver.findElement(By.id("contactUs")).click();
		Thread.sleep(2000);

		// check for the links as twitter,facebook, and insta
		
		//facebook link
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div/div[2]/div/a[1]/i")).click();

		Thread.sleep(5000);

        //twitter link
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div/div[2]/div/a[2]/i")).click();
		
		Thread.sleep(5000);
		
		//instagram link
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div/div[2]/div/a[3]/i")).click();
		
		Thread.sleep(5000);

		// click on the send button so we can check for the mandatory errors
		driver.findElement(By.id("sendContactInfo")).click();
		Thread.sleep(2000);

		// get the errors
		String error1 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[1]/label[2]"))
				.getText();
		if (error1.contains(Constant.C_NAME_ERROR)) {
			Log.info("Enter name ,error is present");
		} else {
			Log.error("Enter name,error is not present");
		}
		Thread.sleep(2000);

		// contact number
		String error2 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[2]/label[3]"))
				.getText();
		if (error2.contains(Constant.CHECK_CONTACT_NOERR)) {
			Log.info("Enter contact number,error is present");
		} else {
			Log.error("Enter contact number,error is not present");
		}
		Thread.sleep(2000);

		// email address
		String error3 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[2]/td[1]/label[2]"))
				.getText();
		if (error3.contains(Constant.ENTER_EMAIL_ERROR)) {
			Log.info("Enter email address,error is present");
		} else {
			Log.error("Enter email address,error is not present");
		}
		Thread.sleep(2000);

		// subject
		String error4 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[2]/td[2]/label[2]"))
				.getText();
		if (error4.contains(Constant.SUBJECT_ERROR)) {
			Log.info("Enter subject,error is present");
		} else {
			Log.error("Enter subject,error is not present");
		}
		Thread.sleep(2000);

		// message
		String error5 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[3]/td/label[2]"))
				.getText();
		if (error5.contains(Constant.MESSAGE_ERROR)) {
			Log.info("Enter message,error is present");
		} else {
			Log.error("Enter message,error is not present");
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------------");

		// passing validation value 1
		Function.contactUs(driver, 23);

		// get the errors
		// name
		String err = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[1]/label[2]"))
				.getText();
		if (err.contains(Constant.C_VALID_NAME_ERROR)) {
			Log.info("Name must be 5 to 20 characters long,error is present");
			ExcelUtils.setCellData("PASS", 23, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Name must be 5 to 20 characters long,error is not present");
			ExcelUtils.setCellData("FAIL", 23, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// contact number
		String err1 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[2]/label[3]"))
				.getText();
		if (err1.contains(Constant.CHECK_CONTACT_NOERR)) {
			Log.info("Enter contact number,error is present");
			ExcelUtils.setCellData("PASS", 23, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Enter contact number,error is not present");
			ExcelUtils.setCellData("FAIL", 23, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email
		String err2 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[2]/td[1]/label[2]"))
				.getText();
		if (err2.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address,error is present");
			ExcelUtils.setCellData("PASS", 23, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Enter valid email address,error is not present");
			ExcelUtils.setCellData("FAIL", 23, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// subject error
		String err3 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[2]/td[2]/label[2]"))
				.getText();
		if (err3.contains(Constant.SUBJECT_VALID_ERROR)) {
			Log.info("Subject must be between 5 to 20 digits long,error is present");
			ExcelUtils.setCellData("PASS", 23, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Subject must be between 5 to 20 digits long,error is not present");
			ExcelUtils.setCellData("FAIL", 23, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------------");

		// passing validation value 2
		Function.contactUs(driver, 24);

		// get the errors
		// name
		String error6 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[1]/label[2]"))
				.getText();
		if (error6.contains(Constant.C_VALID_NAME_ERROR)) {
			Log.info("Name must be 5 to 20 characters long,error is present");
			ExcelUtils.setCellData("PASS", 24, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Name must be 5 to 20 characters long,error is not present");
			ExcelUtils.setCellData("FAIL", 24, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// contact number
		String error7 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[2]/label[3]"))
				.getText();
		if (error7.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("Please enter valid UK contact number is present,error is present");
			ExcelUtils.setCellData("PASS", 24, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Please enter valid UK contact number is present,error is not present");
			ExcelUtils.setCellData("FAIL", 24, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email
		String error8 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[2]/td[1]/label[2]"))
				.getText();
		if (error8.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address,error is present");
			ExcelUtils.setCellData("PASS", 24, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Enter valid email address,error is not present");
			ExcelUtils.setCellData("FAIL", 24, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// subject error
		String error9 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[2]/td[2]/label[2]"))
				.getText();
		if (error9.contains(Constant.SUBJECT_VALID_ERROR)) {
			Log.info("Subject must be between 5 to 20 digits long,error is present");
			ExcelUtils.setCellData("PASS", 24, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Subject must be between 5 to 20 digits long,error is not present");
			ExcelUtils.setCellData("FAIL", 24, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------------");

		// clearing the fields
		driver.navigate().refresh();

		// passing validation values 3
		Function.contactUs(driver, 25);

		// get the errors
		// email
		String error10 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[2]/td[1]/label[2]"))
				.getText();
		if (error10.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address,error is present");
			ExcelUtils.setCellData("PASS", 25, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Enter valid email address,error is not present");
			ExcelUtils.setCellData("FAIL", 25, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		String error11 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[2]/label[3]"))
				.getText();
		if (error11.contains(Constant.CHECK_CONTACT_NOERR)) {
			Log.info("Enter contact number,error is present");
			ExcelUtils.setCellData("PASS", 25, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Enter contact number,error is not present");
			ExcelUtils.setCellData("FAIL", 25, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------------");

		// clearing the fields
		driver.navigate().refresh();

		// passing the validation values 4
		Function.contactUs(driver, 26);

		// get the errors
		// contact number
		String error12 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[2]/label[3]"))
				.getText();
		if (error12.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("Please enter valid UK contact number is present,error is present");
			ExcelUtils.setCellData("PASS", 26, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Please enter valid UK contact number is present,error is not present");
			ExcelUtils.setCellData("FAIL", 26, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email
		String error13 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[2]/td[1]/label[2]"))
				.getText();
		if (error13.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address,error is present");
			ExcelUtils.setCellData("PASS", 26, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Enter valid email address,error is not present");
			ExcelUtils.setCellData("FAIL", 26, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------");

		// clearing fields
		driver.navigate().refresh();

		// passing validation value 5
		Function.contactUs(driver, 27);

		// get the errors
		// name
		String error14 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[1]/label[2]"))
				.getText();
		if (error14.contains(Constant.C_NAME_ERROR)) {
			Log.info("Enter name ,error is present");
			ExcelUtils.setCellData("PASS", 27, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Enter name,error is not present");
			ExcelUtils.setCellData("FAIL", 27, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// contact number
		String error15 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[2]/label[3]"))
				.getText();
		if (error15.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("Please enter valid UK contact number is present,error is present");
			ExcelUtils.setCellData("PASS", 27, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Please enter valid UK contact number is present,error is not present");
			ExcelUtils.setCellData("FAIL", 27, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email
		String error16 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[2]/td[1]/label[2]"))
				.getText();
		if (error16.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address,error is present");
			ExcelUtils.setCellData("PASS", 27, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Enter valid email address,error is not present");
			ExcelUtils.setCellData("FAIL", 27, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------");

		// clearing fields
		driver.navigate().refresh();

		// passing validation value 6
		Function.contactUs(driver, 28);

		// get the errors
		String error17 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[1]/td[2]/label[3]"))
				.getText();
		if (error17.contains(Constant.CHECK_CONTACT_NOERR)) {
			Log.info("Enter contact number,error is present");
			ExcelUtils.setCellData("PASS", 28, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Enter contact number,error is not present");
			ExcelUtils.setCellData("FAIL", 28, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email
		String error18 = driver.findElement(By.xpath("//*[@id='contactUsForm']/table/tbody/tr[2]/td[1]/label[2]"))
				.getText();
		if (error18.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("Enter valid email address,error is present");
			ExcelUtils.setCellData("PASS", 28, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("Enter valid email address,error is not present");
			ExcelUtils.setCellData("FAIL", 28, 6, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------");

		// clearing fields
		driver.navigate().refresh();

		// passing confirm values
		Function.contactUs(driver, 29);

		Log.info("CONFIRM VALUES EXECUTED SUCCESSFULLY");
		
		//click on back to homepage
		driver.findElement(By.xpath("//*[@id='main-content']/div/div/div/div/a")).click();
		Thread.sleep(2000);
		
		Log.info("RETURN TO HOMEPAGE");
		
		

		// changing value from true to false
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
