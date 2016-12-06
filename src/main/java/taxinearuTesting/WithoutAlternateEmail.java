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

public class WithoutAlternateEmail {

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

	@Test
	public void testTaxinearu() throws Exception {

		// check for the page title
		Assert.assertTrue(Constant.TITLE.contains(driver.getTitle()));
		Thread.sleep(5000);
		Log.info("TITLE IS MATCHED");

		// click on the LOGIN./SIGNUP
		driver.findElement(By.xpath("//*[@id='loginsignuplink']")).click();
		Thread.sleep(5000);

		// click on the SignUp
		driver.findElement(By.id("btnSignup")).click();
		Thread.sleep(5000);
        int row=12;
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
		
		// selecting security question
		Function.dropDown(driver, row, 7, Constant.SHEET_NAME4);

		// passing value for security question 1
		driver.findElement(By.id("ans1")).sendKeys(ExcelUtils.getCellData(row, 8, Constant.SHEET_NAME4));

		// selecting security question 2
		Function.dropDown(driver, row, 9, Constant.SHEET_NAME4);

		// passing value for security question 2
		driver.findElement(By.id("ans2")).sendKeys(ExcelUtils.getCellData(row, 10, Constant.SHEET_NAME4));

		// click on the check box
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[11]/div/div/input")).click();

		Thread.sleep(2000);

		// click on the submit button ,so that we can check the errors
		driver.findElement(By.id("btnUsrSignUp")).click();
		Thread.sleep(2000);

		// passing vaule of check to true
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
