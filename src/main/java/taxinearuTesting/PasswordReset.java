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

public class PasswordReset {

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
		// Constant.SHEET_NAME3);

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

		// login
		int row = 1;
		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME));
		Thread.sleep(2000);

		// click on the forget password
		driver.findElement(By.xpath("//*[@id='forgotPasswordLink']")).click();
		Thread.sleep(2000);

		// fill the email id so that the link will go to the email for resetting
		// the password
		driver.findElement(By.xpath("//*[@id='username']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME));

		// click on continue button
		driver.findElement(By.xpath("//*[@id='frmForgotPass']/center/a")).click();
		Thread.sleep(2000);

		// reading email
		// reading mail after sending it to the primary mail id
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.PRIMARY_EMAIL, Constant.PRIMARY_EMAIL_PASSWORD,
				45000);
		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);
		Thread.sleep(5000);

		int row1 = 22;
		// fill details for setting password
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row1, 1, Constant.SHEET_NAME));
		driver.findElement(By.id("repassword")).sendKeys(ExcelUtils.getCellData(row1, 2, Constant.SHEET_NAME));

		// click on submit
		driver.findElement(By.xpath("//html/body/div/div/div[3]/form/div[4]/input")).click();
		Thread.sleep(2000);

		// click on the LOGIN./SIGNUP
		driver.findElement(By.xpath("//*[@id='loginsignuplink']")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row1, 1, Constant.SHEET_NAME));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='btnLogIn']")).click();
		Thread.sleep(5000);
		Log.info("LOGIN DONE");

		// check for the link expired

		// reading email
		// reading mail after sending it to the primary mail id
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.PRIMARY_EMAIL, Constant.PRIMARY_EMAIL_PASSWORD,
				5000);
		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);
		Thread.sleep(5000);

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
