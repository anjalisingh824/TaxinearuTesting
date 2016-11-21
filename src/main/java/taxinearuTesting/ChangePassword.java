package taxinearuTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class ChangePassword {

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
		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME));
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
		Log.info("CHANGE PASSWORD BUTTON SELECTED");
		Thread.sleep(5000);

		// click on the submit button and the mail is send to the primary mail
		// id .
		driver.findElement(By.id("btnRequest")).click();
		Thread.sleep(2000);
		Log.info("PASSWORD CHANGE CONFIRM BUTTON CLICKED...FROM POP UP WINDOW");

		// selecting readEmail function to read mail and open browser
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.PRIMARY_EMAIL, Constant.PRIMARY_EMAIL_PASSWORD,
				45000);

		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);

		Log.info("READING PRIMARY EMAIL");

		// validation value 1 check for pass and conf pass
		int row1 = 3;
		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row1, 1, Constant.SHEET_NAME));
		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row1, 2, Constant.SHEET_NAME));

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();
		Thread.sleep(2000);

		// getting the error message by getText() and comparing it....

		String changePassword = driver.findElement(By.xpath("//body[@id='wrapper']/div[5]/span[3]")).getText();
		System.out.println(changePassword);
		if (changePassword.equals(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row1, 4, Constant.SHEET_NAME);
		} else {
			Log.info("FAIL");
			ExcelUtils.setCellData("FAIL", row1, 4, Constant.SHEET_NAME);
		}

		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 1 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		// taking validation value 2 from row 4
		int row2 = 4;
		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row2, 1, Constant.SHEET_NAME));
		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row2, 2, Constant.SHEET_NAME));

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();
		Thread.sleep(2000);

		// getting the error message by getText() and comparing it....

		String changePassword1 = driver.findElement(By.xpath("//body[@id='wrapper']/div[5]/span[3]")).getText();
		System.out.println(changePassword1);
		if (changePassword1.equals(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row2, 4, Constant.SHEET_NAME);
		} else {
			Log.info("FAIL");
			ExcelUtils.setCellData("FAIL", row2, 4, Constant.SHEET_NAME);
		}

		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 2 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		// taking validation value 3 from excel

		int row3 = 5;
		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row3, 1, Constant.SHEET_NAME));
		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row3, 2, Constant.SHEET_NAME));

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();
		Thread.sleep(2000);

		String changePassword2 = driver.findElement(By.xpath("//body[@id='wrapper']/div[5]/span[3]")).getText();
		System.out.println(changePassword2);
		if (changePassword2.equals(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row3, 4, Constant.SHEET_NAME);
		} else {
			Log.info("FAIL");
			ExcelUtils.setCellData("FAIL", row3, 4, Constant.SHEET_NAME);
		}

		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 3 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		// taking validation value 4.
		int row4 = 6;

		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row4, 1, Constant.SHEET_NAME));
		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row4, 2, Constant.SHEET_NAME));

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();
		Thread.sleep(3000);

		String changePassword3 = driver.findElement(By.xpath("//div/span[3]")).getText();
		System.out.println(changePassword3);
		if (changePassword3.equals(Constant.PASSWORD_MISMATCH_ERROR)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row4, 4, Constant.SHEET_NAME);
		} else {
			Log.info("FAIL");
			ExcelUtils.setCellData("FAIL", row4, 4, Constant.SHEET_NAME);
		}

		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 4 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		int row5 = 7;
		// enter the new and confirm password
		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row5, 1, Constant.SHEET_NAME));
		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row5, 2, Constant.SHEET_NAME));
		Thread.sleep(2000);

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();

		if (driver.getPageSource().contains(Constant.PASSWORD_CHANGED_SUCCESSMSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row5, 4, Constant.SHEET_NAME);
		} else {
			Log.info("FAIL");
			ExcelUtils.setCellData("FAIL", row5, 4, Constant.SHEET_NAME);
		}

		Thread.sleep(5000);
		Log.info("PASSWORD CHANGED SUCCESSFULLY");

		// again reading mail so it should give error(RETURN TO TAXINEARU).as
		// not allowed to use the same link again.
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.PRIMARY_EMAIL, Constant.PRIMARY_EMAIL_PASSWORD,
				5000);

		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);
		Log.error("RETURN TO TAXINEARU");

		// click on RETURN TO TAXINEARU ....for going back to the main page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/a")).click();
		Log.info("RETURNING TO THE MAIN PAGE");

		// CHANGING PASSWORD BY SENDING MAIL TO THE ALTERNATE MAIL ID

		Thread.sleep(5000);
		// check for the page title
		Assert.assertTrue(Constant.TITLE.contains(driver.getTitle()));
		Thread.sleep(5000);
		Log.info("TITLE IS MATCHED");

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

		// select the alternate email id
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[1]/form/p[2]/label"))
				.click();
		Thread.sleep(5000);

		// click on the submit button and the mail is send to the alternate mail
		// id .
		driver.findElement(By.id("btnRequest")).click();
		Thread.sleep(2000);
		Log.info("PASSWORD CHANGE CONFIRM BUTTON CLICKED...FROM POP UP WINDOW");

		// selecting readEmail function to read mail and open browser
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.ALTERNATE_EMAIL,
				Constant.ALTERNATE_EMAIL_PASSWORD, 45000);

		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(15000);
		driver.get(Function.get);
		Log.info("READING ALTERNATE EMAIL");

		// validation value 1 check for pass and conf pass
		Function.changePasswordAlternate(driver, 9, 1, 2, 1);
		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 1 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		// taking validation value 2 from row 4
		Function.changePasswordAlternate(driver, 10, 1, 2, 1);

		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 2 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		// taking validation value 3 from excel
		Function.changePasswordAlternate(driver, 11, 1, 2, 1);
		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 3 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		// taking validation value 4.

		Function.changePasswordAlternate(driver, 12, 1, 2, 2);
		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 4 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		// enter the new and confirm password
		Function.changePasswordAlternate(driver, 13, 1, 2, 3);

		Thread.sleep(5000);
		Log.info("PASSWORD CHANGED SUCCESSFULLY");

		// again reading mail so it should give error(RETURN TO TAXINEARU).as
		// not allowed to use the same link again.
		Function.readEmail(driver, Constant.CONNECTION_EMAIL, Constant.ALTERNATE_EMAIL,
				Constant.ALTERNATE_EMAIL_PASSWORD, 5000);

		System.out.println(Function.link);
		System.out.println(Function.link.length());
		Function.get = Function.link.substring(8, Function.link.length() - 1);
		System.out.println(Function.get);
		Thread.sleep(5000);
		driver.get(Function.get);
		Log.error("RETURN TO TAXINEARU");

		// click on RETURN TO TAXINEARU ....for going back to the main page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/a")).click();
		Log.info("RETURNING TO THE MAIN PAGE");

		Thread.sleep(5000);

		// check for the page title
		Assert.assertTrue(Constant.TITLE.contains(driver.getTitle()));
		Thread.sleep(5000);
		Log.info("TITLE IS MATCHED");

		// CHANGING MAIL ID BY SECURITY QUESTIONS

		// click on the menu for selecting profile option

		Thread.sleep(5000);
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

		int row11 = 15;

		// selecting security questions for changing the password.
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[2]/div/input[1]"))
				.sendKeys(ExcelUtils.getCellData(row11, 1, Constant.SHEET_NAME));
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div[2]/div/input[2]"))
				.sendKeys(ExcelUtils.getCellData(row11, 2, Constant.SHEET_NAME));

		// click on the confirm button after filling the 2 fields.
		driver.findElement(By.id("btnConfirm")).click();
		Thread.sleep(1000);

		if (driver.getPageSource().contains(Constant.SECURITY_QUESTIONSCSMSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row11, 4, Constant.SHEET_NAME);
		} else {
			Log.error("FAIL");
			ExcelUtils.setCellData("FAIL", row11, 4, Constant.SHEET_NAME);
		}

		// checking the validation by taking values from the excel row 16
		int row12 = 16;
		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row12, 1, Constant.SHEET_NAME));

		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row12, 2, Constant.SHEET_NAME));

		String passError = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[3]/div[1]/div/div[2]/div[2]/label"))
				.getText();
		System.out.println(passError);
		if (passError.contains(Constant.SECURITY_CHANGEPASSERROR)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row12, 4, Constant.SHEET_NAME);
		} else {
			Log.error("FAIL");
			ExcelUtils.setCellData("FAIL", row12, 4, Constant.SHEET_NAME);
		}
		Log.info("VALIDATION VALUE 1 SUCCESSFULLY EXECUTED");

		// click on the submit buttton
		driver.findElement(By.id("btnChangePassword")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();

		// checking the validation by taking values from the excel row 17
		int row13 = 17;
		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row13, 1, Constant.SHEET_NAME));

		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row13, 2, Constant.SHEET_NAME));

		String passError1 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[3]/div[1]/div/div[2]/div[2]/label"))
				.getText();
		System.out.println(passError1);
		if (passError1.contains(Constant.SECURITY_CHANGEPASSERROR)) {

			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row13, 4, Constant.SHEET_NAME);
		} else {
			Log.error("FAIL");
			ExcelUtils.setCellData("FAIL", row13, 4, Constant.SHEET_NAME);
		}
		Log.info("VALIDATION VALUE 2 SUCCESSFULLY EXECUTED");

		// click on the submit buttton
		driver.findElement(By.id("btnChangePassword")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();

		// checking the validation by taking values from the excel row 18

		int row14 = 18;
		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row14, 1, Constant.SHEET_NAME));

		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row14, 2, Constant.SHEET_NAME));

		String passError2 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[3]/div[1]/div/div[2]/div[2]/label"))
				.getText();
		System.out.println(passError2);
		if (passError2.contains(Constant.SECURITY_CHANGEPASSERROR)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row14, 4, Constant.SHEET_NAME);
		} else {
			Log.error("FAIL");
			ExcelUtils.setCellData("FAIL", row14, 4, Constant.SHEET_NAME);
		}
		Log.info("VALIDATION VALUE 3 SUCCESSFULLY EXECUTED");

		// click on the submit buttton
		driver.findElement(By.id("btnChangePassword")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();

		// checking the validation by taking values from the excel row 19

		int row15 = 19;
		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row15, 1, Constant.SHEET_NAME));

		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row15, 2, Constant.SHEET_NAME));

		// click on the submit buttton
		driver.findElement(By.id("btnChangePassword")).click();
		Thread.sleep(5000);
		String passError3 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[3]/div[1]/div/div[3]/div[2]/label"))
				.getText();
		System.out.println(passError3);
		if (passError3.contains(Constant.PASSWORD_NOT_MATCH)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row15, 4, Constant.SHEET_NAME);
		} else {
			Log.error("FAIL");
			ExcelUtils.setCellData("FAIL", row15, 4, Constant.SHEET_NAME);
		}
		Log.info("VALIDATION VALUE 4 SUCCESSFULLY EXECUTED");

		Thread.sleep(2000);
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();

		// checking the validation by taking values from the excel row 20

		int row16 = 20;
		driver.findElement(By.id("newPassword")).sendKeys(ExcelUtils.getCellData(row16, 1, Constant.SHEET_NAME));

		driver.findElement(By.id("confPassword")).sendKeys(ExcelUtils.getCellData(row16, 2, Constant.SHEET_NAME));

		Thread.sleep(2000);
		// click on the submit buttton
		driver.findElement(
				By.xpath("//html/body/div[3]/div/div/div/div/div[2]/div/div/form[3]/div[1]/div/div[4]/input")).click();

		ExcelUtils.setCellData("PASS", row16, 4, Constant.SHEET_NAME);

		Log.info("PASSWORD CHANGED SUCCESSFULLY");
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
