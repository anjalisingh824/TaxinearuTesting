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
		
        //clearing the fields
        driver.navigate().refresh();
		
		int row = 14;
		// admin login
		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME8));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME8));

		// click on the login button
		driver.findElement(By.id("loginbtn")).click();
		Thread.sleep(2000);

	
		//click on the company management menu
		driver.findElement(By.xpath("//html/body/div[2]/ul/li[2]/a/i")).click();
		Thread.sleep(2000);

		
		//click on company management now
		driver.findElement(By.id("partnerManagementTab")).click();
		Thread.sleep(2000);
		
		//click on add partner now
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div/div[2]/a")).click();
		Thread.sleep(2000);
		
		
		//click on save partner now,to check for the mandatory fields
		driver.findElement(By.id("savePartner")).click();
		Thread.sleep(2000);
		
		//get the errors
		//company name
		String checkError=driver.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/form/div[1]/div/label")).getText();
		if(checkError.contains(Constant.ADMIN_PARTNER_C_NAME))
		{
			Log.info("Enter Company Name error is present");
		}
		else
		{
			Log.error("Enter Company Name error is not present");
		}
		Thread.sleep(2000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
