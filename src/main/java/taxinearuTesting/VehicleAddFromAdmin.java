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

public class VehicleAddFromAdmin {
	private WebDriver driver;
	boolean check = false;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ExcelUtils.getTableArray(Constant.FILE_FULL_PATH,
		// Constant.SHEET_NAME3);

	}

	@Test()
	public void testTaxinaru() throws Exception {

		// check for the page title
		Assert.assertTrue(Constant.LOGIN_TITLE.contains(driver.getTitle()));
		Thread.sleep(5000);
		Log.info("TITLE IS MATCHED");

		int row = 14;
		// admin login
		driver.findElement(By.id("username")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME8));
		driver.findElement(By.id("password")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME8));

		// click on the login button
		driver.findElement(By.id("loginbtn")).click();
		Thread.sleep(2000);

		Log.info("--------------------------------------------");

		// click on the vehicle image in the left hand side corner
		driver.findElement(By.xpath("//html/body/div[2]/ul/li[3]/a/i")).click();
		Thread.sleep(2000);

		// click on vehicle type management
		driver.findElement(By.xpath("//*[@id='vehicleTypeManagementTab']")).click();
		Thread.sleep(2000);

		// click on the add vehicle button
		driver.findElement(By.xpath("//*[@id='vehicleTypeManagementTableContent']/div/div[2]/a")).click();
		Thread.sleep(2000);

		// click on the save button to check for the mandatory fields
		driver.findElement(By.xpath("//*[@id='saveTaxiType']")).click();
		Thread.sleep(2000);

		// getting errors for the mandatory fields

		// check for vehicle type error
		String error = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[1]/div/label")).getText();
		if (error.contains(Constant.VEHICLE_T_ERROR)) {
			Log.info("Enter vehicle type error is present");
		} else {
			Log.error("Enter vehicle type error is not present");
		}
		Thread.sleep(2000);

		// check for max people allowed
		String error1 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[2]/div/label")).getText();
		if (error1.contains(Constant.MAX_P_ALLOWED_E)) {
			Log.info("Enter max people allowance error is present");
		} else {
			Log.error("Enter max people allowance error is not present");
		}
		Thread.sleep(2000);

		// minimum rate
		String error2 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[3]/div/label")).getText();
		if (error2.contains(Constant.MIN_RATE)) {
			Log.info("Enter minimum rate error is present");
		} else {
			Log.error("Enter minimum rate error is not present");
		}
		Thread.sleep(2000);

		// maximum rate
		String error3 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[4]/div/label")).getText();
		if (error3.contains(Constant.MAX_RATE)) {
			Log.info("Enter maximum rate error is present");
		} else {
			Log.error("Enter minimum rate error is not present");
		}
		Thread.sleep(2000);

		Log.info("---------------------------------------------------");

		// checking for the validation values 1
		Function.vehicleAdd(driver, 27);

		// getting the errors for special characters
		// for max people
		String error4 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[2]/div/label")).getText();
		if (error4.contains(Constant.MAX_P_ALLOWED_E)) {
			Log.info("Enter max people allowance error is present");
			ExcelUtils.setCellData("PASS", 27, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter max people allowance error is not present");
			ExcelUtils.setCellData("FAIL", 27, 5, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// for max and min rate while entering special characters
		String error5 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[3]/div/label")).getText();
		if (error5.contains(Constant.MIN_MAXRATE_ERROR)) {
			Log.info("Invalid format error is present");
			ExcelUtils.setCellData("PASS", 27, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Invalid format error is not present");
			ExcelUtils.setCellData("FAIL", 27, 5, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.findElement(By.id("vehicleType")).clear();

		driver.findElement(By.id("maxPeopleAllowed")).clear();

		driver.findElement(By.id("minRate")).clear();

		driver.findElement(By.id("maxRate")).clear();

		Thread.sleep(2000);

		// passing validation values 2 for alphanumeric
		Function.vehicleAdd(driver, 28);

		// max people
		String error6 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[2]/div/label")).getText();
		if (error6.contains(Constant.VALUE_BETWEEN_ERROR)) {
			Log.info("Value must be between 0 to 20 error is present");
			ExcelUtils.setCellData("PASS", 28, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Value must be between 0 to 20 error is not present");
			ExcelUtils.setCellData("FAIL", 28, 5, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// Rate format
		String error7 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[3]/div/label")).getText();
		if (error7.contains(Constant.MIN_MAXRATE_ERROR)) {
			Log.info("Invalid format error is present");
			ExcelUtils.setCellData("PASS", 28, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Invalid format error is not present");
			ExcelUtils.setCellData("FAIL", 28, 5, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------");

		// clearing the fields
		driver.findElement(By.id("vehicleType")).clear();

		driver.findElement(By.id("maxPeopleAllowed")).clear();

		driver.findElement(By.id("minRate")).clear();

		driver.findElement(By.id("maxRate")).clear();

		Thread.sleep(2000);

		// passing validation value 3(digits)
		Function.vehicleAdd(driver, 29);

		// getting the errors
		// max people
		String error8 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[2]/div/label")).getText();
		if (error8.contains(Constant.VALUE_BETWEEN_ERROR)) {
			Log.info("Value must be between 0 to 20 error is present");
			ExcelUtils.setCellData("PASS", 29, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Value must be between 0 to 20 error is not present");
			ExcelUtils.setCellData("FAIL", 29, 5, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// Rate format
		String error9 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[3]/div/label")).getText();
		if (error9.contains(Constant.MIN_MAXRATE_ERROR)) {
			Log.info("Invalid format error is present");
			ExcelUtils.setCellData("PASS", 29, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Invalid format error is not present");
			ExcelUtils.setCellData("FAIL", 29, 5, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------");

		// clearing the fields
		driver.findElement(By.id("vehicleType")).clear();

		driver.findElement(By.id("maxPeopleAllowed")).clear();

		driver.findElement(By.id("minRate")).clear();

		driver.findElement(By.id("maxRate")).clear();

		Thread.sleep(2000);

		// passing validation value 4 for checking length
		Function.vehicleAdd(driver, 30);

		// check for the errors
		// max people
		String error10 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[2]/div/label"))
				.getText();
		if (error10.contains(Constant.VALUE_BETWEEN_ERROR)) {
			Log.info("Value must be between 0 to 20 error is present");
			ExcelUtils.setCellData("PASS", 30, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Value must be between 0 to 20 error is not present");
			ExcelUtils.setCellData("FAIL", 30, 5, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// Rate format
		String error11 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[3]/div/label"))
				.getText();
		if (error11.contains(Constant.MIN_MAXRATE_ERROR)) {
			Log.info("Invalid format error is present");
			ExcelUtils.setCellData("PASS", 30, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Invalid format error is not present");
			ExcelUtils.setCellData("FAIL", 30, 5, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);
		Log.info("-------------------------------------------------");

		// clearing the fields
		driver.findElement(By.id("vehicleType")).clear();

		driver.findElement(By.id("maxPeopleAllowed")).clear();

		driver.findElement(By.id("minRate")).clear();

		driver.findElement(By.id("maxRate")).clear();

		Thread.sleep(2000);

		// passing validation value 5 for alphabets
		Function.vehicleAdd(driver, 31);

		// check for the errors
		// max people

		String error12 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[2]/div/label"))
				.getText();
		if (error12.contains(Constant.MAX_P_ALLOWED_E)) {
			Log.info("Enter max people allowance error is present");
			ExcelUtils.setCellData("PASS", 31, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Enter max people allowance error is not present");
			ExcelUtils.setCellData("FAIL", 31, 5, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);

		// Rate format
		String error13 = driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[3]/div/label"))
				.getText();
		if (error13.contains(Constant.MIN_MAXRATE_ERROR)) {
			Log.info("Invalid format error is present");
			ExcelUtils.setCellData("PASS", 31, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Invalid format error is not present");
			ExcelUtils.setCellData("FAIL", 31, 5, Constant.SHEET_NAME8);
		}
		Thread.sleep(2000);
		Log.info("-------------------------------------------------");

		// clearing the fields
		driver.findElement(By.id("vehicleType")).clear();

		driver.findElement(By.id("maxPeopleAllowed")).clear();

		driver.findElement(By.id("minRate")).clear();

		driver.findElement(By.id("maxRate")).clear();

		Thread.sleep(2000);

		// passing validation value 6...as the error is for vehicle name already
		// exists
		Function.vehicleAdd(driver, 32);
		Thread.sleep(1000);
		if (driver.getPageSource().contains(Constant.VEHICLE_NAME_EXISTS_ERROR)) {
			Log.info("Vehicle name already exists error is present");
			ExcelUtils.setCellData("PASS", 32, 5, Constant.SHEET_NAME8);
		} else {
			Log.error("Vehicle name already exists error is not present");
			ExcelUtils.setCellData("FAIL", 32, 5, Constant.SHEET_NAME8);
		}

		Thread.sleep(2000);
		Log.info("------------------------------------------");

		// click on the cancel button to check whether it is working or not
		driver.findElement(By.xpath("//*[@id='vehicleTypeManagementForm']/div[6]/input[2]")).click();
		Thread.sleep(2000);

		// now click on the add vehicle button to pass the confirm values

		// driver.findElement(By.xpath("//*[@id='vehicleTypeManagementTableContent']/div/div[2]/a")).click();
		// Thread.sleep(2000);

		// passing confirm values
		// Function.vehicleAdd(driver, 33);

		// now click on edit
		driver.findElement(By.xpath("//*[@id='taxiType_64']")).click();
		Thread.sleep(2000);

		// clearing the fields
		driver.findElement(By.id("vehicleType")).clear();

		driver.findElement(By.id("maxPeopleAllowed")).clear();

		driver.findElement(By.id("minRate")).clear();

		driver.findElement(By.id("maxRate")).clear();

		Thread.sleep(2000);

		// passing edit values
		Function.vehicleAdd(driver, 34);
		Log.info("values are successfully edited");

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
