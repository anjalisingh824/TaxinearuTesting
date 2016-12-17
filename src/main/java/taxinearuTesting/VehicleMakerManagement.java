package taxinearuTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class VehicleMakerManagement {
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

		int row = 14;
		// admin login
		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME8));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME8));

		// click on the login button
		driver.findElement(By.id("loginbtn")).click();
		Thread.sleep(2000);

		Log.info("--------------------------------------------");

		// click on the vehicle image in the left hand side corner
		driver.findElement(By.xpath("//html/body/div[2]/ul/li[3]/a/i")).click();
		Thread.sleep(2000);

		// click on the vehicle maker management
		driver.findElement(By.xpath("//*[@id='vehicleMakerManagementTab']")).click();
		Thread.sleep(2000);

		// click on add button on the right hand side corner
		driver.findElement(By.xpath("//*[@id='vehicleMakerManagementTableContent']/div/div[2]/a")).click();
		Thread.sleep(2000);

		// click on the save button for checking the errors
		driver.findElement(By.xpath("//*[@id='saveTaxiMaker']")).click();
		Thread.sleep(2000);

		// get the errors
		String error = driver.findElement(By.xpath("//*[@id='vehicleMakerManagementForm']/div[1]/div/label")).getText();
		if (error.contains(Constant.VEHICLE_MAKER_ERROR)) {
			Log.info("Enter vehicle maker error is present");
		} else {
			Log.error("Enter vehicle maker error is not present");
		}
		Thread.sleep(2000);

		int row1 = 36;
		// passing validation values
		driver.findElement(By.id("makerName")).sendKeys(ExcelUtils.getCellData(row1, 1, Constant.SHEET_NAME8));
		Thread.sleep(2000);

		// click on the tab so that we can check for the errors
		driver.findElement(By.id("makerName")).sendKeys(Keys.TAB);
		Thread.sleep(1000);

		// clearing the fields
		driver.findElement(By.id("makerName")).clear();
		Thread.sleep(2000);

		// passing validation values
		driver.findElement(By.id("makerName")).sendKeys(ExcelUtils.getCellData(row1, 2, Constant.SHEET_NAME8));
		Thread.sleep(2000);

		// click on the tab so that we can check for the errors
		driver.findElement(By.id("makerName")).sendKeys(Keys.TAB);
		Thread.sleep(1000);

		// clearing the fields
		driver.findElement(By.id("makerName")).clear();
		Thread.sleep(2000);

		// passing validation values
		driver.findElement(By.id("makerName")).sendKeys(ExcelUtils.getCellData(row1, 3, Constant.SHEET_NAME8));
		Thread.sleep(2000);

		// click on the tab so that we can check for the errors
		driver.findElement(By.id("makerName")).sendKeys(Keys.TAB);
		Thread.sleep(1000);

		// clearing the fields
		driver.findElement(By.id("makerName")).clear();
		Thread.sleep(2000);

		// passing validation values
		driver.findElement(By.id("makerName")).sendKeys(ExcelUtils.getCellData(row1, 4, Constant.SHEET_NAME8));
		Thread.sleep(2000);

		// click on the tab so that we can check for the errors
		driver.findElement(By.id("makerName")).sendKeys(Keys.TAB);
		Thread.sleep(1000);

		// clearing the fields
		driver.findElement(By.id("makerName")).clear();
		Thread.sleep(2000);

		// passing validation values
		driver.findElement(By.id("makerName")).sendKeys(ExcelUtils.getCellData(row1, 5, Constant.SHEET_NAME8));
		Thread.sleep(2000);

		// click on the tab so that we can check for the errors
		driver.findElement(By.id("makerName")).sendKeys(Keys.TAB);
		Thread.sleep(1000);

		// clearing the fields
		driver.findElement(By.id("makerName")).clear();
		Thread.sleep(2000);

		// passing validation values
		driver.findElement(By.id("makerName")).sendKeys(ExcelUtils.getCellData(row1, 6, Constant.SHEET_NAME8));
		Thread.sleep(2000);

		// click on the save button for checking the errors
		driver.findElement(By.xpath("//*[@id='saveTaxiMaker']")).click();
		Thread.sleep(2000);

		// get the error for the vehicle maker already exists
		if (driver.getPageSource().contains(Constant.VEHICLE_MAKER_A_EXISTS)) {
			Log.info("Vehicle maker name already exists error is present");
		} else {
			Log.error("Vehicle maker name already exists error is not present");
		}
		Thread.sleep(2000);

		// passing the confirm values now
		// passing validation values
		// driver.findElement(By.id("makerName")).sendKeys(ExcelUtils.getCellData(row1,
		// 7, Constant.SHEET_NAME8));
		//
		// //click on the save button for checking the errors
		// driver.findElement(By.xpath("//*[@id='saveTaxiMaker']")).click();
		// Thread.sleep(2000);

		// click on the cancel button now so we can do editing
		driver.findElement(By.xpath("//*[@id='vehicleMakerManagementForm']/div[3]/input[2]")).clear();

		// do editing now
		driver.findElement(By.xpath("//*[@id='taxiType_19']")).click();
		Thread.sleep(2000);

		// passing edit values
		driver.findElement(By.id("makerName")).sendKeys(ExcelUtils.getCellData(row1, 7, Constant.SHEET_NAME8));
		Thread.sleep(2000);

		// click on the save button for checking the errors
		driver.findElement(By.xpath("//*[@id='saveTaxiMaker']")).click();
		Thread.sleep(2000);

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
