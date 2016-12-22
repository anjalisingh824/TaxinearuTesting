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

public class Booking {
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

		// click on the LOGIN./SIGNUP
		driver.findElement(By.xpath("//*[@id='loginsignuplink']")).click();
		Thread.sleep(5000);

		// passing username and password for login
		Function.loginPage(driver, 1, 1, 2, Constant.SHEET_NAME6);

		Thread.sleep(1000);

		// now click on the search button on the booking page so that we can
		// check for the mandatory errors
		driver.findElement(By.id("searchPartnerTaxi")).click();
		Thread.sleep(2000);

		// now get the errors
		// for pickup area
		String error1 = driver
				.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/div/form/table/tbody[1]/tr/td[1]/label"))
				.getText();
		if (error1.contains(Constant.B_PICKUP_AREA)) {
			Log.info("Enter Pickup location error is present");
		} else {
			Log.error("Enter Pickup location error is not present");
		}
		Thread.sleep(2000);

		// drop off location
		String error2 = driver
				.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/div/form/table/tbody[1]/tr/td[2]/label"))
				.getText();
		if (error2.contains(Constant.B_DROP_OFF_AREA)) {
			Log.info("Enter Drop off location error is present");
		} else {
			Log.error("Enter Drop off location error is not present");
		}
		Thread.sleep(2000);

		Log.info("---------------------------------------------------------");

		// passing values
		int row = 3;
		// pick up

		driver.findElement(By.id("areafrom_0")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME6));

		// drop
		driver.findElement(By.id("areato_0")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME6));

		// click on the plus button for adding more area
		driver.findElement(By.id("addMoreArea")).click();
		Thread.sleep(2000);

		// via
		driver.findElement(By.id("areato_1")).sendKeys(ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME6));

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

		// get the error if,we are not selecting pick,drop and via from dropdown
		if (driver.getPageSource().contains(Constant.B_SUGGESTION_ERROR)) {
			Log.info(" Please select valid location name from suggestion,error is present");
			ExcelUtils.setCellData("PASS", row, 7, Constant.SHEET_NAME6);
		} else {
			Log.error(" Please select valid location name from suggestion,error is not present");
			ExcelUtils.setCellData("FAIL", row, 7, Constant.SHEET_NAME6);
		}
		Thread.sleep(2000);

		Log.info("---------------------------------------------------------");

		//passing validation values
		
		
		
		
		
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
