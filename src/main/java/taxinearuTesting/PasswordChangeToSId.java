package taxinearuTesting;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.Function;
import Utils.Log;

public class PasswordChangeToSId {

	private WebDriver driver;
	boolean check = false;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExcelUtils.getTableArray(Constant.FILE_FULL_PATH, Constant.SHEET_NAME);

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

		// taking row 1 from excel
		int row = 1;
		// passing username and password for login
		driver.findElement(By.id("username"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row).getCell(1).getStringCellValue());
		driver.findElement(By.id("password"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row).getCell(2).getStringCellValue());
		driver.findElement(By.xpath("//*[@id='btnLogIn']")).click();
		Thread.sleep(5000);
		Log.info("LOGIN DONE");

		// click on the menu for selecting profile option
		driver.findElement(By.xpath("//*[@id='mm-menu-toggle']")).click();
		Thread.sleep(5000);
		Log.info("MENU CLICKED");

		// click on the profile option
		driver.findElement(By.xpath("//*[@id='btnProfile']/span[2]")).click();
		Thread.sleep(5000);
		Log.info("PROFILE OPTION SELECTED");

		// click on the change password button in profile page
		driver.findElement(By.id("changePassword")).click();
		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD SELECTED");

	     driver.findElement(By.id("altEmail")).click();
	     Thread.sleep(5000);
		
		}
}
