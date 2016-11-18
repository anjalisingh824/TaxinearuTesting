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

public class changeSecurityQuestions {

	private WebDriver driver;
	boolean check = false;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExcelUtils.getTableArray(Constant.FILE_FULL_PATH, Constant.SHEET_NAME2);

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

		// for entering the login details,click on menu then profile
		Function.loginPage(driver, 1, 1, 2, Constant.SHEET_NAME2);

		Thread.sleep(2000);

		// call function which will do 3 steps
		Function.profile(driver, 1);

		// selecting readEmail function to read mail and open browser
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.PRIMARY_EMAIL, Constant.PRIMARY_EMAIL_PASSWORD,
				45000);

		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		driver.get(Function.get);
		Log.info("READING PRIMARY EMAIL");

		// clicking on the submit button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[1]/center/input")).click();

		// check for the error present
		if (driver.getPageSource().contains(Constant.CHANGE_SEQERROR)) {
			Log.info("ANSWERS CANNOT BE LEFT BLANK ERROR PRESENT");
		} else {
			Log.error("ANSWERS CANNOT BE LEFT BLANK ERROR NOT PRESENT");
		}

		// checking for the validation value 3
		driver.findElement(By.id("ans1")).sendKeys(ExcelUtils.getCellData(5, 1, Constant.SHEET_NAME2));

		// then click ....on submit

		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[1]/center/input")).click();

		// check for the error present
		if (driver.getPageSource().contains(Constant.CHANGE_SEQERROR)) {
			Log.info("ANSWERS CANNOT BE LEFT BLANK ERROR PRESENT");
		} else {
			Log.error("ANSWERS CANNOT BE LEFT BLANK ERROR NOT PRESENT");
		}

		// clearing the fields
		driver.findElement(By.id("ans1")).clear();

		Thread.sleep(5000);
		// calling function for selecting the first security question
		Function.dropDown(driver, 7, 1);

		// passing answer for the security question 1
		driver.findElement(By.id("ans1")).sendKeys(ExcelUtils.getCellData(7, 2, Constant.SHEET_NAME2));

		// calling function for selecting the second security question
		Function.dropDown(driver, 7, 3);

		// passing answer for the security question 2
		driver.findElement(By.id("ans2")).sendKeys(ExcelUtils.getCellData(7, 4, Constant.SHEET_NAME2));

		// click on the submit button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[1]/center/input")).click();

		// check for the success message for the updation of the security
		// questions
		if (driver.getPageSource().contains(Constant.SEQ_UPDATEDSCSMSG)) {
			Log.info("SECURITY QUESTIONS UPDATED SUCCESSFULLY");
			ExcelUtils.setCellData("PASS", 7, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("SECURITY QUESTIONS NOT UPDATED SUCCESSFULLY");
			ExcelUtils.setCellData("FAIL", 7, 6, Constant.SHEET_NAME2);
		}

		// CHANGING SECURITY QUESTIONS BY SENDING MAIL TO THE ALTERNATE MAIL ID

		Thread.sleep(2000);
		// calling Function which will 3 steps
		Function.profile(driver, 2);

		// selecting readEmail function to read mail and open browser
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.ALTERNATE_EMAIL,
				Constant.ALTERNATE_EMAIL_PASSWORD, 45000);

		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		driver.get(Function.get);
		Log.info("READING ALTERNATE EMAIL");

		// clicking on the submit button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[1]/center/input")).click();

		// check for the error present
		if (driver.getPageSource().contains(Constant.CHANGE_SEQERROR)) {
			Log.info("ANSWERS CANNOT BE LEFT BLANK ERROR PRESENT");
		} else {
			Log.error("ANSWERS CANNOT BE LEFT BLANK ERROR NOT PRESENT");
		}

		// checking for the validation value 3
		driver.findElement(By.id("ans1")).sendKeys(ExcelUtils.getCellData(11, 1, Constant.SHEET_NAME2));

		// then click ....on submit

		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[1]/center/input")).click();

		// check for the error present
		if (driver.getPageSource().contains(Constant.CHANGE_SEQERROR)) {
			Log.info("ANSWERS CANNOT BE LEFT BLANK ERROR PRESENT");
		} else {
			Log.error("ANSWERS CANNOT BE LEFT BLANK ERROR NOT PRESENT");
		}

		// clearing the fields
		driver.findElement(By.id("ans1")).clear();

		Thread.sleep(5000);
		// calling function for selecting the first security question
		Function.dropDown(driver, 13, 1);

		// passing answer for the security question 1
		driver.findElement(By.id("ans1")).sendKeys(ExcelUtils.getCellData(13, 2, Constant.SHEET_NAME2));

		// calling function for selecting the second security question
		Function.dropDown(driver, 13, 3);

		// passing answer for the security question 2
		driver.findElement(By.id("ans2")).sendKeys(ExcelUtils.getCellData(13, 4, Constant.SHEET_NAME2));

		// click on the submit button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[1]/center/input")).click();

		// check for the success message for the updation of the security
		// questions
		if (driver.getPageSource().contains(Constant.SEQ_UPDATEDSCSMSG)) {
			Log.info("SECURITY QUESTIONS UPDATED SUCCESSFULLY");
			ExcelUtils.setCellData("PASS", 13, 6, Constant.SHEET_NAME2);
		} else {
			Log.error("SECURITY QUESTIONS NOT UPDATED SUCCESSFULLY");
			ExcelUtils.setCellData("FAIL", 13, 6, Constant.SHEET_NAME2);
		}

		// changing value of check

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
