package taxinearuTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
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
		// ExcelUtils.getTableArray(Constant.FILE_FULL_PATH,
		// Constant.SHEET_NAME1);

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
        
        //event date
        String error2=driver.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[2]/td[2]/label[2]")).getText();
        if(error2.contains(Constant.EVENT_DATE_ERROR))
        {
        	Log.info("ENTER EVENT DATE ERROR IS PRESENT");
        }
        else
        {
        	Log.error("ENTER EVENT DATE ERROR IS NOT PRESENT ");
        }
		Thread.sleep(2000);
		
		//pickup area
		String error3=driver.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[4]/td[1]/label[2]")).getText();
		if(error3.contains(Constant.PICKUP_AREA_ERROR))
		{
			Log.info("ENTER PICKUP AREA ERROR IS PRESENT");
		}
		else
		{
			Log.error("ENTER PICKUP AREA ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);
		
		//drop off location
		String error4=driver.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[4]/td[2]/label[2]")).getText();
		if(error4.contains(Constant.DROPOFF_AREA_ERROR))
		{
			Log.info("ENTER DROP OFF LOCATION ERROR IS PRESENT");
		}
		else
		{
			Log.error("ENTER DROP OFF LOCATION ERROR IS NOT PRESENT ");
		}
		Thread.sleep(2000);
		
		//contact number 
		String error5=driver.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[5]/td[2]/label[3]")).getText();
		if(error5.contains(Constant.VALID_CONTACTNO_ERROR))
		{
			Log.info("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
		}
		else
		{
			Log.error("PLEASE ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);
		
		//email address error
		String error6=driver.findElement(By.xpath("//*[@id='eventbookingForm']/div/div/div[1]/table/tbody/tr[6]/td[1]/label[2]")).getText();
		if(error6.contains(Constant.ENTER_EMAIL_ERROR))
		{
			Log.info("ENTER EMAIL ADDRESS ERROR IS PRESENT");
		}
		else
		{
			Log.error("ENTER EMAIL ADDRESS ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);
		
		
		//passing validation value 1
		Function.EventBooking(driver, 15);
		
	    //getting the errors
		
		
		
		// changing value from true to false
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
