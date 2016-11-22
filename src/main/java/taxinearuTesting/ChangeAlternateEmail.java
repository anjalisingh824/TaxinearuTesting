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
		Function.changeAlternateEmail(driver, 3, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 1 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 2
		Function.changeAlternateEmail(driver, 4, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 2 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 3
		Function.changeAlternateEmail(driver, 5, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 3 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 4
		Function.changeAlternateEmail(driver, 6, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 4 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 5
		Function.changeAlternateEmail(driver, 7, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 5 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 6
		Function.changeAlternateEmail(driver, 8, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 6 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 7
		Function.changeAlternateEmail(driver, 9, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 7 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 8
		Function.changeAlternateEmail(driver, 10, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 8 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 10
		Function.changeAlternateEmail(driver, 12, 1, 2, Constant.MISMATCH_ERROR);
		Log.info("VALIDATION VALUE 10 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 11
		Function.changeAlternateEmail(driver, 13, 1, 2, Constant.ALTERNATE_EMAIL_NOTSAMERROR);
		Log.info("VALIDATION VALUE 11 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// finally entering the confirm values
		Function.changeAlternateEmail(driver, 14, 1, 2, Constant.SCS_MSG_ALTERNATE);
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
		Thread.sleep(5000);

		// click on the change alternate email
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/table[1]/tbody/tr[3]/td[3]/input[1]"))
				.click();
		Thread.sleep(5000);

		// click on the security question checkbox
		driver.findElement(By
				.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[1]/form/p[3]/label"))
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

		// click on the submit button to check the mandatory fields
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/form[2]/div/div/div[4]/input")).click();
		Thread.sleep(5000);

		String checkValidError = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/form[2]/div/div/div[2]/div[2]/label"))
				.getText();
		if (checkValidError.contains(Constant.SECURITY_QUESTION_ERROR)) {
			Log.info("ENTER EMAIL ADDRESS ERROR PRESENT");

		} else {
			Log.error("ENTER EMAIL ADDRESS ERROR IS NOT PRESENT");
		}

		Thread.sleep(2000);
		String checkValidError1 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/form[2]/div/div/div[3]/div[2]/label"))
				.getText();
		if (checkValidError1.contains(Constant.SECURITY_QUESTION_ERROR1)) {
			Log.info("CONFIRM EMAIL ADDRESS ERROR PRESENT");
		} else {
			Log.error("CONFIRM EMAIL ADDRESS ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// checking validation value 1
		Function.changeAlternateBySecurity(driver, 17, 1, 2, Constant.VALID_EMAIL_BYSECURITY_ERRROR);
		Log.info("VALIDATION VALUE 1 EXECUTED SUCCESSFULLY");

		// clear the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();

		Thread.sleep(2000);

		// checking validation value 2
		Function.changeAlternateBySecurity(driver, 18, 1, 2, Constant.VALID_EMAIL_BYSECURITY_ERRROR);
		Log.info("VALIDATION VALUE 2 EXECUTED SUCCESSFULLY");

		// clear the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();

		Thread.sleep(2000);

		// checking validation value 3
		Function.changeAlternateBySecurity(driver, 19, 1, 2, Constant.VALID_EMAIL_BYSECURITY_ERRROR);
		Log.info("VALIDATION VALUE 3 EXECUTED SUCCESSFULLY");

		// clear the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();

		Thread.sleep(2000);

		// checking validation value 4
		Function.changeAlternateBySecurity(driver, 20, 1, 2, Constant.VALID_EMAIL_BYSECURITY_ERRROR);
		Log.info("VALIDATION VALUE 4 EXECUTED SUCCESSFULLY");

		// clear the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();

		Thread.sleep(2000);

		// checking validation value 5
		Function.changeAlternateBySecurity(driver, 21, 1, 2, Constant.VALID_EMAIL_BYSECURITY_ERRROR);
		Log.info("VALIDATION VALUE 5 EXECUTED SUCCESSFULLY");

		// clear the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();

		Thread.sleep(2000);

		// checking validation value 6
		Function.changeAlternateBySecurity(driver, 22, 1, 2, Constant.VALID_EMAIL_BYSECURITY_ERRROR);
		Log.info("VALIDATION VALUE 6 EXECUTED SUCCESSFULLY");

		// clear the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();

		Thread.sleep(2000);

		// checking validation value 7
		Function.changeAlternateBySecurity(driver, 23, 1, 2, Constant.VALID_EMAIL_BYSECURITY_ERRROR);
		Log.info("VALIDATION VALUE 7 EXECUTED SUCCESSFULLY");

		// clear the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();

		Thread.sleep(2000);

		// checking validation value 8
		Function.changeAlternateBySecurity(driver, 24, 1, 2, Constant.VALID_EMAIL_BYSECURITY_ERRROR);
		Log.info("VALIDATION VALUE 8 EXECUTED SUCCESSFULLY");

		// clear the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();

		Thread.sleep(2000);

		// checking validation value 10
		Function.changeAlternateBySecurity(driver, 26, 1, 2, Constant.MISMATCH_BYSECURITY_ERROR);
		Log.info("VALIDATION VALUE 10 EXECUTED SUCCESSFULLY");

		// clear the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();

		Thread.sleep(2000);

		// checking validation value 11
		Function.changeAlternateBySecurity(driver, 27, 1, 2, Constant.ALTERNATE_EMAIL_NOTSAME_BYSECURITY);
		Log.info("VALIDATION VALUE 11 EXECUTED SUCCESSFULLY");

		// clear the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();

		Thread.sleep(2000);

		// entering confirm values
		Function.changeAlternateBySecurity(driver, 28, 1, 2, Constant.SCS_MSG_BY_SECURITY);
		Log.info("CONFIRM VALUES PASSED SUCCESSFULLY");
		Thread.sleep(5000);

		// changing alternate email by sending mail to the alternate email

		// click on the change change alternate email
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/table[1]/tbody/tr[3]/td[3]/input[1]"))
				.click();

		Thread.sleep(5000);
		// click on the link for the alternate email
		driver.findElement(By
				.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[1]/form/p[2]/label"))
				.click();
		Thread.sleep(5000);

		// click on the submit button so the link will send on the primary mail
		// id.
		driver.findElement(By
				.xpath("//html/body/div[3]/div/div/div/div/div[2]/div[1]/div/div[3]/div/div/div/div[1]/form/div/input"))
				.click();

		Thread.sleep(5000);
		// reading mail after sending it to the primary mail id
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.ALTERNATE_EMAIL,
				Constant.ALTERNATE_EMAIL_PASSWORD, 45000);
		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);
		Thread.sleep(5000);

		// checking for the validation errors after clicking on the confirm
		// button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		String changeEmail = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]")).getText();
		if (changeEmail.contains(Constant.ENTER_EMAIL_ERROR)) {
			Log.info("ENTER  EMAIL ADRRESS ERROR PRESENT");
		} else {
			Log.error("ENETER EMAIL ADDRESS ERROR IS NOT PRESENT");

		}

		String confirmEmail1 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]")).getText();
		if (confirmEmail1.contains(Constant.ENTER_EMAIL_ERROR1)) {
			Log.info("ENTER CONFIRM EMAIL ADDRESS ERROR PRESENT");
		} else {
			Log.error("ENTER CONFIRM EMAIL ADDRESS ERROR IS NOT PRESENT");
		}

		Thread.sleep(2000);

		// checking validation value 1
		Function.changeAlternateEmail(driver, 30, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 1 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 2
		Function.changeAlternateEmail(driver, 31, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 2 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 3
		Function.changeAlternateEmail(driver, 32, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 3 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 4
		Function.changeAlternateEmail(driver, 33, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 4 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 5
		Function.changeAlternateEmail(driver, 34, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 5 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 6
		Function.changeAlternateEmail(driver, 35, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 6 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 7
		Function.changeAlternateEmail(driver, 36, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 7 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 8
		Function.changeAlternateEmail(driver, 37, 1, 2, Constant.VALID_EMAIL_ERROR);
		Log.info("VALIDATION VALUE 8 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 10
		Function.changeAlternateEmail(driver, 39, 1, 2, Constant.MISMATCH_ERROR);
		Log.info("VALIDATION VALUE 10 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// checking validation value 11
		Function.changeAlternateEmail(driver, 40, 1, 2, Constant.ALTERNATE_EMAIL_NOTSAMERROR);
		Log.info("VALIDATION VALUE 11 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("alternate")).clear();
		driver.findElement(By.id("confAltEmail")).clear();

		// finally entering the confirm values
		Function.changeAlternateEmail(driver, 41, 1, 2, Constant.SCS_MSG_ALTERNATE);
		Thread.sleep(5000);
		Log.info("CONFIRM VALUES PASSED SUCCESSFULLY");

		// reading function again so the link shd expire
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.ALTERNATE_EMAIL,
				Constant.ALTERNATE_EMAIL_PASSWORD, 5000);
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
