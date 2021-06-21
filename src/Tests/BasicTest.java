package Tests;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;



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
	protected CartSummaryPage cartSummaryPage;
	protected AuthPage authPage;
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected MealPage mealPage;
	protected NotificationSistemPage notificationSistemPage;
	protected ProfilePage profilePage;
	protected SearchResultPage searchResultPage;
    protected String baseUrl= "http://demo.yo-meals.com";
    protected String email = "customer@dummyid.com";
    protected String password = "12345678a";
    
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib//chromedriver.exe");
		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		cartSummaryPage = new CartSummaryPage(driver, waiter, js);
		authPage = new AuthPage(driver, waiter, js);

		locationPopupPage = new LocationPopupPage(driver, waiter, js);
		loginPage = new LoginPage(driver, waiter, js);
		mealPage = new MealPage(driver, waiter, js);
		notificationSistemPage = new NotificationSistemPage(driver, waiter, js);
		profilePage = new ProfilePage(driver, waiter, js);
		searchResultPage = new SearchResultPage(driver, waiter, js);

	         }
	
	
		
	}

