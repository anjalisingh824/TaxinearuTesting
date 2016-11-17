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

public class ChangeEmail {

	private WebDriver driver;
	boolean check = false;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExcelUtils.getTableArray(Constant.FILE_FULL_PATH, Constant.SHEET_NAME1);

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
		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME1));
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

		// click on the change email button
		driver.findElement(By.id("changeEmail")).click();
		Thread.sleep(5000);

		// click on the submit button
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[1]/form/div/input"))
				.click();

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

		// checking validation1 values from row 3

		int row1 = 3;
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row1, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row1, 2, Constant.SHEET_NAME1));

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		// check for the errors present
		String error = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]")).getText();
		if (error.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS PRESENT");
			ExcelUtils.setCellData("PASS", row1, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row1, 4, Constant.SHEET_NAME1);
		}

		String confirmEmailError2 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]"))
				.getText();
		if (confirmEmailError2.contains(Constant.CHECK_EMAIL_ERROR1)) {
			Log.info("ENTER CONFIRM EMAIL ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row1, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER CONFIRM EMAIL ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row1, 4, Constant.SHEET_NAME1);
		}

		Log.info("VALIDATION VALUE 1 SUCCESSFULLY EXECUTED");

		// clearing fields
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("confEmail")).clear();
		Thread.sleep(5000);

		// checking validation2 values from row 4
		int row2 = 4;
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row2, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row2, 2, Constant.SHEET_NAME1));

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		// check for the errors present
		String error1 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]")).getText();
		if (error1.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS PRESENT");
			ExcelUtils.setCellData("PASS", row2, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row2, 4, Constant.SHEET_NAME1);
		}

		String confirmEmailError3 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]"))
				.getText();
		if (confirmEmailError3.contains(Constant.CHECK_EMAIL_ERROR1)) {
			Log.info("ENTER CONFIRM EMAIL ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row2, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER CONFIRM EMAIL ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row2, 4, Constant.SHEET_NAME1);
		}

		Log.info("VALIDATION VALUE 2 SUCCESSFULLY EXECUTED");
		// clearing fields
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("confEmail")).clear();
		Thread.sleep(5000);

		// checking validation3 values from row 5
		int row3 = 5;
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row3, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row3, 2, Constant.SHEET_NAME1));

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		// check for the errors present
		String error2 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]")).getText();
		if (error2.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS PRESENT");
			ExcelUtils.setCellData("PASS", row3, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row3, 4, Constant.SHEET_NAME1);
		}

		String confirmEmailError4 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]"))
				.getText();
		if (confirmEmailError4.contains(Constant.CHECK_EMAIL_ERROR1)) {
			Log.info("ENTER CONFIRM EMAIL ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row3, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER CONFIRM EMAIL ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row3, 4, Constant.SHEET_NAME1);
		}

		Log.info("VALIDATION VALUE 3 SUCCESSFULLY EXECUTED");

		// clearing fields
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("confEmail")).clear();
		Thread.sleep(5000);

		// checking validation4 values from row 6
		int row4 = 6;
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row4, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row4, 2, Constant.SHEET_NAME1));

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		// check for the errors present
		String error3 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]")).getText();
		if (error3.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS PRESENT");
			ExcelUtils.setCellData("PASS", row4, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row4, 4, Constant.SHEET_NAME1);
		}

		String confirmEmailError5 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]"))
				.getText();
		if (confirmEmailError5.contains(Constant.CHECK_EMAIL_ERROR1)) {
			Log.info("ENTER CONFIRM EMAIL ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row4, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER CONFIRM EMAIL ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row4, 4, Constant.SHEET_NAME1);
		}

		Log.info("VALIDATION VALUE 4 SUCCESSFULLY EXECUTED");

		// clearing fields
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("confEmail")).clear();
		Thread.sleep(5000);

		// checking validation5 values from row 7

		int row5 = 7;
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row5, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row5, 2, Constant.SHEET_NAME1));

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		// check for the errors present
		String error4 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]")).getText();
		if (error4.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS PRESENT");
			ExcelUtils.setCellData("PASS", row5, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row5, 4, Constant.SHEET_NAME1);
		}

		String confirmEmailError6 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]"))
				.getText();
		if (confirmEmailError6.contains(Constant.CHECK_EMAIL_ERROR1)) {
			Log.info("ENTER CONFIRM EMAIL ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row5, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER CONFIRM EMAIL ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row5, 4, Constant.SHEET_NAME1);
		}

		Log.info("VALIDATION VALUE 5 SUCCESSFULLY EXECUTED");

		// clearing fields
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("confEmail")).clear();
		Thread.sleep(5000);

		// checking validation6 values from row 8

		int row6 = 8;
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row6, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row6, 2, Constant.SHEET_NAME1));

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		// check for the errors present
		String error5 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]")).getText();
		if (error5.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS PRESENT");
			ExcelUtils.setCellData("PASS", row6, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row6, 4, Constant.SHEET_NAME1);
		}

		String confirmEmailError7 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]"))
				.getText();
		if (confirmEmailError7.contains(Constant.CHECK_EMAIL_ERROR1)) {
			Log.info("ENTER CONFIRM EMAIL ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row6, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER CONFIRM EMAIL ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row6, 4, Constant.SHEET_NAME1);
		}

		Log.info("VALIDATION VALUE 6 SUCCESSFULLY EXECUTED");

		// clearing fields
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("confEmail")).clear();
		Thread.sleep(5000);

		// checking validation7 values from row 9

		int row7 = 9;
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row7, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row7, 2, Constant.SHEET_NAME1));

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		// check for the errors present
		String error6 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]")).getText();
		if (error6.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS PRESENT");
			ExcelUtils.setCellData("PASS", row7, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row7, 4, Constant.SHEET_NAME1);
		}

		String confirmEmailError8 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]"))
				.getText();
		if (confirmEmailError8.contains(Constant.CHECK_EMAIL_ERROR1)) {
			Log.info("ENTER CONFIRM EMAIL ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row7, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER CONFIRM EMAIL ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row7, 4, Constant.SHEET_NAME1);
		}

		Log.info("VALIDATION VALUE 7 SUCCESSFULLY EXECUTED");

		// clearing fields
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("confEmail")).clear();
		Thread.sleep(5000);

		// checking validation8 values from row 10

		int row8 = 10;
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row8, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row8, 2, Constant.SHEET_NAME1));

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		// check for the errors present
		String error7 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[1]")).getText();
		if (error7.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS PRESENT");
			ExcelUtils.setCellData("PASS", row8, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row8, 4, Constant.SHEET_NAME1);
		}
		String confirmEmailError9 = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label[2]"))
				.getText();
		if (confirmEmailError9.contains(Constant.CHECK_EMAIL_ERROR1)) {
			Log.info("ENTER CONFIRM EMAIL ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row8, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER CONFIRM EMAIL ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row8, 4, Constant.SHEET_NAME1);
		}

		Log.info("VALIDATION VALUE 8 SUCCESSFULLY EXECUTED");

		// clearing fields
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("confEmail")).clear();
		Thread.sleep(5000);

		// checking validation10 values from row 12

		int row9 = 12;
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row9, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row9, 2, Constant.SHEET_NAME1));

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(5000);

		// check for the errors present
		String emailMismatchError = driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/label")).getText();
		if (emailMismatchError.contains(Constant.EMAIL_MISMATCH_ERROR)) {
			Log.info("EMAIL AND CONFIRM EMAIL SHOULD BE SAME ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row9, 4, Constant.SHEET_NAME1);

		} else {
			Log.error("EMAIL AND CONFIRM EMAIL SHOULD BE SAME ERROR PRESENT");
			ExcelUtils.setCellData("FAIL", row9, 4, Constant.SHEET_NAME1);
		}

		Log.info("VALIDATION VALUE 10 SUCCESSFULLY EXECUTED");

		// clearing fields
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("confEmail")).clear();
		Thread.sleep(5000);

		// checking validation11 values from row13
		int row10 = 13;

		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row10, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row10, 2, Constant.SHEET_NAME1));

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		Thread.sleep(2000);
		if (driver.getPageSource().contains(Constant.EMAIL_EXIST_ERROR))

		{
			Log.info("EMAIL ALREAY EXIST ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row10, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("EMAIL ALREADY EXIST ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row10, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(6000);
		Log.info("VALIDATION VALUE 11 SUCCESSFULLY EXECUTED");
		// clearing fields
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("confEmail")).clear();
		Thread.sleep(5000);

		// Checking validation12 value from row 14
		int row11 = 14;

		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(row11, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("confEmail")).sendKeys(ExcelUtils.getCellData(row11, 2, Constant.SHEET_NAME1));

		Thread.sleep(2000);

		// click on the button
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		driver.findElement(By.xpath("//html/body/div[3]/div/div/form/div/center/input")).click();
		// check for the error
		if (driver.getPageSource().contains(Constant.EMAIL_CHANGESCSMSG))

		{
			Log.info("EMAIL UPDATE SUCCESS MESSAGE PRESENT");
			ExcelUtils.setCellData("PASS", row11, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("EMAIL UPDATE SUCCESS MESSAGE NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row11, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 12 SUCCESSFULLY EXECUTED");

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

		Thread.sleep(5000);
		// check for the page title
		Assert.assertTrue(Constant.TITLE.contains(driver.getTitle()));
		Thread.sleep(5000);
		Log.info("TITLE IS MATCHED");

		// click on the LOGIN./SIGNUP
		driver.findElement(By.xpath("//*[@id='loginsignuplink']")).click();
		Thread.sleep(5000);

		// taking row 15 from excel
		int roww = 16;
		// passing username and password for login
		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(roww, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(roww, 2, Constant.SHEET_NAME1));
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

		// click on the change email button
		driver.findElement(By.id("changeEmail")).click();
		Thread.sleep(5000);

		// selecting the radio button security questions
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[1]/form/p[3]/label"))
				.click();

		int roww1 = 18;

		// selecting security questions for changing the password.
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[2]/div/input[1]"))
				.sendKeys(ExcelUtils.getCellData(roww1, 1, Constant.SHEET_NAME1));
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[2]/div/input[2]"))
				.sendKeys(ExcelUtils.getCellData(roww1, 2, Constant.SHEET_NAME1));

		// click on the confirm button after filling the 2 fields.
		driver.findElement(By.id("btnConfirm")).click();
		Thread.sleep(1000);

		if (driver.getPageSource().contains(Constant.SECURITY_QUESTIONSCSMSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", roww1, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("FAIL");
			ExcelUtils.setCellData("FAIL", roww1, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("SECURITY QUESTIONS ANSWERS GIVEN SUCCESSFULLY");

		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		String securityError = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[2]/div[2]/label"))
				.getText();
		if (securityError.contains(Constant.SECURITY_QUESTION_ERROR)) {
			Log.info("ENTER EMAIL ADDRESS ERROR PRESENT");
		} else {
			Log.error("ENTER EMAIL ADDRESS ERROR NOT PRESENT");
		}

		Thread.sleep(2000);

		// now checking validation value 1 from row 19
		int roww2 = 19;
		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(roww2, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId")).sendKeys(ExcelUtils.getCellData(roww2, 2, Constant.SHEET_NAME1));

		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		String validEmailError = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[2]/div[2]/label"))
				.getText();
		if (validEmailError.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR PRESENT");
			ExcelUtils.setCellData("PASS", roww2, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", roww2, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 1 SUCCESSFULLY EXECUTED");

		// Clearing the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();
		Thread.sleep(2000);

		// checking validation value 2 from row 20
		int roww3 = 20;

		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(roww3, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId")).sendKeys(ExcelUtils.getCellData(roww3, 2, Constant.SHEET_NAME1));

		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		String validEmailErro1 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[2]/div[2]/label"))
				.getText();
		if (validEmailErro1.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR PRESENT");
			ExcelUtils.setCellData("PASS", roww3, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", roww3, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 2 SUCCESSFULLY EXECUTED");

		// Clearing the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();
		Thread.sleep(2000);

		// checking validation value 3 from row 21
		int roww4 = 21;

		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(roww4, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId")).sendKeys(ExcelUtils.getCellData(roww4, 2, Constant.SHEET_NAME1));

		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		String validEmailErro2 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[2]/div[2]/label"))
				.getText();
		if (validEmailErro2.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR PRESENT");
			ExcelUtils.setCellData("PASS", roww4, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", roww4, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 3 SUCCESSFULLY EXECUTED");

		// Clearing the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();
		Thread.sleep(2000);

		// checking validation value 4 from row 22
		int roww5 = 22;

		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(roww5, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId")).sendKeys(ExcelUtils.getCellData(roww5, 2, Constant.SHEET_NAME1));

		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		String validEmailErro3 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[2]/div[2]/label"))
				.getText();
		if (validEmailErro3.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR PRESENT");
			ExcelUtils.setCellData("PASS", roww5, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", roww5, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 4 SUCCESSFULLY EXECUTED");

		// Clearing the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();
		Thread.sleep(2000);

		// checking validation value 5 from row 23
		int roww6 = 23;

		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(roww6, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId")).sendKeys(ExcelUtils.getCellData(roww6, 2, Constant.SHEET_NAME1));

		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		String validEmailErro4 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[2]/div[2]/label"))
				.getText();
		if (validEmailErro4.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR PRESENT");
			ExcelUtils.setCellData("PASS", roww6, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", roww6, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 5 SUCCESSFULLY EXECUTED");

		// Clearing the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();
		Thread.sleep(2000);

		// checking validation value 6 from row 24
		int roww7 = 24;

		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(roww7, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId")).sendKeys(ExcelUtils.getCellData(roww7, 2, Constant.SHEET_NAME1));

		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		String validEmailErro5 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[2]/div[2]/label"))
				.getText();
		if (validEmailErro5.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR PRESENT");
			ExcelUtils.setCellData("PASS", roww7, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", roww7, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 6 SUCCESSFULLY EXECUTED");

		// Clearing the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();
		Thread.sleep(2000);

		// checking validation value 7 from row 25
		int roww8 = 25;

		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(roww8, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId")).sendKeys(ExcelUtils.getCellData(roww8, 2, Constant.SHEET_NAME1));

		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		String validEmailErro6 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[2]/div[2]/label"))
				.getText();
		if (validEmailErro6.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR PRESENT");
			ExcelUtils.setCellData("PASS", roww8, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", roww8, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 7 SUCCESSFULLY EXECUTED");

		// Clearing the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();
		Thread.sleep(2000);

		// checking validation value 8 from row 26
		int roww9 = 26;

		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(roww9, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId")).sendKeys(ExcelUtils.getCellData(roww9, 2, Constant.SHEET_NAME1));

		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		String validEmailErro7 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[2]/div[2]/label"))
				.getText();
		if (validEmailErro7.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS ERROR PRESENT");
			ExcelUtils.setCellData("PASS", roww9, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", roww9, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 8 SUCCESSFULLY EXECUTED");

		// Clearing the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();
		Thread.sleep(2000);

		// checking validation value 10 from row 28
		int roww10 = 28;

		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(roww10, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId"))
				.sendKeys(ExcelUtils.getCellData(roww10, 2, Constant.SHEET_NAME1));

		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();
		Thread.sleep(5000);

		if (driver.getPageSource().contains(Constant.EMAIL_MISMATCH_CHECK)) {

			Log.info("EMAIL NOT SAME ERROR PRESENT");
			ExcelUtils.setCellData("PASS", roww10, 4, Constant.SHEET_NAME1);

		} else {

			Log.error("EMAIL NOT SAME ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", roww10, 4, Constant.SHEET_NAME1);
		}

		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 10 SUCCESSFULLY EXECUTED");

		// Clearing the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();
		Thread.sleep(2000);

		// checking validation value 11 from row 29
		int roww11 = 29;

		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(roww11, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId"))
				.sendKeys(ExcelUtils.getCellData(roww11, 2, Constant.SHEET_NAME1));

		Thread.sleep(5000);
		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		if (driver.getPageSource().contains(Constant.EMAIL_EXIST1)) {
			Log.info("EMAIL ALREADY EXISTS ERROR PRESENT");
			ExcelUtils.setCellData("PASS", row10, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("EMAIL ALREADY EXISTS ERROR NOT PRESENT");
			ExcelUtils.setCellData("FAIL", row10, 4, Constant.SHEET_NAME1);
		}
		Thread.sleep(5000);
		Log.info("VALIDATION VALUE 11 SUCCESSFULLY EXECUTED");

		// Clearing the fields
		driver.findElement(By.id("txtEmailId")).clear();
		driver.findElement(By.id("txtConfirmEmailId")).clear();
		Thread.sleep(2000);

		// Passing finally confirm values
		int row12 = 30;

		driver.findElement(By.id("txtEmailId")).sendKeys(ExcelUtils.getCellData(row12, 1, Constant.SHEET_NAME1));
		driver.findElement(By.id("txtConfirmEmailId")).sendKeys(ExcelUtils.getCellData(row12, 2, Constant.SHEET_NAME1));

		Thread.sleep(5000);
		// click on the confirm button of the email change page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[2]/div/div/div[4]/input"))
				.click();

		if (driver.getPageSource().contains(Constant.EMAIL_UPDATED)) {
			Log.info("EMAIL UPDATED SUCCESSFULLY ");
			ExcelUtils.setCellData("PASS", row12, 4, Constant.SHEET_NAME1);
		} else {
			Log.error("EMAIL NOT UPDATED");
			ExcelUtils.setCellData("FAIL", row12, 4, Constant.SHEET_NAME1);

		}
		Thread.sleep(5000);
		Log.info("CONFIRM VALUES EXECUTED SUCCESSFULLY");

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
