package taxinearuTesting;

import java.util.List;
import java.util.Set;
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

public class PasswordChangeToSId {

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
		Thread.sleep(5000);

		Thread.sleep(5000);
		// selecting readEmail function to read mail and open browser
		Function.readEmail(driver, "imap.gmail.com", "anjali.smartsensesolutions@gmail.com", "smartAnjali");
		Log.info("READING EMAIL");

		// validation value 1 check for pass and conf pass
		int row1 = 3;
		driver.findElement(By.id("newPassword"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row1).getCell(1).getStringCellValue());
		driver.findElement(By.id("confPassword"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row1).getCell(2).getStringCellValue());

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();
		Thread.sleep(2000);

		// getting the error message by getText() and comparing it....

		String changePassword = driver.findElement(By.xpath("//body[@id='wrapper']/div[5]/span[3]")).getText();
		System.out.println(changePassword);
		if (changePassword.equals(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row1, 4);
		} else {
			Log.info("FAIL");
			ExcelUtils.setCellData("FAIL", row1, 4);
		}

		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 1 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		// taking validation value 2 from row 4
		int row2 = 4;
		driver.findElement(By.id("newPassword"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row2).getCell(1).getStringCellValue());
		driver.findElement(By.id("confPassword"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row2).getCell(2).getStringCellValue());

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();
		Thread.sleep(2000);

		// getting the error message by getText() and comparing it....

		String changePassword1 = driver.findElement(By.xpath("//body[@id='wrapper']/div[5]/span[3]")).getText();
		System.out.println(changePassword1);
		if (changePassword1.equals(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row2, 4);
		} else {
			Log.info("FAIL");
			ExcelUtils.setCellData("FAIL", row2, 4);
		}

		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 2 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		// taking validation value 3 from excel

		int row3 = 5;
		driver.findElement(By.id("newPassword"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row3).getCell(1).getStringCellValue());
		driver.findElement(By.id("confPassword"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row3).getCell(2).getStringCellValue());

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();
		Thread.sleep(2000);

		String changePassword2 = driver.findElement(By.xpath("//body[@id='wrapper']/div[5]/span[3]")).getText();
		System.out.println(changePassword2);
		if (changePassword2.equals(Constant.CHANGEPASSWORDE_MSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row3, 4);
		} else {
			Log.info("FAIL");
			ExcelUtils.setCellData("FAIL", row3, 4);
		}

		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 3 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		// taking validation value 4.
		int row4 = 6;

		driver.findElement(By.id("newPassword"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row4).getCell(1).getStringCellValue());
		driver.findElement(By.id("confPassword"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row4).getCell(2).getStringCellValue());

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();
		Thread.sleep(3000);

		String changePassword3 = driver.findElement(By.xpath("//div/span[3]")).getText();
		System.out.println(changePassword3);
		if (changePassword3.equals(Constant.PASSWORD_MISMATCH_ERROR)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row4, 4);
		} else {
			Log.info("FAIL");
			ExcelUtils.setCellData("FAIL", row4, 4);
		}

		Thread.sleep(5000);
		Log.info("CHANGE PASSWORD ERROR MESSAGE VALIDATION 4 SUCCESSFUL");

		// clearing the fields
		driver.findElement(By.id("newPassword")).clear();
		driver.findElement(By.id("confPassword")).clear();
		Thread.sleep(5000);

		int row5 = 7;
		// enter the new and confirm password
		driver.findElement(By.id("newPassword"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row5).getCell(1).getStringCellValue());
		driver.findElement(By.id("confPassword"))
				.sendKeys(ExcelUtils.ExcelWSheet.getRow(row5).getCell(2).getStringCellValue());
		Thread.sleep(2000);

		// click on submit
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div[2]/center/input")).click();

		if (driver.getPageSource().contains(Constant.PASSWORD_CHANGED_SUCCESSMSG)) {
			Log.info("PASS");
			ExcelUtils.setCellData("PASS", row5, 4);
		} else {
			Log.info("FAIL");
		}

		Thread.sleep(5000);
		Log.info("PASSWORD CHANGED SUCCESSFULLY");

		// again reading mail so it should give error(RETURN TO TAXINEARU).as
		// not allowed to use the same link again.
		Function.readEmail(driver, "imap.gmail.com", "testing3492email@gmail.com", "8306188737");
		Thread.sleep(5000);
		Log.error("RETURN TO TAXINEARU");

		// click on RETURN TO TAXINEARU ....for going back to the main page
		driver.findElement(By.xpath("//html/body/div[3]/div/div/a")).click();
		Log.info("RETURNING TO THE MAIN PAGE");

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
