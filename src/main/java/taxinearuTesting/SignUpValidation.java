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

public class SignUpValidation {
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

	@Test(priority = 0)
	public void testTaxinearu() throws Exception {

		// CHECKING FOR THE MANDATORY ERRORS IN THE IN THE SIGN UP FIELD,AFTER
		// CLICKING ON THE SUBMIT BUTTON

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

		// click on the submit button of the signup page for checking the
		// mandatory fields.
		driver.findElement(By.id("btnUsrSignUp")).click();
		Thread.sleep(5000);

		// checking all the mandatory errors

		// error check for the firstname
		String firstnameError = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[1]/div/div[1]/label[2]"))
				.getText();
		if (firstnameError.contains(Constant.CHECK_FIRSTNAME_ERROR)) {
			Log.info("ENTER FIRSTNAME ERROR IS PRESENT");
		} else {
			Log.error("ENTER FIRSTNAME ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// error check for the lastname
		String lastnameError = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[1]/div/div[2]/label[2]"))
				.getText();
		if (lastnameError.contains(Constant.CHECK_LASTNAME_ERROR)) {
			Log.info("ENTER LAST NAME ERROR IS PRESENT");
		} else {
			Log.error("ENTER LAST NAME ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// check for the contact no field
		String contactnoError = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/label[3]"))
				.getText();
		if (contactnoError.contains(Constant.CHECK_CONTACT_NOERR)) {
			Log.info("ENTER CONTACT NUMBER ERRROR IS PRESENT");

		} else {
			Log.error("ENTER CONTACT NUMBER ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// check for the email address error
		String emailadrsError = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[2]/label[2]"))
				.getText();
		if (emailadrsError.contains(Constant.CHECK_EMAILADRS_ERROR)) {
			Log.info("ENTER EMAIL ADDRESS ERROR IS PRESENT");
		} else {
			Log.error("ENTER EMAIL ADDRESS ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// check for the password error
		String pwdError = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[3]/div/div[1]/label[2]"))
				.getText();
		if (pwdError.contains(Constant.CHECK_PWD_ERROR)) {
			Log.info("PASSWORD VALIDATIN ERROR IS PRESENT");
		} else {
			Log.error("PASSWORD VALIDATION ERROR IS NOT PRESENT");

		}
		Thread.sleep(2000);

		// check for the confirm email address error
		String conemailError = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[3]/div/div[2]/label[2]"))
				.getText();
		if (conemailError.contains(Constant.CHECK_CONPWD_ERROR)) {
			Log.info("ENTER CONFIRM PASSWORD ERROR IS PRESENT");
		} else {
			Log.error("ENTER CONFIRM PASSWORD ERROR IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// check validation error for security answer 1
		String seqans1Error = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[6]/div/div/label[2]"))
				.getText();
		if (seqans1Error.contains(Constant.CHECK_SEQ_ANS_ERROR)) {
			Log.info("ENTER SECURITY ANSWER ERROR 1 IS PRESENT");
		} else {
			Log.error("ENTER SECURITY ANSWER ERROR 1 IS NOT PRESENT");
		}
		Thread.sleep(2000);

		// check validation error for security answer 2
		String seqans2Error = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[8]/div/div/label[2]"))
				.getText();
		if (seqans2Error.contains(Constant.CHECK_SEQ_ANS_ERROR)) {

			Log.info("ENTER SECURITY ANSWER ERROR 2 IS PRESENT");
		} else {
			Log.error("ENTER SECURITY ANSWER ERROR 2 IS NOT PRESENT");
		}

		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void testTaxinearu1() throws Exception {
		// CHECKING FOR THE MANDATORY ERRORS IN THE IN THE SIGN UP FIELD,AFTER
		// CLICKING ON THE SUBMIT BUTTON

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

		// passing validation 1 value from the excel
		Function.signUp(driver, 1);

		// error for the firstname
		String checkError = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[1]/div/div[1]/label[2]"))
				.getText();
		if (checkError.contains(Constant.VALID_FIRSTNAME_ERROR)) {
			Log.info("FIRST NAME SHOULD BE 5 TO 20 CHARACTERS LONG ERROR PRESENT");
			ExcelUtils.setCellData("PASS", 1, 12, Constant.SHEET_NAME4);
		}

		else {
			Log.error("FIRST NAME SHOULD BE 5 TO 20 CHARACTERS LONG ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 1, 12, Constant.SHEET_NAME4);
		}

		Thread.sleep(2000);

		// error for the lastname
		String checkError1 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[1]/div/div[2]/label[2]"))
				.getText();

		if (checkError1.contains(Constant.VALID_LASTNAME_ERROR)) {
			Log.info("LAST NAME SHOULD BE 5 TO 20 CHARACTERS LONG ERROR PRESENT");
			ExcelUtils.setCellData("PASS", 1, 12, Constant.SHEET_NAME4);
		}

		else {
			Log.error("LAST NAME SHOULD BE 5 TO 20 CHARACTERS LONG ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 1, 12, Constant.SHEET_NAME4);
		}

		Thread.sleep(2000);

		// error for the contact no
		String checkError2 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/label[3]"))
				.getText();
		if (checkError2.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("ENTER VALID UK CONTACT NUMBER ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 1, 12, Constant.SHEET_NAME4);
		} else {
			Log.error("ENTER VALID UK CONTACT NUMBER ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 1, 12, Constant.SHEET_NAME4);
		}
		Thread.sleep(2000);

		// error for email address
		String checkError3 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[2]/label[2]"))
				.getText();
		if (checkError3.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS IS PRESENT");
			ExcelUtils.setCellData("PASS", 1, 12, Constant.SHEET_NAME4);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 1, 12, Constant.SHEET_NAME4);
		}
		Thread.sleep(2000);

		// check error for password
		String checkError4 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[3]/div/div[1]/label[2]"))
				.getText();
		if (checkError4.contains(Constant.CHECK_PWD_ERROR)) {
			Log.info("PASSWORD VALIDATIN ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 1, 12, Constant.SHEET_NAME4);

		} else {
			Log.error("PASSWORD VALIDATION ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 1, 12, Constant.SHEET_NAME4);

		}
		Thread.sleep(2000);

		// check error for alternative email
		String checkError5 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[4]/div/div/label[2]"))
				.getText();
		if (checkError5.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS FOR ALTERNATE EMAIL IS PRESENT");
			ExcelUtils.setCellData("PASS", 1, 12, Constant.SHEET_NAME4);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS FOR ALTERNATE EMAIL IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 1, 12, Constant.SHEET_NAME4);
		}
		Thread.sleep(2000);

		Log.info("ERROR VALUES CHECKED SUCCESSFULLY");

	}

	@Test(priority = 2)
	public void testTaxinearu2() throws Exception {
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

		// passing validation 1 value from the excel
		Function.signUp(driver, 2);

		Log.info("VALIDATION 2 VALUES PASSED SUCCESSFULLY");
		Thread.sleep(2000);

		// error check after clicking on the submit button

		// error for the firstname
		String checkError = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[1]/div/div[1]/label[2]"))
				.getText();
		if (checkError.contains(Constant.VALID_FIRSTNAME_ERROR)) {
			Log.info(
					"FIRST NAME SHOULD BE 5 TO 20 DIGITS LONG ERROR PRESENT,AS WE ARE TRYING TO PASS MORE THAN 20 DIGITS");
			ExcelUtils.setCellData("PASS", 1, 12, Constant.SHEET_NAME4);
		}

		else {
			Log.error(
					"FIRST NAME SHOULD BE 5 TO 20 DIGITS LONG ERROR IS NOT PRESENT,AS WE ARE TRYING TO PASS MORE THAN 20 DIGITS ");
			ExcelUtils.setCellData("FAIL", 1, 12, Constant.SHEET_NAME4);
		}

		Thread.sleep(2000);
		// error for the lastname
		String checkError1 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[1]/div/div[2]/label[2]"))
				.getText();

		if (checkError1.contains(Constant.VALID_LASTNAME_ERROR)) {
			Log.info(
					"LAST NAME SHOULD BE 5 TO 20 DIGITS LONG ERROR PRESENT,AS WE ARE TRYING TO PASS MORE THAN 20 DIGITS");
			ExcelUtils.setCellData("PASS", 1, 12, Constant.SHEET_NAME4);
		}

		else {
			Log.error(
					"LAST NAME SHOULD BE 5 TO 20 DIGITS LONG ERROR IS NOT PRESENT,AS WE ARE TRYING TO PASS MORE THAN 20 DIGITS");
			ExcelUtils.setCellData("FAIL", 1, 12, Constant.SHEET_NAME4);
		}

		Thread.sleep(2000);

		String checkError6 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/label[3]"))
				.getText();
		if (checkError6.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("ENTER VALID UK NUMBER ERROR PRESENT,WHEN WE TRY TO ENTER 11 DIGIT MOBILE NUMBER");
			ExcelUtils.setCellData("PASS", 2, 12, Constant.SHEET_NAME4);

		} else {
			Log.error("ENTER VALID UK NUMBER ERROR NOT PRESENT,WHEN WE TRY TO ENTER 11 DIGIT MOBILE NUMBER");
			ExcelUtils.setCellData("FAIL", 2, 12, Constant.SHEET_NAME4);
		}
		Thread.sleep(2000);

		// error check for the password not matching
		String checkError7 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[3]/div/div[2]/label[2]"))
				.getText();
		if (checkError7.contains(Constant.PASSWORD_SHD_MATCH)) {
			Log.info("CONFIRM PASSWORD NOT MATCHED ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 2, 12, Constant.SHEET_NAME4);
		} else {
			Log.error("CONFIRM PASSWORD NOT MATCHED ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 2, 12, Constant.SHEET_NAME4);
		}
		Thread.sleep(2000);
		Log.info("ERRORS ARE SUCCESSFULLY PRESENT");

	}

	@Test(priority = 3)
	public void testTaxinearu3() throws Exception {
		// CHECKING FOR EMAIL AND ALTERNATE EMAIL CAN'T BE SAME FROM ROW 3

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

		// passing validation 1 value from the excel
		Function.signUp(driver, 3);

		// check for the errors
		if (driver.getPageSource().contains(Constant.EMAIL_ALTERNATE_ERROR)) {
			Log.info("EMAIL AND ALTERNATE EMAIL CANNOT BE SAME ERROR PRESENT");
			ExcelUtils.setCellData("PASS", 3, 12, Constant.SHEET_NAME4);
		} else {
			Log.error("EMAIL AND ALTERNATE EMAIL CANNOT BE SAME ERROR IS NOT  PRESENT");
			ExcelUtils.setCellData("FAIL", 3, 12, Constant.SHEET_NAME4);
		}
		Thread.sleep(2000);
		Log.info("VALIDATION 3 VALUES PASSED SUCCESSFULLY");

	}

	@Test(priority = 4)
	public void testTaxinearu4() throws Exception {

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

		// passing validation 1 value from the excel
		Function.signUp(driver, 4);
		// check error for password
		String checkErr1 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[3]/div/div[1]/label[2]"))
				.getText();
		if (checkErr1.contains(Constant.CHECK_PWD_ERROR)) {
			Log.info("PASSWORD VALIDATIN ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 4, 12, Constant.SHEET_NAME4);

		} else {
			Log.error("PASSWORD VALIDATION ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 4, 12, Constant.SHEET_NAME4);

		}
		Thread.sleep(2000);

		// valid contact
		String checkErr2 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[2]/div/div[1]/label[3]"))
				.getText();
		if (checkErr2.contains(Constant.VALID_CONTACTNO_ERROR)) {
			Log.info("ENTER VALID UK NUMBER ERROR PRESENT,WHEN WE TRY TO ENTER 11 DIGIT MOBILE NUMBER");
			ExcelUtils.setCellData("PASS", 4, 12, Constant.SHEET_NAME4);

		} else {
			Log.error("ENTER VALID UK NUMBER ERROR NOT PRESENT,WHEN WE TRY TO ENTER 11 DIGIT MOBILE NUMBER");
			ExcelUtils.setCellData("FAIL", 4, 12, Constant.SHEET_NAME4);
		}
		Thread.sleep(2000);

		// valid email
		String checkErr3 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[4]/div/div/label[2]"))
				.getText();
		if (checkErr3.contains(Constant.CHECK_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ADDRESS FOR ALTERNATE EMAIL IS PRESENT");
			ExcelUtils.setCellData("PASS", 4, 12, Constant.SHEET_NAME4);
		} else {
			Log.error("ENTER VALID EMAIL ADDRESS FOR ALTERNATE EMAIL IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 4, 12, Constant.SHEET_NAME4);
		}
		Thread.sleep(2000);

		Log.info("VALIDATION 4 VALUES PASSED SUCCESSFULLY");

	}

	@Test(priority = 5)
	public void testTaxinearu5() throws Exception {

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

		// passing validation 1 value from the excel
		Function.signUp(driver, 5);
		// check error for password
		String checkErr4 = driver
				.findElement(By.xpath("//html/body/div[3]/div/div/div/div[2]/div/form/div[3]/div/div[1]/label[2]"))
				.getText();
		if (checkErr4.contains(Constant.CHECK_PWD_ERROR)) {
			Log.info("PASSWORD VALIDATIN ERROR IS PRESENT,WHEN ENTERED PASSWORD OF LESS THAN 7 CHARACTERS");
			ExcelUtils.setCellData("PASS", 5, 12, Constant.SHEET_NAME4);

		} else {
			Log.error("PASSWORD VALIDATION ERROR IS NOT PRESENT,WHEN ENTERED PASSWORD OF LESS THAN 7 CHARACTERS");
			ExcelUtils.setCellData("FAIL", 5, 12, Constant.SHEET_NAME4);

		}
		Thread.sleep(2000);
		Log.info("VALIDATION 5 VALUES PASSED SUCCESSFULLY");

	}

	@Test(priority = 6)
	public void testTaxinearu6() throws Exception {

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

		// passing validation 1 value from the excel
		Function.signUp(driver, 6);

		// check for the errors present
		if (driver.getPageSource().contains(Constant.OLD_EMAIL)) {
			Log.info("EMAIL ALREADY EXIST,SO WE HAVE TO ENTER A NEW EMAIL ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 6, 12, Constant.SHEET_NAME4);
		} else {
			Log.error("EMAIL ALREADY EXIST,SO WE HAVE TO ENTER A NEW EMAIL ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 6, 12, Constant.SHEET_NAME4);
		}
		Thread.sleep(5000);
		Log.info("VALIDATION 6 VALUES PASSED SUCCESSFULLY");

	}

	@Test(priority = 7)
	public void testTaxinearu7() throws Exception {

		// Check for the contact number already exists

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

		// passing validation 1 value from the excel
		Function.signUp(driver, 7);
		Thread.sleep(1000);

		// errors present
		if (driver.getPageSource().contains(Constant.OLD_CONTACTNO)) {
			Log.info("CONTACT NUMBER ALREADY EXIST,ENTER A NEW ONE ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 7, 12, Constant.SHEET_NAME4);
		} else {
			Log.error("CONTACT NUMBER ALREADY EXIST,ENTER A NEW ONE ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 7, 12, Constant.SHEET_NAME4);
		}

		Thread.sleep(2000);
		Log.info("VALIDATION 7 VALUES PASSED SUCCESSFULLY");

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
