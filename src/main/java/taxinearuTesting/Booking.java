package taxinearuTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.Function;
import Utils.Log;

public class Booking {
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

	@Test()
	public void testTaxinaru() throws Exception {

		// check for the page title
		Assert.assertTrue(Constant.TITLE.contains(driver.getTitle()));
		Thread.sleep(5000);
		Log.info("TITLE IS MATCHED");

		// click on the LOGIN./SIGNUP
		driver.findElement(By.xpath("//*[@id='loginsignuplink']")).click();
		Thread.sleep(5000);

		// passing username and password for login
		Function.loginPage(driver, 1, 1, 2, Constant.SHEET_NAME6);

		Thread.sleep(1000);

		// now click on the search button on the booking page so that we can
		// check for the mandatory errors
		driver.findElement(By.id("searchPartnerTaxi")).click();
		Thread.sleep(2000);

		// now get the errors
		// for pickup area
		String error1 = driver
				.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/div/form/table/tbody[1]/tr/td[1]/label"))
				.getText();
		if (error1.contains(Constant.B_PICKUP_AREA)) {
			Log.info("Enter Pickup location error is present");
		} else {
			Log.error("Enter Pickup location error is not present");
		}
		Thread.sleep(2000);

		// drop off location
		String error2 = driver
				.findElement(By.xpath("//html/body/div[3]/div[1]/div/div/div/form/table/tbody[1]/tr/td[2]/label"))
				.getText();
		if (error2.contains(Constant.B_DROP_OFF_AREA)) {
			Log.info("Enter Drop off location error is present");
		} else {
			Log.error("Enter Drop off location error is not present");
		}
		Thread.sleep(2000);

		Log.info("---------------------------------------------------------");

		// passing values
		int row = 3;
		// pick up

		driver.findElement(By.id("areafrom_0")).sendKeys("Wembley, United Kingdom");

		// drop
		driver.findElement(By.id("areato_0")).sendKeys("Harlow, United Kingdom");

		// click on the plus button for adding more area
		driver.findElement(By.id("addMoreArea")).click();
		Thread.sleep(2000);

		// via
		driver.findElement(By.id("areato_1")).sendKeys("Bristol, United Kingdom");

		// click on now
		driver.findElement(By.id("now")).click();
		Thread.sleep(2000);

		// select the luggage
		Function.dropDown(driver, row, 5, Constant.SHEET_NAME6);

		// select the people
		Function.dropDown(driver, row, 6, Constant.SHEET_NAME6);

		// click on the search
		driver.findElement(By.id("searchPartnerTaxi")).click();
		Thread.sleep(1000);

		// get the error if,we are not selecting pick,drop and via from dropdown
		if (driver.getPageSource().contains(Constant.B_SUGGESTION_ERROR)) {
			Log.info(" Please select valid location name from suggestion,error is present");
			ExcelUtils.setCellData("PASS", row, 7, Constant.SHEET_NAME6);
		} else {
			Log.error(" Please select valid location name from suggestion,error is not present");
			ExcelUtils.setCellData("FAIL", row, 7, Constant.SHEET_NAME6);
		}
		Thread.sleep(2000);

		Log.info("---------------------------------------------------------");

		// clearing the fields
		driver.navigate().refresh();
		Thread.sleep(2000);

		// passing validation values
		Function.bookTaxi(driver, 3);
		Thread.sleep(2000);

		// click on the modify search modify search
		driver.findElement(By.xpath("//html/body/div[3]/div[1]/div[1]/div/div[6]/a")).click();
		Thread.sleep(2000);

		// change the luggage value
		Function.dropDown(driver, 4, 5, Constant.SHEET_NAME6);
		Thread.sleep(2000);

		// change the people's value
		Function.dropDown(driver, 4, 6, Constant.SHEET_NAME6);
		Thread.sleep(2000);

		// click on the search
		driver.findElement(By.id("modifysearch")).click();
		Thread.sleep(5000);

		Log.info("-------------------------------------------------------");

		// click on the vehicle type to check whether checkboxes are working or
		// not

		// 7 seater
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[3]/ul/li[2]/label")).click();
		Thread.sleep(2000);

		// suv
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[3]/ul/li[3]/label")).click();
		Thread.sleep(2000);

		// saloon
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[3]/ul/li[4]/label")).click();
		Thread.sleep(2000);

		// again default hatchback
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[3]/ul/li[1]/label")).click();
		Thread.sleep(2000);

		Log.info("----------------------------------------------------");

		// now check for the price from low to high
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[4]/label[2]")).click();
		Thread.sleep(2000);

		// back to the low price
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[4]/label[1]")).click();
		Thread.sleep(2000);

		Log.info("------------------------------------------------------");

		// booking type,clicking on the return
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[5]/label[2]")).click();
		Thread.sleep(2000);

		// back to the single booking type
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[5]/label[1]")).click();
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------");

		// check for the ratings checkbox
		// for 5 star
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[7]/label[2]")).click();
		Thread.sleep(2000);

		// 4 star
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[7]/label[3]")).click();
		Thread.sleep(5000);

		// 3 star
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[7]/label[4]")).click();
		Thread.sleep(5000);

		// 2 star
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[7]/label[5]")).click();
		Thread.sleep(5000);

		// 1 star
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[7]/label[6]")).click();
		Thread.sleep(5000);

		// click on the All option after that
		driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[1]/div[7]/label[1]")).click();
		Thread.sleep(5000);

		Log.info("------------------------------------------------------");

		try {

			// click now to book a taxi
			driver.findElement(By.xpath("//html/body/div[3]/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[6]/button"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.getMessage().getClass().getName();
		}
		Log.info("CLICK ON THE BOOK");

		Thread.sleep(5000);

		// click on the card
		driver.findElement(
				By.xpath("//html/body/div[3]/div[1]/div/div/div/div[3]/div/div[1]/div/div/div[1]/ul/li[2]/span"))
				.click();
		Thread.sleep(2000);

		// checking the validation values for card details
		int row6 = 6;
		driver.findElement(By.id("cardNumber")).sendKeys(ExcelUtils.getCellData(row6, 1, Constant.SHEET_NAME6));

		// expiry year
		Function.dropDown(driver, row6, 2, Constant.SHEET_NAME6);

		// expiry month
		Function.dropDown(driver, row6, 3, Constant.SHEET_NAME6);

		// cvc number
		driver.findElement(By.id("cardCVV")).sendKeys(ExcelUtils.getCellData(row6, 4, Constant.SHEET_NAME6));
		Thread.sleep(2000);

		// click on the pay now
		driver.findElement(By.id("confirmBooking")).click();
		Thread.sleep(1000);

		// get the errors
		// card number error above
		if (driver.getPageSource().contains(Constant.B_CARD_NUMBER_E)) {
			Log.info("Your card number is incorrect,error is present");
			ExcelUtils.setCellData("PASS", row6, 5, Constant.SHEET_NAME6);
		} else {
			Log.error("Your card number is incorrect,error is not present");
			ExcelUtils.setCellData("FAIL", row6, 5, Constant.SHEET_NAME6);
		}

		Thread.sleep(2000);

		// for card number
		String err = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div[3]/div/div[1]/div/div/div[2]/div[2]/form/div[1]/div[2]"))
				.getText();
		if (err.contains(Constant.B_CARDN_ERROR)) {
			Log.info("Please enter valid card number error is present");
			ExcelUtils.setCellData("PASS", row6, 5, Constant.SHEET_NAME6);

		} else {
			Log.error("Please enter valid card number error is not present");
			ExcelUtils.setCellData("FAIL", row6, 5, Constant.SHEET_NAME6);
		}
		Thread.sleep(2000);

		Log.info("----------------------------------VALIDATION VALUE 1 PASSED");

		// clearing the fields
		driver.findElement(By.id("cardNumber")).clear();

		driver.findElement(By.id("cardCVV")).clear();

		Thread.sleep(2000);

		// passing validation validation value 2

		int row7 = 7;
		driver.findElement(By.id("cardNumber")).sendKeys(ExcelUtils.getCellData(row7, 1, Constant.SHEET_NAME6));

		// expiry year
		Function.dropDown(driver, row7, 2, Constant.SHEET_NAME6);

		// expiry month
		Function.dropDown(driver, row7, 3, Constant.SHEET_NAME6);

		// cvc number
		driver.findElement(By.id("cardCVV")).sendKeys(ExcelUtils.getCellData(row7, 4, Constant.SHEET_NAME6));
		Thread.sleep(2000);

		// click on the pay now
		driver.findElement(By.id("confirmBooking")).click();
		Thread.sleep(1000);

		// get the errors
		// cvv number error above
		if (driver.getPageSource().contains(Constant.B_CVV_ERROR_ABOVE)) {
			Log.info("Card CVV incorrect,error is present");
			ExcelUtils.setCellData("PASS", row7, 5, Constant.SHEET_NAME6);
		} else {
			Log.error("Card CVV incorrect ,error is not present");
			ExcelUtils.setCellData("FAIL", row7, 5, Constant.SHEET_NAME6);
		}

		Thread.sleep(2000);

		// for card number
		String err1 = driver
				.findElement(By
						.xpath("//html/body/div[3]/div[1]/div/div/div/div[3]/div/div[1]/div/div/div[2]/div[2]/form/div[5]/div[2]"))
				.getText();
		if (err1.contains(Constant.B_CVV_ERROR)) {
			Log.info("Please enter valid CVV number error is present");
			ExcelUtils.setCellData("PASS", row7, 5, Constant.SHEET_NAME6);

		} else {
			Log.error("Please enter valid CVV number error is not present");
			ExcelUtils.setCellData("FAIL", row7, 5, Constant.SHEET_NAME6);
		}
		Thread.sleep(2000);

		Log.info("----------------------------------VALIDATION VALUE 2 PASSED");

		// clearing the fields
		driver.findElement(By.id("cardNumber")).clear();

		driver.findElement(By.id("cardCVV")).clear();

		Thread.sleep(2000);

		// passing validation value3

		int row8 = 8;
		driver.findElement(By.id("cardNumber")).sendKeys(ExcelUtils.getCellData(row8, 1, Constant.SHEET_NAME6));

		// expiry year
		Function.dropDown(driver, row8, 2, Constant.SHEET_NAME6);

		// expiry month
		Function.dropDown(driver, row8, 3, Constant.SHEET_NAME6);

		// cvc number
		driver.findElement(By.id("cardCVV")).sendKeys(ExcelUtils.getCellData(row8, 4, Constant.SHEET_NAME6));
		Thread.sleep(2000);

		// click on the pay now
		driver.findElement(By.id("confirmBooking")).click();
		Thread.sleep(1000);

		// get the errors
		if (driver.getPageSource().contains(Constant.EXPIRATION_DATE_ERROR)) {
			Log.info("Your card's expiration month is invalid.error is present");
			ExcelUtils.setCellData("PASS", row8, 5, Constant.SHEET_NAME6);
		} else {
			Log.error("Your card's expiration month is invalid.error is not present");
			ExcelUtils.setCellData("FAIL", row8, 5, Constant.SHEET_NAME6);
		}

		Thread.sleep(2000);

		Log.info("----------------------------------VALIDATION VALUE 3 PASSED");

		// clearing the fields
		driver.findElement(By.id("cardNumber")).clear();

		driver.findElement(By.id("cardCVV")).clear();

		Thread.sleep(2000);

		int row1 = 9;
		// card number
		driver.findElement(By.id("cardNumber")).sendKeys(ExcelUtils.getCellData(row1, 1, Constant.SHEET_NAME6));

		// expiry year
		Function.dropDown(driver, row1, 2, Constant.SHEET_NAME6);

		// expiry month
		Function.dropDown(driver, row1, 3, Constant.SHEET_NAME6);

		// cvc number
		driver.findElement(By.id("cardCVV")).sendKeys(ExcelUtils.getCellData(row1, 4, Constant.SHEET_NAME6));
		Thread.sleep(2000);

		// click on the saved card ,so that we can use it next time
		driver.findElement(By.id("chkSaveCard")).click();
		Thread.sleep(5000);

		// click on the pay now
		driver.findElement(By.id("confirmBooking")).click();
		Thread.sleep(2000);

		Log.info("-------------------------------------------------");

		Thread.sleep(5000);

		// click on the back to hompage ,so it will go the homapage
		driver.findElement(By.xpath("//html/body/div[3]/div/div/div/div/div/div/a")).click();
		Thread.sleep(2000);

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
