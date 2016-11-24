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
import Utils.Function;
import Utils.Log;

public class LoginPage {
	private WebDriver driver;
	boolean check=false;

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
		// call the function login for passing the values username and password
		Function.loginPage(driver, 10, 1, 2, Constant.SHEET_NAME4);

		// click on the menu for selecting profile option
		driver.findElement(By.xpath("//*[@id='mm-menu-toggle']")).click();
		Thread.sleep(5000);
		Log.info("MENU CLICKED");

		// click on the profile option
		driver.findElement(By.xpath("//*[@id='btnProfile']/span[2]")).click();
		Log.info("PROFILE OPTION SELECTED");
		Thread.sleep(5000);

		// click on the activate link ...so the mail will go to the link for the
		// activation
		driver.findElement(By.id("btnActivate")).click();
		Thread.sleep(5000);

		// reading mail after the link is send to the mail .....we are reading
		// first mail ,so it should expire
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.NEW_EMAIL, Constant.NEW_EMAIL_PASSWORD, 5000);
		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);

		Thread.sleep(5000);

		// reading mail after the link is send to the mail .....we are reading
		// mail...that is went after clicking on the activation button
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.NEW_EMAIL, Constant.NEW_EMAIL_PASSWORD, 40000);
		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);

		Thread.sleep(5000);

		// Should go to the main page after activation.

		driver.findElement(By.xpath("//html/body/div[3]/div/div/a")).click();
		Thread.sleep(5000);
		Log.info("RETURNING TO THE MAIN PAGE");
		
		//changing value of check to true
		check=true;

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
