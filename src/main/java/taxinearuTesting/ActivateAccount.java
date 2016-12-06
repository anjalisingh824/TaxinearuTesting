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

public class ActivateAccount {
	
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
		
		
		//login
		Function.loginPage(driver, 14, 1, 2,Constant.SHEET_NAME4);

		
		//click on menu button
		driver.findElement(By.xpath("//*[@id='mm-menu-toggle']")).click();
		Thread.sleep(2000);
		
		
		
		//click on the activate button
		driver.findElement(By.xpath("//*[@id='btnActivateMenu']")).click();
		Thread.sleep(2000);
		
		
		//reading mail 
		// reading email
		// reading mail after sending it to the primary mail id
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.EMAIL, Constant.EMAIL_PASSWORD,
				45000);
		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);
		Thread.sleep(5000);
		
		
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
	
