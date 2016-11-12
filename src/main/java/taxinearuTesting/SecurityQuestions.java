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

public class SecurityQuestions {

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

		// selecting the radio button security questions
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[1]/form/p[3]/label"))
				.click();

		// click on the confirm button of the pop up window for filling the
		// security questions .
		driver.findElement(By.id("btnRequest")).click();
		Thread.sleep(2000);
		Log.info("PASSWORD CHANGE CONFIRM BUTTON CLICKED...FROM POP UP WINDOW");
		Thread.sleep(5000);

		//selecting security questions for changing the password.
		driver.findElement(By.id("ans1Verify")).sendKeys("bangalore");
		driver.findElement(By.id("ans2Verify")).sendKeys("anu");
		
		//click on the confirm button after filling the 2 fields.
		driver.findElement(By.id("btnConfirm")).click();
		Thread.sleep(5000);
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
