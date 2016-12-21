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

public class EventBooking {

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

		// click on the event booking
		driver.findElement(By.id("eventBooking")).click();
		Thread.sleep(2000);

		// click on the submit button so that we can get the mandatory errors
		driver.findElement(By.id("saveEventBooking")).click();
		Thread.sleep(2000);

		// get the errors
		// firstname error
		String error = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[1]/td[1]/label[2]"))
				.getText();
		if (error.contains(Constant.FIRST_NAME)) {
			Log.info("ENTER FIRSTNAME ERROR IS PRESENT");
		} else {
			Log.error("ENTER FIRSTNAME ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// lastname error
		String error1 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[1]/td[2]/label[2]"))
				.getText();
		if (error1.contains(Constant.LAST_NAME)) {

			Log.info("ENTER LASTNAME ERROR IS PRESENT");

		} else {
			Log.error("ENTER LASTNAME ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// event date
		String error2 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[2]/td[2]/label[2]"))
				.getText();
		if (error2.contains(Constant.EVENT_DATE_ERROR)) {
			Log.info("ENTER EVENT DATE ERROR IS PRESENT");
		} else {
			Log.error("ENTER EVENT DATE ERROR IS NOT PRESENT ");
		}
		Thread.sleep(2000);

		// pickup area
		String error3 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[4]/td[1]/label[2]"))
				.getText();
		if (error3.contains(Constant.PICKUP_AREA_ERROR)) {
			Log.info("ENTER PICKUP AREA ERROR IS PRESENT");
		} else {
			Log.error("ENTER PICKUP AREA ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// drop off location
		String error4 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[4]/td[2]/label[2]"))
				.getText();
		if (error4.contains(Constant.DROPOFF_AREA_ERROR)) {
			Log.info("ENTER DROP OFF LOCATION ERROR IS PRESENT");
		} else {
			Log.error("ENTER DROP OFF LOCATION ERROR IS NOT PRESENT ");
		}
		Thread.sleep(2000);

		// contact number
		String error5 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[5]/td[2]/label[3]"))
				.getText();
		if (error5.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
		} else {
			Log.error("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// email address error
		String error6 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[6]/td[1]/label[2]"))
				.getText();
		if (error6.contains(Constant.ENTER_EMAIL_ERROR)) {
			Log.info("ENTER EMAIL ADDRESS ERROR IS PRESENT");
		} else {
			Log.error("ENTER EMAIL ADDRESS ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------");

		// passing validation value 1
		Function.EventBooking(driver, 15);

		// getting the errors
		// contact number error

		String error7 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[5]/td[2]/label[3]"))
				.getText();
		if (error7.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 15, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 15, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email address error
		String error8 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[6]/td[1]/label[2]"))
				.getText();
		if (error8.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 15, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 15, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("---------------------------------------------------------");

		// clearing fields
		driver.navigate().refresh();
		Thread.sleep(2000);

		// passing validation value 2
		Function.EventBooking(driver, 16);

		// get the errors
		// event date
		String error9 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[2]/td[2]/label[2]"))
				.getText();
		if (error9.contains(Constant.EVENT_DATE_ERROR)) {
			Log.info("ENTER EVENT DATE ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 16, 10, Constant.SHEET_NAME2);

		} else {
			Log.error("ENTER EVENT DATE ERROR IS NOT PRESENT ");
			ExcelUtils.setCellData("FAIL", 16, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);
		// contact number error

		String error10 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[5]/td[2]/label[3]"))
				.getText();
		if (error10.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 16, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 16, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email address error
		String error11 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[6]/td[1]/label[2]"))
				.getText();
		if (error11.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 16, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 16, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("----------------------------------------------------");

		// clearing the fields
		driver.navigate().refresh();

		// passing validation values 3
		Function.EventBooking(driver, 17);

		// get the errors
		// firstname error
		String error12 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[1]/td[1]/label[2]"))
				.getText();
		if (error12.contains(Constant.FIRST_NAME)) {
			Log.info("ENTER FIRSTNAME ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 17, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("ENTER FIRSTNAME ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 17, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// lastname error
		String error13 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[1]/td[2]/label[2]"))
				.getText();
		if (error13.contains(Constant.LAST_NAME)) {

			Log.info("ENTER LASTNAME ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 17, 10, Constant.SHEET_NAME2);

		} else {
			Log.error("ENTER LASTNAME ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 17, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// contact number error

		String error14 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[5]/td[2]/label[3]"))
				.getText();
		if (error14.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 17, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 17, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email address error
		String error15 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[6]/td[1]/label[2]"))
				.getText();
		if (error15.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 17, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 17, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------");

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 4
		Function.EventBooking(driver, 18);

		// get the errors
		// contact number error

		String error16 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[5]/td[2]/label[3]"))
				.getText();
		if (error16.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 18, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 18, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email address error
		String error17 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[6]/td[1]/label[2]"))
				.getText();
		if (error17.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 18, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 18, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("-----------------------------------------------------");

		// passing validation value 5
		Function.EventBooking(driver, 19);

		// getting the errors
		// firstname error
		String error18 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/form/div/div/div[1]/table/tbody/tr[1]/td[1]/label[2]"))
				.getText();
		if (error18.contains(Constant.LENGTH_FIRSTNAME)) {
			Log.info("First name must be 2 to 20 characters long ,ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 19, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("First name must be 2 to 20 characters long,ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 19, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// lastname
		String error19 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/form/div/div/div[1]/table/tbody/tr[1]/td[2]/label[2]"))
				.getText();
		if (error19.contains(Constant.LENGTH_LASTNAME)) {
			Log.info("Last name must be 2 to 20 characters long,ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 19, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("Last name must be 2 to 20 characters long,ERROR IS NOT PRESENT ");
			ExcelUtils.setCellData("FAIL", 19, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		String error20 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[5]/td[2]/label[3]"))
				.getText();
		if (error20.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 19, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 19, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email address error
		String error21 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[6]/td[1]/label[2]"))
				.getText();
		if (error21.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 19, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 19, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------");

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 6
		Function.EventBooking(driver, 20);

		// getting the errors
		// firstname error
		String error22 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/form/div/div/div[1]/table/tbody/tr[1]/td[1]/label[2]"))
				.getText();
		if (error22.contains(Constant.LENGTH_FIRSTNAME)) {
			Log.info("First name must be 2 to 20 characters long ,ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 20, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("First name must be 2 to 20 characters long,ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 20, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// lastname
		String error23 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/form/div/div/div[1]/table/tbody/tr[1]/td[2]/label[2]"))
				.getText();
		if (error23.contains(Constant.LENGTH_LASTNAME)) {
			Log.info("Last name must be 2 to 20 characters long,ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 20, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("Last name must be 2 to 20 characters long,ERROR IS NOT PRESENT ");
			ExcelUtils.setCellData("FAIL", 20, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		String error24 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[5]/td[2]/label[3]"))
				.getText();
		if (error24.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 20, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 20, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		// email address error
		String error25 = driver
				.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[6]/td[1]/label[2]"))
				.getText();
		if (error25.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 20, 10, Constant.SHEET_NAME2);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 20, 10, Constant.SHEET_NAME2);
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------");

		// clearing the fields
		driver.navigate().refresh();

		// passing confirm values
		Function.EventBooking(driver, 21);

		Log.info("CONFIRM VALUES SUCCESSFULLY EXECUTED");

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
