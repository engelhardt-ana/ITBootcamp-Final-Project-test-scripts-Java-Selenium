package Tests;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import Pages.AuthPage;
import Pages.CartSummaryPage;
import Pages.LocationPopupPage;
import Pages.LoginPage;
import Pages.MealPage;
import Pages.NotificationSistemPage;
import Pages.ProfilePage;
import Pages.SearchResultPage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait waiter;
	protected SoftAssert sa;

	protected CartSummaryPage cartSummaryPage;
	protected AuthPage authPage;
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected MealPage mealPage;
	protected NotificationSistemPage notificationSistemPage;
	protected ProfilePage profilePage;
	protected SearchResultPage searchResultPage;

	protected String baseUrl = "http://demo.yo-meals.com";
	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib//chromedriver.exe");

		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;
		this.sa = new SoftAssert();

		cartSummaryPage = new CartSummaryPage(driver, waiter, js);
		authPage = new AuthPage(driver, waiter, js);
		locationPopupPage = new LocationPopupPage(driver, waiter, js);
		loginPage = new LoginPage(driver, waiter, js);
		mealPage = new MealPage(driver, waiter, js);
		notificationSistemPage = new NotificationSistemPage(driver, waiter, js);
		profilePage = new ProfilePage(driver, waiter, js);
		searchResultPage = new SearchResultPage(driver, waiter, js);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@AfterMethod
	public void Screenshoot(ITestResult test) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-mm-s");
		Date date = new Date();
		String fileName = "img";
		if (test.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File photo = scrShot.getScreenshotAs(OutputType.FILE);
			File location = new File("screenshots/" + fileName + "-" + dateFormat.format(date) + ".png");
			FileUtils.copyFile(photo, location);
		}

		this.driver.manage().deleteAllCookies();
	}

}
