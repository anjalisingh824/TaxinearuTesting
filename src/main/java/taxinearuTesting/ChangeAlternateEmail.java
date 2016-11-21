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

public class ChangeAlternateEmail {

	private WebDriver driver;
	boolean check = false;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExcelUtils.getTableArray(Constant.FILE_FULL_PATH, Constant.SHEET_NAME3);

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

		Function.loginPage(driver, 1, 1, 2, Constant.SHEET_NAME1);

		// click on the menu for selecting profile option
		driver.findElement(By.xpath("//*[@id='mm-menu-toggle']")).click();
		Thread.sleep(5000);
		Log.info("MENU CLICKED");

		// click on the profile option
		driver.findElement(By.xpath("//*[@id='btnProfile']/span[2]")).click();
		Thread.sleep(5000);
		Log.info("PROFILE OPTION SELECTED");

		// click on the change alternate email
		driver.findElement(By.xpath("//*[@id='changeAltEmail']")).click();

		Thread.sleep(2000);

		// click on the submit button so the link will send on the primary mail
		// id.
		driver.findElement(By
				.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[1]/form/div/input"))
				.click();

		Thread.sleep(5000);
		// reading mail after sending it to the primary mail id
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.PRIMARY_EMAIL, Constant.PRIMARY_EMAIL_PASSWORD,
				45000);
		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);

		// checking for the validation errors after clicking on the confirm
		// button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		String changeEmailError = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]"))
				.getText();
		if (changeEmailError.contains(Constant.ENTER_EMAIL_ERROR)) {
			Log.info("ENTER  EMAIL ADRRESS ERROR PRESENT");
		} else {
			Log.error("ENETER EMAIL ADDRESS ERROR IS NOT PRESENT");

		}

		String confirmEmailError1 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]"))
				.getText();
		if (confirmEmailError1.contains(Constant.ENTER_EMAIL_ERROR1)) {
			Log.info("ENTER CONFIRM EMAIL ADDRESS ERROR PRESENT");
		} else {
			Log.error("ENTER CONFIRM EMAIL ADDRESS ERROR IS NOT PRESENT");
		}

		Thread.sleep(2000);

		// checking validation value 1
		Function.changeAlternateEmail(driver, 3, 1, 2, 1);
		Log.info("VALIDATION VALUE 1 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 2
		Function.changeAlternateEmail(driver, 4, 1, 2, 1);
		Log.info("VALIDATION VALUE 2 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 3
		Function.changeAlternateEmail(driver, 5, 1, 2, 1);
		Log.info("VALIDATION VALUE 3 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 4
		Function.changeAlternateEmail(driver, 6, 1, 2, 1);
		Log.info("VALIDATION VALUE 4 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 5
		Function.changeAlternateEmail(driver, 7, 1, 2, 1);
		Log.info("VALIDATION VALUE 5 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 6
		Function.changeAlternateEmail(driver, 8, 1, 2, 1);
		Log.info("VALIDATION VALUE 6 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 7
		Function.changeAlternateEmail(driver, 9, 1, 2, 1);
		Log.info("VALIDATION VALUE 7 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 8
		Function.changeAlternateEmail(driver, 10, 1, 2, 1);
		Log.info("VALIDATION VALUE 8 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 10
		Function.changeAlternateEmail(driver, 12, 1, 2, 2);
		Log.info("VALIDATION VALUE 10 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 11
		Function.changeAlternateEmail(driver, 13, 1, 2, 3);
		Log.info("VALIDATION VALUE 11 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// finally entering the confirm values
		Function.changeAlternateEmail(driver, 14, 1, 2, 4);
		Thread.sleep(5000);
		Log.info("CONFIRM VALUES PASSED SUCCESSFULLY");

		// reading function again so the link shd expire
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.PRIMARY_EMAIL, Constant.PRIMARY_EMAIL_PASSWORD,
				5000);
		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);

		Log.info("RETURN TO TAXINEARU");

		// click on RETURN TO TAXINEARU ....for going back to the main page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/a")).click();
		Thread.sleep(5000);
		Log.info("RETURNING TO THE MAIN PAGE");

		// CHANGING ALTERNATE EMAIL BY SECURITY QUESTION
		// click on the menu for selecting profile option
		driver.findElement(By.xpath("//*[@id='mm-menu-toggle']")).click();
		Thread.sleep(5000);
		Log.info("MENU CLICKED");

		// click on the profile option
		driver.findElement(By.xpath("//*[@id='btnProfile']/span[2]")).click();
		Thread.sleep(5000);
		Log.info("PROFILE OPTION SELECTED");

		// click on the change alternate email
		driver.findElement(By.xpath("//*[@id='changeAltEmail']")).click();

		// click on the security question checkbox
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[1]/form/p[3]"))
				.click();
		Thread.sleep(5000);

		int row = 16;
		// answers for the security questions(answer 1)
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[2]/div/input[1]"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME3));

		// answer 2
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[2]/div/input[2]"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME3));

		// submitting the security question
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[2]/div/input[3]"))
				.click();

		Thread.sleep(2000);
		
		if (driver.getPageSource().contains(Constant.SECURITY_QUESTIONSCSMSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("FAIL");
			ExcelUtils.setCellData("FAIL", row, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("SECURITY QUESTIONS ANSWERS GIVEN SUCCESSFULLY");

		
		
		

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
